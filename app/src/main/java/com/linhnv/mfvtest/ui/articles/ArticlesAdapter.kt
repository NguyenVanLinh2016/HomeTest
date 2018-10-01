package com.linhnv.mfvtest.ui.articles

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.linhnv.mfvtest.R
import com.linhnv.mfvtest.databinding.ItemArticlesBinding
import com.linhnv.mfvtest.model.Articles

/**
 * Created by linhnv on 01/10/2018.
 */
class ArticlesAdapter(private val context: Context): RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>(){

    private var articles: List<Articles.Article> = listOf();

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ArticlesViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemArticlesBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_articles, parent, false)
        return ArticlesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder?, position: Int) {
        holder?.bind(articles[position])
    }

    fun updateArticles(articles: List<Articles.Article>) {
        this.articles = articles
        notifyDataSetChanged()
    }

    class ArticlesViewHolder(private val binding: ItemArticlesBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(articles: Articles.Article){
            binding.articles = articles
            binding.executePendingBindings()
        }
    }
}

