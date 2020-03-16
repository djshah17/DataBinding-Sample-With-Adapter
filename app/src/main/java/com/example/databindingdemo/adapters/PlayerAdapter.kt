package com.example.databindingdemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingdemo.R
import com.example.databindingdemo.databinding.PlayerRowBinding
import com.example.databindingdemo.models.Player

class PlayerAdapter(private val context: Context, private val list: MutableList<Player>?) : RecyclerView.Adapter<PlayerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: PlayerRowBinding = DataBindingUtil.inflate(inflater, R.layout.player_row,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        if(list == null){
            return 0
        }
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemBinding.player = list?.get(position)
    }

    class MyViewHolder(val itemBinding: PlayerRowBinding) : RecyclerView.ViewHolder(itemBinding.root){

        private var binding : PlayerRowBinding? = null

        init {
            this.binding = itemBinding
        }

    }

}