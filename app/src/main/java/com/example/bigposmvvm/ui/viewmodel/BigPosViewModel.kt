package com.example.bigposmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bigposmvvm.data.model.ConfigM
import com.example.bigposmvvm.data.model.LoginM
import com.example.bigposmvvm.data.sharedPreference.ConfigPreference
import com.example.bigposmvvm.domain.useCase.GetLoginUseCases
import com.example.bigposmvvm.ui.viewUtil.LoginState
import com.example.bigposmvvm.util.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BigPosViewModel @Inject constructor(

    private val getLoginUseCases: GetLoginUseCases,
    private val configPreference: ConfigPreference

) : ViewModel() {

    private var userModel = MutableStateFlow(LoginState())
    var _userModel: StateFlow<LoginState> = userModel

    val configModel : MutableLiveData<ConfigM> = MutableLiveData()
    val loginModel : MutableLiveData<LoginM> = MutableLiveData()

    fun login(user:String, pass:String) = viewModelScope.launch(Dispatchers.IO){
        getLoginUseCases(user = user, pass = pass).collect{
            when(it){
                is ResponseState.Success ->{
                    userModel.value = LoginState(accessLogin = it.data)
                }
                is ResponseState.Loading ->{
                    userModel.value = LoginState(isLoading = true)
                }
                is ResponseState.Error ->{
                    userModel.value = LoginState(error = it.message?: "An Unexpected Error")
                }
            }
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