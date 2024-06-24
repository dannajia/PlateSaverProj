import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

getAppBar(title) {
  return AppBar(
    title: Text(
      title,
      style: TextStyle(color: Colors.black87, fontSize: 36.w),
    ),
    backgroundColor: Colors.transparent,
    iconTheme: const IconThemeData(color: Colors.black87),
    elevation: 0,
  );
}
