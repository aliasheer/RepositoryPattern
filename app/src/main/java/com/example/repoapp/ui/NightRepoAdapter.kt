package com.example.repoapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.repoapp.R
import com.example.repoapp.model.NightLifeModel
import com.example.repoapp.viewmodel.NightViewModel
import javax.inject.Inject

class NightRepoAdapter:
    RecyclerView.Adapter<NightRepoAdapter.NightRepoViewHolder>() {

    private var nightRepoList: List<NightLifeModel> = listOf()

    fun setData(nightRepoList: List<NightLifeModel>) {
        this.nightRepoList = nightRepoList
        notifyDataSetChanged()
    }

    inner class NightRepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.item_name)
        val itemImage: ImageView = itemView.findViewById(R.id.item_image)
        // Add references to other views as needed
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NightRepoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_night_repo, parent, false)
        return NightRepoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NightRepoViewHolder, position: Int) {
        val currentItem = nightRepoList[position]
        holder.itemName.text = currentItem.name
        // Load image using Glide or any other image loading library
        Glide.with(holder.itemView).load(currentItem.image).into(holder.itemImage)
    }

    override fun getItemCount(): Int {
        return nightRepoList.size
    }
}