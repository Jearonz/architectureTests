package com.example.architecturetests.data.storage

import com.example.architecturetests.data.storage.models.Data

interface UserStorage {
    fun save(param: Data) : Boolean
    fun get() : Data
}