package com.m6.pruebas.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.m6.pruebas.DB.PokemonContract.COLUMN_NAME_NOMBRE
import com.m6.pruebas.DB.PokemonContract.COLUMN_NAME_TIPO1
import com.m6.pruebas.DB.PokemonContract.COLUMN_NAME_TIPO2
import com.m6.pruebas.DB.PokemonContract.DELETE
import com.m6.pruebas.DB.PokemonContract.SQL_CREATE_ENTRIES
import com.m6.pruebas.DB.PokemonContract.SQL_DELETE_ENTRIES
import com.m6.pruebas.DB.PokemonContract.TABLE_NAME
import com.m6.pruebas.Pokemon


class PokemonDBHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "pokemon.db"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    fun insertPokemon(l: Pokemon) {
        val values = ContentValues()
        values.put(COLUMN_NAME_NOMBRE, l.getName())
        values.put(COLUMN_NAME_TIPO1, l.getType1())
        values.put(COLUMN_NAME_TIPO2, l.getType2())

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
    }
    fun deleteTable(){
        val db = this.writableDatabase
        db.execSQL(DELETE)
    }
    fun deletePokemon(name:String){
        val db = this.writableDatabase
        db.execSQL(("DELETE FROM POKEMON WHERE PK_NOMBRE = '${name}'"))
    }
    fun selectPokemon() :MutableList<Pokemon>{
        var lista:MutableList<Pokemon> = ArrayList()
        val select:Array<String> = arrayOf("PK_ID","PK_NOMBRE","PK_TIPO1","PK_TIPO2")
        val db = this.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM POKEMON",null )
        with(cursor) {
            while (cursor.moveToNext()) {
                val nom = getString(getColumnIndexOrThrow("PK_NOMBRE"))
                val tipo1 = getString(getColumnIndexOrThrow("PK_TIPO1"))
                val tipo2= getString(getColumnIndexOrThrow("PK_TIPO2"))
                lista.add(Pokemon(nom,tipo1,tipo2))
            }
        }
        cursor.close()
        return lista
    }
}
