package com.hacklahoma.stressrelief.stressrelief.UseCases.IndoorActivityMenu

import android.media.Image
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton
import com.hacklahoma.stressrelief.stressrelief.R

/**
 * Created by chrah on 3/3/2018.
 */
class IndoorActivity: AppCompatActivity() {

    private lateinit var router: IIndoorRouter
    private lateinit var controller: IIndoorController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_indoors)

        router = IndoorRouter(this)
        controller = IndoorController(router)

        val img_btn_stretchingImage = findViewById<ImageButton>(R.id.img_btn_stretchingImage)
        img_btn_stretchingImage.setOnClickListener(View.OnClickListener {

            controller.actionToStretching()
        })

        val img_btn_breathe = findViewById<ImageButton>(R.id.img_btn_breathe)
        img_btn_breathe.setOnClickListener(View.OnClickListener {

            controller.actionToBreathing()
        })
    }
}