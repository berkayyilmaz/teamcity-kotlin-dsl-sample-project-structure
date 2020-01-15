package _Self.projects.ami.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

class PackerBaseAMI(envKey: String, vcsRoot: GitVcsRoot) : BuildType({
    id("${envKey}_Packer_Base_AMI")

    name = "bla bla bla"
    artifactRules = "%bla bla bla%/manifest.json"
    vcs {
        root(
                vcsRoot
        )
    }

    steps{
        script {
            name = "bla bla bla"
            workingDir = "%bla bla bla%"
            scriptContent = """
                
            """.trimIndent()
        }

        script {
            name = "bla bla bla"
            workingDir = "%bla bla bla%"
            scriptContent = """
               
            """.trimIndent()
        }
    }
})
