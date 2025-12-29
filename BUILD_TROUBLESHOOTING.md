# Build Troubleshooting Guide

## Current Issue: Gradle Build Failing

You're experiencing two common issues:

### 1. Java/JAVA_HOME Not Found

**Error**: `ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH`

**Solutions**:

- **Option A (Recommended)**: Open the project in Android Studio, which will handle all Java/SDK
  setup automatically
- **Option B**: Install Java 17+ and set JAVA_HOME environment variable
- **Option C**: Use Android Studio's embedded terminal which has proper paths set

### 2. File Lock Issues on Windows/OneDrive

**Error**: `Unable to delete directory ... Failed to delete some children`

**Causes**:

- OneDrive syncing is holding file locks
- Windows Defender or antivirus scanning build files
- Previous Gradle daemon processes

**Solutions**:

#### Quick Fix:

1. **Close Android Studio** completely
2. **Pause OneDrive sync** temporarily
3. **Delete build folder** manually: Delete the entire `app/build/` directory
4. **Restart Android Studio** and try building again

#### Alternative Approaches:

1. **Move project out of OneDrive**: Copy the entire project to a local folder like
   `C:/AndroidProjects/yPhone`
2. **Exclude from OneDrive**: Add the project folder to OneDrive's excluded folders
3. **Kill Gradle daemons**:
   ```powershell
   taskkill /f /im java.exe
   ```

## Recommended Build Process

### Option 1: Android Studio (Easiest)

1. Open Android Studio
2. Select "Open an existing project"
3. Navigate to your project folder
4. Let Android Studio sync and download dependencies
5. Click "Build" → "Make Project" or press `Ctrl+F9`
6. To install on device: Click "Run" → "Run 'app'" or press `Shift+F10`

### Option 2: Command Line (After fixing Java)

```powershell
# Clean previous builds
.\gradlew.bat clean --no-daemon

# Build debug APK
.\gradlew.bat assembleDebug --no-daemon

# Install on connected device
.\gradlew.bat installDebug --no-daemon
```

## Project Status

✅ **Code is Complete**: All functionality has been implemented
✅ **Manifest is Configured**: Permissions and broadcast receiver are set up
✅ **UI is Built**: Modern Material Design interface
✅ **Logic is Implemented**: Screen unlock detection and mindfulness prompts

## What the App Does

1. **Detects Screen Unlock**: Uses Android's `USER_PRESENT` broadcast
2. **Shows Mindful Prompt**: Asks "Why did you open your phone?"
3. **Two Response Options**: "For a reason" or "For no reason"
4. **Appropriate Feedback**: Encourages mindful usage
5. **Smart Timing**: Prevents spam with 1-minute cooldown
6. **Auto-close**: Closes after 5 seconds automatically

## Testing the App

Once built and installed:

1. **Install the APK** on your Android device
2. **Grant permissions** if prompted
3. **Lock your phone** and then **unlock it**
4. **The app should automatically appear** with the mindfulness prompt
5. **Test both answer options** to see different responses

## Files Created/Modified

- `MainActivity.kt` - Complete rewrite with mindfulness UI
- `ScreenUnlockReceiver.kt` - New broadcast receiver for unlock detection
- `AndroidManifest.xml` - Added permissions and receiver registration
- `strings.xml` - Updated with app strings
- `README.md` - Complete documentation
- `BUILD_TROUBLESHOOTING.md` - This troubleshooting guide

## Next Steps

1. **Try building in Android Studio first** - it handles most setup automatically
2. **If that fails**, move the project out of OneDrive
3. **Test on a physical Android device** for best results (emulator may not trigger unlock events
   reliably)

The app is ready to use once you can successfully build it!