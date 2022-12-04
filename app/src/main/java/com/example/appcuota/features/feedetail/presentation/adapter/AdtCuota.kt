package com.example.appcuota.features.feedetail.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcuota.R
import com.example.appcuota.databinding.ItemDataAnoBinding
import com.example.appcuota.features.feedetail.domain.model.CuotaByAno

class AdtCuota (var data:MutableList<CuotaByAno>): RecyclerView.Adapter<AdtCuota.holderConsultaDataDeuda>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holderConsultaDataDeuda {
        val layoutInflater = LayoutInflater.from(parent.context)
        return holderConsultaDataDeuda(layoutInflater.inflate(R.layout.item_data_ano,parent,false))
    }

    override fun onBindViewHolder(holder: holderConsultaDataDeuda, position: Int) {
        holder.holderConsultaStock(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }

    class holderConsultaDataDeuda(private val view: View): RecyclerView.ViewHolder(view){

        val binding = ItemDataAnoBinding.bind(view)

        fun holderConsultaStock (data: CuotaByAno){
            val tv_ano=view.findViewById<TextView>(R.id.tv_ano)
            val rv_meses=view.findViewById<RecyclerView>(R.id.rv_meses)

            tv_ano.text = data.ano.toString()
            tv_ano.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.colorPrimary))

            rv_meses?.layoutManager = GridLayoutManager(this.itemView.context,2, RecyclerView.VERTICAL,false)
            val childRecyclerAdapter = AdtCuoataMes(data.cuotas.toMutableList())
            rv_meses.adapter = childRecyclerAdapter

        }
    }

    fun filterList(nameItemBuscado: MutableList<CuotaByAno>) {
        data = nameItemBuscado
        notifyDataSetChanged()
    }

    fun setItems(list: MutableList<CuotaByAno>) {
        list.clear()
        list.addAll(list)
        notifyDataSetChanged()
    }

}