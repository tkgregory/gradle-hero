package com.gradlehero.themepark

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction

abstract class FileDiffTask : DefaultTask() {
    @get:InputFile
    abstract val file1: RegularFileProperty

    @get:InputFile
    abstract val file2: RegularFileProperty

    @TaskAction
    fun diff() {
        if (file1.get().asFile.length() == file2.get().asFile.length()) {
            println("${file1.get().asFile.name} and ${file2.get().asFile.name} have the same size")
        } else if (file1.get().asFile.length() > file2.get().asFile.length()) {
            println("${file1.get().asFile.name} was larger")
        } else {
            println("${file2.get().asFile.name} was larger")
        }
    }
}