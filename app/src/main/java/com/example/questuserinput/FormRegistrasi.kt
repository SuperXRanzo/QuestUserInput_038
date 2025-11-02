package com.example.questuserinput

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import java.util.Calendar

@Composable
fun FormRegistrasi(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf(TextFieldValue("")) }
    var alamat by remember { mutableStateOf(TextFieldValue("")) }
    var rt by remember { mutableStateOf(TextFieldValue("")) }
    var rw by remember { mutableStateOf(TextFieldValue("")) }
    var kota by remember { mutableStateOf(TextFieldValue("")) }
    var tanggalLahir by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            tanggalLahir = "$dayOfMonth/${month + 1}/$year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_form), // ubah sesuai nama file-mu
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.White.copy(alpha = 0.9f), RoundedCornerShape(16.dp))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Form Registrasi",
            style = MaterialTheme.typography.titleLarge
        )

        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama Lengkap") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth()
        )