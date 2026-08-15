/*
 *  Zeeshan Studio — composite-builds/build-deps/logback-core/build.gradle.kts
 */

import org.gradle.api.tasks.bundling.Jar

plugins {
    id("java-library")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly("org.codehaus.janino:janino:+")
    compileOnly("org.codehaus.janino:commons-compiler:+")
    compileOnly("org.fusesource.jansi:jansi:+")
    compileOnly("jakarta.mail:jakarta.mail-api:+")
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.1.0")
}

tasks.named<Jar>("jar") {
    val prebuilt = file("../libs/logback-core.jar")
    if (prebuilt.exists()) {
        from(zipTree(prebuilt).matching {
            exclude("META-INF/*.SF")
            exclude("META-INF/*.DSA")
            exclude("META-INF/*.RSA")
        })
    }
}