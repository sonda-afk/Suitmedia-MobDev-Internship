package com.sondari.myapplication.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelGuest (
    val id : String,
    val name: String,
    val birthdate: String
        )
    :Parcelable