plugins {
    java
    application
    id("org.openjfx.javafxplugin") version "0.0.9"
}

group = "ua.lpnu.teslafactory"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.openjfx:javafx-control:11.0.2")
    implementation("org.openjfx:javafx-fxml:11.0.2")

    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("org.apache.logging.log4j:log4j-slf4j18-impl:2.14.1")
    testImplementation("junit:junit:4.12")
}

tasks {
    javafx {
        version = "16"
        modules("javafx.controls", "javafx.fxml")
    }
    java {
        sourceCompatibility = JavaVersion.VERSION_16
        targetCompatibility = JavaVersion.VERSION_16
    }
    jar {
        manifest {
            attributes["Main-Class"] = "teslafactory.Main"
        }
        /*from(configurations.compileClasspath.map {
            config -> config.map { if (it.isDirectory) it else zipTree(it) }
        })*/
    }
}

configurations {
    setProperty("mainClassName", "teslafactory.Main")
}
