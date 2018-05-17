package com.andazlan.hellokotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ClubAdapter(private val context: Context, private val clubs: List<Club>) : RecyclerView.Adapter<ClubAdapter.ClubHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ClubHolder {
        return ClubHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return clubs.count()
    }

    override fun onBindViewHolder(holder: ClubHolder, position: Int) {
        holder.bindItem(clubs[position])
    }


    class ClubHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.txt_title)
        val image = view.findViewById<ImageView>(R.id.img_pict)

        fun bindItem(club: Club) {
            name.text = club.name;
            Glide.with(itemView.context).load(club.image).into(image)
        }
    }
}