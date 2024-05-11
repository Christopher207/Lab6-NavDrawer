package com.example.lab6_navdrawer.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.lab6_navdrawer.databinding.FragmentGalleryBinding
import com.example.lab6_navdrawer.ui.shared.HomeGalleryViewModel

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val homegalleryViewModel: HomeGalleryViewModel by activityViewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val wbPage = binding.wbPage //Ya no se hace el findViewById
        wbPage.settings.javaScriptEnabled = true
        wbPage.webViewClient = object: WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if(url!=null){
                    view?.loadUrl(url)
                }
                return true
            }
        }
        homegalleryViewModel.url.observe(viewLifecycleOwner){url->
            wbPage.loadUrl(url)
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}