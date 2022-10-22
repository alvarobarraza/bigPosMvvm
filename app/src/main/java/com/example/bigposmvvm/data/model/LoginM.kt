package com.example.bigposmvvm.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginM(
    var user:String,
    var name:String,
    var pass:String,
    var group:Int,
    var checked:Boolean
):Parcelable
