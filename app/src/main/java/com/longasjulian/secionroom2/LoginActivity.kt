package com.longasjulian.secionroom2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.longasjulian.secionroom2.model.usuario.UsuarioDAO
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_login)


        Registrarse_ET.setOnClickListener{
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
            finish()
        }

        Login_BT.setOnClickListener {
            val correo = CorreoLogin_ET.text.toString()
            val contrasena = PasswordLogin_ET.text.toString()

            val usuarioDAO: UsuarioDAO = SecionRoom2.database2.UsuarioDAO()
            val usuario = usuarioDAO.buscarCorreoUsuario(correo)

            if (usuario != null){

                if (usuario.password == contrasena){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else
                    Toast.makeText(this, "Contraseña Incorrecta", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this, "Usuario NO Registrado", Toast.LENGTH_SHORT).show()



        }
    }
}