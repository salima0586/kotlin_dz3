package com.example.kotlin_dz3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin_dz3.MainActivity.Companion.KEY
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private var imageadapter: Imageadapter? = null
    private var imageView: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val url: ArrayList<String>? = intent.getStringArrayListExtra(KEY)
        if (url != null) {
            imageView = url
        }
        imageadapter = Imageadapter(imageView)

        recyclerView2.apply {
            layoutManager = GridLayoutManager(this@SecondActivity, 3)
            adapter = imageadapter
        }
        imageadapter?.setOnItemClickListener(object : Imageadapter.ItemListener {
            override fun onClick(s: String) {
            }
        })
        back.setOnClickListener {
            backActivity()
        }

    }

    private fun backActivity() {
        val intent = Intent(this@SecondActivity, MainActivity::class.java)
        startActivity(intent)
    }
}
