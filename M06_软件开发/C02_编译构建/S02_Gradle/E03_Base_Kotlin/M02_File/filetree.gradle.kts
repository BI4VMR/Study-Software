// 调用测试方法
example01()


/**
 * 示例一：FileTree的简单应用。
 *
 * 在本示例中，我们创建一个FileTree实例并指定参考目录，查看其匹配到的文件。
 */
fun example01() {
    // 创建FileTree实例，指定根目录为 `<当前模块>/testFiles/` 。
    val baseDir = "${layout.projectDirectory}${File.separator}testFiles"
    val tree: FileTree = fileTree(baseDir)
    // 查看匹配到的文件
    tree.forEach { file ->
        println("${file.path}")
    }
}

fun example02() {
    // 设置过滤规则
    val filter: List<String> = listOf(
        "10?.log",
        "**/*Test*",
    )

    // 创建FileTree实例，指定根目录为 `<当前模块>/testFiles/` 。
    val baseDir = "${layout.projectDirectory}${File.separator}testFiles"
    val tree: FileTree = fileTree(baseDir) {
        // 保留命中规则的文件
        include(filter)
    }
    // 查看匹配到的文件
    tree.forEach {
        println("${it.path}")
    }
}

/**
 * 排除测试目录下的所有Log文件，但要保留 `20250701.log` 。
 */
fun example03() {
    val baseDir = "${layout.projectDirectory}${File.separator}testFiles"
    val tree: FileTree = fileTree(baseDir) {
        include("20250701.log")
        exclude("*.log")
    }
    // 查看匹配到的文件
    tree.forEach {
        println("${it.path}")
    }
}

/**
 * 排除测试目录下的所有Log文件，但要保留 `20250701.log` 。
 */
fun example03_2() {
    val baseDir = "${layout.projectDirectory}${File.separator}testFiles"
    // 分别使用排除和包含规则创建FileTree实例，再将二者合并。
    val tree: FileTree = fileTree(baseDir) { exclude("*.log") } +
            fileTree(baseDir) { include("20250701.log") }
    // 查看匹配到的文件
    tree.forEach {
        println("${it.path}")
    }
}
