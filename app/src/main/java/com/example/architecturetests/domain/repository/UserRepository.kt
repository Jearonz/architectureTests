package com.example.architecturetests.domain.repository

import com.example.architecturetests.domain.models.SaveUserData
import com.example.architecturetests.domain.models.UserData

interface UserRepository {
    fun saveData(param : SaveUserData) : Boolean
    fun getData() : UserData
}