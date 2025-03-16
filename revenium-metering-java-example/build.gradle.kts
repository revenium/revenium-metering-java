plugins {
    id("revenium-metering.kotlin")
    id("java")
    application
}

dependencies {
    implementation(project(":revenium-metering-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    mainClass = "com.revenium_metering.api.example.Main"
}
