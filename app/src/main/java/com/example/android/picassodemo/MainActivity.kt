package com.example.android.picassodemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.picassodemo.adapter.ImageGalleryAdapter
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var imageGalleryAdapter: ImageGalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = GridLayoutManager(this, 2)
        recyclerView = findViewById(R.id.rv_images)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager
        imageGalleryAdapter = ImageGalleryAdapter(this, SunsetPhotoAdapter.getSunsetPhotos())
    }

    override fun onStart() {
        super.onStart()
        recyclerView.adapter = imageGalleryAdapter
    }


}