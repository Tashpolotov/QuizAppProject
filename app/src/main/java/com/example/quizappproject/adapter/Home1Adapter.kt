package com.example.quizappproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Home1Model
import com.example.quizappproject.R
import com.example.quizappproject.databinding.ItemHome1Binding

class Home1Adapter(val onClick:(Home1Model)->Unit):ListAdapter<Home1Model, Home1Adapter.ViewHolder>(HomeDiff()) {

    private var selected : Int = RecyclerView.NO_POSITION

    inner class ViewHolder(private val binding:ItemHome1Binding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Home1Model) {
            binding.tvName.text = model.name

            val isSelected = adapterPosition == selected
            val cardColor = if (isSelected) {
                ContextCompat.getColor(binding.root.context, R.color.white)
            } else {
                ContextCompat.getColor(binding.root.context, R.color.backround_black)
            }

            itemView.setOnClickListener {

                selected = adapterPosition
                notifyDataSetChanged()
                onClick(model)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHome1Binding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HomeDiff:DiffUtil.ItemCallback<Home1Model>() {
    override fun areItemsTheSame(oldItem: Home1Model, newItem: Home1Model): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Home1Model, newItem: Home1Model): Boolean {
        return oldItem == newItem
    }

}
