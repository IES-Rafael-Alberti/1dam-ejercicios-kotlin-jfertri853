/*Escribir un programa que pregunte al usuario su edad y muestre por pantalla todos los años que ha cumplido
(desde 1 hasta su edad).*/

/**
 * comprueba que una edad esté dentro de un rango y devuelve la edad si está o lanza una excepción si no
 *
 * @param min Int - Valor mínimo que puede tener la edad
 * @param max Int - Valor máximo que puede tener la edad
 * @param age Int - La edad
 *
 * @return Int - La edad
 */
fun verifyAge (min: Int, max: Int, age: Int): Int {
    when {
        age < min -> {throw NumberFormatException("No puedes tener menos de $min años")}
        age > max -> {throw NumberFormatException("No tienes más de $max años, no mientas")}
        else -> return age
    }
}


/**
 * Pide un numero al usuario, lo convierte a entero y lo devuelve
 *
 * @return Int - el numero introducido por el usuario
 */
fun askForNumber (): Int {
    print(": ")
    return readln().toInt()
}


/**
 * Recibe una edad y muestra todos los numeros desde el 1 hasta el recibido separados por guión
 *
 * @param age Int - La edad del usuario
 */
fun ageCount(age: Int) {
    val count = Array(size = age + 1){it}
    for (number in count) {
        when (number) {
            age -> print("$number.")
            else -> print("$number - ")
        }
    }
}


fun ud2IterativasEj2() {
    var age: Int?

    do {
        print("Introduce tu edad (1 - 125)")
        try {
            age = askForNumber()
            verifyAge(min = 0, max = 125, age)
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
            age = null
        }
    } while (age == null)

    ageCount(age)
}


/*Escribir un programa que pida al usuario un número entero positivo y muestre por pantalla la cuenta atrás
desde ese número hasta cero separados por comas.*/

/**
 * Comprueba si un numero es positivo
 *
 * @param number Int - Un numero
 *
 * @return Boolean - Devuelve verdadero si el numero es positivo o falso si no lo es
 */
fun isPositive(number: Int): Boolean {
    return number >= 0
}


/**
 * Recibe un numero y muestra todos los numeros desde el recibido hasta 0 separados por coma
 *
 * @param number Int - Un numero positivo
 */
fun countdown(number: Int) {

    if (!isPositive(number)) {
        throw NumberFormatException("No se como pero has metido un numero negativo")
    }

    val count = Array(size = number + 1){number - it}
    for (i in count.indices) {
        when (count[i]) {
             0 -> print("${count[i]}.")
            else -> print("${count[i]}, ")
        }
    }

}


fun ud2IterativasEj4() {
    var num: Int

    do {
        print("Introduce un entero positivo")
        try {
            num = askForNumber()
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
            num = -1
        }
    } while (!isPositive(num))

    try {
        countdown(num)
    } catch (e: NumberFormatException) {
        println("** ERROR ** - $e")
        println("Este texto no debería mostrarse nunca")
    }

}


/*Escribir un programa que pida al usuario un número entero y muestre por pantalla un triángulo rectángulo como
el de más abajo, de altura el número introducido.
*
**
***
**** */

/**
 * Recibe un numero y devuelve una cadena con tantos astericos como el numero recibido
 *
 * @param layerNum Int - Cantidad de asteriscos
 *
 * @return String - Cadena de asteriscos
 */
fun createPyramidLayer(layerNum: Int): String {
    var layer = ""
    for (i in 1..layerNum) {
        layer += "*"
    }
    layer += "\n"

    return layer
}


/**
 * Devuelve una piramide  de asteriscos con la cantidad de capas introducidas por parámetro
 *
 * @param height Int - Cantidad de capas de la pirámida
 *
 * @return String - Cadena formando una pirámide de asteriscos
 */
fun createPyramid(height: Int): String {
    var pyramid = ""

    for (i in 1..height) {
        pyramid += createPyramidLayer(i)
    }

    return pyramid
}


fun ud2IterativasEj6() {
    var num: Int

    do {
        print("Introduce un entero positivo")
        try {
            num = askForNumber()
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
            num = -1
        }
    } while (!isPositive(num))

    println(createPyramid(num))

}


/*Escribir un programa que muestre por pantalla la tabla de multiplicar del 1 al 10.*/

/**
 * Recibe una lista conteniendo la tabla de multiplicar de un numero y la devuelve separada por comas
 *
 * @param table Array<Int> - Tabla de multiplicar de algún numero
 */
fun showTable(table: Array<Int>) {
    for (i in table.indices) {
        when (i + 1) {
            table.size -> print("${table[i]}.\n")
            else -> print("${table[i]}, ")
        }
    }
}


