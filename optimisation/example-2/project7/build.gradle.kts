plugins {
    `java-library`
}

group = "org.gradle.test.performance"
version = "2.0"

repositories {
    mavenCentral()
}


dependencies {
    implementation(project(":project4"))
    implementation(project(":project5"))
    implementation(project(":project6"))
    api(libs.commonsLang)
    api(libs.commonsHttpClient)
    api(libs.commonsCodec)
    api(libs.jclOverSlf4j)
    implementation(libs.reflectasm)
    testImplementation(libs.junit)
}