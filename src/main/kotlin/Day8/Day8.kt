package Day8

import java.io.File
    data class Atree(val x:Int, val y:Int, val z: Int)
    val visible: MutableSet<Atree> = mutableSetOf()


    // read the input
    fun main(args: Array<String>) {

        val test:String = "/Users/root1/Library/Application Support/JetBrains/IntelliJIdea2022.3/scratches/day8realinput.txt"
        var fileContent: List<String> = File(test).readLines()
        val arraySize = fileContent.get(0).length
        var forest: Array<IntArray> = Array(arraySize) { IntArray(arraySize)}

        fun getScenicScore(x:Int, y:Int):Int {
            println("getting scenic score for block [$x][$y] ${forest[x][y]}")
            val maxXY = arraySize-1
            if (x < 1 || x > maxXY || y < 1 || y > maxXY) {
                println("Error: tree [$x][$y] to near and edge")
                return 0
            }
            // go up
            var scenicScoreUp =0

            var max = forest[x][y]
            println("Checking up")
            for (xup in x-1 downTo 0) {
                val current = forest[xup][y]
                println("Tree height at [$xup][$y] = $current: max=$max")
                scenicScoreUp++
                if (current >= max) break
            }

            println("Checking left")
            var scenicScoreLeft=0
            for (yleft in y-1 downTo 0) {
                val current = forest[x][yleft]
                println("Tree height at [$x][$yleft] = $current: max=$max")
                scenicScoreLeft++
                if (current >= max) break
            }

            println("Checking down")
            var scenicScoreDown=0
            for (xdown in x+1  .. maxXY) {
                val current = forest[xdown][y]
                println("Tree height at [$xdown][$y] = $current: max=$max")
                scenicScoreDown++
                if (current >= max) break
            }

            println("Checking right")
            var scenicScoreRight=0
            for (yright in y+1 .. maxXY) {
                val current = forest[x][yright]
                println("Tree height at [$x][$yright] = $current: max=$max")
                scenicScoreRight++
                if (current >= max) break
            }
            var final = scenicScoreUp*scenicScoreDown*scenicScoreLeft*scenicScoreRight
            println("Exploration complete: scores: $scenicScoreUp, $scenicScoreDown, $scenicScoreLeft, $scenicScoreRight :- final score $final")
            return final
        }
        var row =0

        fileContent.forEach {
            val line = it.split("")
            println(line)
            for (i in 0..arraySize-1){
                var num = line.get(i+1)
                forest[row][i]= if(num.isNotEmpty()) num.toInt() else  0
            }
            row++
        }
        // walk round the outside, looking in
        // left row:
        for (i in 0..arraySize-1) {
            for (j in 0 .. arraySize-1) {
                // is this tree Day8.getVisible from an edge horizontally
                val tree = Atree(i,j,forest[i][j])
                var visiblexdown: Boolean=true
                var visiblexup:Boolean=true
                var visibleydown: Boolean=true
                var visibleyup:Boolean=true
                for (k in j-1 downTo 0)
                    if (forest[i][k]>=tree.z)
                        visiblexdown=false
                for (k in j+1 .. arraySize-1)
                    if (forest[i][k]>=tree.z)
                        visiblexup=false
                for (k in i-1 downTo 0)
                    if (forest[k][j]>=tree.z)
                        visibleydown=false
                for (k in i+1 .. arraySize-1)
                    if (forest[k][j]>=tree.z)
                        visibleyup=false
                if (visiblexdown||visibleydown||visiblexup||visibleyup) visible.add(tree)
            }
        }
        for (i in forest.indices) {
            println(forest[i].contentToString())
        }

        var scenicScoreMax = 0
//        println(getScenicScore(1,2))
//        println(getScenicScore(3,2))

        for (x in 1 until arraySize) {
            for (y in 1 until arraySize) {
                val currentScore = getScenicScore(x, y)
                if (currentScore > scenicScoreMax) scenicScoreMax=currentScore
            }
        }
        println(visible.size)
        println(scenicScoreMax)
    }