fun ud2IterativasEj7() {
    for (num in 1..10) {
        print("Tabla del $num -> ")
        val table = Array(size = 10){num * (it + 1)} // Recibe un numero y devuelve su tabla de multiplicar
        showTable(table)
    }
}


/*Escribir un programa que pida al usuario un número entero y muestre por pantalla un triángulo
rectángulo como el de más abajo.
1
3 1
5 3 1
7 5 3 1
9 7 5 3 1*/

/**
 * Devuelve una cadena con tantos numeros impares descendentes como la cantidad recibida por parámetro
 *
 * @param num Int - Numero pasado por parametro
 * @param operation function - Una funcion que decide que operación se le aplica al numero
 *
 * @return String - El valor de operation aplicado a num
 */
fun createPyramLayerWithLambdaExpression(num: Int, operation: (Int) -> String): String {
    return operation(num)
}


/**
 *  Una cadena con tantos numeros impares descendentes como la cantidad recibida por parámetro
 */
val layerOfOddNums: (Int) -> String = {
    buildString {
        var oddNum = (it * 2) -1
        while (oddNum >= 1) {
            append("$oddNum ")
            oddNum -= 2
        }
        append("\n")
    }
}


/**
 * Devuelve una cadena de numeros impares descendentes con tantas capas como reciba por parámetro
 *
 * @param num Int - Cantidad de capas de la pirámida
 *
 * @return String - Pirámide de números impares descendentes
 */
fun createOddPyramid(num: Int): String {
    var pyramid = ""

    for (i in 1..num) {
        pyramid += createPyramLayerWithLambdaExpression(i, layerOfOddNums)
    }

    return pyramid
}


