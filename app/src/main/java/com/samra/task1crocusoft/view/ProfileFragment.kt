package com.samra.task1crocusoft.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.samra.task1crocusoft.R
import com.samra.task1crocusoft.databinding.FragmentMoreBinding
import com.samra.task1crocusoft.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //header
        var toolbar = binding.toolbar
        toolbar.backLineIcon.visibility = View.VISIBLE
        toolbar.profilePageHeader.visibility = View.VISIBLE

        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.visibility = View.GONE
        toolbar.backLineIcon.setOnClickListener{
            findNavController().popBackStack()
            bottomNav.visibility = View.VISIBLE
        }
    }

}