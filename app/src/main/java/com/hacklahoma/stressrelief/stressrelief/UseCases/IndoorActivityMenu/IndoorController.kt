package com.hacklahoma.stressrelief.stressrelief.UseCases.IndoorActivityMenu

import java.lang.ref.WeakReference

/**
 * Created by chrah on 3/3/2018.
 */
interface IIndoorController {

    var router: WeakReference<IIndoorRouter>?

    fun actionToStretching()
    fun actionToBreathing()
}

class IndoorController: IIndoorController {

    override var router: WeakReference<IIndoorRouter>? = null

    constructor(router: IIndoorRouter) {

        this.router = WeakReference(router)
    }

    override fun actionToBreathing() {
        router!!.get()?.goToBreathing()
    }

    override fun actionToStretching() {
        router!!.get()?.goToStretching()
    }
}