package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController() //контроллер

            NavHost( //контейнер
                navController = navController,
                startDestination = "screen_1" //экран, который будет открыт по умолчанию
            ) {
                composable("screen_1"){ //запуск экрана
                    Screen1 {
                        navController.navigate("screen_2")
                    }
                }
                composable("screen_2"){//запуск экрана
                    Screen2 {
                        navController.navigate("screen_3")
                    }
                }
                composable("screen_3"){//запуск экрана
                    Screen3 {
                        navController.navigate("screen_1"){
                            popUpTo("screen_1"){//оставить в стеке screen_1, а остальные удалить (чтобы при нажатии на кнопку Назад вернуться сначала к screen_1, а потом выйти из приложения)
                                inclusive = true //убирает из стека screen_1, т.е. сразу при нажатии на кнопку Назад можно выйти из приложения
                            }
                        }
                    }
                }
            }

        }
    }
}


