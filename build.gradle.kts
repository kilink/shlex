import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jlleitschuh.gradle.ktlint") version "10.2.1"
}

repositories {
    mavenCentral()
}

apply(plugin = "org.jlleitschuh.gradle.ktlint")

kotlin {
    explicitApi()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.+"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
        allWarningsAsErrors = true
    }
}
