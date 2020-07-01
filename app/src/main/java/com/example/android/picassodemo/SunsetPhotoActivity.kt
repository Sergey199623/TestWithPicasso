package com.example.android.picassodemo

import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette
import com.squareup.picasso.Callback
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class SunsetPhotoActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_SUNSET_PHOTO = "SunsetPhotoActivity.EXTRA_SUNSET_PHOTO"
    }

    private lateinit var imageView: ImageView
    private lateinit var sunsetPhotoAdapter: SunsetPhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sunset_photo)

        sunsetPhotoAdapter = intent.getParcelableExtra(EXTRA_SUNSET_PHOTO)!!
        imageView = findViewById(R.id.image)
    }

    override fun onStart() {
        super.onStart()

        Picasso.get()
            .load(sunsetPhotoAdapter.url)
            .resize(50, 50)
            .centerCrop()
            .fit()
            .into(imageView, object : Callback {

                override fun onSuccess() {
                    val bitmap = (imageView.drawable as BitmapDrawable).bitmap
                    onPalette(Palette.from(bitmap).generate())
                }

                override fun onError(e: Exception?) {
                }
            })
    }

    fun onPalette(palette: Palette?) {
        if (null != palette) {
            val parent = imageView.parent.parent as ViewGroup
            parent.setBackgroundColor(palette.getDarkVibrantColor(Color.GRAY))
        }
    }
}