package com.keshav.wallpaperapp.di

import com.keshav.wallpaperapp.repository.IWallpaperRepository
import com.keshav.wallpaperapp.repository.WallpaperRepository
import com.keshav.wallpaperapp.repository.network.INetworkManager
import com.keshav.wallpaperapp.repository.network.NetworkManager
import com.keshav.wallpaperapp.repository.network.WallPaperAPI
import com.keshav.wallpaperapp.repository.persistence.IPersistenceManager
import com.keshav.wallpaperapp.repository.persistence.PersistenceManager
import com.keshav.wallpaperapp.ui.adapter.PhotoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { provideRetrofit() }
    single { provideNetworkManager(get()) }
    single { providePersistenceManager() }
    single { provideRepository(get(), get()) }

    viewModel { providePhotoViewModel(get()) }
}
const val baseUrl = "https://api.pexels.com/v1/"
fun provideRetrofit(): WallPaperAPI {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(WallPaperAPI::class.java)
}

fun provideNetworkManager(api: WallPaperAPI): INetworkManager {
    return NetworkManager(api)
}

fun providePersistenceManager(): IPersistenceManager {
    return PersistenceManager()
}

fun provideRepository(network: INetworkManager, persistence: IPersistenceManager): IWallpaperRepository {
    return WallpaperRepository(network, persistence)
}

fun providePhotoViewModel(repository: IWallpaperRepository): PhotoViewModel {
    return PhotoViewModel(repository)
}