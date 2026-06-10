package com.clothing.unclecity.utils

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts.OpenDocument

class OpenPicturesContract : OpenDocument() {
    override fun createIntent(context: Context, input: Array<String>): Intent {
        val intent = super.createIntent(context, input)
        intent.action = Intent.ACTION_PICK
        intent.type = "image/*"
        return intent
    }
}