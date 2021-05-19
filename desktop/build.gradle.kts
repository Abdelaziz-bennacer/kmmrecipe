
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    //kotlin("multiplatform")
    kotlin("jvm")
    id("org.jetbrains.compose") version "0.4.0-build179"
    application
}

group = "fr.abdel"
version = "1.0"

repositories {
    mavenCentral()
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(project(":common"))
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

