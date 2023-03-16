import solutions.Task3Solution

fun testTask3() {
    println("-------task3-------")
    val testArrays = arrayOf(
        intArrayOf(1, 2, 4, 10, 7, 7, 4, 2, 1),
        intArrayOf(0),
        intArrayOf(1, 2, 4, 10, 7, 10, 8, 7, 4, 2, 1),
        intArrayOf(2, 1, 1),
        intArrayOf(1, 2, 3, 4),
        intArrayOf(),
        intArrayOf(9, 7, 6, 5, 4, 3, 2, 1),
        intArrayOf(9, 7, 6, 5, 4, 3, 2, 1, 0)
    )
    testArrays.forEach { testArray ->
        print("Test array:  ")
        testArray.forEach {
            print("$it ")
        }
        println()
        println("Answers")
        println(Task3Solution.notContains(testArray))
        println(Task3Solution.notContains1(testArray))
    }

}