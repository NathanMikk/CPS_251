package com.ebookfrenzy.lifecycledemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.ebookfrenzy.lifecycledemo.R

import com.ebookfrenzy.lifecycledemo.DemoObserver

import com.ebookfrenzy.lifecycledemo.DemoOwner
import com.ebookfrenzy.lifecycledemo.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?):
            View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    private lateinit var demoOwner: DemoOwner

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        lifecycle.addObserver(DemoObserver())
        val resultObserver = Observer<String> {
                result -> binding.statusText.text = result.toString()
        }
        viewModel.getStatus().observe(viewLifecycleOwner, resultObserver)

       //binding.statusText.text = viewModel.getStatus().toString()

        //THESE METHODS ARE FOR THE CUSTOM CLASS.
        //demoOwner = DemoOwner()
        //demoOwner.startOwner()
        //demoOwner.stopOwner()

    }

}