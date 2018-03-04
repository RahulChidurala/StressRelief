package com.hacklahoma.stressrelief.stressrelief.UseCases.Graph

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.androidplot.xy.LineAndPointFormatter
import com.androidplot.xy.PointLabelFormatter
import com.androidplot.xy.SimpleXYSeries
import com.androidplot.xy.XYPlot
import com.hacklahoma.stressrelief.stressrelief.R
import com.hacklahoma.stressrelief.stressrelief.UseCases.StressActivity
import com.hacklahoma.stressrelief.stressrelief.UseCases.StressRating.IStressRatingStorage
import com.hacklahoma.stressrelief.stressrelief.UseCases.StressRating.StressRating
import com.hacklahoma.stressrelief.stressrelief.UseCases.StressRating.StressRatingActivity
import com.hacklahoma.stressrelief.stressrelief.UseCases.StressRating.StressRatingMemoryStorage
import java.util.*

/**
 * Created by chrah on 3/4/2018.
 */
class HappinessGraphActivity : AppCompatActivity() {

    private lateinit var storage: IStressRatingStorage
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundleFromExtra = intent.getBundleExtra("BundleExtra")
        storage = bundleFromExtra.getSerializable("StressRatingStorage") as IStressRatingStorage

        setContentView(R.layout.activity_happiness)

        var allStressRatings = storage.getAll()

        val fakeRating = StressRating(Date(), 3f, StressActivity.Breathing)
        val fakeRating2 = StressRating(Date(), 2f, StressActivity.Breathing)
        var list = ArrayList<StressRating>()
        list.add(fakeRating)
        list.add(fakeRating2)
        for(rating in allStressRatings) {
            if(rating != null) {
                list.add(rating!!)
            }
        }

        val plot = findViewById<XYPlot>(R.id.xy_plot)

        val breathingSeries = getPlotSeries("Breathing", list, StressActivity.Breathing)
        val breathingSeriesFormat = LineAndPointFormatter(R.color.colorChillBlud, R.color.black, R.color.colorChillBlud, PointLabelFormatter(R.color.colorChillBlud))
        plot.addSeries(breathingSeries, breathingSeriesFormat)
    }

    private fun getPlotSeries(seriesName: String, stressRatings: List<StressRating?>, filterBy: StressActivity): SimpleXYSeries {

        var filteredStressRatings = ArrayList<Float>()
        for(stressRating in stressRatings) {

            if(stressRating?.activityType == filterBy) {

                filteredStressRatings.add(stressRating.rating)
            }
        }

        var stressTypeString = "Unknown"
        when(filterBy) {
            StressActivity.Breathing -> stressTypeString = "Breathing"
            StressActivity.Stretching -> stressTypeString = "Stretching"
            StressActivity.OddlySatsifying -> stressTypeString = "OddlySatisfying"
        }

        var simpleXySeries = SimpleXYSeries(filteredStressRatings, SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, stressTypeString)
        return simpleXySeries
    }



}