package jaynewstrom.kaptbug

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.callback = DelegatingWindowCallback(window.callback)
    }
}

private class DelegatingWindowCallback(
    private val delegate: Window.Callback
) : Window.Callback by delegate {
    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (event.keyCode == KeyEvent.KEYCODE_BACK) {
            Log.d("DWC", "Back pressed!")
        }
        return delegate.dispatchKeyEvent(event)
    }
}
