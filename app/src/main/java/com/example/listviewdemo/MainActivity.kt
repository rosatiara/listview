package com.example.listviewdemo

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listView)
//        val redColor = Color.parseColor("#FF0000")
//        listView.setBackgroundColor(redColor)

        listView.adapter = MyCustomAdapter(this)
    }
    private class MyCustomAdapter(context: Context): BaseAdapter() {
        private val mContext: Context

        private val names = arrayListOf<String>(
            "Elon Musk", "Brendon Urie", "Matthew Gray Gubler", "David Beckham", "Steve Jobs"
        )

        init {
           mContext = context
        }

        // counting how many rows are in the list
        override fun getCount(): Int {
            return names.size // make the amount of rows is equal to the names array size
        }
        override fun getItemId(position: Int): Long {
           return position.toLong()
        }

        override fun getItem(position: Int): Any {
           return "test"
        }
        //rendering out each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false) //inflates the rowMain based on the resources passed

            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textview)
            nameTextView.text = names.get(position)
            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
            positionTextView.text = "This is row ${position+1}"
            return rowMain
//            val textView = TextView(mContext)
//            textView.text = "Here's my row for my ListView"
//            return textView
        }
    }
}