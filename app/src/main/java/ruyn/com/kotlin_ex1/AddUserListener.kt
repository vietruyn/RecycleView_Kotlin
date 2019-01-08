package ruyn.com.kotlin_ex1

import ruyn.com.kotlin_ex1.model.UserInfo

interface AddUserListener {
    fun addUser(userInfo: UserInfo)
}