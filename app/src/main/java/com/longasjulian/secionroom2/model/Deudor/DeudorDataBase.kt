package com.longasjulian.secionroom2.model.Deudor

import androidx.room.Database
import androidx.room.RoomDatabase
import com.longasjulian.secionroom2.model.Deudor.Deudor
import com.longasjulian.secionroom2.model.Deudor.DeudorDAO

@Database(entities = arrayOf(Deudor::class), version = 1)
abstract class DeudorDataBase : RoomDatabase(){

    abstract fun DeudorDAO() : DeudorDAO

}