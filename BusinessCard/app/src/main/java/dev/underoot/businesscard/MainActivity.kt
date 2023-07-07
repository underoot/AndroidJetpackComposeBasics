package dev.underoot.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.underoot.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
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
fun GreetingPreview() {
    BusinessCardTheme {
        Greeting("Android")
    }
}

class SmartDevice {
    var speakerVolume: Int = 2
        get() = field
        set(value) {
            field = value
        }
}

@Preview(showBackground = true)
@Composable
fun Header(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 24.dp)
        ) {
            Image(
                painter = image,
                contentDescription = stringResource(R.string.android_logo),
                modifier
                    .background(Color.Black)
                    .width(250.dp)
                    .height(250.dp)
            )
        }
        Text(
            text = stringResource(R.string.name),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(R.string.title),
            color = Color.Black,
            fontSize = 18.sp,
        )
    }
}

@Composable
fun ContactInformationRow(
    modifier: Modifier = Modifier,
    text: String,
    icon: @Composable BoxScope.() -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(bottom = 8.dp)
    ) {
        Box(modifier = Modifier.padding(end = 8.dp)) {
            icon(this)
        }
        Text(
            text = text,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactInformation(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
    ) {
        Column {
            ContactInformationRow(
                text = "+372 5667 1227",
            ) {
                Icon(
                    Icons.Filled.Phone,
                    contentDescription = "Phone",
                    tint = Color.Black
                )
            }
            ContactInformationRow(
                text = "@underoot"
            ) {
                Icon(
                    Icons.Filled.Share,
                    contentDescription = "Twitter",
                    tint = Color.Black
                )
            }
            ContactInformationRow(
                text = "alex.shoronov@gmail.com"
            ) {
                Icon(
                    Icons.Filled.Email,
                    contentDescription = "Email",
                    tint = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)
        ) {
            Header()
        }
        Row() {
            ContactInformation()
        }
    }
}