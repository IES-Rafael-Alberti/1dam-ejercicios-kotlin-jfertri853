/*Escribir un programa que pregunte al usuario los números ganadores de la lotería primitiva,
los almacene en una lista y los muestre por pantalla ordenados de menor a mayor.*/

fun enterLotteryNumber(ticket: List<Int>): Int {
    /**
     *
     */
    print("Introduce un número de lotería (1-49)")
    val num = askForNumber()

    if (num < 1 || num > 49) {
        throw NumberFormatException("El número de lotería debe estar entre 1 y 49.")
    } else if (num in ticket) {
        throw NumberFormatException("Un mismo boleto no puede tener números repetidos.")
    }

    return num
}

fun enterRefundNumber(): Int {
    /**
     *
     */
    print("Introduce el número de reintegro (0-9): ")
    val num = askForNumber()

    if (num < 0 || num > 9) {
        throw NumberFormatException("El número de reintegro debe estar entre 0 y 9.")
    }

    return num
}

fun createTicket(): MutableList<Int> {
    /**
     *
     */
    val ticket = mutableListOf<Int>()
    var counter = 0

    while (counter < 6) {
        try {
            ticket.add(enterLotteryNumber(ticket))
            counter++
        } catch (e: IllegalArgumentException) {
            println("**ERROR** - ${e.message}")
        }
    }

    var refund = false
    while (!refund) {
        try {
            ticket.add(enterRefundNumber())
            refund = true
        } catch (e: IllegalArgumentException) {
            println("**ERROR** - ${e.message}")
        }
    }

    return ticket
}

fun orderTicket(ticket: MutableList<Int>): List<Int> {
    /**
     *
     */
    var total = ticket.size - 2
    var exchanges: Int? = null
    var counter = 0

    while (counter != ticket.size && exchanges != 0) {
        exchanges = 0

        for (i in 0 until total) {
            if (ticket[i] > ticket[i + 1]) {
                val higher = ticket[i]
                ticket[i] = ticket[i + 1]
                ticket[i + 1] = higher
                exchanges++
            }
        }

        total--
        counter++
    }

    return ticket
}

fun showTicket(ticket: List<Int>) {
    /**
     *
     */
    println("Tu boleto:")
    for ((position, num) in ticket.withIndex()) {
        if (position < 5) {
            print("$num - ")
        } else {
            println(num)
        }
    }
    println("Reintegro: ${ticket[6]}")
}

fun ud3ListasyTuplasEj4() {
    val boletoGanador = orderTicket(createTicket())
    showTicket(boletoGanador)
}


/*Escribir un programa que almacene las asignaturas de un curso
(por ejemplo Matemáticas, Física, Química, Historia y Lengua) en una lista,
pregunte al usuario la nota que ha sacado en cada asignatura y elimine de la lista las asignaturas aprobadas.
Al final el programa debe mostrar por pantalla las asignaturas que el usuario tiene que repetir.*/

fun askForGrade(subject: String): Double {
    /**
     *
     */
    print("Introduce la nota de $subject: ")
    return readln().toDouble()
}


fun validateGrade(nota: Double): Boolean {
    /**
     *
     */
    return nota in 0.0..10.0
}


fun putGrades(subjects: List<String>): List<Double> {
    /**
     *
     */
    val grades = mutableListOf<Double>()
    for (pos in subjects.indices) {
        val nota = askForGrade(subjects[pos])
        if (validateGrade(nota)) {
            grades.add(nota)
        } else {
            throw IllegalArgumentException("Alguna de las notas introducidas no es válida.")
        }
    }
    return grades
}


fun showList(subjects: List<String>) {
    /**
     *
     */
    for (pos in subjects.indices) {
        print(if (pos != subjects.size - 1) "${subjects[pos]}, " else subjects[pos])
    }
}


fun deletePassedSubjects(subjects: MutableList<String>, grades: List<Double>): MutableList<String> {
    /**
     *
     */
    val indicesToDelete = mutableListOf<Int>()

    for (pos in subjects.indices) {
        if (grades[pos] >= 5) {
            indicesToDelete.add(pos)
        }
    }

    for (i in indicesToDelete.reversed()) {
        subjects.removeAt(i)
    }

    return subjects
}


fun ud3ListasyTuplasEj6() {
    var subjects = listOf("Matemáticas", "Química", "Historia", "Lengua")
    var grades = emptyList<Double>()

    var notasEvaluadas = false
    while (!notasEvaluadas) {
        try {
            grades = putGrades(subjects)
            notasEvaluadas = true
        } catch (e: IllegalArgumentException) {
            println("**ERROR** - ${e.message}")
        }
    }

    subjects = deletePassedSubjects(subjects.toMutableList(), grades)
    println("Tienes que recuperar:")
    showList(subjects)
}


/*Escribir un programa que pida al usuario una palabra y muestre por pantalla si es un palíndromo.*/

fun askForWord(): List<Char> {
    /**
     *
     */
    print("Introduce una palabra: ")
    val word = readln()
    return word.toList()
}


fun isPalindrome(word: List<Char>, reversedWord: List<Char>): Boolean {
    /**
     *
     */
    return word == reversedWord
}


fun ud3ListasyTuplasEj8() {
    val word = askForWord()
    val reversedWord = word.reversed()

    if (isPalindrome(word, reversedWord)) {
        println("Es palíndromo")
    } else {
        println("No es palíndromo")
    }
}


/*Escribir un programa que pida al usuario una palabra
y muestre por pantalla el número de veces que contiene cada vocal.*/

fun countVowelRepetition(letters: List<Char>, word: String): ArrayList<String> {
    /**
     *
     */
    val vowelsCounting: ArrayList<String> = ArrayList()

    for (letter in letters) {
        val count = word.count {it == letter}
        if (count == 1) {
            vowelsCounting.add("$letter se repite $count vez en la palabra $word")
        } else if (count > 1) {
            vowelsCounting.add("$letter se repite $count veces en la palabra $word")
        }
    }

    return vowelsCounting
}


fun ud3ListasyTuplasEj9() {
    print("Introduce una palabra: ")
    val word = readln().lowercase()

    val vowelCount = countVowelRepetition(letters = listOf('a', 'e', 'i', 'o', 'u'), word)

    for (i in vowelCount) {
        println(i)
    }
}