package com.example.quizappproject.adapter

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.ExploreModel
import com.example.quizappproject.R
import com.example.quizappproject.databinding.ItemExploreBinding

class ExploreAdapter(val onClick:(ExploreModel) -> Unit):ListAdapter<ExploreModel, ExploreAdapter.ViewHolder>(ExploreDiff()) {

    private var selected : Int = RecyclerView.NO_POSITION

    inner class ViewHolder(private val binding:ItemExploreBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ExploreModel) {
            binding.tvName.text = model.category

            val isSelected = adapterPosition == selected
            val cardColor = if(isSelected) {
                ContextCompat.getColor(binding.root.context, R.color.blue)
            } else {
                ContextCompat.getColor(binding.root.context, R.color.backround_black)
            }

            binding.cardView1.setCardBackgroundColor(cardColor)
            val layoutParams = binding.cardView1.layoutParams as ViewGroup.LayoutParams
            val context = binding.root.context
            val position = adapterPosition

            // Проверяем, четная или нечетная позиция
            if (position % 2 == 0) {
                layoutParams.height = 270.dpToPx(context) // 270dp для четных позиций
            } else {
                layoutParams.height = 330.dpToPx(context) // 330dp для нечетных позиций
            }

            binding.cardView1.layoutParams = layoutParams

            itemView.setOnClickListener {
                selected = adapterPosition
                notifyDataSetChanged()
                onClick(model)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemExploreBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    fun Int.dpToPx(context: Context): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }
}

class ExploreDiff:DiffUtil.ItemCallback<ExploreModel>() {
    override fun areItemsTheSame(oldItem: ExploreModel, newItem: ExploreModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ExploreModel, newItem: ExploreModel): Boolean {
        return oldItem == newItem
    }

}
