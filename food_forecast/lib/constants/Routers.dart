import 'package:food_forecast/pages/guest_login/logic.dart';
import 'package:food_forecast/pages/setting/view.dart';
import 'package:food_forecast/pages/web_preview/view.dart';
import 'package:get/get.dart';

import '../pages/food_forecast/view.dart';
import '../pages/guest_login/view.dart';
import '../pages/login/view.dart';
import '../pages/register/view.dart';
import '../pages/submit_food/view.dart';
class Routers {
  static const String index = "/";
  static const String login = "/login";
  static const String register = "/register";
  static const String completeInfo = "/completeInfo";
  static const String foodForecast = "/foodForecast";
  static const String webPreview = "/webPreview";
  static const String setting = "/setting";
  static const String guestLogin = "/guestLogin";

  static final List<GetPage> getPages = [
    GetPage(name: login, page: () => const LoginPage()),
    GetPage(name: register, page: () => const RegisterPage()),
    GetPage(name: index, page: () => const SubmitFoodPage()),
    GetPage(name: foodForecast, page: () => const FoodForecastPage()),
    GetPage(name: webPreview, page: () => const WebPreviewPage(),),
    GetPage(name: setting, page: () => const SettingPage(),),
    GetPage(name: guestLogin, page: () => const GuestLoginPage(),),
  ];
}
