package com.longasjulian.secionroom2.ui.read

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.longasjulian.secionroom2.R
import com.longasjulian.secionroom2.SecionRoom2
import com.longasjulian.secionroom2.model.Deudor.DeudorDAO
import kotlinx.android.synthetic.main.fragment_create.*
import kotlinx.android.synthetic.main.fragment_read.*

class ReadFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_read, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Buscar_BT.setOnClickListener {
            val nombre = NombreRead_TI.text.toString()

            val deudorDAO: DeudorDAO = SecionRoom2.database.DeudorDAO()
            val deudor = deudorDAO.buscarDeudor(nombre)

            if (deudor != null){
                Resultado_TV.text =
                    "Nombre: ${deudor.nombre}\n" + "Telefono: ${deudor.telefono}\n" +
                            "cantidad: ${deudor.cantidad}"
            }else {
                Toast.makeText(context, "Deudor no Registrado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}