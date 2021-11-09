package com.vaishnav.pratilipiproject.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vaishnav.pratilipiproject.data.local.ContentDatabase
import com.vaishnav.pratilipiproject.data.model.Content
import com.vaishnav.pratilipiproject.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _allContent = MutableLiveData<List<Content>>()
    val allContent: LiveData<List<Content>> = _allContent
    private val repository: MainRepository

    init {
        val userDao = ContentDatabase.getDatabase(application).contentDao()
        repository = MainRepository(userDao)
    }

    fun addContent(content: Content) = viewModelScope.launch {
        repository.addContent(content)
    }

    fun getAllContent() {
        repository.getContent().let {
            _allContent.postValue(it.value)
        }
    }

}