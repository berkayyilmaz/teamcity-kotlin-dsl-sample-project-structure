package _Self.projects.network

import _Self.projects.network.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

class Network(envKey: String, vcsRoot: GitVcsRoot) : Project({
    id("${envKey}_Network")
    name = "Network"

    /**
     * Builds
     */
    buildType(TerraformPlan(envKey, vcsRoot))
    buildType(TerraformApply(envKey, vcsRoot))

    buildTypesOrder = listOf(TerraformPlan(envKey, vcsRoot), TerraformApply(envKey, vcsRoot))

    if (envKey == "staging") {
        buildType(TerraformDestroy(envKey, vcsRoot))
    }
})