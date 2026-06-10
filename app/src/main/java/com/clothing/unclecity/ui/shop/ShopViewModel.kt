package com.clothing.unclecity.ui.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShopViewModel : ViewModel() {
    private val _filter = MutableLiveData<String>().apply { value = "" }
    val filter: LiveData<String> = _filter
    fun setFilter(filter : String?){
        if (filter == null) _filter.value = ""
        else _filter.value = filter
    }
}