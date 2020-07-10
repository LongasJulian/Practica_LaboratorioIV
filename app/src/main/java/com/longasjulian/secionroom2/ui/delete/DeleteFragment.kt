package com.longasjulian.secionroom2.ui.delete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.longasjulian.secionroom2.R
import com.longasjulian.secionroom2.SecionRoom2
import kotlinx.android.synthetic.main.fragment_delete.*

class DeleteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Borrar_BT.setOnClickListener {
            val nombre = Nombre_TI.text.toString()

            val deudorDao = SecionRoom2.database.DeudorDAO()
            val deudor = deudorDao.buscarDeudor(nombre)

            if (deudor != null){
                deudorDao.borrarDeudor(deudor)
            }
            else{
                Toast.makeText(context, "Deudor no encontrado", Toast.LENGTH_SHORT).show()
            }

        }

    }
}