buildscript {
    repositories {
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("org.jlleitschuh.gradle:ktlint-gradle:9.4.0")
    }
}

plugins {
    kotlin("jvm") version "1.4.10"
}

allprojects {
    group = "org.kislii.blog"

    version = "0.1"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}
