# QuickBite 🍽️

A modern food discovery Android application built with Kotlin, MVVM architecture, and best practices.

## Features

- **Authentication**: Mock login with email/password validation
- **Home Screen**: Browse meal categories and featured meals with search functionality
- **Meal Detail**: View meal images, ingredients, instructions, and favorite meals
- **Favorites**: Save and manage favorite meals
- **Profile**: User information and logout

## Tech Stack

- **Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel)
- **DI**: Dagger 2
- **Networking**: Retrofit 2 + OkHttp
- **Reactive**: RxJava 3 + RxKotlin
- **Image Loading**: Glide
- **UI**: Material Design Components, ViewBinding, Navigation Component
- **Testing**: JUnit, Mockito, MockWebServer

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/quickbite/app/
│   │   │   ├── QuickBiteApp.kt              # Application class with Dagger
│   │   │   ├── data/
│   │   │   │   ├── models/                   # Data classes (Meal, Category, User)
│   │   │   │   ├── remote/                   # ApiService, ApiEndpoints
│   │   │   │   ├── repository/               # MealRepository
│   │   │   │   └── wrapper/                  # Resource sealed class
│   │   │   ├── di/                           # Dagger modules and components
│   │   │   ├── ui/
│   │   │   │   ├── login/                    # LoginActivity
│   │   │   │   ├── main/                     # MainActivity with BottomNavigation
│   │   │   │   ├── home/                     # HomeFragment + adapters
│   │   │   │   ├── detail/                   # MealDetailFragment
│   │   │   │   ├── favorites/                # FavoritesFragment
│   │   │   │   └── profile/                  # ProfileFragment
│   │   │   ├── viewmodels/                   # All ViewModels
│   │   │   └── components/                   # Reusable custom views
│   │   └── res/
│   │       ├── layout/                       # XML layouts
│   │       ├── drawable/                     # Drawable resources
│   │       ├── values/                       # Strings, colors, themes
│   │       ├── navigation/                   # Navigation graph
│   │       └── menu/                         # Bottom navigation menu
│   └── test/java/com/quickbite/app/
│       ├── viewmodels/                       # LoginViewModelTest, HomeViewModelTest
│       ├── repository/                       # MealRepositoryTest
│       └── remote/                           # ApiServiceTest
```

## Architecture Flow

```
View (Fragment/Activity)
    ↓ observes LiveData
ViewModel
    ↓ calls repository methods
Repository
    ↓ uses ApiService
Retrofit API (TheMealDB)
```

### State Handling

Every data request follows this pattern using the `Resource<T>` sealed class:

- **Loading**: Show loading indicator
- **Success**: Display data
- **Error**: Show error message with retry option
- **Empty**: Show empty state view

## Setup Instructions

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or later
- JDK 17
- Android SDK 34
- Gradle 8.4

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/darkzidedemigod/quickbite-android.git
   ```

2. Open the project in Android Studio:
   - File → Open → Select `quickbite-android` directory

3. Sync Gradle:
   - Wait for Gradle sync to complete
   - If prompted, install any missing SDK components

4. Run the app:
   - Select a device/emulator
   - Click Run ▶️

### Build from Command Line

```bash
# Clean build
./gradlew clean assembleDebug

# Build APK
./gradlew assembleDebug

# Build Release
./gradlew assembleRelease
```

## Dependencies

| Dependency | Version | Purpose |
|------------|---------|---------|
| Kotlin | 1.9.22 | Primary language |
| AGP | 8.2.0 | Android build tools |
| Retrofit | 2.11.0 | HTTP networking |
| Dagger | 2.50 | Dependency injection |
| RxJava 3 | 3.1.8 | Reactive programming |
| Glide | 4.16.0 | Image loading |
| Firebase BOM | 32.7.2 | Analytics (optional) |
| Material | 1.11.0 | Material Design |
| Navigation | 2.7.7 | Screen navigation |
| Lifecycle | 2.7.0 | ViewModel + LiveData |

## Testing

### Run Tests

```bash
# Run all unit tests
./gradlew test

# Run specific test class
./gradlew test --tests "com.quickbite.app.viewmodels.LoginViewModelTest"
```

### Test Coverage

- **LoginViewModelTest**: Email/password validation, login flow, error states
- **HomeViewModelTest**: Categories loading, search functionality, error handling
- **MealRepositoryTest**: API integration, favorites persistence, error mapping
- **ApiServiceTest**: JSON parsing, HTTP error codes, MockWebServer integration
- **FavoritesViewModelTest**: Favorites list management, empty states

## API Reference

This app uses [TheMealDB API](https://www.themealdb.com/api.php):

- `GET /categories.php` — Fetch all meal categories
- `GET /search.php?s={query}` — Search meals by name

## Login Credentials (Mock)

The app uses mock authentication:
- **Email**: Any valid email format (e.g., `user@example.com`)
- **Password**: Minimum 6 characters

## License

This project is for educational/demonstration purposes.