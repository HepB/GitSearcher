package com.github.hepb.gitsearcher.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.github.hepb.gitsearcher.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(){

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_user -> {
                message.setText(R.string.title_user)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_repos -> {
                message.setText(R.string.title_repos)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
