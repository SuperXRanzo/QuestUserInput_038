package com.example.questuserinput

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun FormRegistrasi(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf(TextFieldValue("")) }
    var alamat by remember { mutableStateOf(TextFieldValue("")) }
    var rt by remember { mutableStateOf(TextFieldValue("")) }
    var rw by remember { mutableStateOf(TextFieldValue("")) }
    var kota by remember { mutableStateOf(TextFieldValue("")) }
    var umur by remember { mutableStateOf(TextFieldValue("")) }
    var tanggalLahir by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    var jenisKelamin by remember { mutableStateOf("Laki-laki") } // default

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
            painter = painterResource(id = R.drawable.bg_form),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

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
                value = kota,
                onValueChange = { kota = it },
                label = { Text("Kota Asal") },
                modifier = Modifier.fillMaxWidth()
            )


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = tanggalLahir,
                    onValueChange = {},
                    label = { Text("Tanggal Lahir") },
                    modifier = Modifier
                        .weight(1.3f)
                        .clickable { datePickerDialog.show() },
                    enabled = false,
                    readOnly = true
                )
                OutlinedTextField(
                    value = rt,
                    onValueChange = { rt = it },
                    label = { Text("RT") },
                    modifier = Modifier.weight(0.6f)
                )
                OutlinedTextField(
                    value = rw,
                    onValueChange = { rw = it },
                    label = { Text("RW") },
                    modifier = Modifier.weight(0.6f)
                )
            }

            OutlinedTextField(
                value = umur,
                onValueChange = { umur = it },
                label = { Text("Umur") },
                modifier = Modifier.fillMaxWidth()
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Jenis Kelamin")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = jenisKelamin == "Laki-laki",
                            onClick = { jenisKelamin = "Laki-laki" }
                        )
                        Text("Laki-laki")
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = jenisKelamin == "Perempuan",
                            onClick = { jenisKelamin = "Perempuan" }
                        )
                        Text("Perempuan")
                    }
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it }
                )
                Text("Saya menyetujui data di atas")
            }

            Button(
                onClick = { /* Submit action */ },
                enabled = checked,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Text("Submit")
            }
        }
    }
}
