package com.example.eva1.calculosueldo.entities

class EmpleadoRegular(sueldoBruto: Double) : Empleado(sueldoBruto) {

    override fun calcularLiquido(): Double {
        return sueldoBruto - (sueldoBruto * 0.20)
    }
}