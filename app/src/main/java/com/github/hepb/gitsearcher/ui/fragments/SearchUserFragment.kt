package com.github.hepb.gitsearcher.ui.fragments

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter

import com.github.hepb.gitsearcher.R
import com.github.hepb.gitsearcher.data.model.view.SearchUserViewModel
import com.github.hepb.gitsearcher.presenter.SearchPresenter
import com.github.hepb.gitsearcher.ui.adapters.SearchUsersViewAdapter
import com.github.hepb.gitsearcher.utils.hideKeyboard
import com.github.hepb.gitsearcher.view.MvpSearchView
import kotlinx.android.synthetic.main.fragment_search_user.*
import timber.log.Timber
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

private const val PAGE_SIZE = 30

class SearchUserFragment : MvpAppCompatFragment(), MvpSearchView {
    private var page = 1
    private var isLoading = false
    private var isLastPage = false
    private var name: String = ""

    private val layoutManager: LinearLayoutManager = LinearLayoutManager(context)
    private val adapter = SearchUsersViewAdapter { item: SearchUserViewModel -> userItemClicked(item) }

    @InjectPresenter
    lateinit var searchPresenter: SearchPresenter

    companion object {
        @JvmStatic
        fun newInstance() = SearchUserFragment().apply { arguments = Bundle().apply {} }
    }

    //android callbacks
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search_user, container, false)
    }

    override fun onResume() {
        super.onResume()
        initView()
        initRecyclerView()
    }

    //view functions
    override fun setFoundedUsers(foundedUsers: List<SearchUserViewModel>) {
        Timber.i(foundedUsers.toString())
        if (foundedUsers.size < PAGE_SIZE) isLastPage = true
        adapter.searchUserList.addAll(foundedUsers)
        adapter.notifyDataSetChanged()
    }

    override fun onLoading() {
        isLoading = true
        progressBar.visibility = View.VISIBLE
    }

    override fun showMessage(message: String) {
        Snackbar.make(users, message, Snackbar.LENGTH_LONG).show()
    }

    override fun onLoadingComplete() {
        isLoading = false
        progressBar.visibility = View.GONE
    }

    override fun userSelected(name: String) {
        val message = getString(R.string.user_selected, name)
        Snackbar.make(users, message, Snackbar.LENGTH_LONG).show()
    }

    //inner methods
    private fun initRecyclerView() {
        users.layoutManager = layoutManager
        users.adapter = adapter
        users.addOnScrollListener(initScrollListener())

    }

    private fun initView() {
        initSearchViewBehavior()
        initSearchButtonBehavior()
    }

    private fun initSearchViewBehavior() {
        searchView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                searchPresenter.listenSearchText(s.toString())
            }
        })
        searchView.setOnEditorActionListener { _, _, _ ->
            prepareViewAndSearchUser()
            false
        }
    }

    private fun initSearchButtonBehavior() {
        buttonSearch.setOnClickListener { view ->
            prepareViewAndSearchUser()
        }
    }

    private fun prepareViewAndSearchUser() {
        searchView.hideKeyboard()
        page = 1
        name = searchView.text.toString()
        isLastPage = false
        adapter.searchUserList.clear()
        searchPresenter.searchUser(searchView.text.toString(), page, PAGE_SIZE)
    }

    private fun initScrollListener() = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            if (!isLoading && !isLastPage) {
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= PAGE_SIZE) {
                    loadNextPage()
                }
            }
        }
    }

    private fun loadNextPage() {
        searchPresenter.searchUser(name, ++page, PAGE_SIZE)
    }

    private fun userItemClicked(userModel: SearchUserViewModel) {
        searchPresenter.selectUser(userModel.login)
    }
}
