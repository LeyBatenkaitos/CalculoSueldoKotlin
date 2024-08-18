package com.example.eva1.calculosueldo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eva1.calculosueldo.entities.EmpleadoHonorarios

class CalculoDeHonorario : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculoDeHonorarioUI()
        }
    }
}

/**
 * [CalculoDeHonorarioUI] es una función composable en Jetpack Compose que crea una interfaz de usuario
 * para calcular el sueldo líquido de un empleado a honorarios.
 *
 * Esta función incluye un campo de texto para ingresar el sueldo bruto, un botón para calcular
 * el sueldo líquido, y un botón adicional para volver al menú principal. El resultado del cálculo
 * se muestra en pantalla después de presionar el botón de calcular.
 *
 * Estructura de la interfaz:
 * - Un botón que redirige al usuario al menú principal.
 * - Un texto descriptivo que indica la funcionalidad de la UI.
 * - Un campo de texto para ingresar el sueldo.
 * - Un botón que realiza el cálculo del sueldo líquido.
 * - Un texto que muestra el resultado del cálculo.
 *
 * Variables:
 * - [contexto]: Obtiene el contexto actual de la aplicación para manejar la navegación entre actividades.
 * - [sueldo]: Estado mutable que guarda el valor del sueldo ingresado por el usuario.
 * - [resultado]: Estado mutable que guarda el resultado del cálculo del sueldo líquido.
 *
 * Consideraciones:
 * - El campo de texto solo acepta números, lo que se asegura mediante `KeyboardOptions`.
 * - Se maneja el caso en que la conversión de sueldo a `Double` pueda fallar, asignando un valor predeterminado de `0.0`.
 * - Asegúrate de que la clase [EmpleadoHonorarios] esté correctamente definida para manejar el cálculo del sueldo líquido.
 *
 */
@Preview(showBackground = true)
@Composable
fun CalculoDeHonorarioUI() {
    val contexto = LocalContext.current
    val estadoNumeroInicial = ""
    var sueldo by remember {
        mutableStateOf(estadoNumeroInicial)
    }
    var resultado by remember {
        mutableStateOf(estadoNumeroInicial)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Button(
            onClick = {
                Log.i("CalculoDeHonorario", "Volviendo al menu principal")
                val intent = Intent(contexto, MainActivity::class.java)
                contexto.startActivity(intent)
            },
            modifier = Modifier.padding(
                horizontal = 25.dp,
                vertical = 25.dp
            )
        ) {
            Text(text = "Volver al Menu")
        }

        Text(
            text = "Calculo de sueldo de empleado a Honorarios: ",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = sueldo,
            onValueChange = { sueldo = it },
            label = { Text(text = "Sueldo") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                Log.i("CalculoDeHonorario", "Calculando sueldo honorarios")
                val sueldoToDoble = sueldo.toDoubleOrNull() ?: 0.0
                val empleadoHonorario = EmpleadoHonorarios(sueldoToDoble)
                resultado =
                    "El sueldo liquido a honorarios es: ${empleadoHonorario.calcularLiquido()}"
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Calcular sueldo liquido")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = resultado, modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

    }

}