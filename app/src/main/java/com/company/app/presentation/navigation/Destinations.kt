package com.company.app.presentation.navigation

sealed class ScreenDestination(val route: String) {
    data object Home : ScreenDestination("home")
    data object Chat : ScreenDestination("chat/{chatId}") {
        fun create(chatId: String) = "chat/${'$'}chatId"
    }
    data object Call : ScreenDestination("call")
    data object Settings : ScreenDestination("settings")
    data object History : ScreenDestination("history")
    data object CallDetail : ScreenDestination("history/detail/{callId}") {
        fun create(callId: Long) = "history/detail/${'$'}callId"
    }
    data object AskAi : ScreenDestination("ask_ai")
}
