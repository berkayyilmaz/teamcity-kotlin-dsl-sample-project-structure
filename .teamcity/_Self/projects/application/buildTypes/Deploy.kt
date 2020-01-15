package _Self.projects.application.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_2.PublishMode
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.msBuild
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.MSBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.nuGetInstaller
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.NuGetInstallerStep
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

class Deploy(envKey: String, vcsRoot: GitVcsRoot) : BuildType({
    id("${envKey}_Deploy")

    name = "Deploy"
    artifactRules = "artifact.zip"
    publishArtifacts = PublishMode.SUCCESSFUL

    vcs {
        root(vcsRoot)
    }

    steps {

        nuGetInstaller {
            name = "Restore NuGet Packages"

            type = "jb.nuget.installer"
            param("nuget.path", "%teamcity.tool.NuGet.CommandLine.5.4.0%")
            param("nuget.updatePackages.mode", "sln")
            param("nuget.use.restore", "restore")
            param("sln.path", "xxx_NewDesign.sln")
            param("toolPathSelector", "%teamcity.tool.NuGet.CommandLine.5.4.0%")
        }

        msBuild {
            name = "Build project with MSBuild"
            path = "./Presentation/xxx.Web/xxx.Web.Global.csproj"
            version = MSBuildStep.MSBuildVersion.V4_0
            toolsVersion = MSBuildStep.MSBuildToolsVersion.V4_0
            platform = MSBuildStep.Platform.x86
            args = "/property:Configuration=Release /P:PublishProfile=LIVE.pubxml /P:DeployOnBuild=true"
        }

    }

})