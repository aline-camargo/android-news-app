package com.example.newsapp.articledetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.newsapp.R
import com.example.newsapp.databinding.ArticleDetailsFragmentBinding

class ArticleDetailsFragment : Fragment() {

    private lateinit var viewModelFactory: ArticleDetailsViewModelFactory
    private lateinit var articleDetailsViewModel: ArticleDetailsViewModel
    private lateinit var viewDataBinding: ArticleDetailsFragmentBinding

    private val args: ArticleDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(
            inflater, R.layout.article_details_fragment, container,
            false
        )
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModelFactory = ArticleDetailsViewModelFactory(args.article)
        articleDetailsViewModel = ViewModelProvider(this, viewModelFactory).get(ArticleDetailsViewModel::class.java)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        viewDataBinding.viewModel = articleDetailsViewModel
    }
}
