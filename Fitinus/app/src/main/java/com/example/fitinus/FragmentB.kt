package com.example.fitinus


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.fragment_b.*
import kotlinx.android.synthetic.main.fragment_c.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class FragmentB (var c : Context): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        stress_bar.indeterminateDrawable.setColorFilter(Color.rgb(60,179,113), android.graphics.PorterDuff.Mode.MULTIPLY)


        timeGenerator_b()

        var graphData = ArrayList<BarEntry>()
        graphData.add(BarEntry(0f, 200f))
        graphData.add(BarEntry(1f, 300f))
        graphData.add(BarEntry(2f, 250f))
        graphData.add(BarEntry(3f, 0f))
        graphData.add(BarEntry(4f, 400f))
        graphData.add(BarEntry(5f, 700f))
        graphData.add(BarEntry(6f, 200f))
        graphData.add(BarEntry(7f, 0f))
        graphData.add(BarEntry(8f, 300f))
        graphData.add(BarEntry(9f, 600f))
        graphData.add(BarEntry(10f, 700f))

        initLineChart()
        setChart(graphData)
    }

    fun timeGenerator_b(){
        val instance = Calendar.getInstance()
        var month = (instance.get(Calendar.MONTH) + 1).toString()
        var date = instance.get(Calendar.DATE).toString()
        if (month.toInt() < 10) {
            month = "0$month"
        }
        if (date.toInt() < 10) {
            date = "0$date"
        }
        var day = instance.get(Calendar.DAY_OF_WEEK).toString()
        if(day == "1"){
            day = "월"
        }
        else if(day == "2"){
            day = "화"
        }
        else if(day == "3"){
            day = "수"
        }
        else if(day == "4"){
            day = "목"
        }
        else if(day == "5"){
            day = "금"
        }
        else if(day == "6"){
            day = "토"
        }
        else{
            day = "일"
        }
        date_b.text = month + "월 " + date + "일 " + day
    }

    fun initLineChart(){

        val xAxis = graph.xAxis
        xAxis.setDrawLabels(false)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1f

        val rightYAxis = graph.axisRight
        rightYAxis.setDrawLabels(false)

    }

    fun setChart(listData : ArrayList<BarEntry>){

        val dataSet = BarDataSet(listData, "Stress")
        //dataSet.color = ContextCompat.getColor(c, android.R.color.holo_green_light)
        val color_list : ArrayList<Int> = ArrayList<Int>()
        color_list.add(ContextCompat.getColor(c, android.R.color.holo_green_light))
        color_list.add(ContextCompat.getColor(c, android.R.color.holo_orange_light))
        color_list.add(ContextCompat.getColor(c, android.R.color.holo_blue_light))
        dataSet.colors = color_list

        dataSet.valueTextColor = ContextCompat.getColor(c, android.R.color.black)

        val lineData = BarData(dataSet)
        graph.setFitBars(true)
        graph.data = lineData
        graph.invalidate()
    }

}
