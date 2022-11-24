package com.m6.pruebas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.m6.pruebas.DB.PokemonDBHelper
import com.m6.pruebas.Pokemon
import com.m6.pruebas.R
import com.m6.pruebas.Recyclers.RecyclerViewAdapter

class ListFragment(dbH: PokemonDBHelper) : Fragment() {
    var dbHelper = dbH

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_list, container, false)

        val lista:MutableList<Pokemon> = dbHelper.selectPokemon();

        val recycler: RecyclerView = v.findViewById(R.id.recyclerList);
        recycler.layoutManager = LinearLayoutManager(context)
        val mAdapter : RecyclerViewAdapter = RecyclerViewAdapter(lista,dbHelper, context);

        recycler.adapter = mAdapter
        return v;
    }


}