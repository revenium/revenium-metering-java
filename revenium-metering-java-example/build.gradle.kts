plugins {
    id("revenium-metering.java")
    application
}

repositories {
    mavenCentral()
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
