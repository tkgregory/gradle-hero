import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    base
}

tasks.register<Copy>("generateDescriptions") {
    from("descriptions")
    into("$buildDir/descriptions")
    filter(ReplaceTokens::class, "tokens" to mapOf("THEME_PARK_NAME" to "Grelephant's Wonder World"))
}