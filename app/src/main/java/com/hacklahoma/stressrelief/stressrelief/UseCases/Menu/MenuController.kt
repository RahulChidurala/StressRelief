package com.hacklahoma.stressrelief.stressrelief.UseCases.Menu

import java.lang.ref.Reference
import java.lang.ref.WeakReference
import java.util.*

/**
 * Created by chrah on 3/3/2018.
 */

interface IMenuController {

    var router: WeakReference<IMenuRouter>?

    fun actionIndoors()
    fun actionOutdoors()
}

class MenuController: IMenuController {

    override var router: WeakReference<IMenuRouter>? = null

    constructor(router: IMenuRouter) {
        this.router = WeakReference(router)
    }

    override fun actionIndoors() {

        router!!.get()?.goToIndoors()
    }

    override fun actionOutdoors() {

        router!!.get()?.goToOutdoors()
    }
}