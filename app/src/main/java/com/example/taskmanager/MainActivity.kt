package com.example.taskmanager

import android.app.ActivityManager.TaskDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskDescription(getString(R.string.all_tasks_completed),
                        getString(R.string.nice_work) )
                }
            }
        }
    }
}

@Composable
fun TaskDescription(head: String,description:String, modifier: Modifier = Modifier) {
    Column (modifier=Modifier.fillMaxSize(),
verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Image(painter = painterResource(id = R.drawable.ic_task_completed),contentScale = ContentScale.Crop, contentDescription ="" )
        Text(
            text = head,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(top = 24 .dp, bottom = 8 .dp)
        )
        Text(
            text = description,
            modifier = modifier
        )
    }

}

@Preview(showBackground = true )
@Composable
fun GreetingPreview() {
    TaskDescription("All tasks completed","Nice work!" )
}