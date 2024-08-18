package com.example.eva1.calculosueldo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eva1.calculosueldo.entities.EmpleadoRegular

class CalculoDeEmpleado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculo_de_empleado)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        calcularSueldoEmpleado()

    }

    /**
     * El método [calcularSueldoEmpleado] es una función privada que gestiona la lógica de la interfaz
     * de usuario en una actividad para calcular el sueldo líquido de un empleado regular.
     *
     * Este método asocia eventos `OnClickListener` a los botones de la interfaz para permitir la
     * navegación al menú principal y para realizar el cálculo del sueldo líquido basado en un
     * sueldo bruto ingresado por el usuario.
     *
     * Funcionalidades principales:
     * - Permite al usuario ingresar un sueldo bruto en un campo de texto.
     * - Calcula el sueldo líquido de un empleado regular utilizando la clase [EmpleadoRegular].
     * - Muestra el resultado del cálculo en un `TextView`.
     * - Proporciona un botón para regresar al menú principal.
     *
     * Elementos de la UI manipulados:
     * - [botonMenu]: Un botón que redirige al menú principal de la aplicación.
     * - [campoSueldoBruto]: Un campo de texto donde el usuario ingresa el sueldo bruto.
     * - [botonCalcularSueldoLiquido]: Un botón que, al ser presionado, calcula y muestra el sueldo líquido.
     * - [resultado]: Un `TextView` donde se muestra el resultado del cálculo del sueldo líquido.
     *
     * Manejo de errores:
     * - Si el valor ingresado en [campoSueldoBruto] no es un número válido, se asume un valor predeterminado
     *   de `0.0` para evitar fallos en la aplicación.
     *
     *
     * Dependencias:
     * - La clase [EmpleadoRegular] debe estar correctamente definida para calcular el sueldo líquido.
     *
     * Consideraciones:
     * - Asegúrate de que los IDs utilizados (`R.id.btnMenu`, `R.id.textSueldoBruto`, `R.id.btnCalcularLiquido`,
     *   `R.id.resultado`) estén definidos en el archivo de layout correspondiente.
     * - El método asume que el layout de la actividad contiene los elementos de UI necesarios.
     *
     */
    private fun calcularSueldoEmpleado() {
        val botonMenu = findViewById<Button>(R.id.btnMenu)
        val campoSueldoBruto = findViewById<EditText>(R.id.textSueldoBruto)
        val botonCalcularSueldoLiquido = findViewById<Button>(R.id.btnCalcularLiquido)
        val resultado = findViewById<TextView>(R.id.resultado)

        botonMenu.setOnClickListener() {
            Log.i("CalculoEmpleado", "Volviendo al menu principal")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        botonCalcularSueldoLiquido.setOnClickListener() {
            Log.i("CalculoEmpleado", "Calculando sueldo de empleado regular")
            val sueldoBruto = campoSueldoBruto.text.toString().toDoubleOrNull() ?: 0.0
            val empleadoRegular = EmpleadoRegular(sueldoBruto)
            "El sueldo liquido del empleado regular es: ${empleadoRegular.calcularLiquido()}"
                .also { resultado.text = it }

        }
    }
}