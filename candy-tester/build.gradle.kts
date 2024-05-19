plugins {
    kotlin("jvm")
    id("org.jetbrains.compose") version "1.6.10-rc03"
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(compose.materialIconsExtended)
    implementation("io.github.bonede:tree-sitter:0.22.5a")
    implementation("io.github.bonede:tree-sitter-kotlin:0.3.1")
}

compose.desktop {
    application {
        mainClass = "ru.dimsuz.candy.tester.MainKt"
    }
}
