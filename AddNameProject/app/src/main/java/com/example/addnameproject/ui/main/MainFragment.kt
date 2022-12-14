package com.example.addnameproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.addnameproject.R
import com.example.addnameproject.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding:FragmentMainBinding? = null
    private val binding get() = _binding!!

    companion object{
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?):
            View {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.resultText.text = viewModel.getResult().toString()

        binding.btn1.setOnClickListener{
            if(binding.nameText.text.isNotEmpty()){
                viewModel.setResult(binding.nameText.text.toString())
                binding.resultText.text = viewModel.getResult().toString()
            }else{
                binding.resultText.text = "No Value"
            }
        }
    }

}