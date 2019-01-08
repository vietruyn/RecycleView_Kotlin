package ruyn.com.kotlin_ex1.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ruyn.com.kotlin_ex1.R
import ruyn.com.kotlin_ex1.model.UserInfo

class ListUserAdapter(items: ArrayList<UserInfo>, contex: Context) : RecyclerView.Adapter<ListUserAdapter.viewHolder>() {
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var itemname: UserInfo = mitem[position]
        holder?.firstName?.text = itemname.getFistName()
        holder?.lastName?.text = itemname.getLastName()
        holder?.userName?.text = itemname.getUserName()
        holder?.email?.text = itemname.getFistName()

        holder?.itemView.setOnClickListener {
            Log.d("RLV", "onClickItem")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var view:View= LayoutInflater.from(mContex).inflate(R.layout.item_user_list,parent,false)

        return viewHolder(view)
    }

    var mitem = items
    var mContex = contex

    override fun getItemCount(): Int {
        return mitem.size
    }


    class viewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        var firstName: TextView? = view?.findViewById(R.id.tv_first_name)
        var lastName: TextView? = view?.findViewById(R.id.tv_last_name)
        var userName: TextView? = view?.findViewById(R.id.tv_user_name)
        var email: TextView? = view?.findViewById(R.id.tv_email)


    }
}