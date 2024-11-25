package com.example.vkclient.navigation

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.vkclient.domain.entity.FeedPost

fun NavGraphBuilder.homeScreenNavGraph(
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (FeedPost) -> Unit
) {
    navigation(
        startDestination = Screen.NewsFeed.routeTitle,
        route = Screen.Home.routeTitle
    ) {
        composable(Screen.NewsFeed.routeTitle) {
            newsFeedScreenContent()
        }
        composable(
            route = Screen.Comments.routeTitle,
            arguments = listOf(
                navArgument(Screen.KEY_FEED_POST) {
                    type = FeedPost.NavigationType
                }
            )
        ) {
            val feedPost = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.arguments?.getParcelable(
                    Screen.KEY_FEED_POST,
                    FeedPost::class.java
                ) ?: throw RuntimeException("Args is null")
            } else {
                it.arguments?.getParcelable(
                    Screen.KEY_FEED_POST
                ) ?: throw RuntimeException("Args is null")
            }
            commentsScreenContent( feedPost)
        }
    }
}