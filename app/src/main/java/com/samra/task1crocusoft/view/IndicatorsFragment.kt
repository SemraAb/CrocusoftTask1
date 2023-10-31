package com.samra.task1crocusoft.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.samra.task1crocusoft.adapter.ViewPager2Adapter
import com.samra.task1crocusoft.databinding.FragmentIndicatorsBinding


class IndicatorsFragment : Fragment() {
    private lateinit var binding: FragmentIndicatorsBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIndicatorsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = binding.viewPager2
        tabLayout = binding.tabLayout

        val adapter = ViewPager2Adapter(requireActivity())

        adapter.addFragment(YearFragment(), "Yearly")
        adapter.addFragment(MonthFragment(), "Monthly")

        viewPager.adapter = adapter


        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()

        //header
        var toolbar = binding.toolbar
        toolbar.notificationIcon.visibility = View.VISIBLE
        toolbar.profileIcon.visibility = View.VISIBLE
        toolbar.indicatorsPageHeader.visibility = View.VISIBLE

        toolbar.profileIcon.setOnClickListener{
            var action = IndicatorsFragmentDirections.actionIndicatorsFragmentToProfileFragment()
            findNavController().navigate(action)
        }

    }

}