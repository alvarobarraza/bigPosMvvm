package com.example.bigposmvvm.ui.view.activity.access

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.bigposmvvm.data.model.ConfigM
import com.example.bigposmvvm.data.model.LoginM
import com.example.bigposmvvm.databinding.ActivityLoginBinding
import com.example.bigposmvvm.ui.view.activity.menu.MenuActivity
import com.example.bigposmvvm.ui.view.utils.LoadingDialog
import com.example.bigposmvvm.ui.viewmodel.BigPosViewModel
import com.example.bigposmvvm.util.HostSelectionInterceptor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    companion object {
        var configServer: ConfigM = ConfigM(
            ip = "http://bigpos.ddns.net:1106",
            ep = "01",
            es = "01"
        )
    }

    private lateinit var binding: ActivityLoginBinding
    private var loading = LoadingDialog(this)
    private val bigPosViewModel: BigPosViewModel by viewModels()
    private val onBackPressedCallback: OnBackPressedCallback =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finishAffinity()
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
        this.setEventHandlers()
        this.defaultConfig()

    }

    /*private fun automaticLogin() {
        val rUser: Boolean = prefs.getRuser()
        val user: String = prefs.getUser()
        val pass: String = prefs.getPass()

        if (user.isNotEmpty() && pass.isNotEmpty() && rUser) {
            binding.etUser.setText(user)
            binding.etPass.setText(pass)
            //requestLoginAuto()
        } else {
            binding.etUser.setText("")
            binding.etPass.setText("")
        }
    }*/

    private fun setEventHandlers() {
        this.binding.imgBtnConfig.setOnClickListener {
            goConfig()
        }

        this.binding.linkeSystem.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://esystem.com.co/"))
            startActivity(i)
        }

        this.binding.btnIngresar.setOnClickListener {

            val user = binding.etUser.text.toString()
            val pass = binding.etPass.text.toString()

            bigPosViewModel.login(user, pass)

            CoroutineScope(Dispatchers.Main).launch {
                bigPosViewModel._userModel.collect {
                    when {
                        it.isLoading -> {
                            loading.startLoading()
                        }
                        it.error.isNotBlank() -> {
                            loading.isDismiss()
                            Toast.makeText(this@LoginActivity, it.error, Toast.LENGTH_LONG).show()
                            loading.isDismiss()
                        }
                        it.accessLogin != null -> {
                            loading.isDismiss()
                            goLogin()
                            loading.isDismiss()
                        }
                    }

                }
            }

        }
    }


    private fun defaultConfig() {

        bigPosViewModel.getConfig()
        bigPosViewModel.configModel.observe(this, Observer {
            if (it == null) {
                val config = ConfigM(
                    ip = "http://bigpos.ddns.net:1106",
                    ep = "01",
                    es = "01"
                )
                configServer = config
                bigPosViewModel.saveConfig(config)
            } else {
                configServer = it
            }
        })

    }

    private fun goConfig() {
        val intent = Intent(this, ConfigActivity::class.java)
        startActivity(intent)
    }

    private fun requestLoginAsync() {
        val user: String = binding.etUser.text.toString().trim()
        val pass: String = binding.etPass.text.toString().trim()
        val checked = binding.checkBox.isChecked

        if (user.isEmpty()) {
            binding.etUser.error = "Usuario requerido"
            binding.etUser.requestFocus()
        } else if (pass.isEmpty()) {
            binding.etPass.error = "Contraseña requerida"
            binding.etPass.requestFocus()
        } else {
            /*bigPosViewModel.login()
            bigPosViewModel.userModel.observe(this, Observer { result->
                val loginAccess = LoginM(
                    user = result!!.Perfil,
                    name = result.NombreUsuario,
                    pass = result.Contraseña,
                    group = result.Grupo,
                    checked = checked
                )

                bigPosViewModel.saveLogin(loginAccess)

            })*/
        }
    }

    private fun goLogin() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
        finish()
    }

}