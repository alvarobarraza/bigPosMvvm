package com.example.bigposmvvm.ui.view.utils

import android.app.Activity
import android.app.AlertDialog
import com.example.bigposmvvm.R

class LoadingDialog(private val menuActivity: Activity) {

    private var isdialog:AlertDialog? = null

    fun startLoading(){

        val inflater = menuActivity.layoutInflater
        val dialogView = inflater.inflate(R.layout.loading, null)
        val builder = AlertDialog.Builder(menuActivity)

        builder.setView(dialogView)
        builder.setCancelable(false)
        isdialog = builder.create()
        isdialog?.show()

    }

    fun isDismiss(){
        isdialog?.dismiss()
    }

}