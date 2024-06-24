import 'package:fluttertoast/fluttertoast.dart';
import 'package:get/get.dart';
import '../../bean/RegisterBean.dart';
import '../../constants/ReqestApi.dart';
import '../../constants/Routers.dart';
import '../../utils/request/dio_http.dart';
import '../../utils/storage.dart';
import '../../bean/RecordBean.dart';
import 'package:flutter_easyloading/flutter_easyloading.dart';

class GuestLoginLogic extends GetxController {
  var isLoading = true.obs;
  RecordBean recordBean = RecordBean();
  List vegetables = [];
  List fruits = [];
  List milk = [];
  List entrees = [];
  List grains = [];
  List proteins = [];

  var acceptProtocol = false.obs;
  String userName = 'guest';
  String password = 'guest';
  var loading = false.obs;

  @override
  void onReady() {
    doLogin();
    super.onReady();
    initData();
  }


  void doLogin()  {
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

  void initData() {
    EasyLoading.show();
    DioHttp().get(RequestApi.saveRecord).then((value) {
      if (value.code == 200) {
        EasyLoading.dismiss();
        recordBean = RecordBean.fromJson(value.data['forecast']);
        vegetables = value.data['vegetables'] as List;
        fruits = value.data['fruits'] as List;
        milk = value.data['milk'] as List;
        entrees = value.data['entrees'] as List;
        grains = value.data['grains'] as List;
        proteins = value.data['proteins'] as List;
        update();
      }
    });
  }
}
