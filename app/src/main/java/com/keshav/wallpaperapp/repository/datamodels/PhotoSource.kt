package com.keshav.wallpaperapp.repository.datamodels

data class PhotoSource(
    var original: String = "",
    var large2x: String = "",
    var large: String = "",
    var medium: String = "",
    var small: String = "",
    var portrait: String = "",
    var landscape: String = "",
    var tiny: String = "",
)