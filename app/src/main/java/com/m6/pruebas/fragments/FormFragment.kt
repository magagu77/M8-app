package com.m6.pruebas.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import com.m6.pruebas.DB.PokemonDBHelper
import com.m6.pruebas.Pokemon
import com.m6.pruebas.R

class FormFragment(dbH: PokemonDBHelper) : Fragment() {
    var dbHelper = dbH;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View =  inflater.inflate(R.layout.fragment_form, container, false);

        var buttonSave : Button = view.findViewById(R.id.btnSave);
        var buttonDelete: Button = view.findViewById(R.id.buttonDelete)
        var txtName: EditText = view.findViewById(R.id.pokemonName);
        var txtType1: EditText = view.findViewById(R.id.pokemonType);
        var txtType2: EditText = view.findViewById(R.id.txtPokemonType2);

        buttonSave.setOnClickListener{
            val name:String = txtName.text.toString()
            val type1 = txtType1.text.toString()
            val type2 = txtType2.text.toString()
            dbHelper.insertPokemon(Pokemon(name,type1,type2))
            Toast.makeText(context, "Pokemon has been added", LENGTH_SHORT).show()

        }

        buttonDelete.setOnClickListener{
            val builder = AlertDialog.Builder(this.context)
            builder.setMessage("Confirmar el borrado de datos")
                .setPositiveButton("OK",
                    DialogInterface.OnClickListener { dialog, id ->
                        // Borrar datos
                        dbHelper.deleteTable()
                        Toast.makeText(context, "Data has been deleted", LENGTH_SHORT).show()
                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        // No se borra la base de datos y cierra el dialog
                    })
// Create the AlertDialog object and return it
            builder.create().show()

        }
        return view;
    }
}