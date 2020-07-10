package com.longasjulian.secionroom2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.longasjulian.secionroom2.model.usuario.Usuario
import com.longasjulian.secionroom2.model.usuario.UsuarioDAO
import kotlinx.android.synthetic.main.activity_registro.*
import java.sql.Types.NULL

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        RegistrarseRegistro_BT.setOnClickListener {
            val nombre      = NombreRegistro_ET.text.toString()
            val correo      = CorreoRegistro_ET.text.toString()
            val password    = PasswordRegistro_ET.text.toString()
            val reppassword = repPasswordRegistro_ET.text.toString()

            if (nombre.isEmpty() || correo.isEmpty() || password.isEmpty() || reppassword.isEmpty()){

                Toast.makeText(this,"Por favor complete todos los campos", Toast.LENGTH_SHORT).show()

            }
            else{
                if(password!=reppassword)
                    Toast.makeText(this,"Las contraseñas no coinciden, digítela de nuevo", Toast.LENGTH_SHORT).show()
                else{
                    val intent = Intent(this, LoginActivity::class.java)
                    Toast.makeText(this,"Correo= $correo", Toast.LENGTH_LONG).show()

                    //Se guardan los datos
                    val usuario = Usuario(
                        NULL,
                        nombre,
                        correo,
                        password
                    )

                    val usuarioDAO : UsuarioDAO = SecionRoom2.database2.UsuarioDAO()
                    usuarioDAO.crearUsuario(usuario)

                    onBackPressed()
                    startActivity(intent)
                }
            }


        }

    }
}

