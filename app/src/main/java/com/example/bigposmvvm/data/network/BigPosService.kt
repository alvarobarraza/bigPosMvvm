package com.example.bigposmvvm.data.network

import javax.inject.Inject

class BigPosService @Inject constructor(
    private val api: WebService,
) {

    /*suspend fun getLogin(): AccessLoginM {
        return withContext(Dispatchers.IO) {
            val response = api.getLogin("login?idMainCompany=${configServer.ep}&user=$user&password=$pass")
            //response.body()!!
        }
    }*/

}