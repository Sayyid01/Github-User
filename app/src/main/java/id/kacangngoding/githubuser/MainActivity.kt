package id.kacangngoding.githubuser

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import id.kacangngoding.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter

    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataAvatar: TypedArray
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        val listView: ListView = binding.rvList
        adapter = UserAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            val userData = User(
                users[position].avatar,
                users[position].username,
                users[position].name
            )

            val moveWithDataIntent = Intent(this@MainActivity, UserInfoActivity::class.java)
            moveWithDataIntent.putExtra(UserInfoActivity.EXTRA_USER, userData)
            startActivity(moveWithDataIntent)
        }

        setContentView(binding.root)
    }

    private fun prepare(){
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
    }

    private fun addItem(){
        for (position in dataUsername.indices){
            val user = User(
                dataAvatar.getResourceId(position, -1),
                dataUsername[position],
                dataName[position]
            )
            users.add(user)
        }
        adapter.users = users
    }
}