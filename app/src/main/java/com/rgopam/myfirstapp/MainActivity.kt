package com.rgopam.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rgopam.myfirstapp.ui.theme.MyFirstAppTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter(){

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("USD") }
    var outputUnit by remember { mutableStateOf("INR") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(0.01) }
    val oconversionFactor = remember { mutableStateOf(0.01) }//commit
fun convertFunction(){
    val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
    val result = (inputValueDouble * conversionFactor.value ).roundToInt()
    outputValue = result.toString()
}

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to Currency Converter APP")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange =
        {
            inputValue = it
            convertFunction()
        },label = {Text("Enter Value")})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
           Box{
                Button(onClick = { iExpanded = true}) {
                    Text(inputUnit)
                    Icon(Icons.Default.ArrowDropDown,contentDescription="Arrow Down")

                }
               DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                   DropdownMenuItem(
                       text = { Text("USD") },
                       onClick = {
                           iExpanded = false
                           inputUnit = "USD"
                           conversionFactor.value = 80.0
                           convertFunction()
                       }
                   )
                   DropdownMenuItem(
                       text = { Text("INR") },
                       onClick = { iExpanded = false
                           inputUnit = "INR"
                           conversionFactor.value = 80.0
                           convertFunction()}
                   )
                   DropdownMenuItem(
                       text = { Text("CAD") },
                       onClick = { iExpanded = false
                           inputUnit = "CAD"
                           conversionFactor.value = 80.0
                           convertFunction()}
                   )
                   DropdownMenuItem(
                       text = { Text("AUD") },
                       onClick = { iExpanded = false
                           inputUnit = "AUD"
                           conversionFactor.value = 80.0
                           convertFunction()}
                   )
               }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick = { oExpanded = true}) {
                    Text(outputUnit)
                    Icon(Icons.Default.ArrowDropDown,contentDescription="Arrow Down")


                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = {oExpanded = false}) {
                    DropdownMenuItem(
                        text = { Text("USD") },
                        onClick = { oExpanded = false
                            outputUnit = "USD"
                            oconversionFactor.value = 80.0
                            convertFunction() }
                    )
                    DropdownMenuItem(
                        text = { Text("INR") },
                        onClick = { oExpanded = false
                            outputUnit = "INR"
                            oconversionFactor.value = 80.0
                            convertFunction() }
                    )
                    DropdownMenuItem(
                        text = { Text("CAD") },
                        onClick = { oExpanded = false
                            outputUnit = "CAD"
                            oconversionFactor.value = 80.0
                            convertFunction() }
                    )
                    DropdownMenuItem(
                        text = { Text("AUD") },
                        onClick = { oExpanded = false
                            outputUnit = "AUD"
                            oconversionFactor.value = 80.0
                            convertFunction()}
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result $outputValue")
    }
}



@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}