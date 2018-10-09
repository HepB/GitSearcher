package com.github.hepb.gitsearcher.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter

import com.github.hepb.gitsearcher.R
import com.github.hepb.gitsearcher.presenter.SearchPresenter
import com.github.hepb.gitsearcher.view.MvpSearchView
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

    override fun setFoundedUsers(userName: String) {
        Timber.i("")
    }

    private fun initView() {

    }

}
