package com.example.tugas_hadia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_hadia.databinding.ItemRvBinding
import com.example.tugas_hadia.model.gambar

class gambar_adapter: androidx.recyclerview.widget.ListAdapter<gambar, gambar_adapter.gambarViewHolder>(DIFF_CALLBACK) {
    inner class gambarViewHolder(private val binding: ItemRvBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(gambar: gambar){
            binding.apply {
                namaBand.text = gambar.judul
                imgGambar.setImageResource(gambar.gambar)
            }
        }
    }
    companion object{
        val DIFF_CALLBACK = object: DiffUtil.ItemCallback<gambar> (){
            override fun areContentsTheSame(oldItem: gambar, newItem: gambar): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areItemsTheSame(oldItem: gambar, newItem: gambar): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): gambarViewHolder {
        val binding = ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return gambarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: gambarViewHolder, position: Int) {
       holder.bind(getItem(position))
    }
}