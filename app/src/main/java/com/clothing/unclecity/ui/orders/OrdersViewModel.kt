package com.clothing.unclecity.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrdersViewModel : ViewModel() {
    private val _filter = MutableLiveData<String>().apply { value = "" }
    val filter: LiveData<String> = _filter
}