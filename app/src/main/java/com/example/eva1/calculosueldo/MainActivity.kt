package com.example.eva1.calculosueldo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eva1.calculosueldo.ui.theme.CalculoSueldoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallaInicio()
        }
    }
}

/**
 * [PantallaInicio] es una función composable en Jetpack Compose que crea la interfaz de usuario
 * para la pantalla de inicio o menú principal de una aplicación que calcula sueldos líquidos.
 *
 * Esta función presenta al usuario dos opciones: calcular el sueldo líquido de un empleado a honorarios
 * o calcular el sueldo líquido de un empleado regular. Dependiendo de la selección del usuario,
 * se inicia la actividad correspondiente.
 *
 * Funcionalidades principales:
 * - Muestra el título de la aplicación en la parte superior de la pantalla.
 * - Presenta dos botones que permiten navegar a diferentes pantallas para calcular sueldos.
 * - Maneja la navegación entre actividades utilizando `Intent`.
 *
 * Estructura de la interfaz:
 * - Un `Text` que muestra el título "Calculo de sueldo liquido".
 * - Un `Button` que lleva al usuario a la pantalla de cálculo de sueldos a honorarios.
 * - Un `Button` que lleva al usuario a la pantalla de cálculo de sueldos de empleados regulares.
 * - Espaciadores (`Spacer`) que crean un espacio entre los elementos para una mejor disposición visual.
 *
 * Parámetros:
 * - [contexto]: Se obtiene usando `LocalContext.current` para manejar la navegación dentro de la aplicación.
 *
 * Implementación:
 * - La columna (`Column`) organiza los elementos de la interfaz en una disposición vertical centrada en la pantalla.
 * - Cada `Button` se asocia con un `OnClickListener` que crea un `Intent` y navega a la actividad correspondiente
 *   (`CalculoDeHonorario` o `CalculoDeEmpleado`) al ser presionado.
 * - Se utiliza `Log.i` para registrar en el logcat cuando la pantalla de inicio es mostrada, con el mensaje "Menu principal".
 *
 *
 * Consideraciones:
 * - Asegúrate de que las clases `CalculoDeHonorario` y `CalculoDeEmpleado` existan y estén correctamente configuradas
 *   para manejar las actividades correspondientes.
 * - El color de fondo de la pantalla es `Color.DarkGray` y el texto se muestra en blanco (`Color.White`)
 *   para garantizar la legibilidad.
 * - Esta función puede ser utilizada como la pantalla principal de la aplicación.
 *
 */
@Preview
@Composable
fun PantallaInicio() {
    val contexto = LocalContext.current
    Log.i("MainActivity", "Menu principal")
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Calculo de sueldo liquido", color = Color.White)
        Spacer(modifier = Modifier.height(20.dp) )
        Button(onClick = {
            val intent = Intent(contexto, CalculoDeHonorario::class.java)
            contexto.startActivity(intent)
        }) {
            Text(text = "Calculo de Honorario")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val intent = Intent(contexto, CalculoDeEmpleado::class.java)
            contexto.startActivity(intent)
        }) {
            Text(text = "Calculo de Empleados")
        }
    }
}