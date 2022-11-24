package com.m6.pruebas.Recyclers

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.m6.pruebas.DB.PokemonDBHelper
import com.m6.pruebas.Pokemon
import com.m6.pruebas.R
import com.m6.pruebas.fragments.DetailFragment

class RecyclerViewAdapter(llistat: MutableList<Pokemon>, dbH: PokemonDBHelper, context: Context?): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    var llistat: MutableList<Pokemon> = llistat;
    var context: Context? = context;
    var dbHelper = dbH


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val posicion = position
        holder.txtNom.setText(llistat.get(posicion).getName());
        holder.txtType1.setText((llistat.get(posicion).getType1()))
        holder.txtType2.setText((llistat.get(posicion).getType2()))
        holder.deleteButton.setOnClickListener{
            val builder = AlertDialog.Builder(this.context)
            builder.setMessage("Confirmar el borrado de datos")
                .setPositiveButton("OK",
                    DialogInterface.OnClickListener { dialog, id ->
                        // Borrar datos
                        dbHelper.deletePokemon(llistat.get(position).getName())
                        Toast.makeText(context, "Data has been deleted", Toast.LENGTH_SHORT).show()
                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        // No se borra la base de datos y cierra el dialog
                    })
            //Crea el cuadro de dialog
            builder.create().show()
        }
        //Carga un fragment con mas información
        holder.itemView.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
                activity.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, DetailFragment(llistat[posicion])).commit();
            }
        })

    }

    override fun getItemCount(): Int {
        return llistat.size;
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNom: TextView = view.findViewById(R.id.itemName);
        val txtType1: TextView = view.findViewById(R.id.itemType1)
        val txtType2: TextView = view.findViewById(R.id.itemType2)
        val deleteButton: Button = view.findViewById(R.id.buttonDelete)
    }

}