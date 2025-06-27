// Gradle插件声明
plugins {
    id("net.bi4vmr.gradle.plugin.test") apply false
    id("net.bi4vmr.gradle.plugin.test2") apply false
}

// 为子工程应用自定义插件
allprojects {
    project.apply(plugin = "net.bi4vmr.gradle.plugin.test")
    project.apply(plugin = "net.bi4vmr.gradle.plugin.test2")
}
