import solutions.Task4Solution

fun testTask4() {
    println("-------task4-------")
    val testArrays = arrayOf(
        arrayOf<String>("0", "0"),
        arrayOf("1", "1"),
        arrayOf("1", "0"),
        arrayOf("0", '1'),
        arrayOf("1010", "1111"),
        arrayOf("111", "1111"),
        arrayOf("1010", "1011")
        )
    testArrays.forEach {
        print("Input:  ")
        print("${it[0]} + ${it[1]}")
        println()
        println("Answers")
        println(Task4Solution.add(it[0].toString(), it[1].toString()))
    }

}