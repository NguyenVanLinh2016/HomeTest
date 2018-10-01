package com.linhnv.mfvtest.network

import com.linhnv.mfvtest.model.ArticleResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by linhnv on 01/10/2018.
 */
interface ArticlesApi {
    /**
     * Get the list of the pots from the API
     */


    @GET("/example-feed/feed.json")
    fun getArticles(): Observable<ArticleResponse>
}