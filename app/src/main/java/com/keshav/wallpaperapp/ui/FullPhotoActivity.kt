package com.keshav.wallpaperapp.ui

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.keshav.wallpaperapp.R
import com.keshav.wallpaperapp.ui.adapter.PhotoAdapter
import com.keshav.wallpaperapp.ui.adapter.PhotoViewModel
import kotlinx.android.synthetic.main.activity_full_image.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.itemview_photo.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.IOException


class FullPhotoActivity : AppCompatActivity() {
    val TAG = FullPhotoActivity::class.java.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)

        val url = intent.extras?.get("imageUrl")

        Glide.with(this).load(url).into(iv_fullImage)
        btn_setWallpaper.setOnClickListener {
            val image: Bitmap = (iv_fullImage.drawable as BitmapDrawable).bitmap
            setHomeScreen(image)
        }
    }

    private fun setHomeScreen(image: Bitmap) {
        val wallpaperManager = WallpaperManager.getInstance(applicationContext)
        try {
            wallpaperManager.setBitmap(image)
            Toast.makeText(applicationContext, "Wallpaper Set", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}