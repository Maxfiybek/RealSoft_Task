package com.example.realsofttask.common.composables

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import io.ktor.websocket.Frame.Text

//@Composable
//fun RoundedTextField(
//    modifier: Modifier = Modifier,
//    value: String,
//    onValueChange: (String) -> Unit,
//    placeholder: String = "",
//    keyBoardOption: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//    containerColor: Color = Color.White,
//    singleLine: Boolean = true,
//) {
//    TextField(
//        modifier = modifier,
//        value = value,
//        onValueChange = onValueChange::invoke,
//        keyBoardOption = keyBoardOption,
//        placeholder = { Text(text = placeholder) },
//        singleLine = singleLine,
//        colors = TextFieldDefaults.colors(
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent,
//            disabledIndicatorColor = Color.Transparent,
//            focusedContainerColor = containerColor,
//            unfocusedContainerColor = containerColor
//        ),
//        shape = RoundedCornerShape(8.dp)
//    )
//}