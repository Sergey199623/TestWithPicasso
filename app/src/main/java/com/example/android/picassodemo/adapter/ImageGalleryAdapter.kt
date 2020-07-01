package com.example.android.picassodemo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.android.picassodemo.R
import com.example.android.picassodemo.SunsetPhotoActivity
import com.example.android.picassodemo.SunsetPhotoAdapter
import com.squareup.picasso.Picasso

class ImageGalleryAdapter(val context: Context, val sunsetPhotos: Array<SunsetPhotoAdapter>)
    : RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageGalleryAdapter.MyViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val photoView = inflater.inflate(R.layout.item_image, parent, false)
        return MyViewHolder(photoView)
    }

    override fun onBindViewHolder(holder: ImageGalleryAdapter.MyViewHolder, position: Int) {
        val sunsetPhotoAdapter = sunsetPhotos[position]
        val imageView = holder.photoImageView

        Picasso.get()
            .load(sunsetPhotoAdapter.url)
            .resize(50, 50)
            .centerCrop()
            .into(imageView)

    }

    override fun getItemCount(): Int {
        return sunsetPhotos.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var photoImageView: ImageView = itemView.findViewById(R.id.iv_photo)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val sunsetPhoto = sunsetPhotos[position]
                val intent = Intent(context, SunsetPhotoActivity::class.java).apply {
                    putExtra(SunsetPhotoActivity.EXTRA_SUNSET_PHOTO, sunsetPhoto)
                }
                startActivity(intent)
            }
        }

        private fun startActivity(intent: Intent) {

        }
    }
}