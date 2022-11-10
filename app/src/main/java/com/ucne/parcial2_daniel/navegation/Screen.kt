package com.ucne.parcial2_daniel.navegation

sealed class Screen(val route: String) {
    object ListScreen : Screen(" ListScreen")
    object ListViewModel : Screen("ListViewModel")
}