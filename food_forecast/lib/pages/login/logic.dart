import 'package:fluttertoast/fluttertoast.dart';
import 'package:get/get.dart';

import '../../constants/ReqestApi.dart';
import '../../constants/Routers.dart';
import '../../utils/request/dio_http.dart';
import '../../utils/storage.dart';

class LoginLogic extends GetxController {
  var acceptProtocol = false.obs;
  String userName = '';
  String password = "";
  var loading = false.obs;

  void doLogin() async {
    var params = {"username": userName, "password": password};
    loading.value = true;
    DioHttp()
        .post(RequestApi.login, params: params, needToken: false)
        .then((value) {
      loading.value = false;
      if (value.code == 200)  {
        // success, save token
        Storage().setToken("${value.data}");
        // get user info
        // switch the page
        Get.offAndToNamed(Routers.index);
      } else {
        Fluttertoast.showToast(msg: value.msg);
      }
    });
  }
}
