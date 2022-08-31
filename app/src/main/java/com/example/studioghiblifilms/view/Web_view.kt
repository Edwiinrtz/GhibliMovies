package com.example.studioghiblifilms.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.studioghiblifilms.databinding.ActivityWebViewBinding
import com.example.studioghiblifilms.model.Film

@Suppress("DEPRECATION")
class Web_view : AppCompatActivity() {

    private lateinit var binding : ActivityWebViewBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)

        window.decorView.apply {
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        setContentView(binding.root)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val i = getIntent()

        val film = i.getSerializableExtra("film") as Film

        val webView: WebView = binding.webView
        webView.settings.javaScriptEnabled = true

        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = WebViewClient()

        //webView.loadUrl("https://google.com")
        webView.loadUrl(film.link)
        //webView.loadData(film.link, "text/html", null)
    }
}
