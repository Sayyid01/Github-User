package id.kacangngoding.githubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var avatar: Int,
    var username: String?,
    var name: String?,
) : Parcelable