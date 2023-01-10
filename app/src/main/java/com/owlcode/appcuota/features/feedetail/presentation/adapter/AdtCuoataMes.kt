package com.owlcode.appcuota.features.feedetail.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.owlcode.appcuota.R
import com.owlcode.appcuota.features.feedetail.domain.model.AllCuote
import com.owlcode.appcuota.utils.utils

class AdtCuoataMes (var data:MutableList<AllCuote>): RecyclerView.Adapter<AdtCuoataMes.holderConsultaDataMes>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holderConsultaDataMes {
        val layoutInflater = LayoutInflater.from(parent.context)
        return holderConsultaDataMes(layoutInflater.inflate(R.layout.item_data_mes,parent,false))
    }

    override fun onBindViewHolder(holder: holderConsultaDataMes, position: Int) {
        holder.holderConsultaStock(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class holderConsultaDataMes(private val view: View): RecyclerView.ViewHolder(view){
        fun holderConsultaStock (data: AllCuote){
            val cardDataMes = view.findViewById<LinearLayout>(R.id.cardDataMes)
            val tv_nrocuota = view.findViewById<TextView>(R.id.tv_nrocuota)
            val tv_mes = view.findViewById<TextView>(R.id.tv_mes)
            val tv_fecha = view.findViewById<TextView>(R.id.tv_fecha)
            val tv_estado = view.findViewById<TextView>(R.id.tv_estado)
            val tv_monto = view.findViewById<TextView>(R.id.tv_monto)

            val iv_iconEstado = view.findViewById<ImageView>(R.id.iv_iconEstado)

            tv_nrocuota.text = data.cuota.toString()
            tv_mes.text = data.mes
            tv_fecha.text= data.fechaVencimiento
            tv_estado.text = data.estado
            val importe = utils().returnNumen(data.importe)
            tv_monto.text = "S/. ${utils().pricetostringformat(importe.toDouble())}"

            if (data.estado == "PAGADO"){
                iv_iconEstado.setImageResource(R.drawable.ic_check)
                //iv_iconEstado.setColorFilter(ContextCompat.getColor(this.itemView.context, R.color.green))

                tv_nrocuota.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.white))
                tv_mes.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.white))
                tv_fecha.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.white))
                tv_estado.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.white))
                tv_monto.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.white))
                cardDataMes.setBackgroundColor(ContextCompat.getColor(this.itemView.context, R.color.green))
            }
            if (data.estado == "VENCIDO"){
                iv_iconEstado.setImageResource(R.drawable.ic_close)
                //iv_iconEstado.setColorFilter(ContextCompat.getColor(this.itemView.context, R.color.red))

                tv_nrocuota.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.white))
                tv_mes.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.white))
                tv_fecha.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.white))
                tv_estado.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.white))
                tv_monto.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.white))
                cardDataMes.setBackgroundColor(ContextCompat.getColor(this.itemView.context, R.color.red))
            }
            if (data.estado == "PENDIENTE"){
                iv_iconEstado.setImageResource(R.drawable.ic_circle)
                iv_iconEstado.setColorFilter(ContextCompat.getColor(this.itemView.context, R.color.darkGrey))
                cardDataMes.setBackgroundColor(ContextCompat.getColor(this.itemView.context, R.color.white))
            }

        }
    }

    fun filterList(nameItemBuscado: MutableList<AllCuote>) {
        data = nameItemBuscado
        notifyDataSetChanged()
    }

}