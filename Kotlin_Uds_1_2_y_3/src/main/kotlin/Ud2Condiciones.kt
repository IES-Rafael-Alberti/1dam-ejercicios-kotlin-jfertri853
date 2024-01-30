/* Escribir un programa que almacene la cadena de caracteres contraseña en una variable,
pregunte al usuario por la contraseña e imprima por pantalla si la contraseña
introducida por el usuario coincide con la guardada en la variable sin tener en cuenta
mayúsculas y minúsculas. */

/**
 * Pide al usuario que introduzca una contraseña y la devuelve
 *
 * @return String - la contraseña introducida por el usuario
 */
fun insertPassword (): String {
    print("Introduce su contraseña: ")
    return readln()
}


/**
 * Comprueba si el parámetro es true o false e imprime la frase correspondiente
 *
 * @param acces Boolean - el acceso válido o inválido del usuario
 */
fun verifyLogin (acces: Boolean) {
    if (acces) {
        println("Contraseña correcta, puedes entrar")
    } else {
        println("Contraseña incorrecta")
    }
}


/**
 * Comprueba si 2 cadenas son iguales (ignorando si los caracteres están en mayúscula o minúscula)
 *
 * @param verifiedPass String - Una contraseña guardada
 * @param insertedPass String - Una contraseña insertada por el usuario
 *
 * @return Boolean - el resultado de comparar los 2 parámetros
 */
fun compareTwoStrings(verifiedPass: String, insertedPass: String): Boolean {
    return (verifiedPass.uppercase() == insertedPass.uppercase())
}


fun ud2CondicionesEj2 () {
    val password = "pipo"
    verifyLogin(compareTwoStrings(password, insertPassword()))
}


/* Escribir un programa que pida al usuario dos números y muestre por pantalla su división.
Si el divisor es cero el programa debe mostrar un error. */

/**
 * Divide un numero entre otro y devuelve el resultado o un nulo si el divisor es 0
 *
 * @param dividend Double - numero que va a ser dividido
 * @param divider Double - numero entre el que se divide el dividendo
 *
 * @return Double? - resultado de dividir el dividendo entre el divisor
 */
fun divide (dividend: Double, divider: Double): Double? {
    if (divider == 0.0) {
        println("** ERROR ** - el divisor no puede ser 0")
        return null
    } else {
        return roundTo2Decimals(dividend/divider)
    }
}


/**
 * Pide un dividendo y un divisor, crea una lista con los parámetros de una división y devuelve la lista
 *
 * @return DoubleArray - Los parámetros de una división dentro de una lista
 */
fun createDivision (): DoubleArray {
    print("Introduce el dividendo: ")
    val dividend = readln().toDouble()

    print("Introduce el divisor: ")
    val divider = readln().toDouble()

    return doubleArrayOf(dividend, divider)
}


fun ud2CondicionesEj3 () {
    val divisionNumbers = createDivision()
    println(divide(divisionNumbers[0], divisionNumbers[1]))
}


/* Los alumnos de un curso se han dividido en dos grupos A y B de acuerdo al sexo y el nombre.
El grupo A esta formado por las mujeres con un nombre anterior a la M y los hombres con
un nombre posterior a la N y el grupo B por el resto.
Escribir un programa que pregunte al usuario su nombre y sexo,
y muestre por pantalla el grupo que le corresponde. */

/**
 * Pide el nombre y el género de un alumno y los devuelve dentro de una lista
 *
 * @return List<String> - La lista que guarda el nombre y el género de un alumno
 */
fun fillOutStudentForm (): List<String> {
    print("Introduce el nombre del alumno: ")
    val name = readln()

    print("Introduce el sexo del alumno (M o F): ")
    var gender = readln().uppercase()

    while (gender != "M" && gender != "F") {
        print("El valor introducido es incorrecto, introduce el sexo del alumno (M o F): ")
        gender = readln().uppercase()
    }

    return listOf(name, gender)
}


/**
 * Recibe un nombre y un género de un alumno y devuelve el grupo de clase en el que entraría dicho alumno
 *
 * @param name String - El nombre del alumno
 * @param gender String - El género del alumno
 *
 * @return String - El grupo al que pertenece el alumno
 */
fun assignToGroup(name: String, gender: String): String {
    val group = if ((name[0].uppercase() < "M" && gender == "F") || (name[0].uppercase() > "N" && gender == "M")) {
        "Grupo A"
    } else {
        "Grupo B"
    }

    return group
}


/**
 * Muestra la información del alumno y el grupo al que pertenece,
 * imprime diferentes cadenas según el género del alumno
 *
 * @param name String - El nombre del alumno
 * @param gender String - El género del alumno
 * @param group String - El grupo al que pertenece el alumno
 */
fun showStudentAndGroup(name: String, gender:String, group:String) {
    if (gender == "F") {
        println("La alumna $name pertenece al $group")
    } else {
        println("El alumno $name pertenece al $group")
    }
}


fun ud2CondicionesEj6() {
    val studentForm = fillOutStudentForm()
    showStudentAndGroup(studentForm[0], studentForm[1], assignToGroup(studentForm[0], studentForm[1]))
}


/* En una determinada empresa, sus empleados son evaluados al final de cada año.
Los puntos que pueden obtener en la evaluación comienzan en 0.0 y pueden ir aumentando,
traduciéndose en mejores beneficios.
Los puntos que pueden conseguir los empleados pueden ser 0.0, 0.4, 0.6 o más,
pero no valores intermedios entre las cifras mencionadas.
A continuación se muestra una tabla con los niveles correspondientes a cada puntuación.
La cantidad de dinero conseguida en cada nivel es de 2.400€ multiplicada por la puntuación del nivel.

Nivel	Puntuación
Inaceptable	0.0
Aceptable	0.4
Meritorio	0.6 o más

Escribir un programa que lea la puntuación del usuario e indique su nivel de rendimiento,
así como la cantidad de dinero que recibirá el usuario. */

