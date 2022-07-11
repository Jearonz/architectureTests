package com.example.architecturetests.data.repository

import com.example.architecturetests.data.storage.UserStorage
import com.example.architecturetests.data.storage.models.Data
import com.example.architecturetests.domain.models.SaveUserData
import com.example.architecturetests.domain.models.UserData
import com.example.architecturetests.domain.repository.UserRepository



class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {
    override fun saveData(param: SaveUserData): Boolean {

        val data = mapToStorage(param)
        return userStorage.save(data)
    }

    override fun getData(): UserData {
        val userData = userStorage.get()
        return mapToDomain(userData)
    }

    private fun mapToStorage(param: SaveUserData) : Data {
        return Data(firstPart = param.data, secondPart = "")
    }

    private fun  mapToDomain(data: Data) : UserData {
        return UserData(firstPart = data.firstPart, secondPart = data.secondPart)
    }
}