// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    }
}//
plugins {
    id("com.android.application") version "8.1.2" apply false
    id ("com.android.library") version "7.4.2" apply false
    id("org.jetbrains.kotlin.android") version "1.7.0" apply false
    id("com.google.dagger.hilt.android") version "2.43.2" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.10"
}

