package _Self.projects.application

import _Self.projects.application.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

class Application(envKey: String, vcsRoot: GitVcsRoot) : Project({
    id("${envKey}_Application")
    name = "Application"

    buildType(Deploy(envKey, vcsRoot))
})
