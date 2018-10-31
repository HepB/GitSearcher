package com.github.hepb.gitsearcher.ui.fragments

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter

import com.github.hepb.gitsearcher.R
import com.github.hepb.gitsearcher.data.model.view.RepositoryViewModel
import com.github.hepb.gitsearcher.presenter.RepoPresenter
import com.github.hepb.gitsearcher.ui.adapters.ReposViewAdapter
import com.github.hepb.gitsearcher.view.MvpReposView
import kotlinx.android.synthetic.main.fragment_repos_list.noData
import kotlinx.android.synthetic.main.fragment_repos_list.progress
import kotlinx.android.synthetic.main.fragment_repos_list.repos


class ReposListFragment : MvpAppCompatFragment(), MvpReposView {

    @InjectPresenter
    lateinit var presenter: RepoPresenter
    private val adapter = ReposViewAdapter()

    companion object {
        @JvmStatic
        fun newInstance() = ReposListFragment().apply { arguments = Bundle().apply {} }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_repos_list, container, false)
    }

    override fun onStart() {
        super.onStart()
        repos.adapter = adapter
        presenter.getRepos()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if(!hidden) {
            presenter.getRepos()
        }
    }

    override fun initRepos(repositories: List<RepositoryViewModel>) {
        adapter.repos.clear()
        adapter.repos.addAll(repositories)
        adapter.notifyDataSetChanged()
        noData.visibility = View.GONE
    }

    override fun onLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun onLoadingComplete() {
        progress.visibility = View.GONE
    }

    override fun showMessage(message: String) {
        Snackbar.make(repos, message, Snackbar.LENGTH_LONG).show()
    }
}
