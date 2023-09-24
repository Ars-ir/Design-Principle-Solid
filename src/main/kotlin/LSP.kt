/**
 * @author : Arfan Siregar
 *
 * LSP is Liskov Substitution Principle
 *
 * ““if for each object o1 of type S there is an object
 * o2 of type T such that for all programs P defined
 * in terms of T, the behavior of P is unchanged
 * when o1 is substituted for o2 then S is a subtype
 * of T“
 * */


/**
 * Bad practice
 *
 * this violates LSP
 * */
open class Gold {
    open fun invoke() {
        /** Implementation code */
    }
}

class RealGold: Gold() {
    override fun invoke() {
        /** Implementation code */
    }
}

open class ValidateGold: Gold() {
    fun invoke(isRealGold: Boolean) {
        /** Implementation code */
    }
}

//fun main() {
//    val gold = listOf(Gold(), RealGold(), ValidateGold())
//    gold.forEach {
//        when(it) {
//            is ValidateGold -> it.invoke(true)
//            else -> it.invoke()
//        }
//    }
//}

/**
 * Best practice
 * */

open class Silver {
    open fun invoke() {
        /** Implementation code */
    }
}

class RealSilver: Silver() {
    override fun invoke() {
        /** Implementation code */
    }
}

open class ValidateSilver(private val isRealSilver: Boolean): Silver() {

    override fun invoke() {
        invoke(isRealSilver)
    }

    private fun invoke(isRealSilver: Boolean) {
        /** Implementation code */
    }
}

fun main() {
    val silver = listOf(Silver(), RealSilver(), ValidateSilver(false))
    silver.forEach {
        it.invoke()
    }
}