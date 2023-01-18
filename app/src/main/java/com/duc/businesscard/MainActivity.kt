package com.duc.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duc.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        DuckImage(getString(R.string.name), getString(R.string.title))
                        Spacer(modifier = Modifier.size(250.dp))
                        Box(
                            modifier = Modifier
                                .height(5.dp)
                                .width(500.dp)
                                .background(Color(0xFFff0066))
                        )
                        Credentials(
                            githubtxt = getString(R.string.github_account),
                            mailtxt = getString(R.string.mail_adress)
                        )
                    }
            }
        }
    }
}

@Composable
fun DuckImage(name: String, title: String) {
    val image = painterResource(R.drawable.duck)
    Column() {
        Image(
            painter = image,
            contentDescription = "Duck",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = name,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp),
            color = Color(0xFFff0066)
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(start = 36.dp),
            color = Color(0xFFff0066)
        )
    }
}

@Composable
fun GitHub(githubtxt: String) {
    val github = painterResource(R.drawable.github)
    Row() {
        Image(
            painter = github,
            contentDescription = "GitHub Logo",
            modifier = Modifier
                .padding(start = 24.dp, top = 10.dp)
                .size(size = 60.dp)
        )
        Text(
            text = githubtxt,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(start = 36.dp, top = 30.dp),
            color = Color.Black
        )
    }
}

@Composable
fun Mail(mailtxt: String) {
    val mail = painterResource(R.drawable.mail)
    Row {
        Image(
            painter = mail,
            contentDescription = "Mail Symbol",
            modifier = Modifier
                .padding(start = 24.dp, top = 20.dp)
                .size(size = 60.dp)
        )
        Text(
            text = mailtxt,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(start = 36.dp, top = 35.dp),
            color = Color.Black
        )
    }
}

@Composable
fun Credentials(githubtxt: String, mailtxt: String) {
    Box() {
        Box(modifier = Modifier
            .height(300.dp)
            .width(500.dp)
            .background(Color.Yellow))
        Column() {
            GitHub(githubtxt = githubtxt)
            Mail(mailtxt = mailtxt)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun BusinessPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column {
                DuckImage("Name test", "Title test")
                Spacer(modifier = Modifier.size(250.dp))
                    Box(
                        modifier = Modifier
                            .height(5.dp)
                            .width(500.dp)
                            .background(Color(0xFFff0066))
                    )
                    Credentials(
                        githubtxt = "@GitHub test",
                        mailtxt = "mailtext test"
                    )
                }
            }
        }
    }
}