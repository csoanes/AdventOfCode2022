package Day3

import java.io.File

class Rucksack {
    val compartment1: String
    val compartment2: String
    val both: String

    constructor (items: String) {
        both = items
        var len = items.length;
        compartment1=items.substring(0, len/2)
        compartment2=items.substring((len/2), len)
    }

    fun diagOutput () {
        println("Compartment 1: " + compartment1)
        println("Compartment 2: " + compartment2)
    }

    fun sharedItemPriority():Int {
        for (item in compartment1) {
            if (compartment2.indexOf(item)!=-1) {
                var priority = item.toInt()-96
                if (priority <= 0) priority += 58
                return priority
            }
        }
        return 0
    }
}

fun sharedItemsPriority(sacks: List<Rucksack>):Int {
    for (item in sacks[0].both) {
        if (sacks[1].both.contains(item)) {
            if (sacks[2].both.contains(item)) {
                var priority = item.toInt() - 96
                if (priority <= 0) priority += 58
                return priority
            }
        }
    }
    return 0
}
 fun main(args: Array<String>) {
     // test split
     val testrucksack:Rucksack = Rucksack("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL")
     testrucksack.diagOutput()
     println(testrucksack.sharedItemPriority())
     println('a'.toInt()-96)
     println('A'.toInt()-96)
     val test:String = "/Users/root1/Library/Application Support/JetBrains/IntelliJIdea2022.3/scratches/day3realinput.txt"
     val fileContent: List<String> = File(test).readLines()
     var rucksackList: MutableList<Rucksack> = mutableListOf<Rucksack>();
     fileContent.forEach {
         println(it)
         rucksackList.add(Rucksack(it))
     }
     var sum: Int =0
     rucksackList.forEach {
         sum+= it.sharedItemPriority()
     }
     println(sum)
     val rucksackIterator = rucksackList.iterator()
     var sumOfGroupPriorities: Int = 0
     while (rucksackIterator.hasNext()) {
         val group = listOf(rucksackIterator.next(), rucksackIterator.next(), rucksackIterator.next())
         val groupPriority: Int = sharedItemsPriority(group);
         println("groupsharedval: "+ group)
         sumOfGroupPriorities += groupPriority

     }
     println(sumOfGroupPriorities)
 }