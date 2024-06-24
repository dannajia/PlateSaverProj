import 'package:flutter_easyloading/flutter_easyloading.dart';
import 'package:get/get.dart';

import '../../constants/ReqestApi.dart';
import '../../utils/request/dio_http.dart';
import '../../utils/storage.dart';
import '../login/view.dart';

class SettingLogic extends GetxController {
  void deleteUser() {
    EasyLoading.show();
    EasyLoading.show();
    DioHttp().post(RequestApi.deleteUser).then((value) {
      if (value.code == 200) {
        EasyLoading.dismiss();
        Storage().setToken("");
        Get.offAll(const LoginPage());
      } else {
        EasyLoading.dismiss();
      }
    });
  }
}
