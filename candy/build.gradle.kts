plugins {
    kotlin("jvm")
    application
}

kotlin {
    jvmToolchain(15)
}

application {
    mainClass.set("ru.dimsuz.candy.MainKt")
}
