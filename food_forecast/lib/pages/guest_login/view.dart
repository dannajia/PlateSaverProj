import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:get/get.dart';
import 'package:url_launcher/url_launcher_string.dart';

import '../../components/RoundContainer.dart';
import '../../constants/CustomTitles.dart';
import '../../utils/storage.dart';
import '../login/view.dart';
import 'logic.dart';

class GuestLoginPage extends StatefulWidget {
  const GuestLoginPage({super.key});

  @override
  _GuestLoginPageState createState() => _GuestLoginPageState();
}

class _GuestLoginPageState extends State<GuestLoginPage> {
  final logic = Get.put(GuestLoginLogic());

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Theme.of(context).backgroundColor,
      appBar: AppBar(
        backgroundColor: Theme.of(context).backgroundColor,
        elevation: 0.0,
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
        actions: [
          IconButton(
            onPressed: () {
              Storage().setToken("");
              Get.offAll(const LoginPage());
            },
            icon: const Icon(Icons.exit_to_app_rounded),
          ),
        ],
      ),
      body: GetBuilder<GuestLoginLogic>(
        builder: (controller) => SizedBox.expand(
          child: Column(
            children: [
              Container(
                padding: EdgeInsets.only(left: 60.w, top: 10.w, bottom: 32.w),
                alignment: Alignment.topLeft,
                child: Text(
                  CustomTitles.forecastPage,
                  style: TextStyle(
                      fontSize: 52.w,
                      color: Colors.black,
                      fontWeight: FontWeight.w700),
                ),
              ),
              Expanded(
                child: ListView.separated(
                    padding:
                        EdgeInsets.symmetric(horizontal: 32.w, vertical: 32.w),
                    itemBuilder: (context, index) {
                      return _buildItem(index);
                    },
                    separatorBuilder: (context, index) => SizedBox(
                          height: 32.w,
                        ),
                    itemCount: 6),
              )
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildItem(index) {
    String title = "";
    double? percent = 0.0;
    List users = [];
    String img = "ve.png";

    if (index == 0) {
      title = "Vegetables";
      percent = logic.recordBean.vegetables;
      users = logic.vegetables;
      img = "ve.png";
    } else if (index == 1) {
      title = "Fruits";
      percent = logic.recordBean.fruits;
      users = logic.fruits;
      img = "fr.png";
    } else if (index == 2) {
      title = "Proteins";
      percent = logic.recordBean.proteins;
      users = logic.proteins;
      img = "pr.png";
    } else if (index == 3) {
      title = "Grains";
      percent = logic.recordBean.grains;
      users = logic.grains;
      img = "gr.png";
    } else if (index == 4) {
      title = "Entrees";
      percent = logic.recordBean.entrees;
      users = logic.entrees;
      img = "en.png";
    } else if (index == 5) {
      title = "Milk";
      percent = logic.recordBean.milk;
      users = logic.milk;
      img = "mil.png";
    }

    Image icon = Image.asset(
      "assets/foods/$img",
      width: 30.w,
      height: 30.w,
    );

    return RoundContainer(
      borderRadius: 16.w,
      backgroundColor: const Color(0xffF7F7F7),
      padding: EdgeInsets.all(24.w),
      child: Column(
        children: [
          Row(
            children: [
              icon,
              SizedBox(
                width: 12.w,
              ),
              Text("$title Forecast"),
              const Spacer(),
              Text("$percent")
            ],
          ),
          SizedBox(
            height: 24.w,
          ),
          RoundContainer(
            borderRadius: 16.w,
            backgroundColor: Colors.white,
            padding: EdgeInsets.all(24.w),
            child: Column(
              children: [
                Row(
                  children: [
                    Expanded(
                      flex: 1,
                      child: Text(
                        "Contact info of possible matching students",
                        style: TextStyle(color: Theme.of(context).primaryColor),
                      ),
                    ),
                    Text(
                      "Forecast",
                      style: TextStyle(color: Theme.of(context).primaryColor),
                    ),
                  ],
                ),
                ...users
                    .map((e) => GestureDetector(
                          onTap: () async {
                            String url = 'tel:${e['phone']}';
                            if (!await launchUrlString(url)) {
                              throw Exception('Could not launch');
                            }
                          },
                          behavior: HitTestBehavior.opaque,
                          child: Padding(
                            padding: EdgeInsets.symmetric(vertical: 12.w),
                            child: Row(
                              children: [
                                Icon(
                                  Icons.phone_forwarded_rounded,
                                  size: 32.w,
                                ),
                                SizedBox(
                                  width: 12.w,
                                ),
                                Text("${e['phone']}"),
                                const Spacer(),
                                Text("${e[title.toLowerCase()]}")
                              ],
                            ),
                          ),
                        ))
                    .toList(),
              ],
            ),
          ),
        ],
      ),
    );
  }

  @override
  void dispose() {
    Get.delete<GuestLoginLogic>();
    super.dispose();
  }
}
