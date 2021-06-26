package com.calc

sealed class Expression(open val num1 : Double, open val num2 : Double) {
    data class SUM(override val num1: Double, override val num2: Double): Expression(num1,num2)
    data class SUB(override val num1: Double, override val num2 : Double) : Expression(num1, num2)
    data class MULT(override val num1: Double, override val num2: Double) : Expression(num1, num2)
    data class DIV(override val num1: Double, override val num2: Double) : Expression(num1, num2)
    data class MOD(override val num1: Double, override val num2: Double) : Expression(num1, num2)
    data class SQRT(override val num1: Double, override val num2: Double) : Expression(num1, num2)
    data class PORCT(override val num1: Double, override val num2: Double) : Expression(num1, num2)
    data class FAT(override val num1: Double, override val num2: Double) : Expression(num1, num2)
    data class RES(override val num1: Double, override val num2: Double) : Expression(num1, num2)
}