package com.gradlehero

import org.gradle.api.Plugin
import org.gradle.api.Project

class FileDiffPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def extension = project.extensions.create('fileDiff', FileDiffPluginExtension)

        project.tasks.register('fileDiff', FileDiffTask) {
            file1 = extension.file1
            file2 = extension.file2
        }
    }
}