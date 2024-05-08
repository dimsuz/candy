plugins {
    kotlin("jvm")
    id("org.jetbrains.compose") version "1.6.2"
    application
}

kotlin {
    jvmToolchain(15)
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(compose.materialIconsExtended)
}

application {
    mainClass.set("ru.dimsuz.candy.tester.MainKt")
}
