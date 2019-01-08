package ruyn.com.kotlin_ex1.model

class UserInfo {
    private var firstName: String = ""
    private var lastName: String = ""
    private var userName: String = ""
    private var email: String = ""

    constructor(firstName: String, lastName: String, userName: String, email: String) {
        this.firstName = firstName
        this.lastName = lastName
        this.userName = userName
        this.email = email
    }

    fun getFistName(): String {
        return firstName
    }

    fun getLastName(): String {
        return lastName
    }

    fun getUserName(): String {
        return userName
    }

    fun getEmail(): String {
        return email
    }
}