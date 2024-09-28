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
        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    loadFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.candidateListFragment -> {
                    loadFragment(CandidateListFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.electionListFragment -> {
                    loadFragment(ElectionListFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.dashboardFragment -> {
                    loadFragment(DashboardFragment())
                    return@OnNavigationItemSelectedListener true
                }

                else -> return@OnNavigationItemSelectedListener false
            }
        })

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