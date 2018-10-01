package com.linhnv.mfvtest.ui.articles

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.linhnv.mfvtest.R
import com.linhnv.mfvtest.base.BaseActivity
import com.linhnv.mfvtest.databinding.ActivityArticlesBinding
import com.linhnv.mfvtest.model.Article

class ArticlesActivity : BaseActivity<ArticlesPresenter>(), ArticlesView {

    /**
     * DataBinding instance
     */
    private lateinit var binding: ActivityArticlesBinding

    private val articlesAdapter = ArticlesAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_articles)
        binding.adapter = articlesAdapter
        binding.layoutManager = LinearLayoutManager(this)
        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun updateArticles(articles: List<Article>) {
        articlesAdapter.updateArticles(articles)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun instantiatePresenter(): ArticlesPresenter {
        return ArticlesPresenter(this)
    }
}
