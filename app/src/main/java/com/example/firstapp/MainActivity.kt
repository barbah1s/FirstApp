package com.example.firstapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.border
import androidx.compose.ui.graphics.RectangleShape
import androidx.activity.ComponentActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    //1лаба
                    //ProfileCard()
                    //2лаба
                    TemperatureScreen()
                }
            }
        }
    }
}


@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Верхняя часть
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF6200EE)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "АИ",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "Developer",
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 12.dp)
            )

            Text(
                text = "Алексей Иванов",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 4.dp)
            )

            Text(
                text = "Android Developer",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 2.dp)
            )

            //Статистика
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Stat(number = "24", label = "Projects", Modifier.weight(1f))
                Stat(number = "8", label = "GitHub", Modifier.weight(1f))
                Stat(number = "15", label = "Apps", Modifier.weight(1f))
            }

            //Навыки
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .background(Color.Cyan, RoundedCornerShape(32.dp))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text("Kotlin", fontSize = 13.sp, fontWeight = FontWeight.Medium)
                    Text("Android", fontSize = 13.sp, fontWeight = FontWeight.Medium)
                    Text("Compose", fontSize = 13.sp, fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}

//Показатели
@Composable
fun Stat(
    number: String,
    label: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .border(
                width = 1.5.dp,
                color = Color.Gray,
                shape = RectangleShape
            )
            .padding(vertical = 12.dp, horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = number,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F5F5)
@Composable
fun ProfileCardPreview() {
    ProfileCard()
}

@Composable
fun TemperatureScreen() {

    // Текущая температура (начальное значение 22)
    var temperature by remember { mutableIntStateOf(22) }

    // Текст для Card в зависимости от температуры
    val statusText = when {
        temperature < 20 -> "Прохладная\nтемпература"
        temperature <= 25 -> "Комфортная\nтемпература"
        else -> "Жаркая\nтемпература"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Заголовок
        Text(
            text = "Температура",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.weight(1f))

        // Показ текущего значения
        Text(
            text = "$temperature °C",
            fontSize = 64.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(24.dp))

        // Кнопки «−» и «+»
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            Button(
                onClick = { if (temperature > 16) temperature-- },
                enabled = temperature > 16
            ) {
                Text("−", fontSize = 24.sp)
            }

            Button(
                onClick = { if (temperature < 30) temperature++ },
                enabled = temperature < 30
            ) {
                Text("+", fontSize = 24.sp)
            }
        }

        Spacer(Modifier.height(24.dp))

        // Card с описанием температуры
        Card(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = statusText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }

        Spacer(Modifier.weight(1f))
    }
}