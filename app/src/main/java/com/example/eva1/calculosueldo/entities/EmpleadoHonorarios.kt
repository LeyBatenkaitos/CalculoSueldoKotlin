package com.example.eva1.calculosueldo.entities

class EmpleadoHonorarios(sueldoBruto: Double) : Empleado(sueldoBruto) {

    override fun calcularLiquido(): Double {
        return sueldoBruto - (sueldoBruto * 0.13)
    }
}