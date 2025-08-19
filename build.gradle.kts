/*
 * Copyright (c) 2022-2025 ChilliBits. All rights reserved.
 */

import org.jetbrains.changelog.Changelog
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun properties(key: String) = project.findProperty(key).toString()

plugins {
    id("java")
    kotlin("jvm") version "2.2.10"
    id("org.jetbrains.intellij") version "1.17.4"
    id("org.jetbrains.changelog") version "2.4.0"
}

group = properties("pluginGroup")
version = properties("pluginVersion")

sourceSets["main"].java.srcDirs("src/main/antlr")
sourceSets["main"].java.srcDirs("src/main/gen")

// Configure project's dependencies
repositories {
    mavenCentral()
}

// Configure Gradle IntelliJ Plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
intellij {
    val platformType = properties("platformType")
    val platformVersion = when (platformType) {
        "IU", "IC" -> properties("ideaVersion")
        "CL"       -> properties("clionVersion")
        else       -> throw IllegalArgumentException("Unknown IDE type: $type, supported types: IU, IC, CL")
    }

    pluginName.set(properties("pluginName"))
    version.set(platformVersion)
    type.set(platformType)

    val platformPlugins = when (platformType) {
        "IU" -> properties("ideaPlugins")
        "IC" -> properties("ideaCommunityPlugins")
        "CL" -> properties("clionPlugins")
        else -> throw IllegalArgumentException("Unknown IDE type: $type, supported types: IU, IC, CL")
    }

    // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file.
    plugins.set(platformPlugins.split(',').map(String::trim).filter(String::isNotEmpty))
}

// Configure Gradle Changelog Plugin - read more: https://github.com/JetBrains/gradle-changelog-plugin
changelog {
    version.set(properties("pluginVersion"))
    groups.set(emptyList())
}

tasks {
    // Set the JVM compatibility versions
    properties("javaVersion").let {
        withType<JavaCompile> {
            sourceCompatibility = it
            targetCompatibility = it
        }
        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = it
        }
    }

    runIde {
        maxHeapSize = "2g"
    }

    wrapper {
        gradleVersion = properties("gradleVersion")
    }

    patchPluginXml {
        version.set(properties("pluginVersion"))
        sinceBuild.set(properties("pluginSinceBuild"))
        untilBuild.set(properties("pluginUntilBuild"))

        // Get the latest available change notes from the changelog file
        changeNotes.set(provider {
            changelog.renderItem(changelog.run {
                getOrNull(properties("pluginVersion")) ?: getLatest()
            }, Changelog.OutputType.HTML)
        })
    }

    buildSearchableOptions {
        enabled = false
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}