package com.example.camerakit.sample.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.snap.camerakit.support.widget.CameraLayout
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
            ) { innerPadding ->
                CameraPreview(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}
@Composable
fun CameraPreview(modifier: Modifier = Modifier) {
    AndroidView(
        factory = { context ->
            CameraLayout(context).apply {
                configureLensesCarousel {
                    observedGroupIds = setOf("REPLACE-THIS-WITH-YOUR-OWN-APP-SPECIFIC-VALUE")
                }
            }
        },
        modifier = modifier,
        update = { cameraLayout ->
            cameraLayout.startPreview()
        }
    )
}
