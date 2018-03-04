package com.hacklahoma.stressrelief.stressrelief.UseCases.StressRating

import android.content.Intent
import android.media.Rating
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RatingBar
import com.hacklahoma.stressrelief.stressrelief.R
import com.hacklahoma.stressrelief.stressrelief.UseCases.Graph.HappinessGraphActivity
import com.hacklahoma.stressrelief.stressrelief.UseCases.IndoorActivityMenu.IndoorActivity
import com.hacklahoma.stressrelief.stressrelief.UseCases.StressActivity
import java.io.Serializable
import java.util.*


/**
 * Created by chrah on 3/4/2018.
 */
class StressRatingActivity: AppCompatActivity() {

    private var storage: IStressRatingStorage = StressRatingMemoryStorage()
    private lateinit var controller: IStressRatingController

    private lateinit var stressActivityType: StressActivity
    private var rating: Float = 3f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_stress_rating)

        controller = StressRatingController(storage)

        stressActivityType = intent.extras["StressActivity"] as StressActivity

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        ratingBar.setOnRatingBarChangeListener(RatingBar.OnRatingBarChangeListener { innerratingBar, rating, fromUser ->

            if (fromUser) {
                this.setRating(rating)
            }
        })
    }

    fun setRating(rating: Float) {
        this.rating = rating
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val stressRating = StressRating(Date(), rating, stressActivityType)
        controller.saveStressRating(stressRating)

        // Show graph
        val intent = Intent(this, HappinessGraphActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable("StressRatingStorage", storage as Serializable)
        intent.putExtra("BundleExtra", bundle)
        startActivity(intent)
        finish()
    }
}