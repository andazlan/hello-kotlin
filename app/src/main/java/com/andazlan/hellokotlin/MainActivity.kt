package com.andazlan.hellokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var items: MutableList<Club> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listClub = findViewById<RecyclerView>(R.id.list_club)
        initData()

        listClub.layoutManager = LinearLayoutManager(this);
        listClub.adapter = ClubAdapter(this, items)
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)

        items.clear()
        for (i in name.indices) {
            items.add(Club(name[i], image.getResourceId(i, 0)))
        }
        image.recycle()
    }
}
