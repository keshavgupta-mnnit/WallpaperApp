package com.keshav.wallpaperapp.repository.network

import com.keshav.wallpaperapp.repository.datamodels.PhotoItem
import io.reactivex.Observable

interface INetworkManager {
    fun getWallpapers(pageNo: Int, itemsPerPage: Int): Observable<List<PhotoItem>>
}