import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import java.nio.charset.StandardCharsets

plugins {
    id("java-library") apply(true)
    id("com.github.johnrengelman.shadow") version "7.1.2" apply(true)
}

group = "net.nightlyduck.stations"
version = "0.0.1-SNAPSHOT"
description = "An web application, used Javalin for manage bus stations."

dependencies {
    implementation("io.javalin:javalin:4.6.0")

    implementation("org.tinylog:tinylog-api:2.5.0-M2")
    implementation("org.tinylog:tinylog-impl:2.5.0-M2")

    implementation("org.slf4j:slf4j-simple:1.7.31")

    implementation("org.mariadb.jdbc:mariadb-java-client:3.0.5")
    implementation("com.zaxxer:HikariCP:5.0.1")

    implementation("org.spongepowered:configurate-core:4.1.2")
    implementation("org.spongepowered:configurate-hocon:4.1.2")

    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
}

repositories {
    mavenCentral()
}

tasks {
    withType(JavaCompile::class.java) {
        options.release.set(17)
        options.encoding = StandardCharsets.UTF_8.name()
    }

    withType(ShadowJar::class.java) {
        archiveClassifier.set("")
    }
}

