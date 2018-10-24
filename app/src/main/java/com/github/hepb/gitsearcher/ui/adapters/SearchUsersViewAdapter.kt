package com.github.hepb.gitsearcher.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.hepb.gitsearcher.R
import com.github.hepb.gitsearcher.data.model.view.SearchUserViewModel
import com.github.hepb.gitsearcher.utils.loadPhoto
import kotlinx.android.synthetic.main.item_search_user.view.*

class SearchUsersViewAdapter: RecyclerView.Adapter<SearchUsersViewAdapter.SearchUserViewHolder>() {
    val searchUserList: MutableList<SearchUserViewModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, index: Int): SearchUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_user, parent, false)
        return SearchUserViewHolder(view)
    }

    override fun getItemCount(): Int = searchUserList.size

    override fun onBindViewHolder(holder: SearchUserViewHolder, index: Int) {
        holder.avatar.loadPhoto(searchUserList[index].avatarUrl)
        holder.name.text = searchUserList[index].login
        holder.type.text = searchUserList[index].type
        holder.score.text = searchUserList[index].score.toString()
    }

    class SearchUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar = itemView.avatar
        val name = itemView.name
        val type = itemView.type
        val score = itemView.score
    }
}
