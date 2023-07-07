package dev.underoot.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.underoot.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant(title: String, body: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = title,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = body,
            color = Color.Black,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ComposeQuadrant() {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .weight(1F)
        ) {
            Quadrant(
                title = stringResource(R.string.quadrant_1_title),
                body = stringResource(R.string.quadrant_1_body),
                modifier = Modifier
                    .weight(1F)
                    .background(Color(0xFFEADDFF))
            )
            Quadrant(
                title = stringResource(R.string.quadrant_2_title),
                body = stringResource(R.string.quadrant_2_body),
                modifier = Modifier
                    .weight(1F)
                    .background(Color(0xFFD0BCFF))
            )
        }
        Row(
            modifier = Modifier
                .weight(1F)
        ) {
            Quadrant(
                title = stringResource(R.string.quadrant_3_title),
                body = stringResource(R.string.quadrant_3_body),
                modifier = Modifier
                    .weight(1F)
                    .background(Color(0xFFB69DF8))
            )
            Quadrant(
                title = stringResource(R.string.quadrant_4_title),
                body = stringResource(R.string.quadrant_4_body),
                modifier = Modifier
                    .weight(1F)
                    .background(Color(0xFFF6EDFF))
            )
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}