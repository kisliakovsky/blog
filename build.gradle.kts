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

val assertjVersion: String by project
val hamcrestVersion: String by project
val junitVersion: String by project
val logbackVersion: String by project
val slf4jVersion: String by project

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    dependencies {
        implementation("ch.qos.logback:logback-classic:$logbackVersion")
        implementation("ch.qos.logback:logback-core:$logbackVersion")
        implementation("org.slf4j:slf4j-api:$slf4jVersion")
        testImplementation("org.assertj:assertj-core:$assertjVersion")
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
