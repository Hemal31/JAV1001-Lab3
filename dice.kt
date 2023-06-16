import kotlin.random.Random

class Die(
    var type: String = "d6",
    var numSides: Int = 6,
    var currentSideUp: Int = 1
) {
    init {
        roll()
    }

    fun roll() {
        currentSideUp = Random.nextInt(1, numSides + 1)
    }

    override fun toString(): String {
        return "$type ($numSides sides): $currentSideUp"
    }
}

class DiceGame {
    fun run() {
        // Create different sized dice using each constructor
        val die1 = Die()
        val die2 = Die("d12", 12) // Pass "d12" as a string instead of 12
        val die3 = Die("d20", 20)

        // Roll the dice and display their results (before and after)
        println("Initial dice values:")
        println(die1)
        println(die2)
        println(die3)

        die1.roll()
        die2.roll()
        die3.roll()

        println("\nDice values after rolling:")
        println(die1)
        println(die2)
        println(die3)

        // Choose one Die object and set it to show its highest value
        die1.currentSideUp = die1.numSides

        println("\nDie 1 after setting it to show the highest value:")
        println(die1)

        // Create 5 six-sided dice. Roll each Die in a loop until you get 5 of a kind. Count and display the number of rolls.
        val fiveOfAKind = 5
        val targetValue = 6

        val dice = Array(fiveOfAKind) { Die() }
        var rolls = 0

        do {
            rolls++
            dice.forEach { it.roll() }
        } while (dice.any { it.currentSideUp != targetValue })

        println("\nNumber of rolls to get $fiveOfAKind $targetValue's: $rolls")
    }
}

fun main() {
    val game = DiceGame()
    game.run()
}