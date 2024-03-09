package com.github.billman64.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.findFragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.replace
import com.github.billman64.fragment.ui.theme.FragmentTheme

class MainActivity : FragmentActivity(R.layout.activity_main) {
    // Tip: ComponentActivity would not work with a fragment. Use a different type of activity, such as FragmentActivity or AppCompatActivity, instead.

    private val TAG: String = "FD-MainActivity"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate()")

        // setContentView() not needed here, since the layout can be defined in the constructor of a FragmentActivity or AppCompatActivity, thanks to AndroidX.

        val btn1:Button = findViewById(R.id.button1)
        val defaultButtonColor = btn1.background
        Log.d(TAG, "button color: $defaultButtonColor")
    }

    fun selectFragment(view: View) {
        Log.d(TAG, "button "+ view.id +" tapped")

        // create object for fragment
        var fr: Fragment

        // display fragment 1, if button1 is clicked
        if(view == findViewById(R.id.button1)){
            fr = FragmentOne()
            val btn1: Button = findViewById(R.id.button1)
            val btn2: Button = findViewById(R.id.button2)
//            btn1.setBackgroundColor(Color.YELLOW) //TODO: highlight button associated with currently selected fragment, but need to find way to get non-highlighted button color
//            btn2.setBackgroundColor(Color.GRAY)
        }
        // display fragment2, if button2
        else {
            fr = FragmentTwo()
        }

        // add/replace fragment
        val fm:FragmentManager = supportFragmentManager     // supportFragmentManager needed to initialize
        val fragmentTransaction:FragmentTransaction  = fm.beginTransaction()
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)    // Standardized fragment animation
        fragmentTransaction.replace(R.id.fragment_section, fr)
        fragmentTransaction.commit()

        //TODO: animate fragment transition, with custom animation, for visual effect - https://developer.android.com/guide/fragments/animate
    }
}
