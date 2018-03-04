package com.hacklahoma.stressrelief.stressrelief.UseCases.Menu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.hacklahoma.stressrelief.stressrelief.R

class MenuActivity : AppCompatActivity() {

    private lateinit var router: IMenuRouter
    private lateinit var controller: IMenuController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        router = MenuRouter(this)
        controller = MenuController(router)

        val btnIndoors = findViewById<Button>(R.id.btnIndoors)
        val btnOutdoors = findViewById<Button>(R.id.btnOutdoors)

        btnIndoors.setOnClickListener(View.OnClickListener {
            this.actionIndoors()
        })

        btnOutdoors.setOnClickListener(View.OnClickListener {
            this.actionOutdoors()
        })
    }

    fun actionIndoors() {

        controller.actionIndoors()
    }

    fun actionOutdoors() {

        controller.actionOutdoors()
    }
}
