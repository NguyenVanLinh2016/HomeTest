package com.linhnv.mfvtest.network

import com.linhnv.mfvtest.model.Articles
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

/**
 * Created by linhnv on 01/10/2018.
 */
interface ArticlesApi {
    /**
     * Get the list of the pots from the API
     */


    @GET("/example-feed/feed.json")
    fun getArticles(): Observable<List<Articles.Article>>
}