import 'dart:collection';

import 'package:flutter/material.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:get/get.dart';

import 'logic.dart';

class WebPreviewPage extends StatefulWidget {
  const WebPreviewPage({super.key});

  @override
  _WebPreviewPageState createState() => _WebPreviewPageState();
}

class _WebPreviewPageState extends State<WebPreviewPage> {
  final logic = Get.put(WebPreviewLogic());

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Theme.of(context).backgroundColor,
      appBar: AppBar(
        leading: IconButton(
          icon: Image.asset(
            "assets/foods/back.png",
            width: 36.w,
            height: 36.w,
          ),
          onPressed: () {
            Navigator.pop(context);
          },
        ),
        backgroundColor: Theme.of(context).backgroundColor,
        title: Text(
          "${logic.title}",
          style: const TextStyle(color: Colors.black),
        ),
        elevation: 0.0,
      ),
      body: SizedBox.expand(
        child: InAppWebView(
          initialUrlRequest: URLRequest(url: Uri.https("${logic.url}")),
          initialUserScripts: UnmodifiableListView<UserScript>([]),
        ),
      ),
    );
  }

  @override
  void dispose() {
    Get.delete<WebPreviewLogic>();
    super.dispose();
  }
}
