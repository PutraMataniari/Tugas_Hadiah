package com.example.tugas_hadia

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.tugas_hadia.databinding.FragmentProfileBinding
import com.example.tugas_hadia.helper.constant
import com.example.tugas_hadia.helper.prefHelp




class profile : Fragment() {
    lateinit var prefHelp: prefHelp
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(layoutInflater)
        prefHelp = prefHelp(requireContext())
        binding?.btnlogout?.setOnClickListener{
            prefHelp.clear()
            Toast.makeText(context, "Anda berhasil Logout", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }
        binding?.tvUser?.text = prefHelp.getString( constant.PREF_USERNAME )
        return binding?.root

//        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}