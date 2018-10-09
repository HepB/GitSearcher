package com.github.hepb.gitsearcher.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.github.hepb.gitsearcher.R
import com.github.hepb.gitsearcher.presenter.NavigationMenuPresenter
import com.github.hepb.gitsearcher.ui.fragments.ReposListFragment
import com.github.hepb.gitsearcher.ui.fragments.SearchUserFragment
import com.github.hepb.gitsearcher.ui.fragments.UserDetailsFragment
import com.github.hepb.gitsearcher.view.MvpBottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : MvpAppCompatActivity(),
        MvpBottomNavigationView {
    @InjectPresenter
    lateinit var bottomNavPresenter: NavigationMenuPresenter

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.search_user -> {
                Timber.d("Search button was pressed")
                bottomNavPresenter.selectSearchUser()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_user -> {
                Timber.d("User button was pressed")
                bottomNavPresenter.selectUser()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_repos -> {
                Timber.d("Navigation button was pressed")
                bottomNavPresenter.selectRepos()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.e("onCreate")
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = SearchUserFragment.newInstance()
        goTo(fragment)
    }

    override fun selectSearchUser() {
        Timber.d("Function selectSearchUsers")
        val fragment = SearchUserFragment.newInstance()
        goTo(fragment)
    }

    override fun selectUser() {
        Timber.d("Function selectUser")
        val fragment = UserDetailsFragment.newInstance()
        goTo(fragment)
    }

    override fun selectRepos() {
        Timber.d("Function selectRepos")
        val fragment = ReposListFragment.newInstance()
        goTo(fragment)
    }

    private fun goTo(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        //в backStack добавлять не будем, так как все доступно из nav
        fragmentTransaction.commit()
    }

}
