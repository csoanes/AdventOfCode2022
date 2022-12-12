package Day1

import java.io.File

fun main(args: Array<String>) {
    println("Hello World!")


    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    val test:String = "/Users/root1/Library/Application Support/JetBrains/IntelliJIdea2022.3/scratches/day1data.txt"
    val fileContent: List<String> = File(test).readLines()
    var caloriesList: MutableList<String> = mutableListOf<String>();
    fileContent.forEach {
        println(it)
        caloriesList.add(it)
    }

    println(caloriesList)
    var totalsList: MutableList<Int> = mutableListOf<Int>();
    var currSum=0;
    for (i in caloriesList.indices) {
        val current = caloriesList.get(i)
        if (!current.isNullOrBlank())
            currSum = currSum + current.toInt();
        else {
            totalsList.add(currSum);
            currSum=0;
        }
    }
    totalsList.add(currSum)
    println(totalsList)
    var largest = totalsList[0]
    var second = 0;
    var third = 0;


    for (num in totalsList) {
        if (largest < num) {
            third = second;
            second = largest
            largest = num
        }
        else if (second < num) {
            third=second
            second=num
        }
        else if (third < num)
            third = num
    }

    println("Largest element = %d".format(largest+second+third))
}