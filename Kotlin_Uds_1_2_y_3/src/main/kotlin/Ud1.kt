import java.math.BigDecimal
import java.math.RoundingMode


/* Escribe un programa que le pida al usuario una temperatura en grados Celsius,
 * la convierta a grados Fahrenheite imprima por pantalla la temperatura convertida.
 */


/**
 * Recibe un input y lo convierte a Dpuble
 *
 * @return Double - numero introducido por el usuario
 */
fun askForDouble(): Double {
    return readln().toDouble()
}


/**
 * Redondea un numero con decimales para que solo tenga 2 decimales
 *
 * @param num Double - numero decimal
 *
 * @return Double - numero redondeado a sus 2 primeros decimales
 */
fun roundTo2Decimals(num: Double): Double {
    return BigDecimal(num).setScale(2, RoundingMode.HALF_UP).toDouble()
}


/**
 * Transforma grados celsius a grados fahrenheit
 *
 * @param celsius Double - grados celsius
 *
 * @return Double - grados fahrenheit
 */
fun celsiusToFahrenheit(celsius: Double): Double {
    return (celsius * 1.8) + 32
}


fun ud1Ejercicio4() {
    print("Introduce la temperatura: ")
    val celsius = roundTo2Decimals(askForDouble())
    val fahrenheit = roundTo2Decimals(celsiusToFahrenheit(celsius))
    println("$celsius grados Celsius son $fahrenheit grados Fahrenheit")
}


/* Escribe un programa que pida el importe final de un artículo y calcule e imprima
 * por pantalla el IVA que se ha pagado y el importe sin IVA
 * (suponiendo que se ha aplicado un tipo de IVA del 10%).
 */

const val VAT = 0.1


/**
 * Calcula el precio final de un producto al quitarle el IVA
 *
 * @param amount Double - precio con IVA
 *
 * @return Double - precio sin IVA
 */
fun calculateVATlessAmount(amount: Double): Double {
    return amount / (1 + VAT)
}


fun ud1Ejercicio6() {
    print("Introduce el precio del articulo: ")
    val finalAmount = roundTo2Decimals(askForDouble())
    val vatLessAmount = roundTo2Decimals(calculateVATlessAmount(finalAmount))
    val vatExpenses = roundTo2Decimals(finalAmount - vatLessAmount)
    println("El artículo sin IVA cuesta: $vatLessAmount, has pagado $vatExpenses en IVA")
}


/* Escribir un programa que pida al usuario su peso (en kg) y estatura (en metros),
 * calcule el índice de masa corporal y lo almacene en una variable,
 * y muestre por pantalla la frase Tu índice de masa corporal calculado redondeado
 * con dos decimales.
 */


/**
 * Eleva un numero a una potencia
 *
 * @param num Double - numero a elevar
 * @param exponent Int - potencia
 *
 * @return Double - numero elevado a la potencia
 */
fun raiseTo(num: Double, exponent: Int): Double {
    var raisedNum = 1.0
    for (i in 1..exponent) {
        raisedNum *= num
    }
    return raisedNum
}


/**
 * Calcula el Indice de Masa Corporal
 *
 * @param weight Double - peso de la persona
 * @param height Double - altura de la persona
 *
 * @return Double - Indice de Masa Corporal
 */
fun calculateBMI(weight: Double, height: Double): Double {
    return weight / (raiseTo(height/100, 2))
}


fun ud1Ejercicio12() {
    print("Introduce tu peso en kg: ")
    val weight = roundTo2Decimals(askForDouble())

    print("Introduce tu altura en centimetros: ")
    val height = roundTo2Decimals(askForDouble())

    val bmi = calculateBMI(weight, height)
    println("Tu indice de masa corporal es ${roundTo2Decimals(bmi)}")
}


/* Imagina que acabas de abrir una nueva cuenta de ahorros que te ofrece el 4% de interés al año.
 * Estos ahorros debido a intereses, que no se cobran hasta finales de año,
 * se te añaden al balance final de tu cuenta de ahorros.
 * Escribir un programa que comience leyendo la cantidad de dinero depositada
 * en la cuenta de ahorro, introducida por el usuario.
 * Después el programa debe calcular y mostrar por pantalla la cantidad de ahorros tras el primer,
 * segundo y tercer años.
 * Redondear cada cantidad a dos decimales.
 */

const val INTEREST = 0.04


/**
 * Muestra el dinero obtenido cada año al introducir cierta cantidad de dinero
 * al 4% de interes compuesto, durante cierta cantidad de años
 *
 * @param initialCapital Double - Cantidad de dinero inicial
 * @param years Int - Cantidad de años que se aplicará el interes
 */
fun showMoneyAfterInterest(initialCapital: Double, years: Int) {
    var capital = initialCapital

    for (i in 1..years) {
        capital *= (1 + INTEREST)
        if (i == 1) {
            println("Tras $i año tu capital será de ${roundTo2Decimals(capital)}")
        } else {
            println("Tras $i años tu capital será de ${roundTo2Decimals(capital)}")
        }
    }
}


fun ud1Ejercicio15() {
    print("Introduce la cantidad de dinero que tienes en la cuenta: ")
    val money = roundTo2Decimals(askForDouble())
    showMoneyAfterInterest(money, 3)
}


