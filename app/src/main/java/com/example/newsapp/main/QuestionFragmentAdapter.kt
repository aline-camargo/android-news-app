package com.example.newsapp.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.data.Article
import com.example.newsapp.data.Articles
import com.example.newsapp.databinding.ArticleItemBinding

class QuestionFragmentAdapter(
    private val data: Articles
) : RecyclerView.Adapter<QuestionFragmentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    class ViewHolder private constructor(private val binding: ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: Article
        ) {
            binding.article = item
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

// TODO: Implement "onArticleClick"
// class ClueListener(val clickListener: (correctAnswer: String, userAnswer: String) -> Unit) {
//    fun onClick(clue: Clue, userAnswer: String) = clickListener(clue.answer, userAnswer)
// }
