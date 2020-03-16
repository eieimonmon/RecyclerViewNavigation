package com.ptzp.recyclerviewnavigation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ptzp.recyclerviewnavigation.R
import com.ptzp.recyclerviewnavigation.model.Flower
import kotlinx.android.synthetic.main.item_list.view.*

class FlowerAdapter (var flowerList: ArrayList<Flower>): RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return FlowerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return flowerList.size
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        holder.bind(flowerList[position])
    }


    var mClickListener: ClickListener? = null

    fun setClickListener(clickListener: ClickListener){
        this.mClickListener = clickListener
    }

    inner class FlowerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{


        private lateinit var flower: Flower

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            mClickListener?.onClick(flower)
        }

        fun bind (flower:Flower){
            this.flower = flower
            itemView.txtName.text = flower.name
        }
    }

    interface ClickListener {
        fun onClick(flower: Flower)
    }
}