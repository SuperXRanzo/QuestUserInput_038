package com.example.questuserinput

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun FormRegistrasi(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf(TextFieldValue("")) }