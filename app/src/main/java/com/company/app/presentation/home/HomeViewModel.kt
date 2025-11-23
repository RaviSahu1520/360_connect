package com.company.app.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.app.domain.model.Call
import com.company.app.domain.usecase.call.ObserveCallsUseCase
import com.company.app.presentation.permissions.PermissionChecklistState
import com.company.app.presentation.permissions.PermissionType
import com.company.app.presentation.permissions.PermissionsManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    observeCallsUseCase: ObserveCallsUseCase,
    private val permissionsManager: PermissionsManager
) : ViewModel() {

    val uiState: StateFlow<HomeUiState> = combine(
        observeCallsUseCase(),
        permissionsManager.state
    ) { calls, permissionState ->
        HomeUiState(calls = calls, permissionState = permissionState)
    }.stateIn(viewModelScope, SharingStarted.Eagerly, HomeUiState())

    fun refreshPermissions() {
        permissionsManager.refresh()
    }

    fun onPermissionRequested(type: PermissionType, granted: Boolean) {
        permissionsManager.mark(type, granted)
    }
}

data class HomeUiState(
    val calls: List<Call> = emptyList(),
    val permissionState: PermissionChecklistState = PermissionChecklistState()
)
