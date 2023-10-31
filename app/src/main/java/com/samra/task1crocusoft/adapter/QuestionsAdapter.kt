package com.samra.task1crocusoft.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.samra.task1crocusoft.databinding.RecyclerRowQuestionsBinding
import com.samra.task1crocusoft.model.QuestionsModel

class QuestionsAdapter(var questionsList: List<QuestionsModel>): RecyclerView.Adapter<QuestionsAdapter.QuestionHolder>() {
    class QuestionHolder (var binding: RecyclerRowQuestionsBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionHolder {
        var binding = RecyclerRowQuestionsBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return QuestionHolder(binding)
    }

    override fun getItemCount(): Int {
        return questionsList.size
    }

    override fun onBindViewHolder(holder: QuestionHolder, position: Int) {
        val item = questionsList[position]
        val context = holder.itemView.context
        val text = context.getString(item.questionText)
        holder.binding.questionText.text = text

    }
}