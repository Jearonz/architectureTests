package com.example.architecturetests.data.repository

import com.example.architecturetests.domain.models.SaveUserData
import com.example.architecturetests.domain.models.UserData
import com.example.architecturetests.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {

    override fun saveData(param : SaveUserData):Boolean {
        return true
    }

    override fun getData() : UserData{
        return UserData(firstPart = "Part", secondPart = "2")
    }
}