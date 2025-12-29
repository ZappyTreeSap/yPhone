package com.example.yphone

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences

class ScreenUnlockReceiver : BroadcastReceiver() {

    companion object {
        private const val PREFS_NAME = "yphone_prefs"
        private const val LAST_PROMPT_TIME = "last_prompt_time"
        private const val MIN_PROMPT_INTERVAL = 60000 // 1 minute minimum between prompts
    }

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            Intent.ACTION_USER_PRESENT -> {
                // User unlocked the device - this is the most reliable signal
                if (shouldShowPrompt(context)) {
                    launchMindfulnessPrompt(context)
                }
            }
            Intent.ACTION_BOOT_COMPLETED -> {
                // Device booted, receiver is now active
                // Reset the last prompt time so next unlock will show prompt
                resetPromptTime(context)
            }
        }
    }

    private fun shouldShowPrompt(context: Context): Boolean {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val lastPromptTime = prefs.getLong(LAST_PROMPT_TIME, 0)
        val currentTime = System.currentTimeMillis()

        return (currentTime - lastPromptTime) > MIN_PROMPT_INTERVAL
    }

    private fun updateLastPromptTime(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putLong(LAST_PROMPT_TIME, System.currentTimeMillis()).apply()
    }

    private fun resetPromptTime(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putLong(LAST_PROMPT_TIME, 0).apply()
    }

    private fun launchMindfulnessPrompt(context: Context) {
        updateLastPromptTime(context)

        val launchIntent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
            putExtra("from_unlock", true)
        }

        try {
            context.startActivity(launchIntent)
        } catch (e: Exception) {
            // Handle any potential security exceptions
            e.printStackTrace()
        }
    }
}