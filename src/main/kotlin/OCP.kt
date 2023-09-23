/**
 * @author : Arfan Siregar
 *
 * OCR is Open/Closed Principle
 *
 * “Entities should be open for extension,
 * but closed for modification“
 * */


/**
 * Bad practice
 *
 * Where must modification for add new type
 * */
class Account {
    /** Product entities **/
}

enum class AccountType {
    VIP,
    PREMIUM,
    NORMAL,
}

class SavingAccountService {
    fun invoke(account: Account, accountType: AccountType) {
        when (accountType) {
            AccountType.VIP -> {
                /** do saving with account type */
            }

            AccountType.PREMIUM -> {
                /** do saving with account type */
            }

            AccountType.NORMAL -> {
                /** do saving with account type */
            }
        }
    }
}


/**
 * Best practice
 *
 * Abstraction open to extension and service closed for modification
 * */

abstract class Fetching {
    abstract fun invoke(account: Account): String
}

class VipAccount : Fetching() {
    override fun invoke(account: Account): String {
        return "Vip Account"
    }
}

class PremiumAccount : Fetching() {
    override fun invoke(account: Account): String {
        return "Premium Account"
    }
}

class NormalAccount : Fetching() {
    override fun invoke(account: Account): String {
        return "Normal Account"
    }
}

class SavingAccountServices {

    private val vipAccount = VipAccount()
    private val account = Account()

    private fun savingAccount(account: Account, fetching: Fetching) {
        val invokeAccount = fetching.invoke(account)

        /** Do invoke account for request api */
    }

    fun onCreate() {
        savingAccount(account, vipAccount)
    }
}

