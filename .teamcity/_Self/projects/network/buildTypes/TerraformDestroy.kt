package _Self.projects.network.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.BuildStep
import jetbrains.buildServer.configs.kotlin.v2018_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_2.ParameterDisplay
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.failureConditions.BuildFailureOnText
import jetbrains.buildServer.configs.kotlin.v2018_2.failureConditions.failOnText
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

class TerraformDestroy(envKey: String, vcsRoot: GitVcsRoot) : BuildType({
    id("${envKey}_Network_Terraform_destroy")
    name = "Network Terraform Destroy"

    vcs {
        root(
                vcsRoot
        )
    }

    params {
        param("terraform_path", "general")
        checkbox(
                "confirm",
                "Are you sure?",
                checked = "true",
                unchecked = "false",
                display = ParameterDisplay.PROMPT

        )
    }

    steps {
        script {
            name = "bla bla bla"
            scriptContent = """
                
            """.trimIndent()
        }
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
            scriptContent = """
                
            """.trimIndent()
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