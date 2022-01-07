package com.gradlehero

import org.gradle.api.file.RegularFileProperty

abstract class FileDiffPluginExtension {
    abstract RegularFileProperty getFile1()
    abstract RegularFileProperty getFile2()
}
