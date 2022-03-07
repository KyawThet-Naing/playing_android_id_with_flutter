package com.example.android_id_native

import android.annotation.SuppressLint
import android.provider.Settings
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    private val nativeChannel = "NATIVE_CHANNEL"
    private lateinit var methodChannel: MethodChannel
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        methodChannel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, nativeChannel)

        methodChannel.setMethodCallHandler { call, result ->

            if (call.method == "getAndroidId") {
                val response = getAndroidId()
                result.success(response)
            }

        }
    }

    @SuppressLint("HardwareIds")
    private fun getAndroidId(): String {
        return Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)
    }
}
