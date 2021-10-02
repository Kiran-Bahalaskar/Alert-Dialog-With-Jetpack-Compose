package com.kiranbahalaskar.alertdialog

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.kiranbahalaskar.alertdialog.ui.theme.AlertDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            alertDialog()

        }
    }
}


@Composable
fun alertDialog(){

    val context = LocalContext.current
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value)
    {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "AlertDialog", color = Color.Black) },
            text = { Text(text = "Hello Friends! This is Our Alert Dialog...", color = Color.Black) },

            confirmButton = {

                TextButton(
                    onClick = {
                        openDialog.value = false
                        Toast.makeText(context, "Confirm Button Click", Toast.LENGTH_SHORT).show()
                    }) {
                    Text(text = "Confirm", color = Color.Black)
                }

            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        Toast.makeText(context, "Dismiss Button Click", Toast.LENGTH_SHORT).show()
                    }) {
                    Text(text = "Dismiss", color = Color.Black)
                }
            },
            backgroundColor = Color.Green,
            contentColor = Color.White
        )
    }
}