package com.samra.task1crocusoft.view

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.samra.task1crocusoft.R
import com.samra.task1crocusoft.adapter.CardsAdapter
import com.samra.task1crocusoft.adapter.NewsAdapter
import com.samra.task1crocusoft.databinding.FragmentMainBinding
import com.samra.task1crocusoft.model.CardsModel
import com.samra.task1crocusoft.model.NewsModel


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var recyclerAdapterNews : NewsAdapter
    private lateinit var recyclerAdapterCards : CardsAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recycler row news

        val newsList = listOf(
         NewsModel("Prezident İlham Əliyev Mingəçevir şəhərinin elektrik paylayıcı şəbəkəsinin Avtomatik İdarəetmə..." , R.drawable.news_image1),
         NewsModel("Ağcabədinin Pərioğullar və Hacıbədəlli kəndlərinin elektrik şəbəkəsi yenidən qurulur." , R.drawable.news_image_second),
         NewsModel("Prezident İlham Əliyev Mingəçevir şəhərinin elektrik paylayıcı şəbəkəsinin Avtomatik İdarəetmə..." , R.drawable.news_image1)
        )

        var newsRecyclerView = binding.newsRecyclerView

        var layoutManager = LinearLayoutManager(requireContext().applicationContext , LinearLayoutManager.HORIZONTAL  , false)
        newsRecyclerView.layoutManager = layoutManager
        recyclerAdapterNews = NewsAdapter(newsList)
        newsRecyclerView.adapter = recyclerAdapterNews

        // Recycler row cards


        val cardsList = listOf(
            CardsModel("Ortalama enerji İstehlakı ", R.drawable.card_view_icon_1, "#294D8C"),
            CardsModel("Add auto Top-Up", R.drawable.cardview_icon_2, "#A8C5B7"),
            CardsModel("Enerjiyə qənaət məsləhətləri", R.drawable.cardview_icon_3, "#EA5455")
        )

        var cardsRecyclerView = binding.cardsRecyclerView

        var layoutManagerCards = LinearLayoutManager(requireContext().applicationContext , LinearLayoutManager.HORIZONTAL  , false)
        cardsRecyclerView.layoutManager = layoutManagerCards
        recyclerAdapterCards = CardsAdapter(cardsList)
        cardsRecyclerView.adapter = recyclerAdapterCards


        //
        var toolbar = binding.toolbar
        toolbar.notificationIcon.visibility = View.VISIBLE
        toolbar.profileIcon.visibility = View.VISIBLE
        toolbar.mainPageHeader.visibility = View.VISIBLE

        toolbar.profileIcon.setOnClickListener{
            var action = MainFragmentDirections.actionMainFragmentToProfileFragment()
            findNavController().navigate(action)
        }

    }

}