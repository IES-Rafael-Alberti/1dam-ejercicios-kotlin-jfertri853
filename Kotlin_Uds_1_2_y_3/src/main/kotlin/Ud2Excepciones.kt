/*Escribir un programa que pida al usuario un número entero positivo y muestre por pantalla todos los
números impares desde 1 hasta ese número separados por comas.*/

/**
 * Muestra todos los números impares desde 1 hasta X número
 *
 * @param num Int - Número hasta el cuál se va a mostrar por pantalla
 *
 * @return String - Cadena de número impares desde 1 hasta num
 */
fun oddString(num: Int): String {
    var oddNums = ""
    for (i in 1..num step 2) {
        oddNums += if (i == num || i == num - 1) {
            "$i"
        } else {
            "$i, "
        }
    }
    return oddNums
}


/**
 * Pide un numero hasta que el numero introducido es mayor o igual a 1
 *
 * @return Int - El número introducido por el usuario
 */
fun askForNumberV2(): Int {
    while (true) {
        try {
            print("Introduce un número entero positivo")
            val num = askForNumber()
            if (num < 1) {
                throw NumberFormatException("El número no puede ser menor a 1")
            } else {
                return num
            }
        } catch (e: NumberFormatException) {
            println("Eso no es un número válido")
        }
    }
}


fun ud2ExcepcionesEj2() {
    val num = askForNumberV2()
    println(oddString(num))
}


/*Escribir un programa que pida al usuario un número entero positivo y muestre por pantalla la cuenta atrás
desde ese número hasta cero separados por comas. Deberá solicitar el número hasta introducir uno correcto.*/

/**
 * Recibe un número y devuelve la cuenta atrás hasta 0 separando los números por coma
 *
 * @param num Int - Número de inicio de la cuenta atrás
 *
 * @return String - Cuenta atrás desde num hasta 0
 */
fun countBackwards(num: Int): String {
    var myString = ""   // No sé como llamar a esta variable
    for (i in num downTo 0) {
        myString += when (i) {
            0 -> "$i"
            else -> "$i, "
        }
    }
    return myString
}


fun ud2ExcepcionesEj3() {
    val num = askForNumberV2()
    println(countBackwards(num))
}


/*Escribir un programa que pida al usuario un número entero, si la entrada no es correcta,
mostrará el mensaje "La entrada no es correcta" y lanzará la excepción capturada.*/

fun ud2ExcepcionesEj4() {
    print("Introduce un numero")
    try {
        val num = askForNumber()
        println("Tu numero es correcto!! $num")
    } catch (e: NumberFormatException) {
        println("** ERROR ** - $e")
    }
}