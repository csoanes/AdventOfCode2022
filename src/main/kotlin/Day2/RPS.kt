package Day2

import java.io.File

enum class RPS {
    ROCK, PAPER, SCISSORS, INVALID
}

enum class WLD {
    WIN, LOSE, DRAW
}

fun convertToRPS (input: Char): RPS {
    var lcinput = input.toLowerCase()
    var out = when(lcinput) {
        'a' -> RPS.ROCK
        'x' -> RPS.ROCK
        'b' -> RPS.PAPER
        'y' -> RPS.PAPER
        'c' -> RPS.SCISSORS
        'z' -> RPS.SCISSORS
        else -> RPS.INVALID
    }
    return (out)
}

fun play (opponentPlay:RPS, yourPlay:RPS): Int {
    if (opponentPlay.equals(RPS.ROCK)) {
        if (yourPlay.equals(RPS.ROCK)) {
            println("Rock vs Rock, draw")
            return 1+3
        } // draw
        if (yourPlay.equals(RPS.PAPER)) {
            println("Paper wraps Rock, win")
            return 2+6
        } // win
        if (yourPlay.equals(RPS.SCISSORS)) {
            println("Rock Blunts Scissors, lose")
            return 3+0
        } //lose
    } else {
        if (opponentPlay.equals(RPS.PAPER)) {
            if (yourPlay.equals(RPS.ROCK)) {
                println("Paper wraps Rock, lose")
                return 1 + 0
            } // loss
            if (yourPlay.equals(RPS.PAPER)) {
                println("Paper vs Paper, draw")
                return 2 + 3
            } // draw
            if (yourPlay.equals(RPS.SCISSORS)) {
                println("Scissors cut Paper, win")
                return 3 + 6
            } //win
        }
        else {
            if (opponentPlay.equals(RPS.SCISSORS)) {
                if (yourPlay.equals(RPS.ROCK)) {
                    println("Rock blunts Scissors, win")
                    return 1 + 6
                } // win
                if (yourPlay.equals(RPS.PAPER)) {
                    println("Scissors cut Paper, lose")
                    return 2 + 0
                } // loss
                if (yourPlay.equals(RPS.SCISSORS)) {
                    println("Scissors vs Scissors, draw")
                    return 3 + 3
                } //draw
            }
        }
    }
    return 0
}

fun chooseLose(opponentPlay: RPS):String {
    return when (opponentPlay) {
        RPS.ROCK -> "Z"
        RPS.PAPER -> "X"
        RPS.SCISSORS -> "Y"
        RPS.INVALID -> "V"
    }
}

fun chooseWin(opponentPlay: RPS):String {
    return when (opponentPlay) {
        RPS.ROCK -> "Y"
        RPS.PAPER -> "Z"
        RPS.SCISSORS -> "X"
        RPS.INVALID -> "V"
    }
}


fun chooseDraw(opponentPlay: RPS):String {
    return when (opponentPlay) {
        RPS.ROCK -> "X"
        RPS.PAPER -> "Y"
        RPS.SCISSORS -> "Z"
        RPS.INVALID -> "V"
    }
}


fun main(args: Array<String>) {
    val test:String = "/Users/root1/Library/Application Support/JetBrains/IntelliJIdea2022.3/scratches/day2realinput.txt"
    val fileContent: List<String> = File(test).readLines()
    var playList: MutableList<String> = mutableListOf<String>();
    fileContent.forEach {
        println(it)
        playList.add(it)
    }
    var score: Int=0
    playList.forEach {
        val plays =it.split(' ')
        val oppo = convertToRPS( plays[0][0]?:'o')
        val you = plays[1][0]?:'o'
        val yourPlay = when (you) {
            'X' -> chooseLose(oppo)
            'Z' -> chooseWin(oppo)
            else -> chooseDraw(oppo)
        }
        score += play(oppo, convertToRPS(yourPlay[0]))
    }
    println(score)
}