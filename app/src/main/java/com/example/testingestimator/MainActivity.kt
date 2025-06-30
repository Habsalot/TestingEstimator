package com.example.testingestimator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

// Layout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

// Material3 components
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

// State & runtime
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

// Text input
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



// Preview
import androidx.compose.ui.tooling.preview.Preview

// Your theme
import com.example.testingestimator.ui.theme.TestingEstimatorTheme

// Formatting
import java.text.NumberFormat


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestingEstimatorTheme {
                Scaffold { padding ->
                    PricingEstimatorScreen(
                        modifier = Modifier
                            .padding(padding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun PricingEstimatorScreen(modifier: Modifier = Modifier) {
    var quantity by remember { mutableStateOf("") }
    var unitPrice by remember { mutableStateOf("") }
    var total by remember { mutableStateOf(0.0) }

    Column(modifier = modifier.padding(16.dp)) {
        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Quantity") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = unitPrice,
            onValueChange = { unitPrice = it },
            label = { Text("Unit Price") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                val q = quantity.toIntOrNull() ?: 0
                val p = unitPrice.toDoubleOrNull() ?: 0.0
                total = q * p
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Calculate")
        }
        Spacer(Modifier.height(16.dp))
        Text(
            text = "Total: ${NumberFormat.getCurrencyInstance().format(total)}",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PricingEstimatorPreview() {
    TestingEstimatorTheme {
        PricingEstimatorScreen(Modifier.fillMaxSize())
    }
}
