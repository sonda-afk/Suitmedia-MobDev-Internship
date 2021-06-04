package com.sondari.myapplication.api.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelEvent (
    val image : String,
    val name: String,
    val date: String
    )
    :Parcelable
