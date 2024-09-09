package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private var state : State = State.Initial

    private lateinit var linearLayout : LinearLayout
    private lateinit var textView : TextView
    private lateinit var buttonRemove : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayout = findViewById(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)
        buttonRemove = findViewById(R.id.removeButton)

        buttonRemove.setOnClickListener {
            state = State.Removed
            state.applyTextView(linearLayout, textView)
            state.enableButton(buttonRemove)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putSerializable(KEY, state)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            state = savedInstanceState.getSerializable(KEY, State::class.java) as State
        } else {
            state = savedInstanceState.getSerializable(KEY) as State
        }
        state.applyTextView(linearLayout, textView)
        state.enableButton(buttonRemove)

        super.onRestoreInstanceState(savedInstanceState)
    }
    companion object {
        private const val KEY = "KEY"
    }
}


interface State : Serializable {

    fun applyTextView(linearLayout: LinearLayout, textView: TextView)
    fun enableButton(button: Button)
    object Initial : State {
        override fun applyTextView(linearLayout: LinearLayout, textView: TextView) = Unit

        override fun enableButton(button: Button) = Unit

    }

    object Removed : State {
        override fun applyTextView(linearLayout: LinearLayout, textView: TextView) {
            linearLayout.removeView(textView)
        }

        override fun enableButton(button: Button) {
            button.isEnabled = false
        }

    }
}