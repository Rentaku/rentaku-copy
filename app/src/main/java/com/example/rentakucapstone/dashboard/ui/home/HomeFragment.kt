package com.example.rentakucapstone.dashboard.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
<<<<<<< HEAD
=======
import android.widget.Toast
>>>>>>> 32a93d05e359b3defa77f303ecedb5ac41d75d46
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rentakucapstone.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
<<<<<<< HEAD
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
=======
>>>>>>> 32a93d05e359b3defa77f303ecedb5ac41d75d46

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

<<<<<<< HEAD
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
=======
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

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
>>>>>>> 32a93d05e359b3defa77f303ecedb5ac41d75d46
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}