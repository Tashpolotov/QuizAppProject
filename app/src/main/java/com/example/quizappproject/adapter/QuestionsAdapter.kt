package com.example.quizappproject.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.QuestionsModel
import com.example.quizappproject.R
import com.example.quizappproject.databinding.ItemQuestionsBinding

class QuestionsAdapter():ListAdapter<QuestionsModel, QuestionsAdapter.ViewHolder>(QuestionsDiff()) {


    private val answeredQuestions = mutableSetOf<Int>()
    private val selectedAnswers = mutableMapOf<Int, Int>()
    private var onAnswerClickListener: OnAnswerClickListener? = null

    interface OnAnswerClickListener{
        fun onAnswerClick(selectedIndex : Int)
    }
    fun setOnAnswerClickListener(listener: OnAnswerClickListener) {
        onAnswerClickListener = listener
    }

    inner class ViewHolder(private val binding:ItemQuestionsBinding):RecyclerView.ViewHolder(binding.root) {
        private var correctAnswerIndex: Int = 0
        private var isAnswered: Boolean = false
        init {
            binding.cardA.setOnClickListener { onAnswerClick(0) }
            binding.cardB.setOnClickListener { onAnswerClick(1) }
            binding.cardC.setOnClickListener { onAnswerClick(2) }
            binding.cardD.setOnClickListener { onAnswerClick(3) }
        }

        private fun onAnswerClick(selectedIndex: Int) {
            if (!isAnswered) {
                isAnswered = true
                answeredQuestions.add(adapterPosition)

                selectedAnswers[adapterPosition] = selectedIndex
                    setAnswerBackground(selectedIndex, R.color.white)


                onAnswerClickListener?.onAnswerClick(selectedIndex)
            }
        }
        private fun setAnswerBackground(selectedIndex: Int, colorResource: Int) {
            binding.linerA.setBackgroundResource(if (selectedIndex == 0) colorResource else R.color.backround_black)
            binding.linerB.setBackgroundResource(if (selectedIndex == 1) colorResource else R.color.backround_black)
            binding.linerC.setBackgroundResource(if (selectedIndex == 2) colorResource else R.color.backround_black)
            binding.linerD.setBackgroundResource(if (selectedIndex == 3) colorResource else R.color.backround_black)

        }

        fun bind(model: QuestionsModel) {
            binding.tvQuestions.text = model.questions
            binding.tvAnswerA.text = model.answer[0]
            binding.tvAnswerB.text = model.answer[1]
            binding.tvAnswerC.text = model.answer[2]
            binding.tvAnswerD.text = model.answer[3]
            correctAnswerIndex = model.currentAnswer.toInt()

            isAnswered = answeredQuestions.contains(adapterPosition)

            if (isAnswered) {
                val selectedAnswer = selectedAnswers[adapterPosition] ?: -1
                setAnswerBackground(selectedAnswer, R.color.white)

                // Здесь устанавливайте цвет текста для ответов в зависимости от выбранного ответа.

            } else {
                setAnswerBackground(selectedAnswers[adapterPosition] ?: -1, R.color.backround_black)



            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemQuestionsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    fun clearAnsweredQuestions() {
        answeredQuestions.clear()
        selectedAnswers.clear()
        notifyDataSetChanged()
    }
}

class QuestionsDiff:DiffUtil.ItemCallback<QuestionsModel>() {
    override fun areItemsTheSame(oldItem: QuestionsModel, newItem: QuestionsModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: QuestionsModel, newItem: QuestionsModel): Boolean {
        return oldItem == newItem
    }

}
