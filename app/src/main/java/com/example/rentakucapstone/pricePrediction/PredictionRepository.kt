package com.example.rentakucapstone.pricePrediction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rentakucapstone.api.ApiConfig
import com.example.rentakucapstone.api.PredictionResponse
import com.example.rentakucapstone.dataKendaraan.MotorData
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PredictionRepository {
    private val apiService = ApiConfig.getApiService()

    fun predictMotorPrice(motorData: MotorData): LiveData<com.example.rentakucapstone.Result<List<List<Double>>>> {
        val resultLiveData = MutableLiveData<com.example.rentakucapstone.Result<List<List<Double>>>>()

        val gson = Gson()
        val jsonBody = JsonObject().apply {
            addProperty("feature1", motorData.mileage)
            addProperty("feature2", motorData.merkMotor.value)
            addProperty("feature3", motorData.modelMotor.value)
            addProperty("feature4", motorData.tahunMotor.value)
            addProperty("feature5", motorData.besarCcMotor.value)
        }
        val call = apiService.motor(
            jsonBody
        )

        call.enqueue(object : Callback<PredictionResponse> {
            override fun onResponse(
                call: Call<PredictionResponse>,
                response: Response<PredictionResponse>
            ) {
                if (response.isSuccessful) {
                    val prediction = response.body()?.prediction
                    resultLiveData.postValue(com.example.rentakucapstone.Result.Success(prediction))
                } else {
                    val error = response.errorBody()?.toString()
                    resultLiveData.postValue(com.example.rentakucapstone.Result.Failure(Throwable(error ?: "Unknown error")))
                }
            }

            override fun onFailure(call: Call<PredictionResponse>, t: Throwable) {
                resultLiveData.postValue(com.example.rentakucapstone.Result.Failure(Throwable(t.message ?: "Unknown error")))
            }
        })

        return resultLiveData
    }
}