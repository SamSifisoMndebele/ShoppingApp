plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.google.firebase.crashlytics)
}

android {
    namespace = "com.clothing.unclecity"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.clothing.unclecity"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project.dependencies.platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.storage)
    implementation(libs.firebase.auth)

    implementation(libs.lottie)
    implementation(libs.glide)
    annotationProcessor(libs.glide.compiler)
    implementation(libs.kotlinx.coroutines.play.services)

    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xskip-prerelease-check")
        freeCompilerArgs.add("-Xreturn-value-checker=full")
        freeCompilerArgs.add("-Xexplicit-backing-fields")
        freeCompilerArgs.add("-XXLanguage:+PropertyParamAnnotationDefaultTargetMode")
    }
}

//agcp {
//    manifest = false
//}
//
//// Disable AGC plugin tasks for variants where it's unnecessary or causes errors
//tasks.configureEach {
//    if (name.startsWith("process") && name.endsWith("AGCPlugin")) {
//        if (name.contains("Google", ignoreCase = true) || name.contains("Debug", ignoreCase = true)) {
//            enabled = false
//        }
//    }
//
//    if (name.startsWith("extract") && name.endsWith("SupportedLocales")) {
//        val variantName = name.removePrefix("extract").removeSuffix("SupportedLocales")
//        dependsOn("process${variantName}AGCPlugin")
//    }
//}
