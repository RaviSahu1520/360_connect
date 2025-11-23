package com.company.app.presentation.permissions

enum class PermissionType { MICROPHONE, ACCESSIBILITY, OVERLAY, NOTIFICATION_LISTENER, MEDIA_PROJECTION }

sealed class PermissionStatus {
    data object Granted : PermissionStatus()
    data object Denied : PermissionStatus()
    data object NeedsRationale : PermissionStatus()
}

data class PermissionChecklistState(
    val items: Map<PermissionType, PermissionStatus> = emptyMap()
) {
    val allGranted: Boolean get() = items.values.all { it is PermissionStatus.Granted }
}
