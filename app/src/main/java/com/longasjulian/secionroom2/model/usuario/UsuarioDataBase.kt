package com.longasjulian.secionroom2.model.usuario

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Usuario::class), version = 1)
abstract class UsuarioDataBase: RoomDatabase(){

    abstract fun UsuarioDAO(): UsuarioDAO

}