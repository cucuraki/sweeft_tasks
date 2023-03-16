import datastructure.DoublyLinkedList
import datastructure.MyHashMap

fun testTask6() {
    println("------task6-----")
    println("Testing List")
    println("Initial values: 1, 7, 11, 67, 9, 12, 0, -7")
    val list = DoublyLinkedList<Int>(1, 7, 11, 67, 9, 12, 0, -7)
    print("List: ")
    list.forEach {
        print("$it  ")
    }

    println()
    println("Remove 1 and 67")
    list.remove(1)
    list.remove(11)
    print("List: ")
    list.forEach {
        print("$it  ")
    }
    println()
    println("Add 23 and 11")
    list.addAll(arrayListOf(23, 11))
    list.forEach {
        print("$it  ")
    }
    println()

    println("Testing Map")
    println("Initial values: 1 -> 7, 11 -> 67, 9 -> 12, 0 -> -7")
    val mp = MyHashMap<Int, Int>()
    mp.put(1, 7)
    mp.put(11, 67)
    mp.put(9, 12)
    mp.put(0, -7)
    print("Map: ")
    mp.forEach{
        print("$it, ")
    }
    println()
    println("Note that map is not ordered")
    println("Remove key 0")
    mp.remove(0)
    print("Map: ")
    mp.forEach{
        print("$it, ")
    }
    println()
    println("Change value at key 9 from 12 to 89")
    mp.put(9, 89)
    print("Map: ")
    mp.forEach{
        print("$it, ")
    }
    println()
}