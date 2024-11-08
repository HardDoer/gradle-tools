plugins {
    `kotlin-dsl`
}

group = "ninja.joonas"
version = "1.0.0"

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("githubRepoPlugin") {
            id = "ninja.joonas.gradletools.github-repo"
            implementationClass = "ninja.joonas.gradletools.GithubRepoPlugin"
        }
    }
}