package _Self.projects.autoScaling.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*

import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.failureConditions.BuildFailureOnText
import jetbrains.buildServer.configs.kotlin.v2018_2.failureConditions.failOnText
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

class TerraformApply(envKey: String, vcsRoot: GitVcsRoot) : BuildType ({
    id("${envKey}_Autoscaling_Terraform_apply")
    name = "Autoscaling Terraform Apply"
    artifactRules = "+:%autoscaling_path%/result-apply-%environment%.txt"

    params {
        param("autoscaling_path", "autoscaling")
    }

    vcs {
        root(
                vcsRoot
        )
    }

    dependencies {
        // Id needs to be changed.
        artifacts(BuildType { id("${envKey}_Packer_Base_AMI") }) {
            artifactRules = "manifest.json=>dependencies"
            buildRule = lastSuccessful()
        }
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
            workingDir = "%bla bla bla%"
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
            workingDir = "%bla bla bla%"
        }
    }

    failureConditions {
        failOnText {
            conditionType = BuildFailureOnText.ConditionType.REGEXP
            pattern = "Error:"
            failureMessage = "bla bla bla"
            stopBuildOnFailure = false
        }
    }
})
