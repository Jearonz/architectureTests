package com.example.architecturetests.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecturetests.domain.models.SaveUserData
import com.example.architecturetests.domain.usecase.GetUserDataUseCase
import com.example.architecturetests.domain.usecase.SaveUserDataUseCase

class MainViewModel(private val getUserDataUseCase: GetUserDataUseCase, private val saveUserDataUseCase: SaveUserDataUseCase) : ViewModel() {
    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive : LiveData<String> = resultLiveMutable
    init {
        Log.e("AAA", "VM Created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM Cleared")
        super.onCleared()
    }

    fun getData(){
        val userData: com.example.architecturetests.domain.models.UserData = getUserDataUseCase.execute()
        resultLiveMutable.value = "${userData.firstPart} ${userData.secondPart}"
    }

    fun saveData(text: String) {
        val params = SaveUserData(data = text)
        val resultData: Boolean = saveUserDataUseCase.execute(param = params)
        resultLiveMutable.value = "Save result = $resultData"

    }

}