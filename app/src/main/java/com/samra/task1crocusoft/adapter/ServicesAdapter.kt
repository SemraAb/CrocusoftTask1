package com.samra.task1crocusoft.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.samra.task1crocusoft.R
import com.samra.task1crocusoft.databinding.RecyclerRowServicesBinding
import com.samra.task1crocusoft.model.ServicesModel

class ServicesAdapter(var servicesList: List<ServicesModel> ): RecyclerView.Adapter<ServicesAdapter.ServiceHolder>() {
    class ServiceHolder (var binding: RecyclerRowServicesBinding):RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceHolder {
        var binding = RecyclerRowServicesBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ServiceHolder(binding)
    }

    override fun getItemCount(): Int {
        return servicesList.size
    }

    override fun onBindViewHolder(holder: ServiceHolder, position: Int) {
        val item = servicesList[position]

        // Get the text resource from strings.xml
        val context = holder.itemView.context
        val text = context.getString(item.textSrc)
        val resourceId = context.resources.getIdentifier(item.imageSrc, "drawable", context.packageName)
        holder.binding.servicesImg.setImageResource(resourceId)
        holder.binding.servicesText.text = text

        applyPaletteColorsToCardView(resourceId, holder.binding.colorHolder , context)

    }
    private fun applyPaletteColorsToCardView(image: Int, view: CardView, context:Context) {
        val bitmap= ContextCompat.getDrawable(context,image)!!.toBitmap()
        val dominantColor=ContextCompat.getColor(context, R.color.magenta)
        val color=Palette.from(bitmap).generate().getDominantColor(dominantColor)
        view.setCardBackgroundColor(color)
    }
}


