import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:food_forecast/pages/PdfView.dart';
import 'package:get/get.dart';
import '../../components/RoundContainer.dart';
import '../../constants/CustomTitles.dart';
import '../../constants/Routers.dart';
import 'logic.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({super.key});

  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final logic = Get.put(LoginLogic());

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      resizeToAvoidBottomInset: false,
      backgroundColor: Theme.of(context).backgroundColor,
      body: SizedBox.expand(
        child: Stack(
          children: [
            Column(
              mainAxisSize: MainAxisSize.max,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                SizedBox(
                  height: 200.w,
                ),
                Container(
                  padding: EdgeInsets.only(left: 60.w),
                  alignment: Alignment.topLeft,
                  child: Text(
                    CustomTitles.loginPage,
                    style: TextStyle(
                        fontSize: 52.w,
                        color: Colors.black,
                        fontWeight: FontWeight.w700),
                  ),
                ),
                SizedBox(
                  height: 100.w,
                ),
                RoundContainer(
                  padding:
                      EdgeInsets.symmetric(horizontal: 46.w, vertical: 10.w),
                  margin: EdgeInsets.symmetric(horizontal: 64.w),
                  borderRadius: 12.w,
                  backgroundColor: const Color(0xffF7F7F7),
                  child: TextField(
                    keyboardType: TextInputType.name,
                    textInputAction: TextInputAction.next,
                    onChanged: (value) {
                      logic.userName = value;
                    },
                    style: TextStyle(fontSize: 30.w, color: Colors.black87),
                    maxLines: 1,
                    decoration: const InputDecoration(
                      hintText: "User Name",
                      border: InputBorder.none,
                    ),
                  ),
                ),
                SizedBox(
                  height: 32.w,
                ),
                RoundContainer(
                  padding:
                      EdgeInsets.symmetric(horizontal: 46.w, vertical: 10.w),
                  margin: EdgeInsets.symmetric(horizontal: 64.w),
                  borderRadius: 12.w,
                  backgroundColor: const Color(0xffF7F7F7),
                  child: TextField(
                    keyboardType: TextInputType.visiblePassword,
                    onChanged: (value) {
                      logic.password = value;
                    },
                    obscureText: true,
                    style: TextStyle(fontSize: 30.w, color: Colors.black87),
                    maxLines: 1,
                    decoration: const InputDecoration(
                      hintText: "Password",
                      border: InputBorder.none,
                    ),
                  ),
                ),
                SizedBox(
                  height: 100.w,
                ),
                Center(
                  child: Row(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Obx(() => Checkbox(
                            activeColor: Theme.of(context).primaryColor,
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(10.w),
                            ),
                            value: logic.acceptProtocol.value,
                            onChanged: (value) {
                              logic.acceptProtocol.value = value ?? false;
                            },
                          )),
                      Container(
                        child: RichText(
                          softWrap: false,
                          text: TextSpan(
                              text: "Read and agree",
                              style: const TextStyle(color: Colors.black87),
                              children: [
                                TextSpan(
                                    text: "《User protocol》\n",
                                    style: TextStyle(
                                      color: Theme.of(context).primaryColor,
                                    ),
                                    recognizer: TapGestureRecognizer()
                                      ..onTap = () {
                                        Navigator.push(
                                            context,
                                            MaterialPageRoute(
                                              builder: (context) =>
                                                  const PdfViewPage(
                                                fileName: "TERMS_OF_USE",
                                                pageTitle: "TERMS OF USE",
                                              ),
                                            ));
                                      }),
                                TextSpan(
                                    text: "《Privacy agreement》",
                                    style: TextStyle(
                                      color: Theme.of(context).primaryColor,
                                    ),
                                    recognizer: TapGestureRecognizer()
                                      ..onTap = () {
                                        Navigator.push(
                                            context,
                                            MaterialPageRoute(
                                              builder: (context) =>
                                                  const PdfViewPage(
                                                      fileName:
                                                          "PRIVACY_NOTICE",
                                                      pageTitle:
                                                          "PRIVACY NOTICE"),
                                            ));
                                      }),
                              ]),
                        ),
                      )
                    ],
                  ),
                ),
                SizedBox(
                  height: 20.w,
                ),
                Obx(
                  () => ElevatedButton(
                    style: ElevatedButton.styleFrom(
                      textStyle: TextStyle(fontSize: 32.w),
                      elevation: 0,
                      backgroundColor: Theme.of(context).primaryColor,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(12.w),
                      ),
                      fixedSize: Size(620.w, 100.w),
                    ),
                    onPressed: logic.loading.value
                        ? null
                        : () {
                            // check if the protocol is accepted
                            if (!logic.acceptProtocol.value) {
                              Fluttertoast.showToast(
                                  msg: "please read and accept protocols");
                              return;
                            }
                            if (logic.userName.isEmpty ||
                                logic.password.isEmpty) {
                              Fluttertoast.showToast(
                                  msg: "please complete login information");
                              return;
                            }
                            logic.doLogin();
                          },
                    child: logic.loading.value
                        ? CircularProgressIndicator(
                            color: Theme.of(context).primaryColor,
                          )
                        : const Text(
                            "Login",
                            style: TextStyle(color: Colors.white),
                          ),
                  ),
                ),
                SizedBox(
                  height: 12.w,
                ),
                Obx(
                  () => TextButton(
                    onPressed: logic.loading.value
                        ? null
                        : () {
                            Get.toNamed(Routers.register);
                          },
                    child: Text(
                      "Register",
                      style: TextStyle(color: Theme.of(context).primaryColor),
                    ),
                  ),
                ),
                SizedBox(
                  height: 12.w,
                ),
                Obx(
                      () => TextButton(
                    onPressed: logic.loading.value
                        ? null
                        : () {
                      Get.toNamed(Routers.guestLogin);
                    },
                    child: Text(
                      "Guest Login",
                      style: TextStyle(color: Theme.of(context).primaryColor),
                    ),
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }

  @override
  void dispose() {
    Get.delete<LoginLogic>();
    super.dispose();
  }
}
