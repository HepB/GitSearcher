package com.github.hepb.gitsearcher.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.github.hepb.gitsearcher.R
import com.github.hepb.gitsearcher.presenter.NavigationMenuPresenter
import com.github.hepb.gitsearcher.ui.fragments.*
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
        if (savedInstanceState == null) {
            goTo(FragmentType.SEARCH_USER)
        }
    }

    override fun selectSearchUser() {
        Timber.d("Function selectSearchUsers")
        goTo(FragmentType.SEARCH_USER)
    }

    override fun selectUser() {
        Timber.d("Function selectUser")
        goTo(FragmentType.USER)
    }

    override fun selectRepos() {
        Timber.d("Function selectRepos")
        goTo(FragmentType.REPOS)
    }

    private fun goTo(fragmentType: FragmentType) {
        val fragmentManager = supportFragmentManager
        val fragments = supportFragmentManager.fragments

        var currentFragment: Fragment? = null
        for (fragment in fragments) {
            if (fragment != null && fragment.isVisible) {
                currentFragment = fragment
            }
        }

        var newFragment = supportFragmentManager.findFragmentByTag(fragmentType.tag)

        if(currentFragment != null
                && newFragment != null
                && currentFragment == newFragment) return

        val fragmentTransaction = fragmentManager.beginTransaction()
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment)
        }
        if (newFragment != null) {
            fragmentTransaction.show(newFragment)
        } else {
            newFragment = createFragment(fragmentType)
            fragmentTransaction.add(R.id.container, newFragment, fragmentType.tag)
        }
        fragmentTransaction.commitNow()
    }

}
