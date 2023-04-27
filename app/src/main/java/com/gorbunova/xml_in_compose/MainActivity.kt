package com.gorbunova.xml_in_compose

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.gorbunova.xml_in_compose.ui.theme.XML_in_ComposeTheme
import ru.noties.jlatexmath.JLatexMathView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XML_in_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    XML_in()
                }
            }
        }
    }
}

@Composable
fun XML_in() {
    val text = "$$ c = \\pm\\sqrt{a^2 + b^2} $$"

    AndroidView(
        factory = {
            View.inflate(it,R.layout.text_layout, null)
        },
        modifier = Modifier.fillMaxSize(),
        update ={
            val exempel = it.findViewById<JLatexMathView>(R.id.math_view)
            exempel.setLatex(text)
        }
    )
}
