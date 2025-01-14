package com.example.vkclient.di

import androidx.lifecycle.ViewModel
import com.example.vkclient.presentation.comments.CommentsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CommentsViewModelModule {

    @IntoMap
    @ViewModelKey(CommentsViewModel::class)
    @Binds
    fun bindCommentsViewModel(impl: CommentsViewModel): ViewModel
}