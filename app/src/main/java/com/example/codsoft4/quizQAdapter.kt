package com.example.codsoft4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codsoft4.databinding.QuizqBinding

class quizQAdapter(
    private val listOfQ: ArrayList<quizQ>,
    private val listener: Inter
) : RecyclerView.Adapter<quizQAdapter.QuizViewHolder>() {

    interface Inter {
        fun onAnswerSelected(questionPos: Int, selectedAnswer: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val binding = QuizqBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuizViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        val quizQ = listOfQ[position]

        holder.binding.questionText.text = quizQ.quizQ
        holder.binding.option1.text = quizQ.quizAns
        holder.binding.option2.text = quizQ.quizAns2
        holder.binding.option3.text = quizQ.quizAns3
        holder.binding.option4.text = quizQ.quizAns4

        // Reset the background color for all options
        holder.binding.option1.setBackgroundColor(holder.itemView.context.resources.getColor(android.R.color.transparent))
        holder.binding.option2.setBackgroundColor(holder.itemView.context.resources.getColor(android.R.color.transparent))
        holder.binding.option3.setBackgroundColor(holder.itemView.context.resources.getColor(android.R.color.transparent))
        holder.binding.option4.setBackgroundColor(holder.itemView.context.resources.getColor(android.R.color.transparent))

        // Highlight the selected answer with blue color
        quizQ.selectedAnswer?.let { selectedAnswer ->
            when (selectedAnswer) {
                1 -> holder.binding.option1.setBackgroundColor(
                    holder.itemView.context.resources.getColor(
                        android.R.color.holo_blue_light
                    )
                )

                2 -> holder.binding.option2.setBackgroundColor(
                    holder.itemView.context.resources.getColor(
                        android.R.color.holo_blue_light
                    )
                )

                3 -> holder.binding.option3.setBackgroundColor(
                    holder.itemView.context.resources.getColor(
                        android.R.color.holo_blue_light
                    )
                )

                4 -> holder.binding.option4.setBackgroundColor(
                    holder.itemView.context.resources.getColor(
                        android.R.color.holo_blue_light
                    )
                )
            }
        }

        // Set click listeners on the options
        holder.binding.option1.setOnClickListener {
            listener.onAnswerSelected(position, 1)
            quizQ.selectedAnswer = 1
            notifyItemChanged(position)  // Refresh the item view to show the updated color
        }

        holder.binding.option2.setOnClickListener {
            listener.onAnswerSelected(position, 2)
            quizQ.selectedAnswer = 2
            notifyItemChanged(position)  // Refresh the item view to show the updated color
        }

        holder.binding.option3.setOnClickListener {
            listener.onAnswerSelected(position, 3)
            quizQ.selectedAnswer = 3
            notifyItemChanged(position)  // Refresh the item view to show the updated color
        }

        holder.binding.option4.setOnClickListener {
            listener.onAnswerSelected(position, 4)
            quizQ.selectedAnswer = 4
            notifyItemChanged(position)  // Refresh the item view to show the updated color
        }
    }

    override fun getItemCount(): Int = listOfQ.size

    inner class QuizViewHolder(val binding: QuizqBinding) : RecyclerView.ViewHolder(binding.root)
}
