package com.company.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.company.app.presentation.call.CallScreen
import com.company.app.presentation.call.CallViewModel
import com.company.app.presentation.chat.ChatScreen
import com.company.app.presentation.chat.ChatViewModel
import com.company.app.presentation.history.CallDetailScreen
import com.company.app.presentation.history.CallDetailViewModel
import com.company.app.presentation.history.CallHistoryScreen
import com.company.app.presentation.history.CallHistoryViewModel
import com.company.app.presentation.home.HomeScreen
import com.company.app.presentation.home.HomeViewModel
import com.company.app.presentation.permissions.PermissionType
import com.company.app.presentation.settings.SettingsScreen
import com.company.app.presentation.settings.SettingsViewModel
import com.company.app.presentation.ai.AskAiScreen
import com.company.app.presentation.ai.AskAiViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    onPermissionAction: (PermissionType, (Boolean) -> Unit) -> Unit
) {
    NavHost(navController = navController, startDestination = ScreenDestination.Home.route) {
        composable(ScreenDestination.Home.route) {
            val viewModel: HomeViewModel = hiltViewModel()
            val state by viewModel.uiState.collectAsStateWithLifecycle()
            HomeScreen(
                state = state,
                onStartChat = { navController.navigate(ScreenDestination.Chat.create("general")) },
                onStartCall = { navController.navigate(ScreenDestination.Call.route) },
                onOpenHistory = { navController.navigate(ScreenDestination.History.route) },
                onAskAi = { navController.navigate(ScreenDestination.AskAi.route) },
                onPermissionAction = { type ->
                    onPermissionAction(type) { granted ->
                        viewModel.onPermissionRequested(type, granted)
                        viewModel.refreshPermissions()
                    }
                }
            )
        }
        composable(
            route = ScreenDestination.Chat.route,
            arguments = listOf(navArgument("chatId") {
                defaultValue = "general"
                type = androidx.navigation.NavType.StringType
            })
        ) {
            val viewModel: ChatViewModel = hiltViewModel()
            val state by viewModel.uiState.collectAsStateWithLifecycle()
            ChatScreen(
                state = state,
                onMessageChanged = viewModel::onMessageChanged,
                onSend = viewModel::onSendClicked
            )
        }
        composable(ScreenDestination.Call.route) {
            val viewModel: CallViewModel = hiltViewModel()
            val state by viewModel.uiState.collectAsStateWithLifecycle()
            CallScreen(
                state = state,
                onStartCall = viewModel::startCall,
                onEndCall = viewModel::endCall,
                onToggleMute = viewModel::toggleMute,
                onTranscribe = viewModel::transcribe,
                onQueryRag = viewModel::queryRag
            )
        }
        composable(ScreenDestination.History.route) {
            val viewModel: CallHistoryViewModel = hiltViewModel()
            val state by viewModel.uiState.collectAsStateWithLifecycle()
            CallHistoryScreen(
                state = state,
                onSelectCall = { id -> navController.navigate(ScreenDestination.CallDetail.create(id)) }
            )
        }
        composable(
            route = ScreenDestination.CallDetail.route,
            arguments = listOf(navArgument("callId") { type = NavType.LongType })
        ) { backStackEntry ->
            val callId = backStackEntry.arguments?.getLong("callId") ?: return@composable
            val viewModel: CallDetailViewModel = hiltViewModel()
            val state by viewModel.uiState.collectAsStateWithLifecycle()
            CallDetailScreen(
                callId = callId,
                state = state,
                onLoad = viewModel::load,
                onAsk = { query -> viewModel.askAiAboutCall(callId, query) }
            )
        }
        composable(ScreenDestination.AskAi.route) {
            val viewModel: AskAiViewModel = hiltViewModel()
            val state by viewModel.uiState.collectAsStateWithLifecycle()
            AskAiScreen(
                state = state,
                onQueryChange = viewModel::onQueryChange,
                onSubmit = viewModel::submitQuery
            )
        }
        composable(ScreenDestination.Settings.route) {
            val viewModel: SettingsViewModel = hiltViewModel()
            val ready by viewModel.isReady.collectAsStateWithLifecycle()
            val permissionState by viewModel.permissionState.collectAsStateWithLifecycle()
            SettingsScreen(
                isReady = ready,
                permissionState = permissionState,
                onDownloadModels = viewModel::downloadModels,
                onRequestPermission = { type ->
                    onPermissionAction(type) { granted ->
                        viewModel.onPermissionResult(type, granted)
                    }
                }
            )
        }
    }
}
