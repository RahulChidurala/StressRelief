package com.hacklahoma.stressrelief.stressrelief.UseCases.OutdoorActivities.OutdoorMenu

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton
import com.hacklahoma.stressrelief.stressrelief.R
import com.hacklahoma.stressrelief.stressrelief.UseCases.OutdoorActivities.OutdoorEventsActivity
import com.hacklahoma.stressrelief.stressrelief.UseCases.OutdoorActivities.OutdoorExerciseActivity
import com.hacklahoma.stressrelief.stressrelief.UseCases.OutdoorActivities.OutdoorParkActivity

/**
 * Created by chrah on 3/4/2018.
 */

class OutdoorMenuActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_outdoors)

        val img_btn_parkImage = findViewById<ImageButton>(R.id.img_btn_parkImage)
        img_btn_parkImage.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, OutdoorParkActivity::class.java)
            startActivity(intent)
        })
        img_btn_parkImage.setColorFilter(Color.argb(120, 0, 0, 0))


        val img_btn_nearby = findViewById<ImageButton>(R.id.img_btn_nearby)
        img_btn_nearby.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, OutdoorEventsActivity::class.java)
            startActivity(intent)
        })
        img_btn_nearby.setColorFilter(Color.argb(120, 0, 0, 0))


        val exerciseImage = findViewById<ImageButton>(R.id.exerciseImage)
        exerciseImage.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, OutdoorExerciseActivity::class.java)
            startActivity(intent)
        })
        exerciseImage.setColorFilter(Color.argb(120, 0, 0, 0))

    }
}