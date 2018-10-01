package com.linhnv.mfvtest.base

import com.linhnv.mfvtest.injection.component.DaggerPresenterInjector
import com.linhnv.mfvtest.injection.component.PresenterInjector
import com.linhnv.mfvtest.injection.module.ContextModule
import com.linhnv.mfvtest.injection.module.NetworkModule
import com.linhnv.mfvtest.ui.articles.ArticlesPresenter

/**
 * Created by linhnv on 01/10/2018.
 */
abstract class BasePresenter<out V : BaseView>(protected val view: V) {
    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated(){}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed(){}

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is ArticlesPresenter -> injector.inject(this)
        }
    }
}