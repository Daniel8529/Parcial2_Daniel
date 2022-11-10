package com.ucne.parcial2_daniel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ucne.parcial2_daniel.ui.theme.Parcial2_DanielTheme
import com.ucne.parcial2_daniel.ui.List.ListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial2_DanielTheme {


                ListScreen()


            }
        }
    }
}

