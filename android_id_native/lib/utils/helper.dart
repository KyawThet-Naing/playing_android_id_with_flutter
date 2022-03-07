import 'package:flutter/services.dart';

class Helper {
  static const methodChannel = MethodChannel("NATIVE_CHANNEL");
  static Future<String> getAndroidId() async =>
      await methodChannel.invokeMethod("getAndroidId");
}