/* Escribir un programa que pregunte el nombre completo del usuario en la consola y después
 * muestre por pantalla el nombre completo del usuario tres veces,
 * una con todas las letras minúsculas, otra con todas las letras mayúsculas
 * y otra solo con la primera letra del nombre y de los apellidos en mayúscula.
 * El usuario puede introducir su nombre combinando mayúsculas y minúsculas como quiera.
 */

/**
 * Pide una cadena de caracteres como input al usuario
 *
 * @return String - la cadena de caracteres introducida por el usuario
 */
fun askForString(): String {
    return readln()
}


/**
 * Recibe una frase y devuelve la misma frase pero con la primera
 * letra de cada palabra en mayuscula y el resto en minuscula
 *
 * @param initialPhrase String - frase inicial
 *
 * @return String - frase capitalizada
 */
fun capitalize(initialPhrase: String): String {
    var finalPhrase = ""
    var capNext = true
    for (i in initialPhrase) {
        finalPhrase += if (capNext) i.uppercase() else i.lowercase()
        capNext = i.isWhitespace()
    }
    return finalPhrase
}


fun ud1Ejercicio18() {
    print("Introduce tu nombre completo: ")
    val name = askForString()
    println(name.lowercase())
    println(name.uppercase())
    println(capitalize(name))
}


/* Los teléfonos de una empresa tienen el siguiente formato prefijo-número-extension
 * donde el prefijo es el código del país +34, y la extensión tiene dos dígitos
 * (por ejemplo +34-913724710-56). Escribir un programa que pregunte por un
 * número de teléfono con este formato y muestre por pantalla el número de teléfono
 * sin el prefijo y la extensión.
 */


/**
 * Recibe un numero de telefono con prefijo y sufijo y devuelve el telefono aislado
 *
 * @param phoneNumber String - numero de telefono con prefijo y sufijo
 *
 * @return String - numero de telefono aislado
 */
fun isolatePhoneNumber(phoneNumber: String): String {
    return phoneNumber.split("-")[1]
}


fun ud1Ejercicio20() {
    print("Introduce un numero de telefono con prefijo y sufijo (+34-123456789-75): ")
    val phone = askForString()
    println("El numero sin prefijo ni sufijo es ${isolatePhoneNumber(phone)}")
}


/* Escribir un programa que pida al usuario que introduzca una frase en la consola
 * y muestre por pantalla la frase invertida.
 */


fun ud1Ejercicio21() {
    print("Introduce una palabra: ")
    val word = askForString()
    println(word.reversed())
}


/* Escribir un programa que pida al usuario que introduzca una frase en la consola y una vocal,
 * y después muestre por pantalla la misma frase pero con la vocal introducida en mayúscula.
 */

val VOWELS = listOf("a", "e", "i", "o", "u")


fun ud1Ejercicio22() {
    print("Introduce una palabra: ")
    val word = askForString()

    var vowel = ""
    do {
        print("Introduce una vocal: ")
        try {
            vowel = askForString().lowercase()
            if (vowel !in VOWELS) {
                throw IllegalArgumentException("A ti te parece que $vowel es una vocal!?")
            }
        } catch (e: IllegalArgumentException) {
            println("** ERROR ** - $e")
        }
    } while (vowel !in VOWELS)

    println(word.replace(vowel, vowel.uppercase()))
}


/* Escribir un programa que pregunte por consola el precio de un producto en euros con dos decimales
 * y muestre por pantalla el número de euros y el número de céntimos del precio introducido.
 */

fun ud1Ejercicio24() {
    println("Introduce el precio de un producto: ")
    val price = roundTo2Decimals(askForDouble()).toString()
    println("El producto cuesta ${price.split('.')[0]} euros y ${price.split('.')[1]} céntimos")
}


/* Escribir un programa que pregunte al usuario la fecha de su nacimiento en formato dd/mm/aaaa
 * y muestra por pantalla, el día, el mes y el año. Adaptar el programa anterior para que
 * también funcione cuando el día o el mes se introduzcan con un solo carácter.
 */

fun ud1Ejercicio25() {
    print("Introduce tu fecha de nacimiento en formato dd/mm/aaaa: ")
    val birthdate = askForString().split("/")
    print("Day ${birthdate[0]}, Month ${birthdate[1]}, Year ${birthdate[2]}")
}


/* Escribir un programa que pregunte por consola por los productos de una cesta de la compra,
 * separados por comas y muestre por pantalla cada uno de los productos en una línea distinta.
 */

fun ud1Ejercicio26() {
    println("Introduce los productos de la lista de la compra separados por coma y espacio")
    print("--> ")
    val shoppingList = askForString().replace(", ", "\n")
    println(shoppingList)
}


/* Escribir un programa que pregunte el nombre el un producto, su precio y un número de unidades
 * y muestre por pantalla una cadena con el nombre del producto seguido de su precio unitario
 * con 6 dígitos enteros y 2 decimales, el número de unidades con tres dígitos y el coste total
 * con 8 dígitos enteros y 2 decimales.
 */

/**
 * Pide un input al usuario y lo transforma a un numero entero
 *
 * @return Int - el numero entero introducido por el usuario
 */
fun askForInt(): Int {
    return readln().toInt()
}


fun ud1Ejercicio27() {
    print("Introduce el nombre del producto: ")
    val product = askForString()

    print("Introduce el precio del producto: ")
    val price = roundTo2Decimals(askForDouble())

    print("Introduce la cantidad de productos: ")
    val units = askForInt()

    val finalCost = price * units

    println("%s %09.2f %03d %011.2f".format(product, price, units, finalCost))
}