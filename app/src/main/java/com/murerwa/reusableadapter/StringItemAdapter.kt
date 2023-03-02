package com.murerwa.reusableadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murerwa.reusableadapter.databinding.ListItemStringBinding

class StringItemAdapter(
    private val stringList: List<String>
): RecyclerView.Adapter<StringItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = ListItemStringBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = stringList[position]

        holder.bindView(currentItem)
    }

    override fun getItemCount(): Int = stringList.size

    inner class ViewHolder(private val binding: ListItemStringBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindView(string: String) {
            binding.apply {
                textView.text = string
            }
        }
    }
}