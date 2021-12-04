package com.example.kotlin_dz3

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rv.view.*

class Imageadapter (private val img:ArrayList<String>):RecyclerView.Adapter<Imageadapter.ViewHolder>() {

    private lateinit var clickListener: ItemListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false),clickListener)
    }

    fun setOnItemClickListener(clickListener: ItemListener){
        this.clickListener = clickListener
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(img[position])
    }

    override fun getItemCount(): Int {
        return img.size
    }

    class ViewHolder(itemView: View, var clickListener: ItemListener): RecyclerView.ViewHolder(itemView) {

        fun onBind(s: String) {
            itemView.image_view.load(s)
            itemView.setOnClickListener{
                it.setBackgroundColor(Color.BLUE)
                clickListener.onClick(s)
            }

        }
    }
    interface ItemListener {
        fun onClick(s: String)
    }
}