package com.example.bigposmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bigposmvvm.data.model.ConfigM
import com.example.bigposmvvm.data.model.LoginM
import com.example.bigposmvvm.data.sharedPreference.ConfigPreference
import com.example.bigposmvvm.domain.GetLoginUseCases
import com.example.bigposmvvm.domain.model.AccessLogin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BigPosViewModel @Inject constructor(

    private val getLoginUseCases: GetLoginUseCases,
    private val configPreference: ConfigPreference

) : ViewModel() {

    val userModel = MutableLiveData<AccessLogin?>()
    val configModel : MutableLiveData<ConfigM> = MutableLiveData()
    val loginModel : MutableLiveData<LoginM> = MutableLiveData()

    fun login() {
        viewModelScope.launch {
            val result = getLoginUseCases()
            userModel.value = result
        }
    }

    fun saveConfig(configM: ConfigM){
        viewModelScope.launch(Dispatchers.IO){
            configPreference.saveConfig(
                ConfigM(
                    ip = configM.ip,
                    ep = configM.ep,
                    es = configM.es,
                )
            )
        }
    }

    fun getConfig(){
        viewModelScope.launch(Dispatchers.IO){
            configPreference.getConfig().collect{
                configModel.postValue(it)
            }
        }
    }

    fun saveLogin(loginM: LoginM){
        viewModelScope.launch(Dispatchers.IO){
            configPreference.saveLogin(
                LoginM(
                    user = loginM.user,
                    name = loginM.name,
                    pass = loginM.pass,
                    group = loginM.group,
                    checked = loginM.checked
                )
            )
        }
    }

    fun getLogin(){
        viewModelScope.launch(Dispatchers.IO){
            configPreference.getLogin().collect{
                loginModel.postValue(it)
            }
        }
    }



}