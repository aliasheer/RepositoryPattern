package com.example.repoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repoapp.datasources.remoteDB.NightlifeDAO
import com.example.repoapp.model.NightLife
import com.example.repoapp.model.NightLifeModel
import com.example.repoapp.repository.NightRepo
import com.example.repoapp.utils.NetworkStatusChecker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class NightViewModel @Inject constructor(
    private val nightRepository: NightRepo,  private val networkStatusChecker: NetworkStatusChecker
    ) : ViewModel() {
    private val _nightlife = MutableLiveData<List<NightLifeModel>>()

    val nightlife: MutableLiveData<List<NightLifeModel>> = _nightlife

        init {
            fetchNightlife()
        }


    private fun fetchNightlife() {
        viewModelScope.launch(Dispatchers.IO) {
            if (networkStatusChecker.isOnline()) {
                try {
                    val remoteNightlife = nightRepository.getNightlife()
                    val mappedNightlife = remoteNightlife.map { convertToNightLifeModel(it) }
                    nightRepository.saveNightlife(mappedNightlife)
                    _nightlife.postValue(mappedNightlife)
                } catch (e: Exception) {
                    // Handle network errors
                }
            } else {
                val localNightlife = nightRepository.getLocalNightLife()
                _nightlife.postValue(localNightlife)
            }
        }
    }
    private fun convertToNightLifeModel(nightLife: NightLife): NightLifeModel {
        return NightLifeModel(
            name = nightLife.name,
            image = nightLife.image,
            createdAt = nightLife.createdAt
        )
    }

    }

