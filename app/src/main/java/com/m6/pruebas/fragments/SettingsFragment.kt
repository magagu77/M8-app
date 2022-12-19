package com.m6.pruebas.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.m6.pruebas.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_preferences, rootKey)
    }
}