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

val hamcrestVersion: String by project
val junitVersion: String by project
val slf4jVersion: String by project

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    dependencies {
        implementation("org.slf4j:slf4j-api:$slf4jVersion")
        implementation("org.slf4j:slf4j-simple:$slf4jVersion")
        testImplementation("org.hamcrest:hamcrest-all:$hamcrestVersion")
        testImplementation(platform("org.junit:junit-bom:$junitVersion"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }

    tasks.test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}