/**
 * Pregunta la puntuación de un empleado y si está dentro de las puntuaciones posibles la devuelve
 *
 * @return Double - La puntuación del empleado
 */
fun askForEmployeeScore (): Double {
    print("Introduce la puntuación del empleado: ")
    var score = readln().toDouble()

    while ((score < 0.0) || (score != 0.0 && score != 0.4 && score != 0.6) && score < 0.6) {
        println("** ERROR ** - La puntuación insertada no es válida")
        print("Introduce la puntuación del empleado: ")
        score = readln().toDouble()
    }

    return score
}


/**
 * Recibe una puntuación y devuelve cuál ha sido el rendimiento del empleado según la puntuación
 *
 * @param score Double - Puntuación del empleado
 *
 * @return String - Rendimiento del empleado
 */
fun calculateEmployeePerformance (score: Double): String {
    val performance = when {
        score == 0.0 -> "Inaceptable"
        score == 0.4 -> "Aceptable"
        score >= 0.6 -> "Meritorio"
        else -> "Desconocido"
    }

    return performance
}


/**
 * Recibe una puntuación y devuelve cuanta paga extra le corresponde al empleado según la puntuación
 *
 * @param score Double - Puntuación del empleado
 *
 * @return String - Paga extra del empleado
 */
fun calculateBonusPayment (score: Double): String {
    return "%.2f".format(score * 2400.0)
}


fun ud2CondicionesEj8 () {
    val employeeScore = askForEmployeeScore()
    println("El rendimiento del empleado es ${calculateEmployeePerformance(employeeScore)}," +
            " debe cobrar ${calculateBonusPayment(employeeScore)}$ extra este mes")
}


/*La pizzería Bella Napoli ofrece pizzas vegetarianas y no vegetarianas a sus clientes.
Los ingredientes para cada tipo de pizza aparecen a continuación.

Ingredientes vegetarianos: Pimiento y tofu.
Ingredientes no vegetarianos: Peperoni, Jamón y Salmón.

Escribir un programa que pregunte al usuario si quiere una pizza vegetariana o no,
y en función de su respuesta le muestre un menú con los ingredientes disponibles para que elija.
Solo se puede eligir un ingrediente además de la mozzarella y el tomate que están en todas la pizzas.
Al final se debe mostrar por pantalla si la pizza elegida es vegetariana o no y todos los ingredientes que lleva.*/

/**
 * Muestra el tipo de la pizza y sus ingredientes
 *
 * @param type String - Tipo de pizza
 * @param pizza List<String> - Lista de ingredientes de la pizza
 */
fun printTicket (type: String, pizza: List<String>) {
    print("Su pizza ${type.lowercase()} de ")
    for (i in pizza.indices) {
        if (i + 1 == pizza.size) {
            print("y ${pizza[i]}.")
        } else {
            print("${pizza[i]}, ")
        }
    }
}


/**
 * Devuelve la lista de ingredientes de la pizza
 *
 * @param ingredient String - Ingrediente elegido por el usuario
 *
 * @return List<String> - Lista de ingredientes que lleva la pizza
 */
fun createPizza (ingredient: String): List<String> {
    return listOf("tomate", "mozzarella", ingredient)
}


/**
 * Devuelve una lista de posibles ingredientes según el tipo de pizza recibido
 *
 * @param pizzaType String - Tipo de pizza
 *
 * @return List<String> - Lista de ingredientes posibles para el tipo de pizza seleccionado
 */
fun selectIngredientList (pizzaType: String): List<String> {
    val ingredients = if (pizzaType == "VEGETAL") {
        listOf("pimiento", "tofu")
    } else {
        listOf("pepperoni", "jamon", "salmon")
    }

    return ingredients
}


/**
 * Recibe una lista de ingredientes y pide al usuario que escoja uno para su pizza
 *
 * @param ingredients List<String> - La lista con todos los ingredientes que puede elegir el usuario
 *
 * @return String - El ingrediente elegido por el usuario
 */
fun chooseIngredients (ingredients: List<String>): String {
    println("Elige el ingrediente de tu pizza")
    for (ingredient in ingredients) {
        println("-> $ingredient")
    }

    print("Introduce el nombre del ingrediente que quieres en tu pizza: ")
    var election = readln().lowercase().replace(" ", "")

    while (election !in ingredients) {
        print("No tenemos $election, elige un ingrediente de la lista: ")
        election = readln().lowercase().replace(" ", "")
    }

    return election
}


/**
 * Pide al usuario que elija el tipo de pizza (vegetal o con carne), una vez el usuario introduce un tipo
 * de pizza válido lo devuelve como cadena de caracteres
 *
 * @return String - El tipo de pizza escogido por el usuario
 */
fun choosePizzaType (): String {
    print("pizza vegetal o con carne? ")
    var type = readln().replace(" ", "").uppercase()
    while (type != "VEGETAL" && type != "CONCARNE") {
        println("No hemos entendido su pedido, debe escribir (vegetal) o (con carne)")
        print("-> ")
        type = readln().replace(" ", "").uppercase()
    }

    return type
}


fun ud2CondicionesEj10 () {
    println("Bienvenido a Bella Napoli")
    val pizzaType = choosePizzaType()
    val ingredient = chooseIngredients(selectIngredientList(pizzaType))
    val pizza = createPizza(ingredient)
    printTicket(pizzaType, pizza)
}