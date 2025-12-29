# yPhone - Mindful Phone Usage App

A mindful Android app that encourages conscious phone usage by asking a simple question every time
you unlock your device.

## What it does

When you unlock your phone, yPhone automatically launches and asks:

**"Why did you open your phone?"**

You have two choices:

- **"For a reason"** - The app wishes you good luck and closes
- **"For no reason"** - The app suggests you put your phone down and do something meaningful instead

## Features

- ✨ **Automatic launch** - Opens every time you unlock your phone
- 🤔 **Mindful reflection** - Encourages you to think before using your phone
- 🎯 **Simple choices** - Just two options to choose from
- ⏱️ **Smart timing** - Won't spam you (minimum 1 minute between prompts)
- 🎨 **Beautiful UI** - Modern Material Design interface
- 🔄 **Auto-close** - Closes automatically after 5 seconds

## How it works

1. **Screen Unlock Detection**: Uses Android's `USER_PRESENT` broadcast to detect when the device is
   unlocked
2. **Mindful Prompt**: Shows a simple question with two answer choices
3. **Thoughtful Response**: Provides appropriate feedback based on your choice
4. **Smart Cooldown**: Prevents spam by waiting at least 1 minute between prompts

## Installation

1. Open the project in Android Studio
2. Build and install on your Android device (requires Android 8.0+ / API 26+)
3. Grant any requested permissions
4. The app will automatically start working when you unlock your phone

## Permissions

The app requires these permissions:

- `RECEIVE_BOOT_COMPLETED` - To start the unlock detection after device reboot
- `WAKE_LOCK` - To ensure the prompt shows reliably
- `DISABLE_KEYGUARD` - To show the prompt over the lock screen
- `SYSTEM_ALERT_WINDOW` - To display the app when unlocking

## Technical Details

- **Built with**: Kotlin + Jetpack Compose
- **Minimum SDK**: Android 8.0 (API 26)
- **Target SDK**: Android 14 (API 36)
- **Architecture**: Simple Activity-based with Compose UI

## Customization

You can easily customize:

- The minimum time between prompts (currently 1 minute)
- The question text and responses
- The UI colors and styling
- The auto-close timer (currently 5 seconds)

## Privacy

This app:

- ✅ Works completely offline
- ✅ Stores only the last prompt timestamp locally
- ✅ No data collection or analytics
- ✅ No network permissions
- ✅ Open source - you can verify the code

---

*Made with ❤️ to encourage mindful phone usage*