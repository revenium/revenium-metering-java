plugins {
    id("revenium-metering.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":revenium-metering-java-core"))
    implementation(project(":revenium-metering-java-client-okhttp"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :revenium-metering-java-example:run` to run `Main`
    // Use `./gradlew :revenium-metering-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "io.revenium.metering.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
