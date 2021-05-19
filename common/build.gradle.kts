import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    //id("org.jetbrains.compose") version "0.3.1"
    kotlin("plugin.serialization")
    id("org.jetbrains.kotlin.native.cocoapods")
    id("com.android.library")
    id("com.squareup.sqldelight")
    id("kotlin-parcelize")
}

group = "fr.abdel"
version = "1.0"

android {
    configurations {
        create("androidTestApi")
        create("androidTestDebugApi")
        create("androidTestReleaseApi")
        create("testApi")
        create("testDebugApi")
        create("testReleaseApi")
    }
}

kotlin {
    val sdkName: String? = System.getenv("SDK_NAME")

    val isiOSDevice = sdkName.orEmpty().startsWith("iphoneos")
    if (isiOSDevice) {
        iosArm64("iOS")
    } else {
        iosX64("iOS")
    }

    android()

    cocoapods {
        // Configure fields required by CocoaPods.
        summary = "Some description for a Kotlin/Native module"
        homepage = "Link to a Kotlin/Native module homepage"
    }



    /*cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        frameworkName = "shared"
        podfile = project.file("../iosApp/Podfile")
        //pod("GoogleWebRTC",moduleName = "WebRTC", version = "~> 1.1")
    }*/

    ios {

    }

    jvm("desktop") {

    }

    ios {

    }
    js() {
        browser {


        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                //api(compose.runtime)
                //api(compose.foundation)
                //api(compose.material)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.1.0")
                implementation("io.ktor:ktor-client-core:1.5.3")
                implementation("io.ktor:ktor-client-json:1.5.3")
                implementation("io.ktor:ktor-client-serialization:1.5.3")
                implementation("com.squareup.sqldelight:runtime:1.5.0")
                implementation("org.jetbrains.kotlin:kotlin-parcelize-runtime:1.5.0")
                implementation("dev.icerock.moko:parcelize:0.6.1")
                implementation("io.insert-koin:koin-core:3.0.1")
                implementation("io.insert-koin:koin-test:3.0.1")
                implementation("com.russhwolf:multiplatform-settings-no-arg:0.7.5")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }

        }
        val androidMain by getting {
            dependencies {
                api("androidx.appcompat:appcompat:1.2.0")
                api("androidx.core:core-ktx:1.3.1")
                implementation("com.google.android.material:material:1.3.0")
                implementation("io.ktor:ktor-client-android:1.5.3")
                implementation("com.squareup.sqldelight:android-driver:1.5.0")
                implementation("io.insert-koin:koin-android:3.0.1")
                //implementation("io.insert-koin:koin-android-viewmodel:2.2.2")
                implementation("io.insert-koin:koin-androidx-compose:3.0.1")
                implementation("io.insert-koin:koin-androidx-workmanager:3.0.1")
                implementation("org.jetbrains.kotlin:kotlin-native-utils:1.5.0")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13")
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-apache:1.5.0")
                implementation("com.squareup.sqldelight:jdbc-driver:1.5.0")
                implementation("com.squareup.sqldelight:sqlite-driver:1.5.0")
                //implementation(Ktor.slf4j)
            }


        }
        val desktopTest by getting
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:1.5.3")
                implementation("com.squareup.sqldelight:native-driver:1.5.0")
            }

        }
        val iosTest by getting
        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:1.5.3")
                implementation("com.squareup.sqldelight:sqljs-driver:1.5.0")
            }

        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}

android {
    compileSdk = 29
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 29
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }
}

/*val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}*/

sqldelight {
    database("AppDatabase") {
        packageName = "fr.abdel.kmmrecipe.cache"
        sourceFolders = listOf("sqldelight")
    }
}

/*tasks.getByName("build").dependsOn(packForXcode)
dependencies {
    implementation("com.google.android.gms:play-services-ads-lite:20.1.0")
}*/
