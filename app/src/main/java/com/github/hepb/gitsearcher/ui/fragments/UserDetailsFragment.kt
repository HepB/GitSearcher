package com.github.hepb.gitsearcher.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment

import com.github.hepb.gitsearcher.R

class UserDetailsFragment : MvpAppCompatFragment() {

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

}
