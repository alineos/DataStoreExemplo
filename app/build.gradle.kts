import com.android.build.api.dsl.ViewBinding

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "ifsp.dmos5.datastoreexemplo"
    compileSdk = 34

    defaultConfig {
        applicationId = "ifsp.dmos5.datastoreexemplo"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding{
        enable = true
    }


}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    //   Dependencias Data Store
    implementation("androidx.datastore:datastore-preferences-android:1.1.1")
    implementation("androidx.datastore:datastore-core:1.1.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")

    //implementation("org.jetbrains.kotlinx:kotlin-coroutines-core:1.7.1")
    //implementation("org.jetbrains.kotlinx:kotlin-coroutines-android:1.7.1")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}