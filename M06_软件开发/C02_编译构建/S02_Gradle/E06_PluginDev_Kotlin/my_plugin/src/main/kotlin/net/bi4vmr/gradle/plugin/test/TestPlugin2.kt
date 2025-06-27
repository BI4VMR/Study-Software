package net.bi4vmr.gradle.plugin.test

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 插件：测试。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
class TestPlugin2 : Plugin<Project> {

    /**
     * 插件被模块应用时该方法将被回调，我们需要在此处编写插件逻辑。
     *
     * @param[target] 当前模块。
     */
    override fun apply(target: Project) {
        println("TestPlugin2 -> Apply on project:[${target.name}]")
    }
}
