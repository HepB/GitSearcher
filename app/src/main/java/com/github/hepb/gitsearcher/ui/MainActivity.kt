package com.github.hepb.gitsearcher.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.github.hepb.gitsearcher.R
import com.github.hepb.gitsearcher.presenter.NavigationMenuPresenter
import com.github.hepb.gitsearcher.presenter.SearchPresenter
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : MvpAppCompatActivity(),
        BottomNavigationMvpView,
        MvpSearchView
{
    private lateinit var searchView: SearchView

    @InjectPresenter lateinit var bottomNavPresenter: NavigationMenuPresenter
    @InjectPresenter lateinit var searchPresenter: SearchPresenter

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        searchView = menu!!.getItem(0).actionView as SearchView
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        R.id.item_search -> true
        else -> false
    }

    override fun selectUser() {
        Timber.d("Function selectUser")
        message.setText(R.string.title_user)
    }

    override fun selectRepos() {
        Timber.d("Function selectRepos")
        message.setText(R.string.title_repos)
    }

    override fun searchUser(userName: String) {

    }
}
