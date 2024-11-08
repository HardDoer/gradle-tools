package ninja.joonas.gradletools

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.repositories.PasswordCredentials

class GithubRepoPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val conf = project.extensions.create("githubRepoConfig", RepositoryConf::class.java)

        project.afterEvaluate {
            conf.modules.forEach { repoName ->
                project.repositories.maven {
                    url = project.uri("https://maven.pkg.github.com/${conf.repoRoot}/$repoName")
                    credentials(PasswordCredentials::class.java) {
                        username = project.findProperty("gpr.user") as String? ?: System.getenv("PR_ACCESS_TOKEN_USER")
                        password = project.findProperty("gpr.key") as String? ?: System.getenv("PR_ACCESS_TOKEN")
                    }
                }
            }
        }
    }
}

open class RepositoryConf {
    var modules: List<String> = emptyList()
    var repoRoot: String = ""
}
