package com.example.questuserinput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@Composable
fun FormDataDiri(modifier: Modifier
){
    var textName by remember {mutableStateOf( value = "")}
    var textAlamat by remember {mutableStateOf( value = "")}
    var textJK by remember {mutableStateOf( value = "")}

    var nama by remember {mutableStateOf( value = "")}
    var alamat by remember {mutableStateOf( value = "")}
    var jenis by remember {mutableStateOf( value = "")}

    val gender:List<String> =listOf("Laki-Laki","Perempuan")

    Column(modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = textName,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width( width = 250.dp),
            label = { Text(text = "Nama Lengkap") },
            enValueChange = {
                textName = it
            }
        )
        Row {
            gender.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = textJK == item,
                    onClick = { textJK = item }
                ), verticalAlignment = Alignment.CenterHorizontally) {
                    RadioButton(
                        selected = textJK == item,
                        onClick = {
                            textJK = item
                        })
                    Text(text = item)
                }
            }
        }
        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width( width = 250.dp),
            label = { Text(text = "Alamat Lengkap") },
            onValueChange = {
                val it = null
                textAlamat = it
            }
        )
        Devider(
            modifier = Modifier.padding(bottom = dimensionResource(id=R.dimen.padding_medium), top = dimensionResource(
                id = R.dimen.padding_medium
            )),
            thickness = dimensionResource(id = R.dimen.divider_tipis),
            color = Color.DarkGray
        )
        Button(

        ) { }
    }
}