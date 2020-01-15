package _Self.projects.autoScaling

import _Self.projects.autoScaling.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

class AutoScaling(envKey: String, vcsRoot: GitVcsRoot) : Project({
    id("${envKey}_AutoScaling")
    name = "AutoScaling"

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
