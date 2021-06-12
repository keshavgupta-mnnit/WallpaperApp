package com.keshav.wallpaperapp.repository.persistence

import com.keshav.wallpaperapp.repository.datamodels.PhotoItem
import io.reactivex.Observable

interface IPersistenceManager {
    fun getWallpapers(): Observable<List<PhotoItem>>
}