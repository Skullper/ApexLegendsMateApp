// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.2.1" apply false
    id("com.android.library") version "7.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.0" apply false
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.7.0" apply false
//    id("com.gitlab.stfs.gradle.dependency-graph-plugin") version "0.4"
}

subprojects {

    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    apply(from = "$rootDir/sdkversions.gradle.kts")

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        version.set("0.45.2")
        outputToConsole.set(true)
        android.set(true)
        ignoreFailures.set(false)
        filter {
            exclude { element ->
                element.file.path.contains("generated/")
                element.file.path.contains("test/")
                element.file.path.contains("androidTest/")
                element.file.path.contains("libs/")
            }
        }
        disabledRules.set(setOf("no-wildcard-imports", "import-ordering"))
        reporters {
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
