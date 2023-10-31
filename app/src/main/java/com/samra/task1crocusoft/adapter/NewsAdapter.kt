package com.samra.task1crocusoft.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.samra.task1crocusoft.databinding.RecyclerRowNewsBinding
import com.samra.task1crocusoft.model.NewsModel

class NewsAdapter(var newsList: List<NewsModel>): RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    class NewsHolder(var binding: RecyclerRowNewsBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        var binding = RecyclerRowNewsBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return NewsHolder(binding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
       var item =newsList[position]

        holder.binding.newsImage.setImageResource(item.imageSrc)
        holder.binding.newsText.text = item.text


    }
}