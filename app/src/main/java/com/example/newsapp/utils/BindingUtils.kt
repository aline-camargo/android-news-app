package com.example.newsapp.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("setArticleItemFormatted")
fun TextView.setArticleItemFormatted(item: String?) {
    item?.let {
        text = item
    }
}
