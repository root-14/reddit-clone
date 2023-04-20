package com.mithrundeal.mclub.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mithrundeal.mclub.network.Resource
import com.mithrundeal.mclub.network.models.response.Login
import com.mithrundeal.mclub.network.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _res = MutableLiveData<Resource<Login>>()

    val res: LiveData<Resource<Login>>
        get() = _res

    init {
        login()
    }

    private fun login() = viewModelScope.launch {
        _res.postValue(Resource.loading(null))
        mainRepository.login().let {
            if (it.isSuccessful) {
                _res.postValue(Resource.success(it.body()))
            } else {
                _res.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }

}