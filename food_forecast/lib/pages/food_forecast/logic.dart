import 'package:flutter_easyloading/flutter_easyloading.dart';
import 'package:get/get.dart';

import '../../bean/RecordBean.dart';
import '../../constants/ReqestApi.dart';
import '../../utils/request/dio_http.dart';

class FoodForecastLogic extends GetxController {
  var isLoading = true.obs;
  RecordBean recordBean = RecordBean();
  List vegetables = [];
  List fruits = [];
  List milk = [];
  List entrees = [];
  List grains = [];
  List proteins = [];

  @override
  void onReady() {
    super.onReady();
    initData();
  }

  // get forecast
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
