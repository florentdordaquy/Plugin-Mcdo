val name: String by project
val ideaVersion: String by project
val javaVersion: String by project
val pluginVerifierIdeVersions: String by project

plugins {
    java
    id("org.jetbrains.intellij.platform") version "2.6.0"
}

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }

}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity("2025.1")
        bundledPlugin("com.intellij.java")
        pluginVerifier()
        zipSigner()
        instrumentationTools()
    }

}


java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

