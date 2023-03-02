package com.murerwa.reusableadapter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.murerwa.reusableadapter.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentFirstBinding.bind(view)
    }

    override fun onDestroyView() {
        _binding = null

        super.onDestroyView()
    }
}