package com.example.realsofttask.common.composables

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Spacer10dp() {
    Spacer(modifier = Modifier.size(10.dp))
}

@Composable
fun ColumnScope.FillAvailableSpace() {
    Spacer(modifier = Modifier.weight(1f))
}

@Composable
fun RowScope.FillAvailableSpace() {
    Spacer(modifier = Modifier.weight(1f))
}