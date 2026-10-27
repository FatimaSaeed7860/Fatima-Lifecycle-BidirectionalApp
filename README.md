# Activity Lifecycle & Bidirectional Intent App

**Student:** Fatima Saeed  
**Platform:** Android  
**Language:** Java  
**UI:** XML layouts

## Overview
This Android learning project demonstrates two concepts:

1. **Activity Lifecycle:** Both activities log lifecycle callbacks such as `onCreate()`, `onStart()`, `onResume()`, `onPause()`, `onStop()`, `onRestart()`, and `onDestroy()` to Logcat.
2. **Bidirectional Intent Communication:** Screen 1 sends a message to Screen 2 using an explicit Intent. Screen 2 returns a reply to Screen 1 using an activity result.

## App flow
1. Enter a message on Screen 1.
2. Tap **Send to Screen 2**.
3. Screen 2 displays the received message.
4. Enter a reply and tap **Send Reply**.
5. Screen 1 displays the returned reply.

## Project structure
```text
FatimaLifecycleBidirectionalApp/
├── app/
│   ├── build.gradle
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/fatimasaeed/lifecyclebidirectionalapp/
│       │   ├── MainActivity.java
│       │   └── ReplyActivity.java
│       └── res/layout/
│           ├── activity_main.xml
│           └── activity_reply.xml
├── build.gradle
├── gradle.properties
└── settings.gradle
```

## How to run
Open the project in Android Studio, allow Gradle to sync, then run the app on an emulator or Android device.

To view lifecycle logs, open **Logcat** and filter by `LifecycleMain` or `LifecycleReply`.

## Learning outcomes
- Understand common Android Activity lifecycle callbacks.
- Send data between activities using Intent extras.
- Return data from a second activity to the first activity.
- Read lifecycle messages in Logcat.

## Note
This is a starter project. It has not been built or tested in Android Studio in this environment. Use it as a learning base and verify it in Android Studio before submission.
