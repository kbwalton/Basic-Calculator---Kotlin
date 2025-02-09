import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val history = mutableListOf<Calculation>()

    println("Welcome to the Kotlin Calculator!")
    while (true) {
        print("Enter first number: ")
        val num1 = getValidNumber(scanner)

        print("Enter an operator (+, -, *, /, %, ^, r): ")
        val operator = getValidOperator(scanner)

        val num2 = if (operator == 'r') 0.0 else {
            print("Enter second number: ")
            getValidNumber(scanner)
        }

        val result = calculate(num1, num2, operator)
        println("Result: $result")

        history.add(Calculation(num1, num2, operator, result.toString()))

        print("Do you want to perform another calculation? (yes/no/history): ")
        val choice = scanner.next().lowercase()
        if (choice == "history") {
            printCalculationHistory(history)
        } else if (choice != "yes") {
            println("Goodbye!")
            break
        }
    }
}

fun printCalculationHistory(history: List<Calculation>) {
    println("Calculation History:")
    if (history.isEmpty()) {
        println("No calculations yet.")
    } else {
        history.forEachIndexed { index, calc ->
            println("${index + 1}: ${calc.num1} ${calc.operator} ${calc.num2} = ${calc.result}")
        }
    }}