plugins {
    alias(libs.plugins.agp.app)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.ksp)
}

android {
    compileSdk = 34

    defaultConfig {
        applicationId = "moe.chenxy.miuiextra"
        minSdk = 31
        targetSdk = 34
        versionCode = 18
        versionName = "2.6.9.4-U-HyperOS"
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            multiDexEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    dependenciesInfo.includeInApk = false

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = listOf(
            "-Xno-param-assertions",
            "-Xno-call-assertions",
            "-Xno-receiver-assertions"
        )
    }

    namespace = "moe.chenxy.miuiextra"

    buildFeatures {
        buildConfig = true
    }

    lint {
        abortOnError = true
        checkReleaseBuilds = false
    }
}

configurations.configureEach {
    exclude(group = "androidx.appcompat", module = "appcompat")
    exclude(group = "androidx.lifecycle", module = "lifecycle-viewmodel-ktx")
}

dependencies {
    implementation(libs.coordinatorlayout)
    implementation(libs.coreKtx)
    implementation(libs.material)
    implementation(libs.preferenceKtx)
    implementation(libs.rikkaxAppcompat)
    implementation(libs.rikkaxCore)
    implementation(libs.rikkaxInsets)
    implementation(libs.rikkaxMaterial)
    implementation(libs.rikkaxMaterialPreference)
    implementation(libs.rikkaxSimplemenuPreference)
    implementation(libs.rikkaxRecyclerviewKtx)
    implementation(libs.rikkaxBorderview)
    implementation(libs.rikkaxMainswitchbar)
    implementation(libs.rikkaxLayoutinflater)
    compileOnly(libs.xposedApi)
    implementation(libs.yukihookApi)
    ksp(libs.yukihookKsp)
}