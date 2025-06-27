@file:Suppress("UnstableApiUsage")

// 构建工具的依赖配置
pluginManagement {
    // 声明Gradle插件仓库
    repositories {
        // 腾讯云仓库镜像：Maven中心仓库+Spring+Google+JCenter
        maven { setUrl("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }
        // 阿里云仓库镜像：Gradle社区插件
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin/") }
        // 阿里云仓库镜像：Maven中心仓库+JCenter
        maven { setUrl("https://maven.aliyun.com/repository/public/") }
        // 阿里云仓库镜像：Google仓库
        maven { setUrl("https://maven.aliyun.com/repository/google/") }

        mavenCentral()
        gradlePluginPortal()
    }
}

// 所有模块的依赖配置
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    // 声明Maven组件仓库
    repositories {
        // 腾讯云仓库镜像：Maven中心仓库+Spring+Google+JCenter
        maven { setUrl("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }
        // 阿里云仓库镜像：Maven中心仓库+JCenter
        maven { setUrl("https://maven.aliyun.com/repository/public/") }
        // 阿里云仓库镜像：Google仓库
        maven { setUrl("https://maven.aliyun.com/repository/google/") }
        // JitPack
        maven { setUrl("https://jitpack.io/") }

        mavenCentral()
        google()
    }
}

/* ----- 工程结构声明 ----- */
// 主工程名称
rootProject.name = "E05_PluginUsage_Kotlin"

include(":M02_JaCoCo_Java")
include(":M02_JaCoCo_Kotlin")
