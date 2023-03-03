package com.murerwa.reusableadapter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.murerwa.reusableadapter.databinding.FragmentFirstBinding
import com.murerwa.reusableadapter.databinding.ListItemStringBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentFirstBinding.bind(view)

        initViews()
    }

    private fun initViews() {
        val listOfStrings = listOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten")

        val stringItemAdapter = GenericAdapter<String, ListItemStringBinding>(
            list = listOfStrings,
            bindView = { item: String, itemView: View -> bindView(item, itemView) }
        )

        binding.recyclerView.adapter = stringItemAdapter
    }

    private fun bindView(item: String, itemView: View) {
        val binding = ListItemStringBinding.bind(itemView)
        binding.textView.text = item
    }

    override fun onDestroyView() {
        _binding = null

        super.onDestroyView()
    }
}