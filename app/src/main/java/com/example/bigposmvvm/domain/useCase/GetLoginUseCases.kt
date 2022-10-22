package com.example.bigposmvvm.domain.useCase

import com.example.bigposmvvm.domain.model.AccessLogin
import com.example.bigposmvvm.domain.repository.BigposRepository
import com.example.bigposmvvm.util.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetLoginUseCases @Inject constructor(private val repository: BigposRepository) {

    operator fun invoke(user:String,pass:String): Flow<ResponseState<AccessLogin>> = flow {
        try {

            emit(ResponseState.Loading())
            val loginAccess = repository.getLogin(user,pass).toAccessLogin()
            emit(ResponseState.Success(loginAccess))

        }catch (e: HttpException){

            emit(ResponseState.Error(e.localizedMessage ?: "An Unexpected Error"))

        }catch (e: IOException){

            emit(ResponseState.Error("Internet Error"))

        }
    }

}