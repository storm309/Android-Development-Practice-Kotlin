# Android Development Practice (Kotlin & Jetpack Compose)

This repository contains a collection of Android UI components and layouts implemented using **Jetpack Compose**. It serves as a practical guide for learning modern Android development.

## 🚀 Features & Examples

The project includes the following implementations in `MainActivity.kt`:

### 1. MenuApp (Material 3)
- A complete screen with a `TopAppBar` and a `Scaffold`.
- Implementation of a **Dropdown Menu** (Settings, About, LogOut) triggered by a `MoreVert` icon.
- Dynamic UI updates based on menu selection.

### 2. Custom Rating Bar
- A fully functional rating system with **Half-Star** support.
- Built using `pointerInput` and `detectTapGestures` to detect precise touch positions.
- Custom star icons with fill fractions for visual accuracy.

### 3. Spinner / Dropdown Selector
- An `OutlinedTextField` used as a read-only selector.
- Customized `DropdownMenuItem`s using `Card` layouts and multiple background colors (**Red, Blue, Green, Yellow**).

### 4. Lazy Layouts & Grids
- **GridExample**: Displays subjects in a 2-column `LazyVerticalGrid` with elevated cards.
- **SimpleScrollExample**: Demonstrates basic vertical scrolling with `rememberScrollState`.
- **NestedScrollExample**: Shows a mix of `LazyColumn` (vertical) and `LazyRow` (horizontal) within a scrollable container.

## 🛠️ Tech Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Design System**: Material Design 3 (M3)
- **Architecture**: Modern Android Development (MAD) practices

## 📸 How to Run
1. Clone the repository.
2. Open the project in **Android Studio (Ladybug or later)**.
3. In `MainActivity.kt`, uncomment the component you want to see in the `setContent` block:
   ```kotlin
   setContent {
       CSE_UNIt1Theme {
           // Toggle between these:
           // SimpleScrollExample()
           // GridExample()
           // RatingApp()
           MenuApp() 
       }
   }
   ```
4. Run on an emulator or a physical device.

---
*Happy Coding!* ✌️
