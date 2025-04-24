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
tasks.test {
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

jacoco {
    toolVersion = "0.8.10"
}


tasks.jacocoTestCoverageVerification {
    executionData.setFrom(fileTree(buildDir).include("/jacoco/test.exec"))
    classDirectories.setFrom(fileTree("build/classes/kotlin/main/org/example/Calculate"))
    sourceDirectories.setFrom(files("src/main/kotlin/Calculate"))
    violationRules {
        rule {
            limit {
                counter = "CLASS"
                /*
                * LINE: line coverage
                BRANCH: branch coverage
                INSTRUCTION: bytecode instruction coverage
                METHOD: method coverage
                CLASS: class coverage
                 **/
                value = "COVEREDRATIO"
                counter = "METHOD"
                minimum = "1.0".toBigDecimal() // 50% coverage

            }
        }
    }
   // classDirectories.setFrom(
    //    files(classDirectories.files.map {
      //      fileTree(it).include("**/src/test/kotlin/**")
       // })
    //)
}

kotlin {
    jvmToolchain(8)
}