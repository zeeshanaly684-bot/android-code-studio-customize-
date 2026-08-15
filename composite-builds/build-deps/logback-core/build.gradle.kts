/*
 *  This file is part of AndroidIDE.
 *
 *  AndroidIDE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidIDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 */

plugins {
    //noinspection JavaPluginLanguageLevel
    id("java-library")
}

java {
    // Prefer the prebuilt jar from libs/, fall back to the submodule source
    // if it is available.
    val jarFallback = rootProject.projectDir.resolve("../libs/logback-core.jar")
    val srcDir =
        rootProject.projectDir.resolve("../external/logback-android/logback-core/src/main/java")

    sourceSets.getByName("main") {
        if (jarFallback.exists() && (!srcDir.exists() || !srcDir.resolve("ch").exists())) {
            // Use the prebuilt jar as the published artifact instead of
            // compiling from the (now unreachable) submodule source.
            this.java.excludes("**/*.java")
        } else {
            java.srcDirs(srcDir)

            val modInfo = srcDir.resolve("module-info.java")
            if (modInfo.exists() && modInfo.isFile) {
                modInfo.renameTo(srcDir.resolve("module-info.java.exclude"))
            }
        }
    }

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

tasks.named("jar") {
    // When we are using the prebuilt jar fallback, just repackage the jar as-is.
    if (file("../libs/logback-core.jar").exists()) {
        from(zipTree("../libs/logback-core.jar").matching { exclude("META-INF/*.SF", "META-INF/*.DSA", "META-INF/*.RSA") })
    }
}
