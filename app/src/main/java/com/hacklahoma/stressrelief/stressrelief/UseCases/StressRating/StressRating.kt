package com.hacklahoma.stressrelief.stressrelief.UseCases.StressRating

import com.hacklahoma.stressrelief.stressrelief.UseCases.StressActivity
import java.io.Serializable
import java.util.*

/**
 * Created by chrah on 3/4/2018.
 */
class StressRating: Serializable {

    var timestamp: Date

    /**
     * From 1 - 5
     */
    var rating: Float

    var activityType: StressActivity

    constructor(timestamp: Date, rating: Float, activityType: StressActivity) {
        this.timestamp = timestamp
        this.rating = rating
        this.activityType = activityType
    }
}