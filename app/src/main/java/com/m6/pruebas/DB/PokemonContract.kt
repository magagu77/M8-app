package com.m6.pruebas.DB

object PokemonContract  {
    val TABLE_NAME = "POKEMON"
    val COLUMN_NAME_NOMBRE = "PK_NOMBRE"
    val COLUMN_NAME_TIPO1 = "PK_TIPO1"
    val COLUMN_NAME_TIPO2 = "PK_TIPO2"
    val SELECT_ALL = "SELECT * FROM ${TABLE_NAME}"

    val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${TABLE_NAME} (" +
                "PK_ID INTEGER PRIMARY KEY," +
                "${COLUMN_NAME_NOMBRE} TEXT," +
                "${COLUMN_NAME_TIPO1} TEXT,"+
                "${COLUMN_NAME_TIPO2} TEXT)"

    val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${TABLE_NAME}"

    val DELETE = "DELETE FROM POKEMON"
}