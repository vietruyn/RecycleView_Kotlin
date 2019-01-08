package ruyn.com.kotlin_ex1

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.dialog_enter_user.*
import ruyn.com.kotlin_ex1.model.UserInfo

class EnterInfoUserDialog : DialogFragment(), View.OnClickListener {


    private var addUserListener: AddUserListener? = null

    fun setAddUserListener(addUserListener: AddUserListener){
        this.addUserListener = addUserListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_enter_user, container, false)
        val btnAdd = view.findViewById<View>(R.id.btn_sign_up) as Button

        btnAdd.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_sign_up -> addUser()
        }
    }

    private fun addUser() {
        var firstName: String = et_first_name.text.toString()
        var lastName: String = et_last_name.text.toString()
        var userName: String = et_username.text.toString()
        var emailName: String = et_email.text.toString()

        Log.d("RLV", "\n$firstName-$lastName\n$userName\n$emailName")

        var userInfo = UserInfo(firstName, lastName, userName, emailName)

        et_first_name.setText("")
        et_last_name.setText("")
        et_username.setText("")
        et_email.setText("")

        addUserListener!!.addUser(userInfo)
        dismiss()

    }
}