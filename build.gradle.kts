plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "1.3.+"
}

group = "ninja.joonas.gradle-tools"
version = "1.0.0"

repositories {
    mavenCentral()
}

gradlePlugin {
    website = "someday"
    vcsUrl = ""
    plugins {
        create("githubRepoPlugin") {
            id = "ninja.joonas.gradletools.github-repo"
            displayName = "github repo plugin"
            tags = listOf()
            description = "Small helper plugin to easily use dependencies hosted in github."
            implementationClass = "ninja.joonas.gradletools.GithubRepoPlugin"
        }
    }
}