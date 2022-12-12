package Day4

import Day3.Rucksack
import java.io.File


class Section{
    val start: Int
    val end: Int

    constructor(start: Int, end: Int) {
        this.start = start
        this.end = end
    }

    fun contains(other: Section) :Boolean {
        //is our section fully contained by the other section, or vice versa?
        if (this.start==other.start || this.end==other.end) return true
        if (this.start>=other.start) {
            if (this.end <= other.end)
                return true
        }
        else {
            if (this.end >= other.end)
                return true
        }
        return false
    }

    fun overlaps(other: Section) : Boolean {
        if (this.start < other.start && this.end < other.start) return false
        if (this.start > other.end) return false
        return true
    }

    override fun toString(): String {
        return "Section(start=$start, end=$end)"
    }


}

data class Pair(val first:Section, val second: Section)
fun main(args: Array<String>) {
    val testSection1: Section = Section(48,58)
    val testSection2: Section = Section(48,53)


    println("Test: $testSection1, $testSection2, " +testSection1.contains(testSection2))


    val test:String = "/Users/root1/Library/Application Support/JetBrains/IntelliJIdea2022.3/scratches/day4realinput.txt"
    val fileContent: List<String> = File(test).readLines()
    var pairsList: MutableList<Pair> = mutableListOf<Pair>();
    fileContent.forEach {
        // strip out the square brackets
        val pair = it.replace("[","").replace("]","")
        val pairs = pair.split(",")
        val pair1 = pairs[0].split("-")
        val pair2 = pairs[1].split("-")
        pairsList.add(Pair(Section(pair1[0].toInt(),pair1[1].toInt()),Section(pair2[0].toInt(), pair2[1].toInt())))
    }
    var containers:Int=0
    pairsList.forEach(){
        print(it)
        println(it.first.contains(it.second))
        if (it.first.contains(it.second)) containers++
    }
    println(containers)
    var overlappers: Int =0
    pairsList.forEach() {
        if (it.first.overlaps(it.second)) overlappers++
    }
    println(overlappers)
}