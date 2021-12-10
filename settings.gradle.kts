rootProject.name = "clob"

fun initializeProjects(vararg names: String) {
    val projectName = rootProject.name
    include(*names.map { "module-$it" }.toTypedArray())
    names.forEach { project(":module-$it").name = "$projectName-$it" }
}

initializeProjects("api","bootstrap","impl-base", "impl-jda","app")