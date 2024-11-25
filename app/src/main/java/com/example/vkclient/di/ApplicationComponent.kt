package com.example.vkclient.di

import android.content.Context
import com.example.vkclient.domain.entity.FeedPost
import com.example.vkclient.presentation.ViewModelFactory
import com.example.vkclient.presentation.main.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun getViewModelFactory() : ViewModelFactory

    fun getCommentsScreenComponentFactory() : CommentsScreenComponent.Factory


    @Component.Factory
    interface Factory {
        fun crate(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}