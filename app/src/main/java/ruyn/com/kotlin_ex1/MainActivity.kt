package ruyn.com.kotlin_ex1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import ruyn.com.kotlin_ex1.adapter.ListUserAdapter
import ruyn.com.kotlin_ex1.model.UserInfo

class MainActivity : AppCompatActivity(), View.OnClickListener, AddUserListener {

    private val dialog: EnterInfoUserDialog = EnterInfoUserDialog()

    private var listUserInfo: ArrayList<UserInfo> = ArrayList()
    private var listUserAdapter: ListUserAdapter = ListUserAdapter(listUserInfo, this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAdd = findViewById<Button>(R.id.btn_add)

        dialog.setAddUserListener(this)

        buttonAdd.setOnClickListener(this)

        rcv_list_user.layoutManager = LinearLayoutManager(this)
        rcv_list_user.setHasFixedSize(true)
        rcv_list_user.itemAnimator = DefaultItemAnimator()
        rcv_list_user.addItemDecoration(DividerItemDecoration(rcv_list_user.context, DividerItemDecoration.VERTICAL))
        rcv_list_user.adapter = listUserAdapter



    }

    override fun addUser(userInfo: UserInfo) {
        listUserInfo.add(userInfo)
        listUserAdapter.notifyItemChanged(listUserInfo.size - 1)
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_add -> dialog.show(supportFragmentManager, "")

        }

    }

}
