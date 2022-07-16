pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    defaultLibrariesExtensionName.set("deps")
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ApexLegendsMateApp"

include(":app")
include(":network-utils")
include(":ui-theme")
include(":mozambique-api")
include(":player-repo")
include(":account-repo")
include(":legends-repo")
include(":badges-repo")
include(":trackers-repo")
