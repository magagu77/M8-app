package com.m6.pruebas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.m6.pruebas.Pokemon
import com.m6.pruebas.R


class DetailFragment(pokemon:Pokemon) : Fragment() {
    var pk:Pokemon = pokemon
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_detail, container, false);

        val txtDetail: TextView = view.findViewById(R.id.textDetail);
        val txt:String = "${pk.getName()} es un pokemon"
        txtDetail.setText(txt)

        return view;

    }
}