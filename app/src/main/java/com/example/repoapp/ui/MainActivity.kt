package com.example.repoapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.repoapp.R
import com.example.repoapp.model.NightLifeModel
import com.example.repoapp.viewmodel.NightViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val nightViewModel: NightViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NightRepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        adapter = NightRepoAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        nightViewModel.nightlife.observe(this, Observer { response ->


            adapter.setData(response)

        })

//        setContent {
//
//            ComposeNightTheme(nightViewModel)
//        }




    }

    
    
//    @Composable
//    fun rowitem(title: NightLifeModel){
//        Row(
//            horizontalArrangement = Arrangement.Center
//
//        ) {
//           Text (text = title.name.toString(),
//               fontSize = 25.sp)
//        }
//
//    }
//    @Composable
//    fun ComposeNightTheme(nightViewModel: NightViewModel) {
//        val nightlifeList by nightViewModel.nightlife.observeAsState(initial = emptyList())
//            LazyColumn {
//                items(nightlifeList) { nightlifeItem ->
//                    rowitem(title = nightlifeItem) // assuming NightlifeModel has a 'title' property
//                }
//            }
//
//    }

}
