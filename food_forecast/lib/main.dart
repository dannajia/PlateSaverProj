import 'package:flutter/material.dart';
import 'package:flutter_easyloading/flutter_easyloading.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:food_forecast/utils/storage.dart';
import 'package:get/get.dart';
import 'package:get_storage/get_storage.dart';

import 'constants/Routers.dart';

void main() async {
  await GetStorage.init();
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    // check login
    String? token = Storage().getToken();
    bool noLogin = false;
    if (token == null || token.isEmpty) {
      noLogin = true;
    }
    return ScreenUtilInit(
      designSize: const Size(750, 1334),
      useInheritedMediaQuery: true,
      builder: (BuildContext context, Widget? child) {
        return GetMaterialApp(
          debugShowCheckedModeBanner: false,
          title: "food forecast",
          theme: ThemeData(
              primaryColor: const Color(0xff00ac00),
              backgroundColor: const Color(0xffEAEEEA),
              buttonTheme: const ButtonThemeData(
                buttonColor: Color(0xff00ac00),
              )),
          initialRoute: noLogin ? Routers.login : Routers.index,
          getPages: Routers.getPages,
          builder: EasyLoading.init(),
        );
      },
    );
  }
}
