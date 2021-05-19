pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    }
    
}
rootProject.name = "kmmrecipe"


include(":android")
include(":desktop")
include(":common")
include(":ios")
include(":web")

