package com.betrip.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.betrip.project.travelers.CreateEvent
import com.betrip.project.travelers.SelectedTravelEvent
import com.betrip.project.travelers.SettingTraveler
import com.betrip.project.travelers.fragments.event_fragment
import com.betrip.project.travelers.fragments.routes_fragment

import com.betrip.project.travelers.models.TravelEvent
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeTravellerActivity : AppCompatActivity() {

    lateinit var travelEvents: List<TravelEvent>
   // lateinit var travelEventAdapter: TravelEventAdapter
    val eventsFragment= event_fragment()
    val routesFragment= routes_fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_traveller)
        loadContact()

        replacePrincipalLayout(eventsFragment)
        menuListener()
    }
    private fun loadContact() {
        val geeks = listOf(TravelEvent("Lima","25-12-2002","15:00",12))
        travelEvents=geeks;
    }
    private fun routes(){
        val intent = Intent(this, SettingTraveler::class.java)
        startActivity(intent)
    }
    private fun Add(){
        val intent = Intent(this, CreateEvent::class.java)
        startActivity(intent)
    }
    private fun menuListener(){
        val menu=findViewById<BottomNavigationView>(R.id.bnmNavTool)
        val addButton=findViewById<FloatingActionButton>(R.id.btfAdd)
        addButton.setOnClickListener(){
            Add()
        }
        menu.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menuEvents->
                {
                    replacePrincipalLayout(eventsFragment)
                    true
                }
                R.id.menuFindRoutes->{
                    replacePrincipalLayout(routesFragment)
                    true
                }
                R.id.menuSetting->{
                    routes()
                    true
                }
                else -> super.onOptionsItemSelected(it)
            }

            }
    }
    fun replacePrincipalLayout(fragment: Fragment){
        if(fragment!=null){
            val transacion=supportFragmentManager.beginTransaction()
            transacion.replace(R.id.fmlPrincipal,fragment)
            transacion.commit()
        }
    }



}