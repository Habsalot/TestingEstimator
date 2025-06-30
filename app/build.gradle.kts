plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.testingestimator"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.testingestimator"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // AndroidX core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Compose BOM
    implementation(platform(libs.androidx.compose.bom))

    // Core Compose UI (layouts, drawing, etc.)
    implementation("androidx.compose.ui:ui")

    // Text input APIs (KeyboardOptions, KeyboardType, etc.)
    implementation("androidx.compose.ui:ui-text")

    // Foundation (basic building blocks)
    implementation("androidx.compose.foundation:foundation:1.7.0")

    // UI preview support
    implementation("androidx.compose.ui:ui-tooling-preview")

    // Material3 components
    implementation("androidx.compose.material3:material3")

    // Activity + Compose integration
    implementation("androidx.activity:activity-compose:1.8.0")

    // Debug-only tooling (for @Preview)
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Your existing test deps:
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