fun ud2IterativasEj8() {
    var number = 0

    do {
        try {
            print("Introduce un numero")
            number = askForNumber()
            if (number < 1) {
                throw NumberFormatException("el numero debe ser mayor que 0")
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
        }
    } while (number < 1)

    print(createOddPyramid(number))
}


/*Escribir un programa que muestre el eco de tod-o lo que el usuario introduzca hasta que el usuario escriba
“salir” que terminará.*/

/**
 * Pide al usuario que introduzca texto y mostrará cada vez que pulsa Enter o finalizará si el usuario
 * introduce "salir"
 */
fun writeDown() {
    println("Escribe lo que quieras, escribe salir para salir")
    var text = ""

    while (text.uppercase().trim() != "SALIR") {
        print("--> ")
        text = readln()
        if (text.uppercase().trim() != "SALIR") {
            println(text)
        }
    }
}


fun ud2IterativasEj13() {
    writeDown()
}


/*Leer números enteros de teclado, hasta que el usuario ingrese el 0. Finalmente, mostrar la sumatoria
de todos los números positivos ingresados.*/

/**
 * Deja que el usuario introduzca cualquier numero hasta que el numero se igual a la condición de corte,
 * devuelve solamente los numeros positivos introducidos
 *
 * @param cutCondition Int - Condición de corte, cuando el usuario la introduce se devuelve la lista de numeros
 *
 * @return MutableList<Int> - Lista de todos los números positivos introducidos por el usuario
 */
fun endlessNumberInput(cutCondition: Int): MutableList<Int> {
    var num = -100
    val nums = mutableListOf<Int>()

    do {
        print("Introduce un numero positivo")
        try {
            num = askForNumber()
            if (num < cutCondition) {
                throw NumberFormatException("he dicho numeros positivos -___-")
            } else {
                nums.add(num)
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
        }
    } while (num != cutCondition)

    return nums
}


/**
 * Calcula el sumatorio de una lista de números
 *
 * @param nums MutableList<Int> - Lista de números
 *
 * @return Int - Sumatorio de la lista
 */
fun summation (nums: MutableList<Int>): Int {
    var summation = 0

    for (num in nums) {
        summation += num
    }

    return summation
}


fun ud2IterativasEj15() {
    val sum = summation(endlessNumberInput(0))
    println("sumatorio = $sum")
}


/*Solicitar al usuario que ingrese números enteros positivos y, por cada uno,
imprimir la suma de los dígitos que lo componen. La condición de corte es que se ingrese el número -1.
Al finalizar, mostrar cuántos de los números ingresados por el usuario fueron números pares.*/

/**
 * Comprueba si un número es par
 *
 * @param num Int - Número a comprobar
 *
 * @return Boolean - Si el número es par o no
 */
fun isEven (num: Int): Boolean {
    return num % 2 == 0
}


/**
 * Cuenta cuántos números pares hay en una lista
 *
 * @param nums MutableList<Int> - Lista de números pares e impares
 *
 * @return Int - Cantidad de números pares que hay en la lista
 */
fun countEvenNumbers (nums: MutableList<Int>): Int {
    var evenNums = 0

    for (num in nums) {
        if (isEven(num)) {
            evenNums += 1
        }
    }

    return evenNums
}


fun ud2IterativasEj18 () {
    val nums = endlessNumberInput(-1)
    println("Has introducido ${countEvenNumbers(nums)} numeros pares")
}


/*Mostrar un menú con tres opciones: 1- comenzar programa, 2- imprimir listado, 3-finalizar programa.
A continuación, el usuario debe poder seleccionar una opción (1, 2 ó 3). Si elige una opción incorrecta,
informarle del error. El menú se debe volver a mostrar luego de ejecutada cada opción, permitiendo volver a elegir.
Si elige las opciones 1 ó 2 se imprimirá un texto. Si elige la opción 3,
se interrumpirá la impresión del menú y el programa finalizará.*/

var myGrades = mutableListOf<Int>()


/**
 * Muestra un menú de opciones y pide al usuario que escoja una.
 * Se ejecutan diferentes funciones según lo que escoja el usuario
 */
fun showMenu() {
    println("1 - Introduzca una nota")
    println("2 - Imprimir listado")
    println("3 - Finalizar programa")
    print("Seleccione una opción")
    var option = 0

    do {
        try {
            option = askForNumber()
            if (option < 1 || option > 3) {
                throw NumberFormatException("$option no es una opción")
            } else {
                selectOption(option)
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
            print("Seleccione una opción (1, 2 o 3)")
        }
    } while (option != 3)
}


/**
 * Añade una nota a una variable de orden superior
 *
 * @param grade Int - Una nota pasada como parámetro
 */
fun setGrades(grade: Int) {
    myGrades.add(grade)
}


/**
 * Imprime la lista de notas guardadas en una variable de orden superior separando cada nota por un guión
 */
fun getGrades() {
    print("Notas = ")
    for (grade in myGrades) {
        print("$grade - ")
    }
    println()
}


/**
 * Pide una nota y solo se devuelve cuando está entre 0 y 10
 *
 * @return Int - La nota introducida por el usuario
 */
fun gradeInput(): Int {
    var nota: Int
    do {
        print("Introduce una nota (0-10)")
        nota = askForNumber()
    } while (nota < 0 || nota > 10)
    return nota
}


/**
 * Recibe un numero que corresponde con una opción de un menú y ejecuta un código diferente según la opción
 *
 * @param option Int - La opción elegida por el usuario
 */
fun selectOption(option: Int) {
    when (option) {
        1 -> {
            setGrades(gradeInput())
            showMenu()
        }
        2 -> {
            getGrades()
            showMenu()
        }
        3 -> println("Cerrando el programa...")
    }
}


fun ud2IterativasEj19() {
    showMenu()
}


/*Solicitar al usuario que ingrese una frase y luego informar cuál fue la palabra más larga
(en caso de haber más de una, mostrar la primera) y cuántas palabras había. Precondición:
se tomará como separador de palabras al carácter “ “ (espacio), ya sea uno o más.*/

/**
 * Recibe una frase y la divide por palabras tomando como separador los espacios en blanco
 *
 * @param phrase String - Una frase
 *
 * @return List<String> - Una lista donde cada elemento corresponde a cada palabra de la frase
 */
fun modifyPhrase(phrase: String): List<String> {
    val fraseModificada = phrase
        .replace(",", "")
        .replace(".", "")
        .replace("?", "")
        .replace("¿", "")
        .replace("!", "")
        .replace("¡", "")
        .replace(":", "")
        .replace(";", "")
        .split(" ")
        .filter { it.isNotBlank() }

    return fraseModificada
}

/**
 * Recibe una lista de palabras y devuelve cuál es más larga y cuántos caracteres tiene.
 * En caso de haber 2 iguales devuelve la primera
 *
 * @param enlistedPhrase List<String> - Lista de palabras
 *
 * @return Pair<String, Int> La palabra más larga y su cantidad de caracteres
 */
fun searchLongestWord(enlistedPhrase: List<String>): Pair<String, Int> {
    var mayor = 0
    var longestWord = ""

    for (word in enlistedPhrase) {
        val wordLen = word.length
        if (wordLen > mayor) {
            mayor = wordLen
            longestWord = word
        }
    }

    return Pair(longestWord, mayor)
}

fun ud2IterativasEj25() {
    print("Introduce una frase: ")
    val paragraph = readln()
    val modifiedParagraph = modifyPhrase(paragraph)
    val result = searchLongestWord(modifiedParagraph)

    println("La palabra más larga es '${result.first}' con ${result.second} letras.")
}