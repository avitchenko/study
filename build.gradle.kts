plugins {
    id("java")
}

group = "tech.inni.study"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    testImplementation(platform("org.junit:junit-bom:6.1.3"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.fasterxml.jackson.core:jackson-core:2.22.2")
}


// печатает "Test run is over"
tasks.test {
    useJUnitPlatform()
    finalizedBy("printTestRunOver")
}

// печатает сообщение
tasks.register("printTestRunOver") {
    group = "verification"
    description = "Печатает Test run is over после завершения тестов"
    doLast {
        println("Test run is over")
    }
}

// запускает тесты с тегом Smoke
tasks.register<Test>("smoke") {
    group = "tests"
    systemProperty("CIRCUIT", System.getProperty("circuit", "DEV"))
    useJUnitPlatform {
        includeTags("Smoke")
    }
}