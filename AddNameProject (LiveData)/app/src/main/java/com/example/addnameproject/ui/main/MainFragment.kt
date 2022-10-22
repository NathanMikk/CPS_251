package com.example.addnameproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.addnameproject.R
import com.example.addnameproject.databinding.FragmentMainBinding
import androidx.lifecycle.ViewModel
import com.example.addnameproject.BR.myViewModel
import androidx.databinding.ViewDataBinding

class MainFragment : Fragment() {

    companion object{
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?):
            View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){

      super.onViewCreated(view, savedInstanceState)
       // viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.setVariable(myViewModel, viewModel)

    }

}