import 'package:fluttertoast/fluttertoast.dart';
import 'package:get/get.dart';
import '../../bean/RecordBean.dart';
import '../../constants/ReqestApi.dart';
import '../../constants/Routers.dart';
import '../../utils/request/dio_http.dart';

class SubmitFoodLogic extends GetxController {
  RecordBean recordBean = RecordBean();
  var loading = false.obs;

  // save record
  void saveRecord() {
    loading.value = true;
    DioHttp()
        .post(RequestApi.saveRecord, params: recordBean.toJson())
        .then((value) {
      loading.value = false;
      if (value.code == 200) {
        // switch the page
        Get.toNamed(Routers.foodForecast);
      } else {
        Fluttertoast.showToast(msg: value.msg);
      }
    });
  }
}
