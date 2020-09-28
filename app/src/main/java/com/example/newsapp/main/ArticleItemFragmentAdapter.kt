package com.example.newsapp.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.data.Article
import com.example.newsapp.data.Articles
import com.example.newsapp.databinding.ArticleItemBinding

class ArticleItemFragmentAdapter(
    private val data: Articles,
    private val clickListener: ArticleItemListener
) : RecyclerView.Adapter<ArticleItemFragmentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], clickListener)
    }

    override fun getItemCount() = data.size

    class ViewHolder private constructor(private val binding: ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: Article,
            clickListener: ArticleItemListener
        ) {
            binding.article = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ArticleItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

 class ArticleItemListener(val clickListener: (article: Article) -> Unit) {
    fun onClick(article: Article) = clickListener(article)
 }
