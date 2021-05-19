buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
        classpath("com.android.tools.build:gradle:7.1.0-alpha01")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.5.0")
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.0")
    }
}

group = "fr.abdel"
version = "1.0"

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
        maven(url = "https://kotlin.bintray.com/kotlin-js-wrappers/")
    }
}