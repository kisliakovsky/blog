val flywayVersion: String by project
val jacksonVersion: String by project
val jedisVersion: String by project
val testContainersVersion: String by project

plugins {
    id("org.flywaydb.flyway")
}

dependencies {
    implementation(project(":domain"))
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("redis.clients:jedis:$jedisVersion")
    testImplementation("org.testcontainers:junit-jupiter:$testContainersVersion")
    testImplementation("org.testcontainers:testcontainers:$testContainersVersion")
}
