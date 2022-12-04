package com.example.appcuota.features.login.data.remote.dto

import com.example.appcuota.features.login.domain.model.LoginResponse

data class LoginResponseDTO(
    val usuario: String?,
    val nombreusuario: String?,
    val codigO_EMPRESA: String?,
    val iD_CLIENTE: Int?,
    val poR_IGV: String?,
    val cdgmoneda: String?,
    val validez: String?,
    val cdgpago: String?,
    val sucursal: String?,
    val nombremozo: String?,
    val usuarioautoriza: String?,
    val usuariocreacion: String?,
    val descuento: String?,
    val seriepedido: String?,
    val estadopedido: String?,
    val tipocambio: Double?,
    val jwtToken: String?,
    val facturA_ADELANTADA: String?,
    val iD_COTIZACION: String?,
    val puntO_VENTA: String?,
    val redondeo: String,
    val motivo: String?,
    val correlativo: String?,
    val refreshToken: String,
    val cdG_VENDEDOR: String?,
    val ruc: String,
    val nombre: String,
    val flogin: Int
){
    fun toLoginResponce() = LoginResponse(
         ruc= ruc,
         nombre= nombre,
         flogin= flogin
    )
}