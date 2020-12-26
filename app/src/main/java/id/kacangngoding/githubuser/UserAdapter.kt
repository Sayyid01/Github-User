package id.kacangngoding.githubuser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import id.kacangngoding.githubuser.databinding.ItemUserBinding

class UserAdapter internal constructor(private val context: Context): BaseAdapter(){

    internal var users = arrayListOf<User>()
    override fun getCount(): Int = users.size

    override fun getItem(position: Int): Any = users[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null){
            //Connect ViewaHolder with view
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View){
        private var binding = ItemUserBinding.bind(view)

        private val txtUsername: TextView = binding.username
        private val txtName: TextView = binding.name
        private val imgAvatar: ImageView = binding.avatarImage

        internal fun bind(user: User){
            txtUsername.text = user.username
            txtName.text = user.name
            imgAvatar.setImageResource(user.avatar)
        }
    }
}