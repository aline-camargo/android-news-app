package com.example.newsapp.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.databinding.MainNewsFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainNewsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val mainNewsViewModel: MainNewsViewModel by viewModels { viewModelFactory }
    private lateinit var viewDataBinding: MainNewsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(
            inflater, R.layout.main_news_fragment, container,
            false
        )
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainNewsViewModel.articles.observe(
            viewLifecycleOwner,
            Observer {
                viewDataBinding.articlesRecyclerView.apply {
                    val linearLayout = LinearLayoutManager(context)
                    layoutManager = linearLayout
                    adapter = ArticleItemFragmentAdapter(it, ArticleItemListener { article ->
                        val action = MainNewsFragmentDirections.actionMainNewsFragmentToArticleDetailsFragment(article)
                        findNavController().navigate(action)
                    })
                }
            }
        )

        mainNewsViewModel.clickedFab.observe(
            viewLifecycleOwner,
            Observer {
                val layoutManager = viewDataBinding.articlesRecyclerView.layoutManager
                layoutManager?.smoothScrollToPosition(viewDataBinding.articlesRecyclerView, null, 0)
            }
        )

        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        viewDataBinding.viewModel = mainNewsViewModel
    }
}
