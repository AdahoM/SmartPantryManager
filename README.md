SmartPantryManager
Student Name: Adaho Mulidzi
Student ITS No:402306956
Qualification: BSc IT Year 3 Semester 2
Module: Mobile App Development 700
Submission Date: 23 October 2026
Package Name: com.example.smartpantrymanager
Project Description
SmartPantryManager is an Android mobile app that solves food waste from forgotten expiry dates. Users can track pantry items with expiry in days and get alerts when items expire within 7 days. The app also suggests recipes like Fried Rice based on available items.
Features Implemented
-Add Food: Add item name, quantity, unit, expiry (int days)
-Pantry List: Display all items in Recycler View from SQLite
-Messages Activity: Core feature - Shows alert "Milk expires in 2 days!" when expiry <= 7
-Suggested Recipes: Fried Rice recipe strict-matching using Rice, Eggs, Oil
-Edit / Delete: Update and remove items
-Settings: Additional screen
-SQLite Database: Table pantry items (id, name, quantity, unit, expiry)
Tech Stack
Android Studio
Java
SQLite (DatabaseHelper.java)
RecyclerView, Intents
Emulator: Small Phone API 28 "Pie" Android 9.0 - Google Play Intel x86 Atom System Image
Screenshots
Figure 0: AVD Configuration - Small Phone API 28
Figure 1: Install Success - 47s on Small_Phone API 28
Figure 2: Pantry List Activity - Shows Eggs 25 days
Figure 3: MessagesActivity - Shows Oil/Milk expiry alert 2 days
Figure 4: SuggestedRecipesActivity - Fried Rice
How to Run / Install APK
Open Android Studio -> Open project SmartPantryManager
Create AVD: Small Phone, API 28, Google Play Intel x86 Image
Run -> Select Small Phone emulator
Or install APK: app/build/outputs/apk/debug/app-debug.apk on device
Project Structure
