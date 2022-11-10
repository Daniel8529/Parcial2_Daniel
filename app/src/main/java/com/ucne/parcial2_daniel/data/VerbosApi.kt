package com.ucne.parcial2_daniel.data
import com.ucne.parcial2_daniel.data.DTO.Vervoresponsidto
import retrofit2.http.GET
import retrofit2.Response

interface VerbosApi {
    @GET("verbos")
    suspend fun getverbo(): List<Vervoresponsidto>
}

