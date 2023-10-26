plugins {
    `java-library`
}

group = "org.gradle.test.performance"
version = "2.0"

repositories {
    mavenCentral()
}


dependencies {
    implementation(project(":project0"))
    implementation(project(":project1"))
    implementation(project(":project2"))

    api(libs.commonsLang)
    api(libs.commonsHttpClient)
    api(libs.commonsCodec)
    api(libs.jclOverSlf4j)
    implementation(libs.reflectasm)
    testImplementation(libs.junit)
}