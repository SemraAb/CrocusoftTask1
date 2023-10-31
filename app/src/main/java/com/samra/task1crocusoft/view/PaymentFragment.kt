package com.samra.task1crocusoft.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.samra.task1crocusoft.R
import com.samra.task1crocusoft.adapter.PaymentAdapter
import com.samra.task1crocusoft.databinding.FragmentPaymentBinding
import com.samra.task1crocusoft.databinding.FragmentServicesBinding
import com.samra.task1crocusoft.model.PaymentModel

class PaymentFragment : Fragment() {
    private lateinit var binding: FragmentPaymentBinding
    private lateinit var recyclerPaymentAdapter: PaymentAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPaymentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var paymentList = listOf(
            PaymentModel("06.03.2023" , 165 , 30632 , 11.55),
            PaymentModel("03.02.2023" , 274 , 30467 , 19.18),
            PaymentModel("05.01.2023" , 382 , 30193 , 30.02),
        )

        var recyclerViewPayment = binding.paymentRecyclerView
        recyclerViewPayment.layoutManager = LinearLayoutManager(context)
        recyclerPaymentAdapter = PaymentAdapter(paymentList)
        recyclerViewPayment.adapter = recyclerPaymentAdapter

        //header
        var toolbar = binding.toolbar
        toolbar.notificationIcon.visibility = View.VISIBLE
        toolbar.profileIcon.visibility = View.VISIBLE
        toolbar.paymentPageHeader.visibility = View.VISIBLE

        toolbar.profileIcon.setOnClickListener{
            var action = PaymentFragmentDirections.actionPaymentFragmentToProfileFragment()
            findNavController().navigate(action)
        }


        //limitation fragment
        binding.bottomItem.setOnClickListener{
            var action = PaymentFragmentDirections.actionPaymentFragmentToLimitFragment()
            findNavController().navigate(action)
        }
    }
}