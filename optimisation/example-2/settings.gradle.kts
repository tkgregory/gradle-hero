rootProject.name = "example-2"
include("project0")
include("project1")
include("project2")
include("project3")
include("project4")
include("project5")
include("project6")
include("project7")
include("project8")
include("project9")

plugins {
    id("com.gradle.enterprise") version ("3.15.1")
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
    }
}