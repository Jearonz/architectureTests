package com.example.architecturetests.presentation

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.architecturetests.R
import com.example.architecturetests.data.repository.UserRepositoryImpl
import com.example.architecturetests.data.storage.UserStorage
import com.example.architecturetests.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.architecturetests.domain.models.SaveUserData
import com.example.architecturetests.domain.models.UserData
import com.example.architecturetests.domain.usecase.GetUserDataUseCase
import com.example.architecturetests.domain.usecase.SaveUserDataUseCase

class MainActivity : Activity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = applicationContext))
    }
    private val getUserDataUseCase by lazy(LazyThreadSafetyMode.NONE)  {
        GetUserDataUseCase(userRepository = userRepository)
    }
    private val saveUserDataUseCase by lazy(LazyThreadSafetyMode.NONE)  {
        SaveUserDataUseCase(userRepository = userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataTextView = findViewById<TextView>(R.id.textView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val getButton = findViewById<Button>(R.id.getButton)

        saveButton.setOnClickListener{
            val text = dataEditText.text.toString()
            val params = SaveUserData(data = text)
            val result:Boolean = saveUserDataUseCase.execute(param = params)
            dataTextView.text = "Save res = $result"
        }
        getButton.setOnClickListener {
            val userData: com.example.architecturetests.domain.models.UserData = getUserDataUseCase.execute()
            dataTextView.text = "${userData.firstPart} ${userData.secondPart}"
        }
    }
}