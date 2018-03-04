package com.hacklahoma.stressrelief.stressrelief.UseCases.IndoorActivities.IndoorBreathing

import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.hacklahoma.stressrelief.stressrelief.R
import android.R.attr.y
import android.R.attr.x
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.TimeInterpolator
import android.graphics.Point
import android.support.v4.media.session.PlaybackStateCompat
import android.view.Display
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import java.util.*
import kotlin.concurrent.schedule


/**
 * Created by chrah on 3/3/2018.
 */
class IndoorBreathingActivity: AppCompatActivity() {

    private lateinit var img_breathingCircle: ImageView

    private var timer = Timer()

    private final val MAX_CIRCLE_SCALE = 1.8f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_indoor_breathing)

        img_breathingCircle = findViewById(R.id.img_breathingCircle)

        enlargeCircle()
    }

    private fun enlargeCircle() {

        val valueAnimator = ValueAnimator.ofFloat(1f, MAX_CIRCLE_SCALE)
        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            img_breathingCircle.scaleX = value
            img_breathingCircle.scaleY = value
        }

        valueAnimator.addListener(object: AnimatorListenerAdapter() {

            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)

                Timer().schedule(2000) {

                    runOnUiThread {
                        shrinkCircle()
                    }
                }
            }
        })

        valueAnimator.interpolator = DecelerateInterpolator(1.3f)
        valueAnimator.duration = 5000
        valueAnimator.start()
    }

    private fun shrinkCircle() {

        val valueAnimator = ValueAnimator.ofFloat(MAX_CIRCLE_SCALE, 1f)
//2
        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            img_breathingCircle.scaleX = value
            img_breathingCircle.scaleY = value
        }

        valueAnimator.addListener(object: AnimatorListenerAdapter() {

            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)

                Timer().schedule(2000) {
                    runOnUiThread {
                        enlargeCircle()
                    }
                }
            }
        })

        valueAnimator.interpolator = DecelerateInterpolator(1.3f)
        valueAnimator.duration = 5000
        valueAnimator.start()
    }
}