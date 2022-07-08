package com.example.architecturetests.presentation

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.architecturetests.R
import com.example.architecturetests.data.repository.UserRepository
import com.example.architecturetests.domain.models.SaveUserData
import com.example.architecturetests.domain.models.UserData
import com.example.architecturetests.domain.usecase.GetUserDataUseCase
import com.example.architecturetests.domain.usecase.SaveUserDataUseCase

class MainActivity : Activity() {
    private val userRepository = UserRepository()
    private val getUserDataUseCase = GetUserDataUseCase()
    private val saveUserDataUseCase = SaveUserDataUseCase()

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
            val userData: UserData = getUserDataUseCase.execute()
            dataTextView.text = "${userData.firstPart} ${userData.secondPart}"
        }
    }
}