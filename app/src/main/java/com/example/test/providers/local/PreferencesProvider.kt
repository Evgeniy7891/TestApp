package com.example.test.providers.local

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferencesProvider @Inject constructor(
    @ApplicationContext context: Context
) {

    companion object{
        const val SHARED_PREFERENCES_NAME = "sh_pref"
        const val ACCESS_TOKEN = "access_token"
    }
    private var sharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun saveToken(token: String?) {
        sharedPreferences.edit()?.putString(
            ACCESS_TOKEN,
            token
        )?.apply()
    }

    fun getToken() = sharedPreferences.getString(ACCESS_TOKEN, "")

    fun delete(){
        sharedPreferences.edit {
            clear()
            commit()
        }
    }
}