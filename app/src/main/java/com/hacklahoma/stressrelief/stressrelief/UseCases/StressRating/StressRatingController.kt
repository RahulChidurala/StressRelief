package com.hacklahoma.stressrelief.stressrelief.UseCases.StressRating

import java.lang.ref.WeakReference

/**
 * Created by chrah on 3/4/2018.
 */

interface IStressRatingController {

    var storage: WeakReference<IStressRatingStorage>?

    fun saveStressRating(stressRating: StressRating)
}

class StressRatingController: IStressRatingController {

    override var storage: WeakReference<IStressRatingStorage>?
    constructor(storage: IStressRatingStorage) {
        this.storage = WeakReference(storage)
    }

    override fun saveStressRating(stressRating: StressRating) {

        storage!!.get()?.store(stressRating)
    }
}