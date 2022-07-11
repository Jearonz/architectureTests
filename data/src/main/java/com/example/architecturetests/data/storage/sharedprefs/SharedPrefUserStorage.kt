package com.example.architecturetests.data.storage.sharedprefs


import android.content.Context
import com.example.architecturetests.data.storage.UserStorage
import com.example.architecturetests.data.storage.models.Data

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_DATA = "firstPart"
private const val KEY_SECOND_DATA = "secondPart"
private const val DEFAULT_FIRST_DATA = "Default"
private const val DEFAULT_SECOND_DATA = "Default"

class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    override fun save(param: Data): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_DATA, param.firstPart).apply()
        sharedPreferences.edit().putString(KEY_SECOND_DATA, param.secondPart).apply()
        return true
    }

    override fun get(): Data {
        val firstPart = sharedPreferences.getString(KEY_FIRST_DATA, DEFAULT_FIRST_DATA) ?: DEFAULT_FIRST_DATA
        val secondPart = sharedPreferences.getString(KEY_SECOND_DATA, DEFAULT_SECOND_DATA) ?: DEFAULT_SECOND_DATA
        return Data(firstPart = firstPart, secondPart = secondPart)
    }
}