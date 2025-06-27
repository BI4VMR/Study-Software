plugins {
    kotlin("jvm")
    // 声明Jacoco插件
    id("jacoco")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.21")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

    testImplementation("junit:junit:4.13.2")
}

// Jacoco配置
jacoco {
    // 指定Jacoco版本
    toolVersion = "0.8.13"
    // 指定报告输出目录
    reportsDirectory = layout.buildDirectory.dir("jacocoReports")
}

// 在Gradle Test任务执行后自动执行Jacoco任务
tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)

    // 设置排除项
    classDirectories.setFrom(
        files(
            classDirectories.files.map {
                fileTree(it) {
                    // exclude(
                    //     "net/**",
                    // )
                }
            }
        )
    )
}
