package com.example.catnews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.catnews.databinding.FragmentWebLinkBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebLinkFragment :BaseFragment<FragmentWebLinkBinding>() {
    var url : String? = null
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWebLinkBinding {
        return FragmentWebLinkBinding.inflate(inflater,container,false)
    }

    override fun initArgument() {
        url = arguments?.getString("URL")
        //url = "https://www.google.com"
    }

    override fun init() {
        url?.let { lodeUrlToWebView(it) }
    }

    private fun lodeUrlToWebView(url:String){
        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl(url)
    }

}