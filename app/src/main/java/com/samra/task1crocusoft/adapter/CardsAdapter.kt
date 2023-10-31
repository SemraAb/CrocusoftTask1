package com.samra.task1crocusoft.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.samra.task1crocusoft.databinding.RecyclerRowCardsBinding
import com.samra.task1crocusoft.model.CardsModel

class CardsAdapter(var cardsList: List<CardsModel>): RecyclerView.Adapter<CardsAdapter.CardsHolder>() {
    class CardsHolder(var binding:RecyclerRowCardsBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsHolder {
        var binding = RecyclerRowCardsBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return CardsHolder(binding)
    }

    override fun getItemCount(): Int {
        return cardsList.size
    }

    override fun onBindViewHolder(holder: CardsHolder, position: Int) {
        var item = cardsList[position]

        holder.binding.cardText.text = item.text
        holder.binding.cardIcon.setImageResource(item.imageSrc)
        holder.binding.recyclerRowCards.setCardBackgroundColor(Color.parseColor(item.bgColor))
    }
}