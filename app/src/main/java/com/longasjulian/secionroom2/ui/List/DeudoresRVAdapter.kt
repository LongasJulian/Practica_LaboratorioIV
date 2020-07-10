package com.longasjulian.secionroom2.ui.List

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.longasjulian.secionroom2.R
import com.longasjulian.secionroom2.model.Deudor.Deudor
import kotlinx.android.synthetic.main.item_deudor.view.*

class DeudoresRVAdapter (
    var context: Context,
    var deudoresList : ArrayList<Deudor>
):RecyclerView.Adapter<DeudoresRVAdapter.DeudoresViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DeudoresViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.item_deudor, parent, false)
        return DeudoresViewHolder(itemView, context)
    }

    override fun getItemCount(): Int = deudoresList.size

    override fun onBindViewHolder(
        holder: DeudoresViewHolder,
        position: Int
    ) {
        val deudor: Deudor = deudoresList[position]
        holder.binDeudor(deudor)
    }

    class DeudoresViewHolder(
        itemView: View,
        context: Context
    ) : RecyclerView.ViewHolder(itemView) {
        fun binDeudor(deudor: Deudor) {
            itemView.Nombre_TV.text = deudor.nombre
            itemView.DeudaTV.text = deudor.cantidad.toString()
        }
    }
}
