package com.example.sample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sample1.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment  = HomeFragment()
        val transferFragment = TransferFragment()
        val paymentFragment = PaymentFragment()
        val savingFragment = SavingFragment()
        val menuFragment = MenuFragment()

        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_transfer -> makeCurrentFragment(transferFragment)
                R.id.ic_payment -> makeCurrentFragment(paymentFragment)
                R.id.ic_saving -> makeCurrentFragment(savingFragment)
                R.id.ic_menu -> makeCurrentFragment(menuFragment)

            }
            true
        }
    }
    private fun makeCurrentFragment(fragment : Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }
}