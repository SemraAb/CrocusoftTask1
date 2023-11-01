package com.samra.task1crocusoft.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.samra.task1crocusoft.R
import com.samra.task1crocusoft.databinding.FragmentMainBinding
import com.samra.task1crocusoft.databinding.FragmentMoreBinding
import com.samra.task1crocusoft.databinding.FragmentPaymentBinding


class MoreFragment : Fragment() {

    private lateinit var binding: FragmentMoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoreBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var toolbar = binding.toolbar
        toolbar.notificationIcon.visibility = View.VISIBLE
        toolbar.profileIcon.visibility = View.VISIBLE
        toolbar.morePageHeader.visibility = View.VISIBLE

        toolbar.profileIcon.setOnClickListener{
            var action = MoreFragmentDirections.actionMoreFragmentToProfileFragment()
            findNavController().navigate(action)
        }

        binding.frequentlyQuestions.setOnClickListener{
            var action = MoreFragmentDirections.actionMoreFragmentToQuestionsFragment()
            findNavController().navigate(action)
        }
        binding.securityQuestions.setOnClickListener{
            var action = MoreFragmentDirections.actionMoreFragmentToWebViewFragment()
            findNavController().navigate(action)
        }

    }
}