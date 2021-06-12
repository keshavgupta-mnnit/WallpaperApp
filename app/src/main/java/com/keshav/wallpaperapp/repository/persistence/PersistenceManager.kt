package com.keshav.wallpaperapp.repository.persistence

import com.keshav.wallpaperapp.repository.datamodels.PhotoItem
import io.reactivex.Observable

class PersistenceManager : IPersistenceManager{
    override fun getWallpapers(): Observable<List<PhotoItem>> {
        TODO("Not yet implemented")
    }
}