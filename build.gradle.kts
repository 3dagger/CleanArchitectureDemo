// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.Essential.AndroidGradleVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Essential.KotlinGradleVersion}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.Jetpack.HiltVersion}")
        classpath("de.mannodermaus.gradle.plugins:android-junit5:${Versions.Essential.JUnitGradleVersion}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}