package com.hacklahoma.stressrelief.stressrelief.UseCases.Menu

import android.content.Context
import android.content.Intent
import com.hacklahoma.stressrelief.stressrelief.UseCases.IndoorActivityMenu.IndoorActivity
import com.hacklahoma.stressrelief.stressrelief.UseCases.OutdoorActivities.OutdoorMenu.OutdoorMenuActivity

/**
 * Created by chrah on 3/3/2018.
 */

interface IMenuRouter {

    fun goToIndoors()
    fun goToOutdoors()
}

class MenuRouter: IMenuRouter {

    private var context: Context

    constructor(context: Context) {
        this.context = context
    }

    override fun goToIndoors() {

        val intent = Intent(context, IndoorActivity::class.java)
        context.startActivity(intent)
    }

    override fun goToOutdoors() {

        val intent = Intent(context, OutdoorMenuActivity::class.java)
        context.startActivity(intent)
    }
}