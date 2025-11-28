package com.company.app.platform.accessibility

import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.widget.Toast

fun Context.openAccessibilitySettings() {
    try {
        // Most Android devices (Pixel, Samsung, OnePlus)
        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        return
    } catch (_: Exception) {
    }

    try {
        // Some OEMs require this alternative settings route
        val intent = Intent(Settings.ACTION_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        return
    } catch (_: Exception) {
    }

    Toast.makeText(this, "Unable to open Accessibility Settings", Toast.LENGTH_LONG).show()
}

fun Context.openAccessibilityServiceSettings() {
    val manufacturer = Build.MANUFACTURER.lowercase()

    try {
        when {
            manufacturer.contains("samsung") -> {
                // Samsung often uses standard intent
                startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                })
            }

            manufacturer.contains("xiaomi") -> {
                // Xiaomi/Redmi often blocks the normal intent
                startActivity(Intent("com.android.settings.ACCESSIBILITY_SETTINGS").apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                })
            }

            manufacturer.contains("oneplus") -> {
                startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                })
            }

            manufacturer.contains("vivo") || manufacturer.contains("oppo") -> {
                // ColorOS / FuntouchOS
                startActivity(Intent(Settings.ACTION_SETTINGS).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                })
            }

            else -> {
                // Default fallback
                startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                })
            }
        }
    } catch (_: Exception) {
        // Final fallback
        startActivity(Intent(Settings.ACTION_SETTINGS).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        })
    }
}

/**
 * Ordered list of intents to try when launching Accessibility settings with ActivityResult APIs.
 * Keeps OEM-specific priorities without forcing a new task so the result can be observed.
 */
fun Context.accessibilitySettingsIntents(): List<Intent> {
    val manufacturer = Build.MANUFACTURER.lowercase()
    val intents = mutableListOf<Intent>()

    when {
        manufacturer.contains("xiaomi") -> {
            intents += Intent("com.android.settings.ACCESSIBILITY_SETTINGS")
            intents += Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        }

        manufacturer.contains("vivo") || manufacturer.contains("oppo") -> {
            intents += Intent(Settings.ACTION_SETTINGS)
            intents += Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        }

        else -> {
            intents += Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        }
    }

    intents += Intent(Settings.ACTION_SETTINGS)
    return intents
}
