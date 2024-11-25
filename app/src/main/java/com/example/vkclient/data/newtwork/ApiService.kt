package com.example.vkclient.data.newtwork

import com.example.vkclient.data.model.CommentsResponseDto
import com.example.vkclient.data.model.LikesCountResponseDto
import com.example.vkclient.data.model.NewsFeedResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("newsfeed.getRecommended?v=5.199")
    suspend fun loadRecommendation(
        @Query("access_token") token: String
    ): NewsFeedResponseDto

    @GET("newsfeed.getRecommended?v=5.199")
    suspend fun loadRecommendation(
        @Query("access_token") token: String,
        @Query("start_from") startFrom : String
    ): NewsFeedResponseDto


    @GET("likes.add?v=5.199&type=post")
    suspend fun addLike(
        @Query("access_token") token: String,
        @Query("owner_id") ownerId: Long,
        @Query("item_id") postId: Long
    ) : LikesCountResponseDto


    @GET("likes.delete?v=5.199&type=post")
    suspend fun deleteLike(
        @Query("access_token") token: String,
        @Query("owner_id") owner_id: Long,
        @Query("item_id") postId: Long
    ) : LikesCountResponseDto


    @GET("wall.getComments?v=5.199&extended=1&fields=photo_100")
    suspend fun getComments(
        @Query("access_token") token: String,
        @Query("owner_id") owner_id: Long,
        @Query("post_id") postId: Long
    ): CommentsResponseDto

    @GET("newsfeed.ignoreItem?v=5.199&type=post&type=wall")
    suspend fun ignorePost(
        @Query("access_token") token: String,
        @Query("owner_id") ownerId: Long,
        @Query("item_id") postId: Long
    )

}