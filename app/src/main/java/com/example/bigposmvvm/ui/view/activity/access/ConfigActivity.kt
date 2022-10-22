package com.example.bigposmvvm.ui.view.activity.access

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.bigposmvvm.data.model.ConfigM
import com.example.bigposmvvm.databinding.ActivityConfigBinding
import com.example.bigposmvvm.ui.viewmodel.BigPosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfigActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfigBinding
    private val bigPosViewModel: BigPosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.loadConfig()
        this.setEventHandlers()
    }

    private fun setEventHandlers() {
        this.binding.btnVolver.setOnClickListener {
            goBack()
        }

        this.binding.btnGuardar.setOnClickListener {
            setConfig()
        }
    }

    private fun loadConfig() {

        bigPosViewModel.getConfig()

        bigPosViewModel.configModel.observe(this, Observer {
            binding.etIp.setText(it!!.ip)
            binding.etEp.setText(it.ep)
            binding.etEs.setText(it.es)
        })

    }

    private fun setConfig() {
        val ipServer = binding.etIp.text.toString().trim()
        val ePrincipal = binding.etEp.text.toString().trim()
        val eSecundarias = binding.etEs.text.toString().trim()

        if (ipServer.isEmpty()) {
            binding.etIp.error = "IP Requerida"
            binding.etIp.requestFocus()
        } else if (ePrincipal.isEmpty()) {
            binding.etEp.error = "Empresa Principal Requerida"
            binding.etEp.requestFocus()
        } else if (eSecundarias.isEmpty()) {
            binding.etEs.error = "Empresas Secundarias Requeridas"
            binding.etEs.requestFocus()
        } else {

            val config = ConfigM(
                ip = ipServer,
                ep = ePrincipal,
                es = eSecundarias
            )
            bigPosViewModel.saveConfig(config)

            goBack()
            Handler(Looper.getMainLooper()).post {
                Toast.makeText(this@ConfigActivity, "CONFIGURACIÓN REALIZADA", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun goBack() {
        onBackPressedDispatcher.onBackPressed()
    }


}