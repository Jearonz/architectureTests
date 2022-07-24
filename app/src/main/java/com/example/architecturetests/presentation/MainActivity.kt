package com.example.architecturetests.presentation

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.architecturetests.R
import com.example.architecturetests.data.repository.UserRepositoryImpl
import com.example.architecturetests.data.storage.UserStorage
import com.example.architecturetests.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.architecturetests.domain.models.SaveUserData
import com.example.architecturetests.domain.models.UserData
import com.example.architecturetests.domain.usecase.GetUserDataUseCase
import com.example.architecturetests.domain.usecase.SaveUserDataUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("AAA", "Activity created")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataTextView = findViewById<TextView>(R.id.textView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val getButton = findViewById<Button>(R.id.getButton)
        vm = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java) //один и тот же объект ViewModel

        vm.resultLive.observe(this,  { text ->
            dataTextView.text = text
        })

        saveButton.setOnClickListener {
            val text = dataEditText.text.toString()
            vm.saveData(text)
        }

        getButton.setOnClickListener {
            vm.getData()
        }
    }
}