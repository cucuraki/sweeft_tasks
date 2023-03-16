import solutions.Task2Solution

fun testTask2() {
    println("-------task2-------")
    val testArrays = intArrayOf(1, 2, 3, 4, 5, 20, 80, 123, 157, 1276, 129928)
    testArrays.forEach {
        print("Input:  ")
        print(it)
        println()
        println("Answers")
        println(Task2Solution.minSplit(it))
    }

}