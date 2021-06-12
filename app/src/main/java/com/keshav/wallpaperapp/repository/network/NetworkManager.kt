package com.keshav.wallpaperapp.repository.network

import com.keshav.wallpaperapp.repository.datamodels.PhotoItem
import io.reactivex.Observable

class NetworkManager(private val api: WallPaperAPI) : INetworkManager {
    val API_KEY = "563492ad6f917000010000018adebfd92f9847e0988e287660c0645d"

    override fun getWallpapers(pageNo: Int, itemsPerPage: Int): Observable<List<PhotoItem>> {
        return api.getWallpapers(API_KEY, pageNo, itemsPerPage).map {
            it.photos
        }
    }
}