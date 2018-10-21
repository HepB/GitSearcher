package com.github.hepb.gitsearcher.ui.fragments

import android.support.v4.app.Fragment

fun createFragment(fragmentType: FragmentType): Fragment = when (fragmentType) {
    FragmentType.SEARCH_USER -> SearchUserFragment.newInstance()
    FragmentType.USER -> UserDetailsFragment.newInstance()
    FragmentType.REPOS -> ReposListFragment.newInstance()
}