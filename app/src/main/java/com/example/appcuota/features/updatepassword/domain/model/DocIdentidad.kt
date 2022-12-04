package com.example.appcuota.features.updatepassword.domain.model

import com.example.appcuota.features.updatepassword.data.remote.dto.DocIdentidadDTO

data class DocIdentidad(
    val docIdentidad: String
){
    fun toDocIdentidadDTO() = DocIdentidadDTO(
        docIdentidad = docIdentidad
    )
}