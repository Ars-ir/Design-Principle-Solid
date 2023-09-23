
/**
 * @author : Arfan Siregar
 *
 * SRP is Single Responsibility Principle
 *
 * “A class should have one and only one reason to
 * change“
 * */


/**
 * Bad practice.
 *
 * Where the class have then more one responsibility
 * */
class BadTransactionService(
    private val id: Int?,
) {
    fun fetchInvoice() {
        if (!validateInvoice()) {
            // fetch invoice
        }
    }

    private fun validateInvoice(): Boolean {
        return id != null
    }
}


/**
 * Best practice.
 *
 * Where the class have one responsibility
 * */

class GoodTransactionService(
    private val id: Int?,
) {
    fun fetchInvoice() {
        if (Validate.invoice(id)) {
            // fetch invoice
        }
    }
}

object Validate {
    fun invoice(id: Int?): Boolean {
        return id != null
    }
}