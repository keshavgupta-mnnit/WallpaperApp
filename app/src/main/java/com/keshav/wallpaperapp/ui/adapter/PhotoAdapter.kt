package com.keshav.wallpaperapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.keshav.wallpaperapp.R
import com.keshav.wallpaperapp.repository.datamodels.PhotoItem
import kotlinx.android.synthetic.main.itemview_photo.view.*

class PhotoAdapter(private val wallPaperSelect: (String) -> Unit) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    private var photoList: MutableList<PhotoItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.itemview_photo, parent, false),
            wallPaperSelect
        )
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bindModel(photoList[position])
    }

    fun setData(list: List<PhotoItem>) {
        photoList.addAll(list)
        notifyDataSetChanged()
    }

    class PhotoViewHolder(itemView: View, private val wallPaperSelect: (String) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        fun bindModel(photoItem: PhotoItem) {
            itemView.tv_source.text = photoItem.photographer
            Glide.with(itemView).load(photoItem.src?.medium).into(itemView.iv_photo)
            itemView.iv_photo.setOnClickListener {
                photoItem.src?.let { it1 -> wallPaperSelect(it1.large) }
            }
        }
    }
}