package com.example.vkclient.data.model

import com.google.gson.annotations.SerializedName

data class NewsFeedResponseDto(
    @SerializedName("response") val newsFeedContent : NewsFeedContentDto
)
