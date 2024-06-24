import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:fluttertoast/fluttertoast.dart';

import '../../constants/ReqestApi.dart';
import '../../utils/reg_pattern.dart';
import '../../utils/request/dio_http.dart';
import 'SmsController.dart';

class SendSmsCodeComponent extends StatefulWidget {
  final SmsController controller;

  const SendSmsCodeComponent({Key? key, required this.controller})
      : super(key: key);

  @override
  State<SendSmsCodeComponent> createState() => _SendSmsCodeComponentState();
}

class _SendSmsCodeComponentState extends State<SendSmsCodeComponent> {
  Timer? _timer;
  int _count = 60;
  String text = "Get Verification Code";

  String phone = '';

  setPhone(String phone) {
    this.phone = phone;
  }

  @override
  void initState() {
    super.initState();
    widget.controller.setPhone = setPhone;
  }

  @override
  Widget build(BuildContext context) {
    bool isWaiting = _count != 60;

    return TextButton(
      style: TextButton.styleFrom(
        textStyle: TextStyle(
          fontSize: 30.w,
        ),
      ),
      onPressed: isWaiting
          ? null
          : () {
              if (phone.isEmpty) {
                Fluttertoast.showToast(msg: "Please input cell phone#");
                return;
              }
              // check if the phone# is valid
              RegExp exp = RegExp(RegPattern.mobilePattern);
              bool matched = exp.hasMatch(phone);
              if (!matched) {
                Fluttertoast.showToast(msg: "incorret cell phone number format");
                return;
              }
              if (isWaiting) return;
              startTimer();
              doSendReq();
            },
      child: Text(
        isWaiting ? 'Please wait $_count S' : "Send Verification Code",
        style: TextStyle(color: Theme.of(context).primaryColor),
      ),
    );
  }

  // Send request for verification code
  doSendReq() async {
    var params = {"phone": phone};
    await DioHttp().get(
      RequestApi.login,
      params: params,
      needToken: false,
    );
  }

  startTimer() {
    _timer = Timer.periodic(const Duration(milliseconds: 1000), (timer) {
      _count--;
      if (_count <= 0) {
        _count = 60;
        timer.cancel();
      }
      setState(() {});
    });
  }

  cancelTimer() {
    if (_timer != null) {
      _timer!.cancel();
    }
  }

  @override
  void dispose() {
    // TODO: implement dispose
    cancelTimer();
    super.dispose();
  }
}
