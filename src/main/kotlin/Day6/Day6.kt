package Day6

import Day5.Move
import Day5.Stacks
import java.io.File


fun findDelimiter( input: List<Char>) {

    for (count in 14..input.lastIndex) {
        val sublist = input.subList(count-14, count)
        val theMutableSet:MutableSet<Char> = mutableSetOf()
        sublist.forEach {
            theMutableSet.add(it)
        }
        println(sublist)
        print(theMutableSet)
        println(":"+theMutableSet.size)
        if (theMutableSet.size>=14) {
            println(" "+(count))
            break
        }
    }
}
fun main(args: Array<String>) {
    val test1 = "mjqjpqmgbljsphdztnvjfqwrcgsmlb".toList()
    val test2 = "bvwbjplbgvbhsrlpgdmjqwftvncz".toList()
    val test3 = "nppdvjthqldpwncqszvftbrmjlhg".toList()
    val test4 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg".toList()
    val test5 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw".toList()
    val real = "dvgdvvbpbtbhbdhbhmmmcctmcmccggtrgghnhmnnqffpcprrqssnhsnhnshhsrsqqhchcdcfcqqcncrrzpppmzpzzhjzzzvrvnnpbpzzswzwswnngjgjgcjcfcllhffjbfjfhhppvnppfmfcmmcnnmnfnzfnzffphpnnnsvswvvnwnfntftjftfvvztzqzhzddttjpjbpphhlnnwgnwggdmmczclczzqddlcdldrlrccfflwwgqwwrjwrwzrrsdrrfssddcmmvrvlvhvfhfzhzbhbzzdmdvvsppwswmwdwjjzmzhhvghgthghvvtcthcttgsttpqpbbhthppzznntpnttshtshthhwrrgbbjzbjblblzbllcblcblbvvqfqqnjqqhfhftftwfftvvmddgzzmdzmdmtttttqmqmnqmqpmqpqqjlldpllfvlffjdfjjvlvjjjjbsjbjnnhmnhnrrwtrrfvvtppwmmpnnjbnjjcncjcttrcrjjlqjljccpzccvqvzzscctgccsmmnznhzhnnjggmjgmgjgtgtlgglhhrlhhrvhvrvtvvlvvwmmrjjzqqbzqqtgtzgttmgggwpgwgbwggwwprwwvswszznczncnccjnccjdjdjssqmmgcmcjmmhwhswhwdwrddtccmzmjmsmrmrddhrhhqbbspbsppqvqmvqmmclcddzjzvvslsffdhhqgqrqjrqjqjrrmpmrppcjpjffwhfwwppqvvzjzqqtftgfghgpglgnglldlvvwzwmmfzzhzmzhhswhhnvhvphpmphphrrwwfccmgmqgmmzgmgngznnzbzttjwttgngzzdndffwhfwhhlmllwqlwwgfgfpfnnldnldndbdcdddmbdmbbdpbpwbpptrrpggtrtrnttsmmcrmmlhltlgttblttbhttjzzvnnsbsqbqwbbtwtmtbbcjcljjslscswwglgqlgqgmmcpctcrttprpjjfvjfjqqljlvjljnnfhhfzhzmhmghhjnhjjbppmqqwlwswwgbbzszspzsppcscvvnhndhdwdmdrdssqrqdqsddnbnpplqppjbjdbdqdcccffsnntzntnmnlnbbrzzzvgvvqttbbzpbzpzdpdvppjmjpjbbdrbbgwgffzpzzjddmldlwwjdwwscwcfccnznmmfttvvmpmvpmvmcvmmjmwjwbbwqwjjzqjzjbbjqbjqqqthhsssmrsshvvprvvwccjlcctwwmgwgpwgpgcpptrppjppltlhthctttfptppwgpwprpbbqzbzznssfcsffbnnndffqmmqwmmpvvpvdppjqqttfpttjccbnbddvtdvddlsstjtccphchsswbbrqqgtqgqpqjqnjjvccwscwssjwjttqvtvmtmjjghghccpnpsplslmmfjfjtffgtgrtrftfhttpsttzzmhmllwqwhhnffdpffwbwnnbrrfbrrnjrjlljqqnjqnqqwlqqbbbtvvwgvgbgddpwdwvdwvdvvwzvwwtzwttppnttqccjtjrttqbbprpsrpssfjsffmdfmfbmbggjhggcjgcgvvjqqbhbllhrlhlclzzplpqqdtddrhhfssdvsvrrscsjjnwjjfpjfffcbfcfmmlpmphhhlpltptcpttppfssppgwppjgjnnblbhbtbrbgbpplnlvlsvlvwvwpptmtsswzswsnscsfcsfsfggzhghvvgbbfddgbbrmrtrqtthvhzhzthtbtjjcljjlcllzglzzdszdzjzjfzzzblbslbljjdnndvvnwnqnwqqscscmczcwwvrrlclttbtdtvddbrddvllnppvpmvmbbvfvttfcttggwgffrfwwwpwcpchppcrrgprgprgrjgjdgdgvddzndzdbzzswsvvtgtccrrnggbwggpjpnnsjjwfjjqfqvffrrhdrrsfrfjjfzfdzzqfqwbztszjqtttfdqvzmznzjlsjnwdthtwdtfslgdmgfpwsqcsqdhnsnsmghttfvlzqgspzdtlstdmthzftwmnqrznldpmwqbtthggjwcgjjmbpqgrnwspggjvrlcmtvpchmqhlwwtswqgpdjpbznqnssqhdjzgbjnfmgssrvnmmcvvhgmcvqbfdhgrhnqqzdmttmdzwgtprzqhplwnhhmlrvcbwpllqprtltdvqrwhvwzvlqsvfqsfjwmrnzlqpdgfpmtfdczqdnfjjbjmrdnffcmtwlzcmvnwmlpmqhvggdhptnzlvzwzwjbcszsnzgpwncfgvzfgbzwclvrbmllzpltzwjrftmppsfwhvvvhvqjtstnnczgtdbmpjjsscbdwplftgcgmtrnrnzplzhghrqgdtjwntwfstjwqjjrlhtwhnfqwfqgsjptjfpsrbnvvlgsltnvtfvscttwvrfzblzmfmnfrlrnzrrzhclggtntpjbbcphdvrfhnrtzvdmwbwgbftgzwlcqztghdhdmzwlmjbgptfnnzbmwsnzlzcpprqzmbbdsplmhpgmzthqcsfjcnfbfvsdsqzfvfcnpgqsvpgwsdbgjmsglrwmfjfpddczwvgdppfmrtszbtfdwbmlmzhqvvwmvlzvjfpffjnhwwhssfjnbzlqwqvjbjbhfntmhgswntdpbzlwwfbdbhrfhzfjsjbtlrqhlnrpfbwtpmrfvbhlmmsgtvcmrqmdpwvhqfqpgmfgnfrbvprhprtnpzjcnltndfsvjgndwblhwphtpsmnczgbtpwdvjsrctjbvbfslvslzlwbtstqvgcrqmfphwztpjqdmvcjpjqmjbdndfpzwsfwplchsmqwwbggptjdtztszmpfwgfwnqpdwfcpgrrhmfglsctjllflfltbcfvcpfcnqbwrvzmcmjpwptgsrlbrdchngwsdstfmcbrqvdsvvbnppdmnfwcgvpjjzqwcpvqfncvqlsfnjzprvhpgqscshqwsttdrsmqjfwlhcwlvnzvgvclqfjdgctvsrbwzflcldmrwlfhbgdtstqsqlblndnpgqlfbjzslcpcwvdwdffshhrzvhqwdsdmwtmtvcnrhmstvrnscppmbpmjbfjhljmsjnbjlhjhmnmcvvfgbdrblwbzrcctrjwjjwjtgnfjhhqbsmdjvdrdjtjbscfrsljnvqjlgjwqrvfmdttsvqjwdbswdtcfqsrpbvzrbsdqlqfjlrgcwzbqtqrpsrfcmbzcvjngcsmvqlbnghllcqcztbtvdrfcmpgfdprghsmbjvzbdnrdqnjdzslclgdsqglvpvcjpzqfwztlssljtmcdfcqdnqzwcttvpqfdpvzlhjfvvsgphgqrmzppvnjznqmdzfnfztjppstjfwddftcpcjnssznqbrvlvrzfhbvsjrwghttwlwfrptsvsrwfnvjtthwrppbngbgqvbsdgcrjcwjjljcwptrvgmbjpjtdbmhmzcfhzbsbrmzhdsrjbbmnwbsntpffdrrlgcrcgbcfwvlpmrzvsmvpjthtdjdvcspdsdvshlrwzcqnjmcnrgzbqzhfzbmtrvzzmjwbnjggtrtgcsnrmzbtjzgdmffdntspdhgnvgrmpbtnsspcqhsrvppjbrmdbggjbftnnbrgdsmdscqthdzflldfnplqccthpwccsfsnstttwztqnmnfshntqngmcndbsbftmgnhhwjvhchdfqzzgpdnfgvnjzjzfdzvsvtdqqcftrvmdcszcwpfrbcsmlqqfprrjgncwcvcngmrnwntcvzzlnwrhrznnldslhqdscbgsrqnvnmdtqvlttwqljmvbpbfldtbgzhvwzghnhwrwdqphhhgjpnmtlcmvfbdffnsvcswtmffzsrvczbntfpdsmwbqphvvcflpwgsrmjhrljlvzdgrcwpfphmvtwqwhjmrvmjzjlzlbflhzrdrzcdwhblpqwjljbvprddtvnccmchgctncwbpnmlqppfmhwchvjvpmblqhccfhlprdrczdfhmnsqhddbqlppgsnvhhfrwhqhfdpvsfcvzbqhgswtmnpmzrwsvnmztnqwdrhllssmgtzbztsprpsj".toList()

    findDelimiter(test1)
    findDelimiter(test2)
    findDelimiter(test3)
    findDelimiter(test4)
    findDelimiter(test5)
    findDelimiter(real)

}