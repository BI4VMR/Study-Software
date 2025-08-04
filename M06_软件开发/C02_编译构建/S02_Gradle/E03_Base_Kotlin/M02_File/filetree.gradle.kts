// 调用测试方法
example02()


/**
 * 示例二：FileTree的简单应用。
 *
 * 在本示例中，我们创建一个FileTree实例并指定参考目录，查看其匹配到的文件。
 */
fun example02() {
    // 创建FileTree实例，指定根目录为 `<当前模块>/testFiles/` 。
    val baseDir = "${layout.projectDirectory}${File.separator}testFiles"
    val tree: FileTree = fileTree(baseDir)
    // 查看匹配到的文件
    tree.forEach { file ->
        println("${file.path}")
    }
}


/**
 * 示例三：FileTree的筛选规则。
 *
 * 在本示例中，我们创建一个FileTree实例并指定筛选规则，查看其匹配到的文件。
 */
fun example03() {
    // 设置过滤规则
    val filter: List<String> = listOf(
        "10?.log",
        "**/*Test*",
    )

    // 创建FileTree实例，指定根目录为 `<当前模块>/testFiles/` 。
    val baseDir = "${layout.projectDirectory}${File.separator}testFiles"
    val tree: FileTree = fileTree(baseDir) {
        // 筛选命中规则的文件
        include(filter)
    }
    // 查看匹配到的文件
    tree.forEach { file ->
        println("${file.path}")
    }
}


/**
 * 示例四：设置过滤规则后再添加部分特定文件。
 *
 * 有时我们希望排除特定目录中的大多数文件，但又要求保留特定的文件，通过配置FileTree可以达到此目的。
 *
 * 在本示例中，我们希望排除测试目录下的所有Log文件，但需要保留 `20250701.log` 。
 *
 * 第一步，我们了解一种常见的错误用法。
 */
fun example04_1() {
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
 * 第二步，我们提供一种正确用法。
 */
fun example04_2() {
    val baseDir = "${layout.projectDirectory}${File.separator}testFiles"
    // 分别使用排除和包含规则创建FileTree实例，再将二者合并。
    val tree: FileTree = fileTree(baseDir) { exclude("*.log") } +
            fileTree(baseDir) { include("20250701.log") }
    // 查看匹配到的文件
    tree.forEach {
        println("${it.path}")
    }
}
