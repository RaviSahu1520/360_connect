package com.company.app.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.app.data.ai.manager.ModelDownloadManager
import com.company.app.presentation.permissions.PermissionChecklistState
import com.company.app.presentation.permissions.PermissionType
import com.company.app.presentation.permissions.PermissionsManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val modelDownloadManager: ModelDownloadManager,
    private val permissionsManager: PermissionsManager
) : ViewModel() {

    val isReady: StateFlow<Boolean> = modelDownloadManager.state
        .stateIn(viewModelScope, SharingStarted.Eagerly, false)

    val permissionState: StateFlow<PermissionChecklistState> = permissionsManager.state
        .stateIn(viewModelScope, SharingStarted.Eagerly, PermissionChecklistState())

    fun downloadModels() {
        viewModelScope.launch {
            modelDownloadManager.ensureModelDownloaded("baseline-pack")
        }
    }

    fun onPermissionResult(type: PermissionType, granted: Boolean) {
        permissionsManager.mark(type, granted)
        permissionsManager.refresh()
    }
}
