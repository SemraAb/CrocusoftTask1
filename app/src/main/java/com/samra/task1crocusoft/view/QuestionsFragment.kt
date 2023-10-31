package com.samra.task1crocusoft.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.samra.task1crocusoft.R
import com.samra.task1crocusoft.adapter.QuestionsAdapter
import com.samra.task1crocusoft.databinding.FragmentQuestionsBinding
import com.samra.task1crocusoft.model.QuestionsModel


class QuestionsFragment : Fragment() {
    private lateinit var binding: FragmentQuestionsBinding
    private lateinit var recyclerAdapterQuestions : QuestionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuestionsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionsList = listOf(
            QuestionsModel(R.string.question_1),
            QuestionsModel(R.string.question_2),
            QuestionsModel(R.string.question_3),
            QuestionsModel(R.string.question_4),
            QuestionsModel(R.string.question_5),
            QuestionsModel(R.string.question_6),
            QuestionsModel(R.string.question_7),
            QuestionsModel(R.string.question_8))


        var questionsRecyclerView = binding.questionsRecyclerView

        questionsRecyclerView.layoutManager = LinearLayoutManager(context)
        recyclerAdapterQuestions = QuestionsAdapter(questionsList)
        questionsRecyclerView.adapter = recyclerAdapterQuestions



        //header
        var toolbar = binding.toolbar
        toolbar.notificationIcon.visibility = View.VISIBLE
        toolbar.profileIcon.visibility = View.VISIBLE
        toolbar.questionsPageHeader.visibility = View.VISIBLE

        toolbar.profileIcon.setOnClickListener{
            var action = QuestionsFragmentDirections.actionQuestionsFragmentToProfileFragment()
            findNavController().navigate(action)
        }
    }



}