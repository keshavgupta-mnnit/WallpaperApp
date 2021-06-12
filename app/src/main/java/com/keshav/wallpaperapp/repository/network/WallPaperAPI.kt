package com.keshav.wallpaperapp.repository.network

import com.keshav.wallpaperapp.repository.datamodels.ApiResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WallPaperAPI {
    @GET("curated")
    fun getWallpapers(
        @Header("Authorization") apiKey: String,
        @Query("page") pageNo: Int,
        @Query("per_page") itemsPerPage: Int
    ): Observable<ApiResponse>
}