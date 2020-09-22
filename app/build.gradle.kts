plugins {
    application
    kotlin("jvm")
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

dependencies {
    implementation(project(":adapter"))
    implementation(project(":domain"))
    implementation(kotlin("stdlib"))
}
