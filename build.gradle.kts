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
    testImplementation("org.assertj:assertj-core:3.27.7")
}

// === Обычная задача test: все тесты + печать "Test run is over" после ===
tasks.test {
    useJUnitPlatform()
    finalizedBy("printTestRunOver")
}

// === Вспомогательная задача: печатает сообщение ===
tasks.register("printTestRunOver") {
    group = "verification"
    description = "Печатает Test run is over после завершения тестов"
    doLast {
        println("Test run is over")
    }
}

// === Smoke-задача: тесты с тегом Smoke ===
tasks.register<Test>("smoke") {
    group = "tests"
    systemProperty("CIRCUIT", System.getProperty("circuit", "DEV"))
    useJUnitPlatform {
        includeTags("Smoke")
    }
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath
}

// === Задача для ДЗ-3: только тесты с тегом Assertions (по тегу и имени класса) ===
tasks.register<Test>("assertionsTest") {
    group = "verification"
    description = "Запускает только тесты с тегом Assertions"
    useJUnitPlatform {
        includeTags("Assertions")
    }
    filter {
        includeTestsMatching("tech.inni.study.Assertions*")
    }
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath
}