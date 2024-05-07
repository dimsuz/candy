plugins {
    kotlin("jvm")
    application
}

kotlin {
    jvmToolchain(15)
}

dependencies {
    implementation("io.github.bonede:tree-sitter:0.22.5a")
    implementation("io.github.bonede:tree-sitter-kotlin:0.3.1")
}

application {
    mainClass.set("ru.dimsuz.candy.MainKt")
}
