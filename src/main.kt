fun main() {
    val leonardoAccount = Account(holder = "Leonardo", number = 1001)
    val pauloAccount = Account(holder = "Paulo", number = 1002)

    println("\n** Welcome to ByteBank **")
    println()

    println("Holder: ${leonardoAccount.holder}")
    println("Number: ${leonardoAccount.number} ")
    println("Balance: ${leonardoAccount.balance}")
    println("----------------------------------------")

    println("Performing a deposit in Leonardo account...")
    if (leonardoAccount.deposit(100.00)) {
        println("Performed successfully.")
    } else {
        println("The operation failed, to complete the operation you may put a positive value")
    }
    println("Current balance: $ ${leonardoAccount.balance} ")
    println("---------------------------------")

    println("Performing a withdraw...")
    if (leonardoAccount.withDraw(50.00)) {
        println("Performed successfully.")
    } else {
        println("The operation failed, insufficient funds")
    }
    println("Current balance: $ ${leonardoAccount.balance} ")
    println("---------------------------------")

    println("Performing a transfer to Paulo Account...")
    if (leonardoAccount.transfer(30.00, pauloAccount)) {
        println("Performed successfully.")
    } else {
        println("The operation failed, insufficient funds")
    }
    println("Current balance: $ ${leonardoAccount.balance} ")
    println("---------------------------------")

    println("\n** Welcome to ByteBank **")
    println()

    println("Holder: ${pauloAccount.holder}")
    println("Number: ${pauloAccount.number} ")
    println("Balance: ${pauloAccount.balance}")
}


class Account(val number: Int, val holder: String) {
    var balance = 0.0
        private set

    fun deposit(value: Double): Boolean {
        return if (value > 0) {
            balance += value
            true
        } else {
            false
        }

    }

    fun withDraw(value: Double): Boolean {
        return if (value <= balance) {
            balance -= value
            println("Drawing value: $ $value")
            true
        } else {
            false
        }
    }

    fun transfer(value: Double, destiny: Account): Boolean {
        return if (value <= balance) {
            balance -= value
            println("Value of transfer: $ $value")
            destiny.deposit(value)

            true
        } else {
            false
        }

    }


///////////////////////////////////////////////

    // Print sequence of number 1 to 5
    fun testFor() {
        for (i in 1..5) {
            println(i)

        }
    }

    // Print 100 lines with one "i" and 5 "j"
    fun testMultipleFor() {
        for (i in 1..100) {
            print("i")
            for (j in 1..5)
                print("j")
            println()
        }
    }

    // Leaving at the first looping.
    fun testForLoop() {

        loop@ for (i in 0..100) {
            println("i $i")
            for (j in 1..100) {
                println("j $j")
                if (j == 5) break@loop
            }
        }
    }

    // Print status Balance
    fun testBalanceStatus() {

        when {
            balance > 0.0 -> println("Your balance is positive")
            balance == 0.0 -> println("Your balance is neutral")
            else -> println("Your balance is negative")

        }
    }

}



