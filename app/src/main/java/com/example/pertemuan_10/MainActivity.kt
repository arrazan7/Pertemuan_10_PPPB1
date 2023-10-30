package com.example.pertemuan_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pertemuan_10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(ProfileFragment())

        with(binding){
            bottomNavView.setOnItemSelectedListener {
                when(it.itemId) {
                    R.id.nav_home -> replaceFragment(HomeFragment())
                    R.id.nav_notif -> replaceFragment(NotifikasiFragment())
                    R.id.nav_prof -> replaceFragment(ProfileFragment())

                    else -> {}
                }
                true
            }
        }
    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}