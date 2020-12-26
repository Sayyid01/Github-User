package id.kacangngoding.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import id.kacangngoding.githubuser.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfoBinding
    companion object{
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)

        val txtUsername: TextView = binding.username
        val txtName: TextView = binding.name
        val imgAvatar: ImageView = binding.avatarImage

        val userData = intent.getParcelableExtra<User>(EXTRA_USER) as User
        txtUsername.text = userData.username.toString()
        txtName.text = userData.name.toString()
        imgAvatar.setImageResource(userData.avatar)

        setContentView(binding.root)
    }
}