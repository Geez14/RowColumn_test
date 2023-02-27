package com.example.row_col

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.row_col.ui.theme.Row_colTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row_colTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    UITEST()
                }
            }
        }
    }
}


@Composable
private fun UITEST()
{
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            Content(stringResource(R.string.firstTitle), stringResource(R.string.firstContent), Color.Green, Modifier.weight(1f))
            Content(stringResource(R.string.secondTitle), stringResource(R.string.secondContent), Color.Yellow, Modifier.weight(1f))
        }
        Row(modifier = Modifier.weight(1f)) {
            Content(stringResource(R.string.thirdTitle), stringResource(R.string.thirdContent), Color.Cyan, Modifier.weight(1f))
            Content(stringResource(R.string.fourthTitle), stringResource(R.string.fourthContent), Color.LightGray, Modifier.weight(1f))
        }
    }
}

@Composable
private fun Content(Head:String, Body:String, color: Color, modifier : Modifier = Modifier)
{
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
       Text( text = Head,
           Modifier.padding(16.dp),
           fontWeight = FontWeight.W900,
           color = Color.Black
       )

       Text(text = Body,
           modifier = Modifier
               .align(Alignment.CenterHorizontally)
               .wrapContentWidth(Alignment.Start),
           color = Color.Black
       )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Row_colTheme {
        UITEST()
    }
}