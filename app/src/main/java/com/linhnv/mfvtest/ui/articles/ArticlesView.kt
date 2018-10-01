package com.linhnv.mfvtest.ui.articles

import android.support.annotation.StringRes
import com.linhnv.mfvtest.base.BaseView
import com.linhnv.mfvtest.model.Article

/**
 * Created by linhnv on 01/10/2018.
 */
interface ArticlesView : BaseView{
    fun updateArticles(articles: List<Article>)


    fun showError(error: String)

    fun showError(@StringRes errorResId: Int){
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()
}