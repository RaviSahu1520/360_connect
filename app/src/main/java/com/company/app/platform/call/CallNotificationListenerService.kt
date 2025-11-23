package com.company.app.platform.call

import android.service.notification.NotificationListenerService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CallNotificationListenerService : NotificationListenerService() {
    override fun onListenerConnected() {
        super.onListenerConnected()
        // Connectivity only used to surface notification listener permission status.
    }
}
