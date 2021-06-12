package com.keshav.wallpaperapp.repository.datamodels

data class ApiResponse(
    val page: Int,
    val per_page: Int,
    val photos: List<PhotoItem>
)