package com.example.architecturetests.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecturetests.data.repository.UserRepositoryImpl
import com.example.architecturetests.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.architecturetests.domain.usecase.GetUserDataUseCase
import com.example.architecturetests.domain.usecase.SaveUserDataUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
    }
    private val getUserDataUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserDataUseCase(userRepository = userRepository)
    }
    private val saveUserDataUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserDataUseCase(userRepository = userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserDataUseCase = getUserDataUseCase,
            saveUserDataUseCase = saveUserDataUseCase
        ) as T
    }
}