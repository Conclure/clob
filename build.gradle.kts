plugins {
    java
}

group = "me.conclure"
version = "1.0-SNAPSHOT"

subprojects {
    apply(plugin = "java-library")

    java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

    repositories {
        mavenCentral()
    }

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    }
    buildDir = File(File(rootProject.rootDir,"out"),this.project.name)
}
/*
dependencies {
    implementation("com.squareup.moshi:moshi:1.12.0")
    implementation("com.discord4j:discord4j-core:3.2.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}*/