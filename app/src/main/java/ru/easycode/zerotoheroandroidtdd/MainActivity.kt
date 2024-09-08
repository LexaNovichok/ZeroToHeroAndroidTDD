package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private var state : State = State.Initial

    private lateinit var buttonRemove : Button
    private lateinit var text : TextView
    private lateinit var linearLayout : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRemove = findViewById(R.id.removeButton)
        text = findViewById(R.id.titleTextView)
        linearLayout = findViewById(R.id.rootLayout)

        buttonRemove.setOnClickListener {
            state = State.Removed
            state.apply(linearLayout, text)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            state = savedInstanceState.getSerializable(KEY, State::class.java) as State
        } else {
            state = savedInstanceState.getSerializable(KEY) as State
        }
        state.apply(linearLayout, text)
    }

    companion object {
        private const val KEY = "KEY"
    }
}


interface State : Serializable {

    fun apply(linearLayout: LinearLayout, textView: TextView)
    object Initial : State {
        override fun apply(linearLayout: LinearLayout, textView: TextView) = Unit

    }

    object Removed : State {
        override fun apply(linearLayout: LinearLayout, textView: TextView) {
            linearLayout.removeView(textView)
        }
    }
}

