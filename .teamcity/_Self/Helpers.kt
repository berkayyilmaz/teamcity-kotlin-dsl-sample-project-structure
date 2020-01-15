package _Self

import _Self.projects.ami.AMI
import _Self.projects.application.Application
import _Self.projects.autoScaling.AutoScaling
import _Self.projects.network.Network

import jetbrains.buildServer.configs.kotlin.v2018_2.ParameterDisplay
import jetbrains.buildServer.configs.kotlin.v2018_2.Project
import jetbrains.buildServer.configs.kotlin.v2018_2.toId
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

fun createEnvironment(envTitle: String, envKey: String, namespace: String, branchName: String, envAccountId: String): Project {
    val infraVcsRoot = createInfraVCS(branchName)
    val appVcsRoot = createAppVCS(branchName)

    return Project {
        id(envTitle.toId())
        name = envTitle
        description = "Builds run from the $branchName branch"

        vcsRoot(infraVcsRoot)
        vcsRoot(appVcsRoot)

        params {
            param("environment", envKey)
            param("ami_path", "ami")
            param("application_path", "xxx-com")
            param("autoscaling_path", "autoscaling")
            param("terraform_path", "general")
            param("aws_db_secret_id", "staging/xxx/xxx")
            param("aws_webserver_secret_id", "staging/xxx/windows")

            text("env.AWS_SECRET_ACCESS_KEY", "%vault:/aws/creds/role-xxx-teamcity!/secret_key%", display = ParameterDisplay.HIDDEN, readOnly = true, allowEmpty = true)
            text("env.AWS_SESSION_TOKEN", "%vault:/aws/creds/role-xxx-teamcity!/security_token%", display = ParameterDisplay.HIDDEN, readOnly = true, allowEmpty = true)
            text("env.AWS_ACCESS_KEY_ID", "%vault:/aws/creds/role-xxx-teamcity!/access_key%", display = ParameterDisplay.HIDDEN, readOnly = true, allowEmpty = true)

            text("xxx_cert_chain", "%vault:/secret/xxx/certificate!/chain%", display = ParameterDisplay.HIDDEN, readOnly = true, allowEmpty = true)
            text("xxx_cert_crt", "%vault:/secret/xxx/certificate!/crt%", display = ParameterDisplay.HIDDEN, readOnly = true, allowEmpty = true)
            text("xxx_cert_key", "%vault:/secret/xxx/certificate!/key%", display = ParameterDisplay.HIDDEN, readOnly = true, allowEmpty = true)
        }

        subProject(Network(namespace, infraVcsRoot))
        subProject(AutoScaling(namespace, infraVcsRoot))
        subProject(AMI(namespace, infraVcsRoot))
        subProject(Application(namespace, appVcsRoot))
    }
}

fun createInfraVCS(branchName: String): GitVcsRoot {
    return GitVcsRoot {
        id("VCS_infra_$branchName")

        name = "gitlab.xxx.com:xxx/xxx-infrastructure.git-$branchName"
        url = "git@gitlab.xxx.com:xxx/xxx-infrastructure.git"
        branch = "refs/heads/$branchName"
        authMethod = uploadedKey {
            uploadedKey = "GitLab"
        }
    }
}

fun createAppVCS(branchName: String): GitVcsRoot {
    return GitVcsRoot {
        id("VCS_app_$branchName")

        name = "gitlab.xxx.com:xxx/xxx-com.git-$branchName"
        url = "git@gitlab.xxx.com:xxx/xxx-com.git"
        branch = "refs/heads/development"
        authMethod = uploadedKey {
            uploadedKey = "GitLab"
        }
    }
}
