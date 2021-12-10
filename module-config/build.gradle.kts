dependencies {
    testAnnotationProcessor(project(":clob-config"))
    testCompileOnly("org.spigotmc:plugin-annotations:1.2.3-SNAPSHOT")
    testAnnotationProcessor("org.spigotmc:plugin-annotations:1.2.3-SNAPSHOT")
}

repositories {
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots")
}