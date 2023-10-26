plugins {
    `java-library`
}

group = "org.gradle.test.performance"
version = "2.0"

repositories {
    mavenCentral()
}


dependencies {
    api(libs.commonsLang)
    api(libs.commonsHttpClient)
    api(libs.commonsCodec)
    api(libs.jclOverSlf4j)
    implementation(libs.reflectasm)
    testImplementation(libs.junit)
}