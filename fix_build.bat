@echo off
echo Fixing Android build issues...

echo Step 1: Killing processes...
taskkill /f /im java.exe >nul 2>&1
taskkill /f /im gradle* >nul 2>&1

echo Step 2: Cleaning build directories...
if exist "app\build" rmdir /s /q "app\build"
if exist ".gradle" rmdir /s /q ".gradle"
if exist "build" rmdir /s /q "build"

echo Step 3: Cleaning Gradle cache...
if exist "%USERPROFILE%\.gradle\caches" rmdir /s /q "%USERPROFILE%\.gradle\caches"

echo Step 4: Attempting build...
call gradlew.bat clean --no-daemon
call gradlew.bat assembleDebug --no-daemon

echo Build process completed!
echo If successful, your APK will be in: app\build\outputs\apk\debug\
pause