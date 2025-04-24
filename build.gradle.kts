plugins {
    kotlin("jvm") version "2.1.10"
    jacoco
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.12.2")
    testImplementation("com.google.truth:truth:1.4.4")
    testImplementation("io.kotest:kotest-assertions-core:5.9.0")
    testImplementation("io.mockk:mockk:1.14.0")
}

tasks.test {
    useJUnitPlatform()
}
tasks.test{
    finalizedBy(tasks.jacocoTestReport)
}
tasks.jacocoTestReport {
    reports {
        csv.required.set(false)
        xml.required.set(true)
        html.required.set(true)
    }
    dependsOn(tasks.test)
}
tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                minimum = "0.5".toBigDecimal() // 100% coverage
            }
        }
    }
    classDirectories.setFrom(
        files(classDirectories.files.map {
            fileTree(it).exclude(
                "**/config/**",
                "**/dto/**",
                "**/model/**",
                "**/*Exception*",
                "**/BuildConfig.class",
                "**/generated/**",    // Generated code (Lombok, Protobuf, etc.)
                "**/AutoValue_*",     // AutoValue generated classes
                "**/*Test.class",     // Test classes themselves
                "**/R.class",        // Android R files (if applicable)

            )
        })
    )
}

kotlin {
    jvmToolchain(8)
}