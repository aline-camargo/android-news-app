package com.example.newsapp.di

import androidx.lifecycle.ViewModel
import com.example.newsapp.main.MainNewsFragment
import com.example.newsapp.main.MainNewsViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainNewsModule {
    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    internal abstract fun startGameFragment(): MainNewsFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainNewsViewModel::class)
    abstract fun bindViewModel(viewModel: MainNewsViewModel): ViewModel
}
