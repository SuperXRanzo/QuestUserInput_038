package com.example.questuserinput

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun FormDataDiri(modifier: Modifier
){
    var textName by remember {mutableStateOf( value = "")}
    var textAlamat by remember {mutableStateOf( value = "")}
    var textJK by remember {mutableStateOf( value = "")}
}