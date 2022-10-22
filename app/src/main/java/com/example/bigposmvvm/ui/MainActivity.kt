package com.example.bigposmvvm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bigposmvvm.ui.view.activity.access.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}