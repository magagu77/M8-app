package com.m6.pruebas

class Pokemon (name:String="", type1:String="",type2:String="" ){
    var name:String = name
    var type1:String = type1
    var type2:String = type2

    @JvmName("devuelveNombre")
    fun getName():String{return this.name}
    @JvmName("devuelveType1")
    fun getType1():String{return this.type1}
    @JvmName("devuelveType2")
    fun getType2():String{return this.type2}
    @JvmName("setNombre")
    fun setName(nombre: String) {this.name=nombre}
    @JvmName("setTyp1")
    fun setType1(nombre: String) {this.type1=nombre}
    @JvmName("setTyp2")
    fun setType2(nombre: String) {this.type2=nombre}

}