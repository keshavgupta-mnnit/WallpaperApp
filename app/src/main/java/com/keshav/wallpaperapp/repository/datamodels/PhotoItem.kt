package com.keshav.wallpaperapp.repository.datamodels

data class PhotoItem(
    val id: Int,
    val width: Int,
    val height: Int,
    val url: String = "",
    val photographer: String = "",
    val photographer_url: String = "",
    val photographer_id: Int,
    val avg_color: String = "",
    val src: PhotoSource? = null
)