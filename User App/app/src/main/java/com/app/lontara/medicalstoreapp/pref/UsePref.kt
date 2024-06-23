package com.app.lontara.medicalstoreapp.pref

import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow



interface UsePref {

    suspend fun setUserData(userData : List<UserData>)

    fun getUserData() : Flow<List<UserData>>
}