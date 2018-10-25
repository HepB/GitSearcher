package com.github.hepb.gitsearcher.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.hepb.gitsearcher.R
import com.github.hepb.gitsearcher.data.model.view.SearchUserViewModel
import com.github.hepb.gitsearcher.utils.loadPhoto
import kotlinx.android.synthetic.main.item_search_user.view.*

class SearchUsersViewAdapter(private val listener: (SearchUserViewModel) -> Unit): RecyclerView.Adapter<SearchUsersViewAdapter.SearchUserViewHolder>() {
    val searchUserList: MutableList<SearchUserViewModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, index: Int): SearchUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_user, parent, false)
        return SearchUserViewHolder(view)
    }

    override fun getItemCount(): Int = searchUserList.size

    override fun onBindViewHolder(holder: SearchUserViewHolder, index: Int) {
        holder.bind(searchUserList[index], listener)
    }

    class SearchUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: SearchUserViewModel, clickListener: (SearchUserViewModel) -> Unit) {
            itemView.avatar.loadPhoto(data.avatarUrl)
            itemView.name.text = data.login
            itemView.type.text = data.type
            itemView.score.text = data.score.toString()
            itemView.setOnClickListener{clickListener(data)}
        }
    }
}
