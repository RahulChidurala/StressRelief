package com.hacklahoma.stressrelief.stressrelief.UseCases.StressRating

import java.io.Serializable

/**
 * Created by chrah on 3/4/2018.
 */

interface IStressRatingStorage: Serializable {
    fun store(stressRating: StressRating)
    fun retrieveObject(byId: Int): StressRating?
    fun deleteObject(byId: Int)
    fun getAll(): Array<StressRating?>
}

class StressRatingMemoryStorage: IStressRatingStorage {

    private var dictionary = mutableMapOf<Int, StressRating?>()
    private var nextPrimaryKey = 1

    override fun store(stressRating: StressRating) {

        dictionary[nextPrimaryKey] = stressRating
        nextPrimaryKey++
    }

    override fun retrieveObject(byId: Int): StressRating? {
        return dictionary[byId]
    }

    override fun deleteObject(byId: Int) {

        dictionary.remove(byId)
    }

    override fun getAll(): Array<StressRating?> {

        return dictionary.values.toTypedArray()
    }
}