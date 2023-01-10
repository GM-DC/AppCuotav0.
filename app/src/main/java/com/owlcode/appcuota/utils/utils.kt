package com.owlcode.appcuota.utils

class utils {

    fun pricetostringformat(valuenumeric: Double): String {
        return String.format("%,.2f", valuenumeric)
    }

    fun returnNumen(string: String):String{
        val regex = """[0123456789.]+""".toRegex()
        return regex.find(string)?.value ?: ""
    }

}