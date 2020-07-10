package com.longasjulian.secionroom2.ui.List

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.longasjulian.secionroom2.R
import com.longasjulian.secionroom2.SecionRoom2
import com.longasjulian.secionroom2.model.Deudor.Deudor
import com.longasjulian.secionroom2.model.Deudor.DeudorDAO

class ListFragment : Fragment() {

    var allDeudores : List<Deudor> = emptyList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_list, container, false)

        val Deudores_RV = root.findViewById<RecyclerView>(R.id.Deudores_RV)

        Deudores_RV.layoutManager = LinearLayoutManager(
            this.requireActivity().applicationContext,
            RecyclerView.VERTICAL,
            false
        )

        Deudores_RV.setHasFixedSize(true)

        var deudorDAO: DeudorDAO = SecionRoom2.database.DeudorDAO()
        allDeudores = deudorDAO.getDeudores()

        var deudoresRVAdapter = DeudoresRVAdapter(
            this.requireActivity().applicationContext,
            allDeudores as ArrayList<Deudor>
        )

        Deudores_RV.adapter = deudoresRVAdapter

        deudoresRVAdapter.notifyDataSetChanged()

        return root
    }



}