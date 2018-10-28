package com.github.hepb.gitsearcher.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.hepb.gitsearcher.App
import com.github.hepb.gitsearcher.R
import com.github.hepb.gitsearcher.data.model.view.RepositoryViewModel
import kotlinx.android.synthetic.main.item_repo.view.*

class ReposViewAdapter: RecyclerView.Adapter<ReposViewAdapter.RepoViewHolder>() {
    val repos: MutableList<RepositoryViewModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, index: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return RepoViewHolder(view)
    }

    override fun getItemCount(): Int = repos.size


    override fun onBindViewHolder(holder: RepoViewHolder, index: Int) {
        val item = repos[index]
        with(item) {
            holder.name.text= name
            holder.lang.text = App.component.appContext().getString(R.string.language, language)
            holder.watchers.text = App.component.appContext().getString(R.string.watchers, watchersCount)
            holder.created.text = App.component.appContext().getString(R.string.created, createdAt)
        }
    }

    class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.name
        val lang: TextView = itemView.language
        val watchers: TextView = itemView.watchers
        val created: TextView = itemView.createdAt
    }
}