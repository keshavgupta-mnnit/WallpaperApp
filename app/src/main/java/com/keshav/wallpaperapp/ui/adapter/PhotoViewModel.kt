package com.keshav.wallpaperapp.ui.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.keshav.wallpaperapp.repository.IWallpaperRepository
import com.keshav.wallpaperapp.ui.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class PhotoViewModel(private val repository: IWallpaperRepository) : ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val _state: MutableLiveData<PhotoActivityStates> = MutableLiveData()
    val state: LiveData<PhotoActivityStates> = _state
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun getPhotos(pageNo: Int = 1, itemsPerPage: Int = 20) {
        _state.value = IsLoading
        val observable = repository.getWallpapers(pageNo,itemsPerPage).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
                {
                    _state.value = DataLoaded(it)
                }, {
                    _state.value = ErrorState(it.message.toString())
                }
            )
        compositeDisposable.add(observable)
    }

}