package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                /* Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}


@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
        .padding(horizontal = 8.dp)
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(modifier)
        Spacer(modifier = Modifier.height(50.dp))
        CardBody(modifier)
        Spacer(modifier = Modifier.height(30.dp))
        CardFooter()
    }
}


@Composable
fun Card(modifier: Modifier = Modifier){
    Surface(
        modifier = modifier
            .fillMaxSize(),
            shape = RoundedCornerShape(8.dp), // To match the border's shape
            color = Color.White,              // Background color of the surface
            shadowElevation = 8.dp
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "1",
            modifier
                .fillMaxWidth()
                .padding(24.dp)
                .height(250.dp)
        )
    }
}

@Composable
fun CardBody(modifier : Modifier = Modifier){
    Text(
        "Sailing under the bridge",
        style = MaterialTheme.typography.displaySmall
    )
    Row {
        Text(
            "Kat Kuan",
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            ("2017"),

        )
    }
}

@Composable
fun CardFooter(modifier : Modifier = Modifier){
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button( onClick = { println("Previous")}, modifier = Modifier.widthIn(min = 150.dp).padding(8.dp)) {
            Text(text = "Previous")
        }
        Button( onClick = { println("Next")}, modifier = Modifier.widthIn(min = 150.dp).padding(8.dp)) {
            Text(text = "Next")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceLayout()
    }
}