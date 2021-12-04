package com.example.kotlin_dz3

import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_rv.view.*

fun ImageView.load(url:String){
    Glide.with(context).load(url).centerCrop().into(image_view)
}