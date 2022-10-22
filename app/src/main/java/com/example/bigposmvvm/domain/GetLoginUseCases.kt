package com.example.bigposmvvm.domain

import com.example.bigposmvvm.data.BigPosRepository
import com.example.bigposmvvm.data.database.entities.toDatabase
import com.example.bigposmvvm.domain.model.AccessLogin
import javax.inject.Inject

//AccessLoginM = repository.getLogin()
class GetLoginUseCases @Inject constructor(private val repository: BigPosRepository) {

    suspend operator fun invoke(): AccessLogin? {
        //val accessLogin = repository.getLogin()
        return repository.getLogin()
        /*return if (accessLogin != null) {
            repository.insertUser(accessLogin.toDatabase())
            accessLogin
        } else {
            repository.getUser()
        }*/
    }

}