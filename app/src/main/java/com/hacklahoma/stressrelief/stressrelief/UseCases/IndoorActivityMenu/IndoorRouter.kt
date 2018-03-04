package com.hacklahoma.stressrelief.stressrelief.UseCases.IndoorActivityMenu

import android.content.Context
import android.content.Intent
import com.hacklahoma.stressrelief.stressrelief.UseCases.IndoorActivities.IndoorBreathing.IndoorBreathingActivity
import com.hacklahoma.stressrelief.stressrelief.UseCases.IndoorActivities.IndoorStretching.IndoorStrecthingActivity

/**
 * Created by chrah on 3/3/2018.
 */

interface IIndoorRouter {

    fun goToStretching()
    fun goToBreathing()
}

class IndoorRouter: IIndoorRouter {

    private var context: Context
    constructor(context: Context) {
        this.context = context
    }

    override fun goToBreathing() {

        val intent = Intent(context, IndoorBreathingActivity::class.java)
        context.startActivity(intent)
    }

    override fun goToStretching() {

        val intent = Intent(context, IndoorStrecthingActivity::class.java)
        context.startActivity(intent)
    }
}