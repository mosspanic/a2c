package com.on.a2c

import android.app.Notification
import android.app.NotificationManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.on.a2c.User
import android.content.Context;
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import com.on.a2c.R

class MainAdapter(private val users: ArrayList<User>) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    var userCLickListener: UserCLickListener? = null
    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {
            itemView.apply {
                val textViewUserName = this.findViewById<TextView>(R.id.textViewUserName)
                val textViewUserEmail = this.findViewById<TextView>(R.id.textViewUserSpecies)
                val imageViewAvatar = this.findViewById<ImageView>(R.id.imageViewAvatar)

                val lcontainer = this.findViewById<ConstraintLayout>(R.id.lcontainer)
                val usr=user.name+user.id+user.species;   println("########## Добавлен в список $usr")
                textViewUserName.text = user.name
                textViewUserEmail.text = user.species
                Glide.with(imageViewAvatar.context)
                    .load(user.avatar)
                    .into(imageViewAvatar)

               /* val builder: NotificationCompat.Builder = NotificationCompat.Builder(this)
                    .setSmallIcon(android.R.mipmap.sym_def_app_icon)
                    .setContentTitle("Title")
                    .setContentText("Notification text")

                val notification: Notification = builder.build()

                val notificationManager = getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.notify(1, notification)*/

                lcontainer.setOnClickListener {  //println("####### 1 нажал на строку в списке")
                    userCLickListener?.onClick(user.id);    val usr=user.id; println("####### 2 нажал на строку в списке id- $usr")

                    Toast.makeText(context, user.name, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addUsers(users: List<User>) {
        this.users.apply {
            clear()
            addAll(users)
        }
    }

    /*interface OnUserClickListener {
        fun onUserClick(user: User?, position: Int)
    }

    private val onClickListener: OnUserClickListener? = null

    fun MainAdapter(context: Context?, users: List<User>, onClickListener: OnUserClickListener?) {
        this.onClickListener = onClickListener

        this.users = users;
        this.inflater = LayoutInflater.from(context);
    }*/
    fun interface UserCLickListener {
        fun onClick(id: String)
    }
}