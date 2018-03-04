package com.hacklahoma.stressrelief.stressrelief.UseCases.Menu

/**
 * Created by chrah on 3/3/2018.
 */

interface IMenuController {

    var router: IMenuRouter?

    fun actionIndoors()
    fun actionOutdoors()
}

class MenuController: IMenuController {

    override var router: IMenuRouter? = null

    override fun actionIndoors() {

        router?.goToIndoors()
    }

    override fun actionOutdoors() {

        router?.goToOutdoors()
    }
}