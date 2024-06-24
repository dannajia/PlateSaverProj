import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class LabelComponent extends StatelessWidget {
  final String labelText;
  final Color textColor;
  final Color bgColor;

  const LabelComponent(
      {Key? key,
      required this.labelText,
      required this.textColor,
      required this.bgColor})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisSize: MainAxisSize.min,
      children: [Container(
        height: 38.w,
        decoration: BoxDecoration(
          color: bgColor,
          borderRadius: BorderRadius.circular(20.w),
        ),
        padding: EdgeInsets.symmetric(horizontal: 20.w),
        child: Center(
          child: Text(
            labelText,
            style: TextStyle(fontSize: 22.w, color: textColor),
          ),
        ),
      )],
    );
  }
}
