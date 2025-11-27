plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.example.rollit"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.rollit"
        minSdk = 33
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures{
        compose = true
    }



    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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
        // BOM مدیریت نسخه
        implementation(platform("androidx.compose:compose-bom:2024.10.00"))

        // Compose UI
        implementation("androidx.compose.ui:ui")

        // Material 3
        implementation("androidx.compose.material3:material3")

        // ابزارهای طراحی (Preview)
        implementation("androidx.compose.ui:ui-tooling-preview")
        debugImplementation("androidx.compose.ui:ui-tooling")

        // فعالیت سازگار با Compose
        implementation("androidx.activity:activity-compose:1.9.3")

        // Navigation Compose (در صورت نیاز)
        implementation("androidx.navigation:navigation-compose:2.8.2")

        // ViewModel برای Compose
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")

        // LiveData → Compose (اختیاری)
        implementation("androidx.compose.runtime:runtime-livedata")

        // Coil برای لود عکس در Compose (در صورت نیاز)
        implementation("io.coil-kt:coil-compose:2.7.0")


    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}