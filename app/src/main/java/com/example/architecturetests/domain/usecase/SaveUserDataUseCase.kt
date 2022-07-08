package com.example.architecturetests.domain.usecase

import com.example.architecturetests.domain.models.SaveUserData
import com.example.architecturetests.domain.repository.UserRepository

class SaveUserDataUseCase(private val userRepository: UserRepository)  {
    fun execute(param: SaveUserData):Boolean {
        return userRepository.saveData(param = param)
    }
}