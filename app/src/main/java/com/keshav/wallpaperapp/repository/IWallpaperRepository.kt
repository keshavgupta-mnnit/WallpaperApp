package com.keshav.wallpaperapp.repository

import com.keshav.wallpaperapp.repository.datamodels.PhotoItem
import io.reactivex.Observable

interface IWallpaperRepository {
    fun getWallpapers(pageNo: Int, itemsPerPage: Int): Observable<List<PhotoItem>>
}