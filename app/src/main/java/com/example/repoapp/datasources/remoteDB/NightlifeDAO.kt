package com.example.repoapp.datasources.remoteDB

import com.example.repoapp.model.NightLife
import retrofit2.http.GET

interface NightlifeDAO {

    @GET("/nightlife")
    suspend fun getNightLife(): List<NightLife>

}