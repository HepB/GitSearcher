package com.github.hepb.gitsearcher.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.github.hepb.gitsearcher.GlideApp

private const val TIMEOUT = 60000

fun View.hideKeyboard() {
    val imm: InputMethodManager = getContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

fun ImageView.loadPhoto(url: String) {
    GlideApp.with(this)
            .load(url)
            .centerCrop()
            .timeout(TIMEOUT)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this)
}

