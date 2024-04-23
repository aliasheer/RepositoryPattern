package com.example.repoapp.repository

import com.example.repoapp.datasources.offlineDB.offlineDAO
import com.example.repoapp.datasources.offlineDB.offlineDBRoom
import com.example.repoapp.datasources.remoteDB.NightlifeDAO
import com.example.repoapp.model.NightLife
import com.example.repoapp.model.NightLifeModel
import javax.inject.Inject


class NightRepo @Inject constructor( private val offlineDAO: offlineDAO, private val nightlifeDAO: NightlifeDAO) {


     suspend fun getNightlife() = nightlifeDAO.getNightLife()

     suspend fun getLocalNightLife()= offlineDAO.getNightLife()

     suspend fun saveNightlife(nightlife: List<NightLifeModel>) {
          offlineDAO.insertNightLife(nightlife)
     }



}