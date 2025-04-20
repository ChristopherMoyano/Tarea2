package com.example.tarea2.ui

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CustomOutlinedFile(
    name: String,
    label: String, onValueChange: (String) -> Unit,
    icon: @Composable (() -> Unit)? = null, keyboardType: KeyboardType = KeyboardType.Text,
    placeholder: @Composable (() -> Unit)? = null,
    validation: ((String) -> Boolean)? = null,
    errorMessage: String? = null
) {
    OutlinedTextField(
        value = name,
        singleLine = true,
        leadingIcon = icon,
        onValueChange = onValueChange,
        maxLines = 1,
        isError = validation != null && !validation(name),
        placeholder = placeholder,
        textStyle = TextStyle(
            color = MaterialTheme.colorScheme.onPrimary
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = if (validation != null && !validation(name)) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onPrimary,
            unfocusedBorderColor = if (validation != null && !validation(name)) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onPrimary,
            errorBorderColor = MaterialTheme.colorScheme.error,
            errorCursorColor = MaterialTheme.colorScheme.error,
            errorLeadingIconColor = MaterialTheme.colorScheme.error,
            errorLabelColor = MaterialTheme.colorScheme.error,
        ),
        supportingText = {
            if (validation != null) {
                if (!validation(name)) {
                    Text(
                        text = "$errorMessage",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        },
        label = { Text(label, color = MaterialTheme.colorScheme.onPrimary) }
    )
}