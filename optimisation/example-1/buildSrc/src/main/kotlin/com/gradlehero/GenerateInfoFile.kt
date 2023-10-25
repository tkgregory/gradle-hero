package com.gradlehero

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class GenerateInfoFile : DefaultTask() {
    @get:Input
    abstract val hash: Property<String>

    @get:OutputFile
    abstract val infoFile: RegularFileProperty

    init {
        infoFile.convention(project.layout.buildDirectory.file("info.txt"))
    }

    @TaskAction
    fun generate() {
        infoFile.get().asFile.writeText("Software hash ${hash.get()}")
    }
}