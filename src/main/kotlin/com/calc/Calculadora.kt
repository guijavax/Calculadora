package com.calc

class Calculadora {
    fun calcula(oper : String, num1 : Double?, num2 : Double?) = calc(oper, num1, num2)

    private fun calc(oper: String, num1: Double?, num2: Double?) : Double?{
        val expression = defineExpression(oper, num1, num2)
        return when(expression) {
            is Expression.SUM -> num1?.plus(num2?:0.0)
            is Expression.SUB -> num1?.minus(num2?:0.0)
            is Expression.MULT -> num1?.times(num2?:0.0)
            is Expression.DIV -> num1?.div(num2?:0.0)
            is Expression.MOD -> num1?.rem(num2?:0.0)
            is Expression.PORCT -> num2?.div(100)?.let { num1?.times(it) }
            is Expression.SQRT -> Math.sqrt(num1?:0.0)
            is Expression.FAT -> calcFat(num1?:0.0)
            else -> 0.0
        }
    }

    private fun defineExpression(oper : String, num1: Double?, num2: Double?) : Expression {
        return when(oper){
            "+" -> Expression.SUM(num1?:0.0, num2?:0.0)
            "-" -> Expression.SUB(num1?:0.0, num2?:0.0)
            "*" -> Expression.MULT(num1?:0.0, num2?:0.0)
            "/" -> Expression.DIV(num1?:0.0, num2?:0.0)
            "%" -> Expression.PORCT(num1?:0.0, num2?:0.0)
            "mod" -> Expression.MOD(num1?:0.0, num2?:0.0)
            "!" -> Expression.FAT(num1?:0.0, num2?:0.0)
            else -> Expression.RES(num1?:0.0, num2?:0.0)
        }
    }

    private fun calcFat(num1: Double?) : Double {
        var res = 0
        var num = num1?.toInt()
        return if(num != null && num > 0) {
            for(i in num downTo 2 step 1) {
                res = if(res == 0)
                     i * (i - 1)
                else  res * (i - 1)
            }
           res.toDouble()
        }
        else 0.0
    }

}