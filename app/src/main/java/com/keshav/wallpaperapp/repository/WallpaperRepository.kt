package com.keshav.wallpaperapp.repository

import com.keshav.wallpaperapp.repository.datamodels.PhotoItem
import com.keshav.wallpaperapp.repository.network.INetworkManager
import com.keshav.wallpaperapp.repository.persistence.IPersistenceManager
import io.reactivex.Observable

class WallpaperRepository(
    private val networkManager: INetworkManager,
    private val persistenceManager: IPersistenceManager
) : IWallpaperRepository {
    override fun getWallpapers(pageNo: Int, itemsPerPage: Int): Observable<List<PhotoItem>> {
        return networkManager.getWallpapers(pageNo, itemsPerPage)
    }
}