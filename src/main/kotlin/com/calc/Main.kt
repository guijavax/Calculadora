package com.calc



fun main() {

    var num  = getValue()?.toDouble()
    var oper = getValue()
    var num2 : Double? = 0.0
    if(oper != "!") {
        num2 = getValue()?.toDouble()
    }
    var result  : Double? = 0.0
    val calc = Calculadora()
    var i = 0
    while("=" != oper) {
        result = if(i == 0) {
            calc.calcula(oper?:"",num,num2)
        }
        else {
            oper = getValue()
            if("=" == oper) break
            num = getValue()?.toDouble()

            calc.calcula(oper?:"", result, num)
        }
        i++
    }
    println(result)

}
private fun getValue() : String? = readLine()
