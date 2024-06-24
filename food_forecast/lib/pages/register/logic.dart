import 'package:fluttertoast/fluttertoast.dart';
import 'package:get/get.dart';
import '../../bean/RegisterBean.dart';
import '../../constants/ReqestApi.dart';
import '../../constants/Routers.dart';
import '../../utils/request/dio_http.dart';
import '../../utils/storage.dart';

class RegisterLogic extends GetxController {
  var acceptProtocol = false.obs;
  RegisterBean registerBean = RegisterBean(userSchool: "Langley HS");
  var loading = false.obs;

  // registration
  void register() {
    loading.value = true;
    DioHttp()
        .post(RequestApi.register,
            params: registerBean.toJson(), needToken: false)
        .then((value) {
      loading.value = false;
      if (value.code == 200) {
        // succeed，save token
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
