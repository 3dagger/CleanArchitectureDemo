plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("de.mannodermaus.android-junit5")
    id("dagger.hilt.android.plugin")
//    jacoco
}

android {
    compileSdk = ConfigData.CompileSdkVersion

    defaultConfig {
        applicationId = "kr.dagger.cleanarchitecturedemoapplication"
        minSdk = ConfigData.MinSdkVersion
        targetSdk = ConfigData.TargetSdkVersion
        versionCode = ConfigData.VersionCode
        versionName = ConfigData.VersionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro") 
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(project(ProjectConstants.Domain))
    implementation(project(ProjectConstants.Data))

    implementation(Dependencies.AndroidSupport.CoreKtx)
    implementation(Dependencies.AndroidSupport.AppCompat)
    implementation(Dependencies.AndroidSupport.Material)
    implementation(Dependencies.AndroidSupport.ConstraintLayout)
    implementation(Dependencies.AndroidSupport.CardView)
    implementation(Dependencies.AndroidSupport.ViewPager2)
    implementation(Dependencies.AndroidSupport.RecyclerView)

    implementation(Dependencies.AndroidSupport.LifeCycle.ViewModelKtx)
    implementation(Dependencies.AndroidSupport.LifeCycle.LiveDataKtx)
    implementation(Dependencies.AndroidSupport.LifeCycle.Runtime)


    implementation("androidx.activity:activity-ktx:1.5.1")


    implementation(Dependencies.Coroutines.Core)
    implementation(Dependencies.Coroutines.Android)
    implementation(Dependencies.Kotlin.StdLib)

    implementation(Dependencies.Hilt.Android)
    kapt(Dependencies.Hilt.Compiler)



    implementation(Dependencies.Okhttp.OkHttp)
    implementation(Dependencies.Okhttp.LoggingInterceptor)
    implementation(Dependencies.Retrofit.Retrofit)
    implementation(Dependencies.Retrofit.GsonConverter)



    implementation(Dependencies.Glide.Glide)
    kapt(Dependencies.Glide.Compiler)
}