import '/utils/helper.dart';
import 'package:flutter/material.dart';

class Home extends StatelessWidget {
  const Home({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Android Id"),
        centerTitle: true,
      ),
      body: FutureBuilder<String>(
        future: Helper.getAndroidId(),
        builder: (conext, snapshot) {
          if (snapshot.hasData) {
            return Center(
              child: Text(snapshot.data!),
            );
          } else {
            return const Center(child: CircularProgressIndicator());
          }
        },
      ),
    );
  }
}
