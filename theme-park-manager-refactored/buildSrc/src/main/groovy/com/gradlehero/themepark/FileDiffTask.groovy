package com.gradlehero.themepark

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction

abstract class FileDiffTask extends DefaultTask {
    @InputFile
    abstract Property<File> getFile1()
    @InputFile
    abstract Property<File> getFile2()

    @TaskAction
    def diff() {
        if (file1.get().size() == file2.get().size()) {
            println "${file1.get().name} and ${file2.get().name} have the same size"
        } else if (file1.get().size() > file2.get().size()) {
            println "${file1.get().name} was larger"
        } else {
            println "${file2.get().name} was larger"
        }
    }
}
