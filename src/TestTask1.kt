import solutions.Task1Solution

fun testTask1() {
    println("-------task1-------")
    val testArrays = arrayOf(
        intArrayOf(1, 2, 4, 10, 7, 7, 4, 2, 1),
        intArrayOf(0),
        intArrayOf(1, 2, 4, 10, 7, 10, 8, 7, 4, 2, 1),
        intArrayOf(2, 1, 1)
    )
    testArrays.forEach { testArray ->
        print("Test array:  ")
        testArray.forEach {
            print("$it ")
        }
        println()
        println("Answers")
        println(Task1Solution.singleNumber(testArray))
        println(Task1Solution.singleNumber2(testArray))
        println(Task1Solution.singleNumber3(testArray))
    }

}