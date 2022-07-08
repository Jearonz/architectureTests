package com.example.architecturetests.domain.usecase

import com.example.architecturetests.domain.models.UserData


class GetUserDataUseCase {
    fun execute() : UserData {
        return UserData(firstPart = "Meme", secondPart = "KEK")
    }
}