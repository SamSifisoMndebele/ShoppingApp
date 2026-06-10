package com.clothing.unclecity.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clothing.unclecity.models.User
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class UserViewModel : ViewModel() {
    private val userDBRef = Firebase.firestore.collection("Users")
        .document(Firebase.auth.currentUser!!.uid)

    private val _user = MutableLiveData<User>().apply {
        userDBRef.addSnapshotListener { value, error ->
                if (error != null){
                    return@addSnapshotListener
                }
                val user = value?.toObject<User>()
                if (user != null){
                    this.value = user
                }
            }

    }
    val user: LiveData<User> = _user
}