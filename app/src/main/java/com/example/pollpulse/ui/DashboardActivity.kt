package com.example.pollpulse.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pollpulse.R
import com.example.pollpulse.ui.fragments.CandidateListFragment
import com.example.pollpulse.ui.fragments.DashboardFragment
import com.example.pollpulse.ui.fragments.ElectionListFragment
import com.example.pollpulse.ui.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.itemIconTintList = null;
        bottomNavigationView.setOnItemSelectedListener{ item: MenuItem ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    loadFragment(HomeFragment())
                    true
                }

                R.id.candidateListFragment -> {
                    loadFragment(CandidateListFragment())
                    true
                }

                R.id.electionListFragment -> {
                    loadFragment(ElectionListFragment())
                    true
                }

                R.id.dashboardFragment -> {
                    loadFragment(DashboardFragment())
                    true
                }

                else -> false
            }
        }

        loadFragment(HomeFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.nav_fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}