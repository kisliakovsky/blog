plugins {
    application
}

val mainClass = "org.kislii.blog.app.ApplicationKt"

tasks {
    register("fatJar", Jar::class.java) {
        archiveClassifier.set("all")
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        manifest {
            attributes("Main-Class" to mainClass)
        }
        from(
            configurations.runtimeClasspath
                .get()
                .map { if (it.isDirectory) it else zipTree(it) }
        )
        from(sourceSets.main.get().output)
    }
}

val hamcrestVersion: String by project
val javaxWsRsVersion: String by project
val jcabiVersion: String by project
val jerseyVersion: String by project
val takesVersion: String by project

dependencies {
    implementation(project(":adapter"))
    implementation(project(":domain"))
    implementation("org.takes:takes:$takesVersion")
    testImplementation("com.jcabi:jcabi-http:$jcabiVersion")
    testImplementation("javax.ws.rs:javax.ws.rs-api:$javaxWsRsVersion")
    testImplementation("org.glassfish.jersey.core:jersey-common:$jerseyVersion")
    testImplementation("org.hamcrest:hamcrest-all:$hamcrestVersion")
}
