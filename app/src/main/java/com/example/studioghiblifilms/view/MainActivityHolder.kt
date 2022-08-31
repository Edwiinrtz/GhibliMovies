package com.example.studioghiblifilms.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.studioghiblifilms.databinding.ActivityWebViewBinding
import com.example.studioghiblifilms.databinding.FilmBinding
import com.example.studioghiblifilms.model.Film


class MainActivityHolder(itemView: View, webViewItem: View) : RecyclerView.ViewHolder(itemView) {

    val binding = FilmBinding.bind(itemView)
    //val bindingWebView = ActivityWebViewBinding.bind(webViewItem)


    fun render(film: Film, onClickListener:(Film)->Unit) {
        binding.tvTitle.text = film.title
        binding.tvOriginalTitle.text = film.originalTitle
        binding.tvDate.text = film.realeseDate
        Glide.with(itemView.context).load(film.photo).centerCrop().into(binding.ivPhoto)
        binding.filmItem.setOnClickListener{
            onClickListener(film)
        }

        /*binding.btnWachOnline.setOnClickListener {
            val webView:WebView = binding.webView
            webView.getSettings().setJavaScriptEnabled(true);

            webView.webViewClient = WebViewClient()
            webView.webChromeClient = WebChromeClient()

            webView.loadData(film.link, "text/html", null)


            /*var page: Uri = Uri.parse(film.link)
            val intent = Intent(Intent.ACTION_VIEW,page)
            startActivity(itemView.context,intent,null)*/
        }*/
    }

}

