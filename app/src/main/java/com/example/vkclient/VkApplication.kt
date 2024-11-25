package com.example.vkclient

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.vkclient.di.ApplicationComponent
import com.example.vkclient.di.DaggerApplicationComponent
import com.example.vkclient.domain.entity.FeedPost

class VkApplication : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().crate(this)
    }

}


@Composable
fun getApplicationComponent() : ApplicationComponent {
    return (LocalContext.current.applicationContext as VkApplication).component
}