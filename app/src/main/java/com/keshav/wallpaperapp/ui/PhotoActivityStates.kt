package com.keshav.wallpaperapp.ui

import com.keshav.wallpaperapp.repository.datamodels.PhotoItem

sealed class PhotoActivityStates

object IsLoading : PhotoActivityStates()

data class DataLoaded(
    var photoList: List<PhotoItem>
) : PhotoActivityStates()

data class ErrorState(
    var message: String
) : PhotoActivityStates()