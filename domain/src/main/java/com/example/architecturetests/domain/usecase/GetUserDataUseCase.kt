package com.example.architecturetests.domain.usecase

import com.example.architecturetests.domain.models.UserData
import com.example.architecturetests.domain.repository.UserRepository


class GetUserDataUseCase (private val userRepository: UserRepository) {
    fun execute() : UserData {
        return userRepository.getData()
    }
}