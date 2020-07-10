package com.longasjulian.secionroom2.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.longasjulian.secionroom2.R
import com.longasjulian.secionroom2.SecionRoom2
import com.longasjulian.secionroom2.model.Deudor.Deudor
import com.longasjulian.secionroom2.model.Deudor.DeudorDAO
import kotlinx.android.synthetic.main.fragment_create.*
import java.sql.Types

class CreateFragment : Fragment() {



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_create, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_guardar.setOnClickListener{
            val nombre = Nombre_TI.text.toString()
            val telefono = Telefono_TI.text.toString()
            val cantidad = Cantidad_TI.text.toString().toLong()

            val deudor = Deudor(
                Types.NULL,
                nombre,
                telefono,
                cantidad
            )

            val deudorDAO : DeudorDAO = SecionRoom2.database.DeudorDAO()

            deudorDAO.crearDeudor(deudor)

            Nombre_TI.setText("")
            Telefono_TI.setText("")
            Cantidad_TI.setText("")
        }

    }
}