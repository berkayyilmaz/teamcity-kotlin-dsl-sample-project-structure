package _Self

import jetbrains.buildServer.configs.kotlin.v2018_2.Project

object Project : Project({
    /**
     * Setup the project
     */

    params {
        param("aws_region", "us-east-1")
    }

    /**
     * Setup the environments
     */
    subProject(Staging)
    subProject(Production)
    subProjectsOrder = listOf(Staging, Production)
})

val Production = createEnvironment(
        "Production",
        "production",
        "production",
        "production",
        "_ACCOUNT_ID"
)

val Staging = createEnvironment(
        "Staging",
        "staging",
        "staging",
        "staging",
        "_ACCOUNT_ID_"
)