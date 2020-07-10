package com.longasjulian.secionroom2.model.usuario

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.longasjulian.secionroom2.model.Deudor.Deudor

@Dao
interface UsuarioDAO {

    @Insert
    fun crearUsuario(usuario: Usuario)

    @Query("SELECT * FROM tabla_usuario WHERE correo LIKE :correo")
    fun buscarCorreoUsuario(correo: String) : Usuario




}