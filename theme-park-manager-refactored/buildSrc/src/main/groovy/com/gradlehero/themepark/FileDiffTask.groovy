package com.gradlehero.themepark

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction

abstract class FileDiffTask extends DefaultTask {
    @InputFile
    abstract RegularFileProperty getFile1()
    @InputFile
    abstract RegularFileProperty getFile2()

    @TaskAction
    def diff() {
        if (file1.get().asFile.size() == file2.get().asFile.size()) {
            println "${file1.get().asFile.name} and ${file2.get().asFile.name} have the same size"
        } else if (file1.get().asFile.size() > file2.get().asFile.size()) {
            println "${file1.get().asFile.name} was larger"
        } else {
            println "${file2.get().asFile.name} was larger"
        }
    }
}
