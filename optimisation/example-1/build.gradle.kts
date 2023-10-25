import com.gradlehero.GenerateInfoFile
import java.util.*

plugins {
    java
}

version = "1.0.0-SNAPSHOT"

val generateProjectVersionFileTask = tasks.register<GenerateInfoFile>("generateProjectVersionFile") {
    hash = UUID.randomUUID().toString()
}

tasks.named<Copy>("processResources") {
    from(generateProjectVersionFileTask.map { it.outputs })
}