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
    // Use `./gradlew :revenium-metering-java-example:run` to run `Main`
    // Use `./gradlew :revenium-metering-java-example:run -Dexample=Something` to run `SomethingExample`
    mainClass = "com.revenium_metering.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
