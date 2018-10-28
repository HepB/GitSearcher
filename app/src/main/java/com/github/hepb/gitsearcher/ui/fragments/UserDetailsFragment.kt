package com.github.hepb.gitsearcher.ui.fragments

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter

import com.github.hepb.gitsearcher.R
import com.github.hepb.gitsearcher.data.model.view.UserViewModel
import com.github.hepb.gitsearcher.presenter.UserPresenter
import com.github.hepb.gitsearcher.utils.loadPhoto
import com.github.hepb.gitsearcher.view.MvpUserView
import kotlinx.android.synthetic.main.fragment_user_details.*

class UserDetailsFragment : MvpAppCompatFragment(), MvpUserView {

    @InjectPresenter
    lateinit var userPresenter: UserPresenter

    companion object {
        @JvmStatic
        fun newInstance() = UserDetailsFragment().apply { arguments = Bundle().apply {} }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    override fun onResume() {
        super.onResume()
        userPresenter.getUser()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if(!hidden) {
            userPresenter.getUser()
        }
    }

    override fun initUserView(user: UserViewModel) {
        login.text = user.login
        name.text = getString(R.string.user_name, user.name)
        organization.text = getString(R.string.user_organization, user.company)
        avatar.loadPhoto(user.avatarUrl)
        location.text = getString(R.string.user_location, user.location)
        type.text = getString(R.string.user_type, user.type)
        publicRepos.text = getString(R.string.user_repos_count, user.publicReposNum)
        followers.text = getString(R.string.user_followers, user.followers)
        following.text = getString(R.string.user_following, user.following)
        createdAt.text = getString(R.string.user_created_at, user.createdAt)
        updatedAt.text = getString(R.string.user_updated_at, user.updatedAt)
        noData.visibility = View.GONE
    }

    override fun onLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun onLoadingComplete() {
        progress.visibility = View.GONE
    }

    override fun showMessage(message: String) {
        Snackbar.make(layout, message, Snackbar.LENGTH_LONG).show()
    }
}
