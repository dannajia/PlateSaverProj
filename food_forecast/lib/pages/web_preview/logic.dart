import 'package:get/get.dart';

class WebPreviewLogic extends GetxController {
  late String? title;
  late String? url;

  @override
  void onInit() {
    super.onInit();
    var argument = Get.parameters;
    title = argument['title'];
    url = argument['url'];
  }
}
