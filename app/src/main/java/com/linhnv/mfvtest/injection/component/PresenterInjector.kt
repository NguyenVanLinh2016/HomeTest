package com.linhnv.mfvtest.injection.component

import com.linhnv.mfvtest.base.BaseView
import com.linhnv.mfvtest.injection.module.ContextModule
import com.linhnv.mfvtest.injection.module.NetworkModule
import com.linhnv.mfvtest.ui.articles.ArticlesPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by linhnv on 01/10/2018.
 */

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {
    /**
     * Injects required dependencies into the specified ArticlesPresenter.
     * @param postPresenter ArticlesPresenter in which to inject the dependencies
     */
    fun inject(postPresenter: ArticlesPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}