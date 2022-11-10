package com.ucne.parcial2_daniel.data.repository
import com.ucne.parcial2_daniel.data.VerbosApi
import com.ucne.parcial2_daniel.data.DTO.Vervoresponsidto
import javax.inject.Inject
class ConsumirApi @Inject constructor(
    private val api: VerbosApi

){
    suspend fun geAllapi() = api.getverbo()
}