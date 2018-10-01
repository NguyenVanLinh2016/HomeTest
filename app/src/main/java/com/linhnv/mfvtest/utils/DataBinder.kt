// Safe here as method are used by Data binding
@file:Suppress("unused")

package com.linhnv.mfvtest.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import com.linhnv.mfvtest.ui.articles.ArticlesAdapter

/**
 * Created by linhnv on 01/10/2018.
 */

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: ArticlesAdapter) {
    view.adapter = adapter
}

@BindingAdapter("layoutManager")
fun setLayoutManager(view: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
    view.layoutManager = layoutManager
}

@BindingAdapter("dividerItemDecoration")
fun setDividerItemDecoration(view: RecyclerView, dividerItemDecoration: DividerItemDecoration) {
    view.addItemDecoration(dividerItemDecoration)
}