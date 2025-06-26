// Gradle插件声明
plugins {
    // Groovy语言支持
    groovy

    // Java语言支持
    `java-gradle-plugin`

    // Kotlin DSL语言支持
    `kotlin-dsl`
}

// 如果使用Kotlin DSL，必须手动声明仓库。
repositories {
    // 阿里云仓库镜像：Gradle社区插件
    maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin/") }
    // 阿里云仓库镜像：Maven中心仓库+JCenter
    maven { setUrl("https://maven.aliyun.com/repository/public/") }
    // 阿里云仓库镜像：Google仓库
    maven { setUrl("https://maven.aliyun.com/repository/google/") }
    // 腾讯云仓库镜像：Maven中心仓库+Google+JCenter
    maven { setUrl("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }

    gradlePluginPortal()
    mavenCentral()
}

// 声明插件
gradlePlugin {
    plugins {
        // 声明一个插件
        create("Test") {
            // 声明插件ID
            id = "net.bi4vmr.gradle.plugin.test"
            // 声明入口类
            implementationClass = "net.bi4vmr.gradle.plugin.test.TestPlugin"
        }
    }
}
