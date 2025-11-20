package com.example.lomake

import android.R.attr.label
import android.R.attr.value
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lomake.ui.theme.LomakeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LomakeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Form(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Form (modifier: Modifier = Modifier) {
    val formModifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp)
        .padding(vertical = 8.dp)
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = modifier

    ) {
        Text(
            modifier=formModifier,
            text = "Login",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold, // Make it bold
                fontSize = 28.sp

        ) ,
            textAlign = TextAlign.Center

        )

        OutlinedTextField(
            modifier = formModifier,
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            trailingIcon = {
                Icon(Icons.Default.Person, contentDescription = "Person")

            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        OutlinedTextField(
            modifier = formModifier,
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            trailingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Lock")

            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()

        )

        Button(
            // This modifier makes the button take up the full width.
            modifier = formModifier,
            onClick = {
                // TODO: Handle the button click, for example:
                // Log.d("Form", "Username: $username, Password: $password")
            }
        ) { // The content of the Button, like Text, goes inside the trailing lambda.
            Text("Submit")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LomakeTheme {
       Form()
    }
}