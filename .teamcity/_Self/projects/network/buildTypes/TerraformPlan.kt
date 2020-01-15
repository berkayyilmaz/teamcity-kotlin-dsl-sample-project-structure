package _Self.projects.network.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*

import jetbrains.buildServer.configs.kotlin.v2018_2.buildFeatures.sshAgent
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.failureConditions.BuildFailureOnText
import jetbrains.buildServer.configs.kotlin.v2018_2.failureConditions.failOnText
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

class TerraformPlan(envKey: String, vcsRoot: GitVcsRoot) : BuildType ({
    id("${envKey}_Network_Terraform_plan")
    name = "Network Terraform Plan"

    params {
        param("terraform_path", "general")
    }

    vcs {
        root(
                vcsRoot
        )
    }

    steps {
        script {
            name = "bla bla bla"
            scriptContent = """
                
            """.trimIndent()
            workingDir = "%bla bla bla%"
        }
        script {
            name = "bla bla bla"
            scriptContent = """
                
            """.trimIndent()
        }
        script {
            name = "bla bla bla"
            workingDir = "%bla bla bla%"
            scriptContent = """
                
            """.trimIndent()
        }
        script {
            name = "bla bla bla"
            scriptContent = "bla bla bla"
            executionMode = BuildStep.ExecutionMode.ALWAYS
        }
    }

    failureConditions {
        failOnText {
            conditionType = BuildFailureOnText.ConditionType.REGEXP
            pattern = "Error:"
            failureMessage = "bla bla bla"
            stopBuildOnFailure = true
        }
    }
})
