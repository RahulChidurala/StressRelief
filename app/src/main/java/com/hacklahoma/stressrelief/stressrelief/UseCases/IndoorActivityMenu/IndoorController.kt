package com.hacklahoma.stressrelief.stressrelief.UseCases.IndoorActivityMenu

/**
 * Created by chrah on 3/3/2018.
 */
interface IIndoorController {

    var router: IIndoorRouter?

    fun actionToStretching()
    fun actionToBreathing()
}

class IndoorController: IIndoorController {

    override var router: IIndoorRouter? = null

    override fun actionToBreathing() {
        router?.goToBreathing()
    }

    override fun actionToStretching() {
        router?.goToStretching()
    }
}