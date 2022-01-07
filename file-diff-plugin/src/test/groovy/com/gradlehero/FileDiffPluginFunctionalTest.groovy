package com.gradlehero

import org.gradle.testkit.runner.GradleRunner
import spock.lang.Specification
import spock.lang.TempDir
import static org.gradle.testkit.runner.TaskOutcome.SUCCESS

class FileDiffPluginFunctionalTest extends Specification {
    @TempDir
    File testProjectDir
    File testFile1
    File testFile2
    File buildFile

    def setup() {
        testFile1 = new File(testProjectDir, 'testFile1.txt')
        testFile2 = new File(testProjectDir, 'testFile2.txt')
        buildFile = new File(testProjectDir, 'build.gradle')
        buildFile << """
            plugins {
                id 'com.gradlehero.file-diff'
            }
            
            fileDiff {
                file1 = file('${testFile1.getName()}')
                file2 = file('${testFile2.getName()}')
            }
        """
    }

    def "can diff 2 files of same length"() {
        given:
        testFile1.createNewFile()
        testFile2.createNewFile()

        when:
        def result = GradleRunner.create()
            .withProjectDir(testProjectDir)
            .withArguments('fileDiff')
            .withPluginClasspath()
            .build()

        then:
        result.output.contains('testFile1.txt and testFile2.txt have the same size')
        result.task(':fileDiff').outcome == SUCCESS
    }

    def "can diff 2 files where 1st file larger than 2nd"() {
        given:
        testFile1 << 'Some text'
        testFile2.createNewFile()

        when:
        def result = GradleRunner.create()
                .withProjectDir(testProjectDir)
                .withArguments('fileDiff')
                .withPluginClasspath()
                .build()

        then:
        result.output.contains('testFile1.txt was larger')
        result.task(':fileDiff').outcome == SUCCESS
    }

    def "can diff 2 files where 2nd file larger than 1st"() {
        given:
        testFile1.createNewFile()
        testFile2 << 'Some text'

        when:
        def result = GradleRunner.create()
                .withProjectDir(testProjectDir)
                .withArguments('fileDiff')
                .withPluginClasspath()
                .build()

        then:
        result.output.contains('testFile2.txt was larger')
        result.task(':fileDiff').outcome == SUCCESS
    }
}
