package com.linhnv.mfvtest.ui.articles

import com.linhnv.mfvtest.R
import com.linhnv.mfvtest.base.BasePresenter
import com.linhnv.mfvtest.network.ArticlesApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by linhnv on 01/10/2018.
 */
class ArticlesPresenter(articlesView: ArticlesView) : BasePresenter<ArticlesView>(articlesView) {

    @Inject
    lateinit var postApi: ArticlesApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadArticles()
    }

    private fun loadArticles() {
        view.showLoading()
        subscription = postApi
                .getArticles()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe({
                    view.updateArticles(it.articles)
                }, {
                    view.showError(R.string.unknown_error)
                })
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}