package com.keshav.wallpaperapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import com.keshav.wallpaperapp.R
import com.keshav.wallpaperapp.ui.adapter.PhotoAdapter
import com.keshav.wallpaperapp.ui.adapter.PhotoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class PhotoActivity : AppCompatActivity() {
    val TAG = PhotoActivity::class.java.canonicalName
    private val viewModel: PhotoViewModel by viewModel()
    private lateinit var adapter: PhotoAdapter
    private var pageNo = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.state.observe(this, Observer { render(it) })

        adapter = PhotoAdapter(::launchFullPhotoActivity)
        rv_photos.adapter = adapter
        viewModel.getPhotos(pageNo)

        scrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                viewModel.getPhotos(++pageNo)
            }
        })

    }

    private fun render(state: PhotoActivityStates) {
        when (state) {
            is IsLoading -> {
                progressBar.visibility = View.VISIBLE
            }
            is ErrorState -> {
                progressBar.visibility = View.GONE
                Log.d(TAG, state.message)
            }
            is DataLoaded -> {
                progressBar.visibility = View.GONE
                adapter.setData(state.photoList)
                rv_photos.visibility = View.VISIBLE
            }
        }

    }

    private fun launchFullPhotoActivity(imageUrl: String) {
        val intent = Intent(this, FullPhotoActivity::class.java)
        intent.putExtra("imageUrl", imageUrl)
        startActivity(intent)
    }
}