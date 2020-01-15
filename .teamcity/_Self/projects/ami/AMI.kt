package _Self.projects.ami

//import _Self.projects.ami.buildTypes.PackerAppAMI
import _Self.projects.ami.buildTypes.PackerBaseAMI
import jetbrains.buildServer.configs.kotlin.v2018_2.Project
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

class AMI (envKey: String, vcsRoot: GitVcsRoot) : Project({
    id("${envKey}_AMI")
    name = "AMI"

    buildType(PackerBaseAMI(envKey, vcsRoot))
})