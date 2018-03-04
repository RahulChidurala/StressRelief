package com.hacklahoma.stressrelief.stressrelief.UseCases.Menu

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.hacklahoma.stressrelief.stressrelief.UseCases.IndoorActivities.IndoorActivity

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

//        val intent = Intent(context, OutdoorActivity::class.java)
//        context.startActivity(intent)
    }
}