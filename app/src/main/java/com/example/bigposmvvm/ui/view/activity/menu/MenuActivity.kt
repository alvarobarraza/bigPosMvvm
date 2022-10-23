package com.example.bigposmvvm.ui.view.activity.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.example.bigposmvvm.databinding.ActivityMenuBinding
import com.example.bigposmvvm.ui.view.activity.access.LoginActivity
import com.example.bigposmvvm.ui.viewmodel.BigPosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private val bigPosViewModel: BigPosViewModel by viewModels()
    private lateinit var builder: AlertDialog.Builder

    /*private val onBackPressedCallback: OnBackPressedCallback =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                builder.setTitle("¡ALERTA!")
                    .setMessage("¿Seguro que quiere salir?")
                    .setCancelable(false)
                    .setPositiveButton("SI") { _, _ ->
                        bigPosViewModel.wipe()
                        loadLogin()
                    }
                    .setNegativeButton("NO") { dialogInterface, _ ->
                        dialogInterface.cancel()
                    }
                    .show()
            }
        }*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        builder = AlertDialog.Builder(this)
        //onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        this.setEventHandler()
    }

    private fun setEventHandler() {
        this.binding.btnVCPdia.setOnClickListener {
            //goCuadreCaja()
        }

        this.binding.btnTmultiproposito.setOnClickListener {
            //goTMulti()
        }

        this.binding.btnInventarioRef.setOnClickListener {
            //loadInventory()
        }

        this.binding.btnSalir.setOnClickListener {
            loadLogin()
        }

        this.binding.btnGrabarP.setOnClickListener {
            //goGPedido()
        }

        this.binding.btnTercero.setOnClickListener {
            //goTercero()
        }

        this.binding.btnCartera.setOnClickListener {

        }

    }

    private fun loadLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    /*private fun loadInventory() {
        val intent = Intent(this, InventarioActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goCuadreCaja() {
        val intent = Intent(this, VentaCajaxDia::class.java)
        startActivity(intent)
        finish()
    }

    private fun goTMulti() {
        val intent = Intent(this, ListTMulti::class.java)
        startActivity(intent)
        finish()
    }

    private fun goGPedido() {
        val intent = Intent(this, OrderActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goTercero() {
        val intent = Intent(this, TerceroActivity::class.java)
        startActivity(intent)
    }*/
}