package com.github.hepb.gitsearcher.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter

import com.github.hepb.gitsearcher.R
import com.github.hepb.gitsearcher.presenter.SearchPresenter
import com.github.hepb.gitsearcher.utils.hideKeyboard
import com.github.hepb.gitsearcher.view.MvpSearchView
import kotlinx.android.synthetic.main.fragment_search_user.*
import timber.log.Timber

class SearchUserFragment : MvpAppCompatFragment(), MvpSearchView {

    @InjectPresenter
    lateinit var searchPresenter: SearchPresenter

    companion object {
        @JvmStatic
        fun newInstance() = SearchUserFragment().apply { arguments = Bundle().apply {} }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search_user, container, false)
    }

    override fun onResume() {
        super.onResume()
        initView()
    }

    override fun setFoundedUsers(userName: String) {
        Timber.i("Set founded users")
    }

    //init view methods
    //TODO: по хорошему тут бы сделать CustomView, и вынести его в отдельный модуль, но это потом
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
        hideKeyboard(context, searchView)
        searchPresenter.searchUser(searchView.text.toString())
    }
}
