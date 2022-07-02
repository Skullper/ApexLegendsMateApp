// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.2.1" apply false
    id("com.android.library") version "7.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.0" apply false
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.7.0" apply false
    id("com.google.devtools.ksp") version "1.7.0-1.0.6" apply false //required for moshi
    id("com.github.ben-manes.versions") version "0.42.0"
    id("nl.littlerobots.version-catalog-update") version "0.5.1"
//    id("com.gitlab.stfs.gradle.dependency-graph-plugin") version "0.4"
}

subprojects {

    apply(plugin = "org.jlleitschuh.gradle.ktlint")

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
        disabledRules.set(setOf("no-wildcard-imports", "import-ordering", "comment-spacing"))
        reporters {
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

versionCatalogUpdate {
    sortByKey.set(false)
}
