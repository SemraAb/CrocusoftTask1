package com.samra.task1crocusoft.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.samra.task1crocusoft.databinding.FragmentPaymentBinding
import com.samra.task1crocusoft.databinding.RecyclerRowPaymentBinding
import com.samra.task1crocusoft.model.PaymentModel

class PaymentAdapter(var paymentList: List<PaymentModel>) :
    RecyclerView.Adapter<PaymentAdapter.PaymentHolder>() {


    class PaymentHolder(var binding: RecyclerRowPaymentBinding) :
        RecyclerView.ViewHolder(binding.root) {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentHolder {
        var binding = RecyclerRowPaymentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PaymentHolder(binding)
    }

    override fun getItemCount(): Int {
        return paymentList.size
    }

    override fun onBindViewHolder(holder: PaymentHolder, position: Int) {
        var item = paymentList[position]

        val usedEnergyText = "${item.usedEnergy} kW/s"

        holder.binding.date.text = item.date
        holder.binding.balance.text = item.usedBalance.toString()
        holder.binding.totalEnergy.text = item.totalEnergy.toString()
        holder.binding.usedEnergy.text = usedEnergyText
    }
}
