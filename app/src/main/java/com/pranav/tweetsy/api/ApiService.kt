package com.pranav.tweetsy.api

import com.pranav.tweetsy.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiService {

    @GET("/v3/b/66ed43f9acd3cb34a887f1c3?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path")category: String): Response<List<TweetListItem>>

    @GET("/v3/b/66ed43f9acd3cb34a887f1c3?meta=false")
    @Headers("X-JSON-Path : tweets..category")
    suspend fun getCategory(): Response<List<String>>

}