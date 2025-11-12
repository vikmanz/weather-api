plugins {
    kotlin("jvm") version "2.2.20"
}

group = "com.vikmanz"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.retrofit2:retrofit:3.0.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}