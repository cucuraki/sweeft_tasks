import solutions.Task5Solution

fun testTask5() {
    println("-------task5-------")
    val testArrays = intArrayOf(
        1, 2, 3, 4, 5, 6, 7,
        8, 9, 10, 11, 12, 13,
        25, 26, 27, 39, 40, 41
    )

    testArrays.forEach {
        print("Input:  ")
        print(it)
        println()
        println("Answers")
        print("${Task5Solution.countVariants(it)}, ")
        print("${Task5Solution.countVariantsBinary(it)}")
        println()
    }

}