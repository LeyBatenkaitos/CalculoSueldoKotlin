package com.example.eva1.calculosueldo.entities

abstract class Empleado(val sueldoBruto : Double) {
    abstract fun calcularLiquido() : Double
}