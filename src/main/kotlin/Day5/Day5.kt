package Day5

import Day4.Pair
import Day4.Section
import java.io.File

class Stacks {
    var stacks: List<MutableList<Char>> = listOf(
        mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(),
        mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf()
    )

    fun initializeStacks (isTest: Boolean) {
        if (isTest) {
            stacks[0].addAll("ZN".toList())
            stacks[1].addAll("MCD".toList())
            stacks[2].addAll("P".toList())
        } else {
            stacks[0].addAll("GTRW".toList())
            stacks[1].addAll("GCHPMSVW".toList())
            stacks[2].addAll("CLTSGM".toList())
            stacks[3].addAll("JHDMWRF".toList())
            stacks[4].addAll("PQLHSWFJ".toList())
            stacks[5].addAll("PJDNFMS".toList())
            stacks[6].addAll("ZBDFGCSJ".toList())
            stacks[7].addAll("RTB".toList())
            stacks[8].addAll("HNWLC".toList())
        }
        println("Initialization complete")
        printStacks()
    }

    fun printStacks() {
        // find length of the highest stack
        var maxLength: Int = 0
        stacks.forEach {
            if (it.size > maxLength) maxLength = it.size
        }
        for (i in maxLength downTo 1) {
            stacks.forEach {
                if (it.size >= i) print("[" + it.get(i - 1) + "] ")
                else print("    ")
            }
            println()
        }
        println("====================================")
    }

    fun move(source:Int, destination:Int, amount: Int) {
        println("moving: $amount from $source to $destination")
        for( i in amount downTo 1) {
            var top: Int = stacks[source-1].size-i
            val moving:Char = stacks[source-1].removeAt(top)
            stacks[destination-1].add(moving)
            printStacks()
        }
        println("Move Complete!")
    }
}

data class Move(val number: Int, val source: Int, val destination: Int)
fun main(args: Array<String>) {
    val heap: Stacks = Stacks()
    heap.initializeStacks(false)
    // test moves

    val test:String = "/Users/root1/Library/Application Support/JetBrains/IntelliJIdea2022.3/scratches/day5input.txt"
    val fileContent: List<String> = File(test).readLines()
    var moveList: MutableList<Move> = mutableListOf<Move>();
    fileContent.forEach {
        // strip out the square brackets
        val spl = it.split(' ')
        moveList.add(Move(spl[1].toInt(), spl[3].toInt(), spl[5].toInt()))
    }
    moveList.forEach {
        println("Move " + it.number + " from " + it.source + " to " + it.destination)
        heap.move(it.source, it.destination, it.number)
    }
}

