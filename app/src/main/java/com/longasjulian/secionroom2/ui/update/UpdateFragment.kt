package com.longasjulian.secionroom2.ui.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.longasjulian.secionroom2.R
import com.longasjulian.secionroom2.SecionRoom2
import com.longasjulian.secionroom2.model.Deudor.Deudor
import com.longasjulian.secionroom2.model.Deudor.DeudorDAO
import kotlinx.android.synthetic.main.fragment_update.*


class UpdateFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_update, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TelefonoUpdate_TI.visibility = View.GONE
        CantidadUpdate_TI.visibility = View.GONE
        var idDeudor = 0
        val deudorDAO: DeudorDAO = SecionRoom2.database.DeudorDAO()

        this.BuscarUpdate_BT.setOnClickListener {
            val nombre = NombreUpdate_TI.text.toString()
            val deudor = deudorDAO.buscarDeudor(nombre)

            if (deudor != null) {

                idDeudor = deudor.id
                TelefonoUpdate_TI.visibility = View.VISIBLE
                CantidadUpdate_TI.visibility = View.VISIBLE
                TelefonoUpdate_TI.setText(deudor.telefono)
                CantidadUpdate_TI.setText(deudor.cantidad.toString())
                BuscarUpdate_BT.visibility = View.GONE
                Actualizar_BT.visibility = View.VISIBLE
            } else {
                Toast.makeText(context, "Deudor no Registrado", Toast.LENGTH_SHORT).show()
            }
        }

            Actualizar_BT.setOnClickListener {

                val deudor = Deudor(
                    idDeudor,
                    NombreUpdate_TI.text.toString(),
                    TelefonoUpdate_TI.text.toString(),
                    CantidadUpdate_TI.text.toString().toLong()
                )

                deudorDAO.actualizarDeudor(deudor)
                TelefonoUpdate_TI.visibility = View.GONE
                CantidadUpdate_TI.visibility = View.GONE
                BuscarUpdate_BT.visibility = View.VISIBLE
                Actualizar_BT.visibility = View.GONE
            }

        }

}