package com.github.billman64.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
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

    }

    fun selectFragment(view: View) {
        Log.d(TAG, "button clicked")

        // create object for fragment
        var fr: Fragment

        // display fragment 1, if button1 is clicked
        if(view == findViewById(R.id.button1)){
            fr = FragmentOne()
        }
        // display fragment2, if button2
        else {
            fr = FragmentTwo()
        }

        // add/replace fragment
        val fm:FragmentManager = supportFragmentManager     // supportFragmentManager needed to initialize
        val fragmentTransaction:FragmentTransaction  = fm.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_section, fr)
        fragmentTransaction.commit()

        //TODO: animate fragment transition for visual effect - https://developer.android.com/guide/fragments/animate
    }
}




//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    FragmentTheme {
//        Greeting("Android")
//    }
//}