package Day7

import java.io.File



var allDirs: MutableList<Directory> = mutableListOf()


data class DirectoryFile(val size:Int, val name: String)
class Directory (name: String, parentDir: Directory?) {

    var dirName= name
    var files: MutableList<DirectoryFile> = mutableListOf()
    var subdirectories: MutableList< Directory> = mutableListOf()
    var parent: Directory? =parentDir

    fun getSubdirectory(dName: String):Directory{
        return this.subdirectories.first{it.dirName==dName}
    }

    override fun toString(): String {
        var retval:String = " Directory(dirName='$dirName', files=$files size:"+ filesSize()+ "\n"
        if (subdirectories.isNotEmpty()) {
            retval += " subdirs:\n"
            subdirectories.forEach{
                retval += "dir    $it"
            }
        }
        return retval
    }

    fun filesSize():Int {
        var thisSize =  files.sumOf{it.size}
        var subsSize = subdirectories.sumOf{ it.filesSize()}
        println ("dirName: ${dirName}, thisSize: $thisSize, subSize: $subsSize")

        return (subsSize+thisSize)
    }
}

fun main(args: Array<String>) {

    var root = Directory("/", null)
    var current:Directory = root


    val test:String = "/Users/root1/Library/Application Support/JetBrains/IntelliJIdea2022.3/scratches/day7realInput.txt"
    var fileContent: List<String> = File(test).readLines()

    fileContent.forEach {
        val line = it.split(" ")
        println("line:$line")
        val first = line.get(0)
        if (first.equals("$")) {//command mode
            // get the command
            val second = line.get(1)
            if (second.equals("cd")) {// change directory
                val third = line.get(2)
                if (third.equals("..")) {
                    current = current.parent ?: root
                } else {
                    if (third.equals("/")) {
                        current= root
                    } else {

                        // assume a subdirectory name
                        current = current.getSubdirectory(third)
                    }
                }
            }
        } else {
            if (first.equals("dir")) {
                // add a subdirectory
                val dirName = line.get(1)
                val dir:Directory = Directory(dirName, current)
                current.subdirectories.add(dir)
                allDirs.add(dir)
            } else {
                // must be a file
                current.files.add(DirectoryFile(first.toInt(), line.get(1)))
            }
        }
        // recalculate file sizes:

    }

    println(root.toString())
    println(root.filesSize())

    val free = 7_000_0000 - root.filesSize()
    println("free: $free")
    val required = 30_000_000-free
    println("required: $required")
    println(allDirs.filter {it.filesSize() > required}.sortedBy { it.filesSize() }.first().filesSize())

}