package com.murerwa.reusableadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murerwa.reusableadapter.databinding.ListItemStringBinding

/**
 * A Generic Adapter that can be used to display any list of data.
 * The constructor Creates an adapter that can be attached to your prepared recycler view
 *
 * It takes two params, T and BT.
 *
 * Param T is the data type to be displayed. It should not be a list. The Generic Adapter parses it as a List<T>.
 *
 * Param BT is the binding class type. It should be the binding class for the layout to be inflated.
 *
 */
class GenericAdapter<T, BT>(
    private val list: List<T>
): RecyclerView.Adapter<GenericAdapter<T, BT>.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = ListItemStringBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]

        holder.bindView(currentItem)
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: ListItemStringBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: T) {
            binding.apply {
                textView.text = item as String
            }
        }
    }
}