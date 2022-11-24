package com.m6.pruebas.Recyclers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.m6.pruebas.Pokemon
import com.m6.pruebas.R

class RecyclerViewAdapter(llistat: MutableList<Pokemon>, context: Context?): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    var llistat: MutableList<Pokemon> = llistat;
    var context: Context? = context;


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtNom.setText(llistat.get(position).getName());
        holder.txtType1.setText((llistat.get(position).getType1()))
        holder.txtType2.setText((llistat.get(position).getType2()))

    }

    override fun getItemCount(): Int {
        return llistat.size;
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNom: TextView = view.findViewById(R.id.itemName);
        val txtType1: TextView = view.findViewById(R.id.itemType1)
        val txtType2: TextView = view.findViewById(R.id.itemType2)
    }

}