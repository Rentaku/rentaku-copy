package com.example.rentakucapstone.dashboard.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rentakucapstone.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var rekomendasiAdapter : RekomendasiAdapter
    private lateinit var disekitarAdapter : DisekitarAdapter
    private val rekomendasiNames = listOf("ZX 250R", "ZX 250R", "ZX 250R", "ZX 250R")
    private val disekitarNames = listOf("ZX 250R", "ZX 250R", "ZX 250R", "ZX 250R")

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rekomendasiAdapter = RekomendasiAdapter(rekomendasiNames)
        disekitarAdapter = DisekitarAdapter(disekitarNames)

        var recyclerView: RecyclerView
        binding.rvRekomendasi.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvRekomendasi.setHasFixedSize(true)
        binding.rvRekomendasi.adapter = rekomendasiAdapter

        binding.rvDisekitarmu.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvDisekitarmu.setHasFixedSize(true)
        binding.rvDisekitarmu.adapter = disekitarAdapter

        val horizontalLayoutRekomendasi = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.rvRekomendasi.layoutManager = horizontalLayoutRekomendasi
        binding.rvRekomendasi.layoutManager

        val horizontalLayoutDisekitar = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.rvDisekitarmu.layoutManager = horizontalLayoutDisekitar
        binding.rvDisekitarmu.layoutManager

        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        with(binding) {
            searchView.setupWithSearchBar(searchBar)
            searchView
                .editText
                .setOnEditorActionListener { textView, actionId, event ->
                    searchBar.text = searchView.text
                    searchView.hide()
                    Toast.makeText(requireContext(), searchView.text, Toast.LENGTH_SHORT).show()
                    false
                }
        }

        //val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            //textView.text = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}