package com.samra.task1crocusoft.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.samra.task1crocusoft.R
import com.samra.task1crocusoft.adapter.ServicesAdapter
import com.samra.task1crocusoft.databinding.FragmentServicesBinding
import com.samra.task1crocusoft.model.ServicesModel


class ServicesFragment : Fragment() {
    private lateinit var binding: FragmentServicesBinding
    private lateinit var recyclerAdapterServices : ServicesAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentServicesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val servicesList = listOf(
            ServicesModel("services_icon_1" , R.string.services_text_1),
            ServicesModel("services_icon_2" , R.string.services_text_2),
            ServicesModel("services_icon_3" , R.string.services_text_3),
            ServicesModel("services_icon_4" , R.string.services_text_4),
            ServicesModel("services_icon_5" , R.string.services_text_5),
            ServicesModel("services_icon_6" , R.string.services_text_6),
            ServicesModel("services_icon_7", R.string.services_text_7),
            ServicesModel("services_icon_8" , R.string.services_text_8),
        )

        var servicesRecyclerView = binding.servicesRecyclerView
        // hedaindg
        var toolbar = binding.toolbar
        toolbar.notificationIcon.visibility = View.VISIBLE
        toolbar.profileIcon.visibility = View.VISIBLE
        toolbar.servicesPageHeader.visibility = View.VISIBLE

        toolbar.profileIcon.setOnClickListener{
            var action = ServicesFragmentDirections.actionServicesFragmentToProfileFragment()
            findNavController().navigate(action)
        }


        //color palette
//        val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.services_icon_1)
//        val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.services_icon_2)
//        val bitmap3 = BitmapFactory.decodeResource(resources, R.drawable.services_icon_3)
//        val bitmap4 = BitmapFactory.decodeResource(resources, R.drawable.services_icon_4)
//        val bitmap5 = BitmapFactory.decodeResource(resources, R.drawable.services_icon_5)
//        val bitmap6 = BitmapFactory.decodeResource(resources, R.drawable.services_icon_6)
//        val bitmap7 = BitmapFactory.decodeResource(resources, R.drawable.services_icon_7)
//        val bitmap8 = BitmapFactory.decodeResource(resources, R.drawable.services_icon_8)

        recyclerAdapterServices = ServicesAdapter(servicesList)
        servicesRecyclerView.adapter = recyclerAdapterServices

    }


}