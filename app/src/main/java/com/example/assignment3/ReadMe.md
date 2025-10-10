package com.example.assignment3

# 📱 **MenuPlus**

## 🥗 What the App Does
**MenuPlus** is a Jetpack Compose Android app that helps you **remember your favorite dishes** from restaurants.
You can log the restaurant name, dish, optional notes, and attach an image link (for example, from the restaurant’s website or a review site).
It then saves each entry into your personal history — making it easy to look back and recall what you loved, without forgetting the details.

The app focuses on simple food journaling, dietary tags (spicy, vegan, etc.), and lightweight image previewing — built entirely in **Kotlin with Material 3**.

---

## 🚀 How to Run It
1. **Clone or download** this project from GitHub.
2. **Open in Android Studio** (version Hedgehog or newer).
3. Ensure the **Emulator** runs API Level 33 or higher (Android 13+).
4. Click **Run ▶** to launch the app.
5. You’ll see the **bottom navigation bar** at the bottom of the screen:
- **Scan:** Add a new favorite dish
- **History:** Browse and manage your saved entries
- **About:** Learn what the app does

*(No external APIs required — all data is stored in memory for this prototype.)*

---

## ✨ Features List
✅ **Add & View Favorite Dishes** — Enter restaurant name, dish name, notes, and an image URL (with live preview).
✅ **Tag Selector** — Mark dishes with quick dietary tags like *spicy*, *vegan*, or *halal*.
✅ **History Management** — View all previous entries, delete unwanted ones, or tap to revisit details.
✅ **Detail Screen** — Displays large image and full details of any saved dish.
✅ **Polished About Screen** — Explains the app’s purpose and lightweight design philosophy.
✅ **Dynamic UI** — Modern Material 3 components with spacing, typography, and responsive layouts.
✅ **State Preservation** — Fields and history persist in session using a shared local repository.
✅ **Accessible Layout** — Touch-friendly chips, proper color contrast, and content descriptions.

---

## 🎨 Design Overview
The app uses a **shared Scaffold** and **bottom navigation bar** across all screens.
Colors are soft and minimal, designed for calm readability and food imagery.
Material 3 typography styles (`headlineSmall`, `titleMedium`, etc.) unify the visual hierarchy.

**Why URLs and not camera photos?**
This build focuses on simplicity and privacy — using restaurant image URLs prevents accidental personal photo storage and avoids image ownership concerns. Future versions could integrate a camera or gallery picker.

---

## 🧩 Project Structure
com.example.assignment3/
│
├── data/
│ └── LocalMenuRepo.kt
├── model/
│ └── MenuItem.kt
├── nav/
│ ├── Route.kt
│ └── AppNavHost.kt
├── ui/
│ ├── components/ (MenuItemCard, reusable UI pieces)
│ ├── screens/
│ │ ├── ScanScreen.kt
│ │ ├── DetailScreen.kt
│ │ ├── HistoryScreen.kt
│ │ └── AboutScreen.kt
│ └── theme/ (colors, typography, shapes)
└── MainActivity.kt

yaml
Copy code

---

## 🕒 Level of Effort (Final Actuals)

| Task | Description | Estimated (hrs) | Actual (hrs) | Notes |
|------|--------------|-----------------|---------------|-------|
| Project setup | Repo + Gradle + Android Studio + Git setup | 0.8 | 0.8 | Smooth setup |
| Navigation structure | Bottom nav + sealed routes | 1.2 | 1.0 | Minor tweaks only |
| Design system | Colors, typography, icons | 1.5 | 1.2 | Chose minimal palette |
| UI design pass | Built mock layouts for 4 screens | 1.2 | 1.0 | Reused components |
| **Scan screen** | Form inputs, image preview, validation | **1.4** | **2.0** | Took longer: field validation, Coil image preview, UX tuning |
| Preferences screen integration | Simplified — partially replaced by dietary tags | 1.0 | 0.5 | Integrated within Scan |
| Detail screen | Show most recent entry with image | 0.9 | 0.8 | Straightforward |
| History screen | List display, delete, tap-to-view | 1.2 | 1.2 | Matched design intent |
| About screen | Informational layout + visuals | 0.8 | 0.8 | Quick polish |
| Styling & polish | Spacing, typography, dark mode pass | 1.5 | 1.0 | Simplified |
| Testing & debugging | Emulator tests, navigation, rotation | 1.0 | 0.8 | Fixed small Coil bug |
| Documentation | README + WBS/LOE + Git screenshots | 1.1 | 0.7 | Written post-project |
| **Total** |  | **13.6h (est.)** | **10.8h (actual)** |  |

### 🧠 Reflection
The **Scan Screen** required the most effort due to field validation, Coil image behavior, and UX feedback improvements. Other screens were more straightforward, with navigation and repository state working smoothly after setup. The final implementation was slightly faster than estimated overall because prior assignments provided reusable patterns (especially for navigation and theming).

---

## 🧾 Credits & Notes
- Developed by **[Malik Al-Shourbaji]** for **Assignment 3 – Android Development (Fall 2025)**
- **Jetpack Compose** + **Material 3**
- Image loading handled with **Coil** (open-source library).
- Some UI and documentation structure inspired by Google’s Material3 guidelines and ChatGPT formatting assistance (<15% non-original). As well I fed my ideas into ai for this read me and it generated the entire file and I copy pasted. I also used it for documentation across the project.
