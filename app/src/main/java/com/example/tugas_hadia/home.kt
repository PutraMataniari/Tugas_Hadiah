package com.example.tugas_hadia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas_hadia.adapter.gambar_adapter
import com.example.tugas_hadia.data.data_gambar
import com.example.tugas_hadia.databinding.FragmentHomeBinding
import com.example.tugas_hadia.databinding.FragmentProfileBinding


class home : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private lateinit var gambarAdapter: gambar_adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding?.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycleView()
    }

    private fun setUpRecycleView() {
        val dataGambar = data_gambar.dummy_data_gambar
        gambarAdapter = gambar_adapter()
        binding?.rvGambar?.apply {
            layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL, false)
            adapter = gambarAdapter
        }
        gambarAdapter.submitList(dataGambar)
    }
}