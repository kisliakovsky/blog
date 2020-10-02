plugins {
    kotlin("jvm")
}

val jacksonVersion: String by project

dependencies {
    implementation(project(":domain"))
    implementation(kotlin("stdlib"))
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
}
