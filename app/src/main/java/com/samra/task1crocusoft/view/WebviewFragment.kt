package com.samra.task1crocusoft.view

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.samra.task1crocusoft.R
import com.samra.task1crocusoft.databinding.FragmentServicesBinding
import com.samra.task1crocusoft.databinding.FragmentWebviewBinding


class WebviewFragment : Fragment() {
    private lateinit var binding: FragmentWebviewBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWebviewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var webView = binding.webView
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.google.com/")
        webView.settings.setSupportZoom(true)


        var toolbar = binding.toolbar
        toolbar.servicesPageHeader.visibility = View.VISIBLE


    }
}