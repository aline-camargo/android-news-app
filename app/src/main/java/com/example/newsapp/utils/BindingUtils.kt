package com.example.newsapp.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("setArticleItemFormatted")
fun TextView.setArticleItemFormatted(item: String?) {
    item?.let {
        text = item
    }
}

@BindingAdapter("setArticleImage")
fun setArticleImage(view: ImageView, imageUrl: String?) {
    Picasso.get()
        .load(imageUrl)
//        .placeholder(R.drawable.plac)
        .into(view)
}
