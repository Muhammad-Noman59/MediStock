package com.app.lontara.medicalstoreapp.pref

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.lang.reflect.Type


val USER_DATA = stringPreferencesKey("user_data")

class UserPrefImpl(private val dataStore: DataStore<Preferences>) : UsePref {


    private val gson = Gson()
    private val listType: Type = object : TypeToken<List<UserData>>() {}.type

    override suspend fun setUserData(userData: List<UserData>) {

        dataStore.edit { preferences ->
            val json = gson.toJson(userData)
            preferences[USER_DATA] = json
        }

    }

    override fun getUserData(): Flow<List<UserData>> {

        return dataStore.data.catch {
            emit(emptyPreferences())

        }.map { preferences ->

            val json = preferences[USER_DATA] ?: ""

            if (json.isEmpty()) {
                emptyList()
            } else {
                gson.fromJson(json, listType)
            }
        }
    }
}