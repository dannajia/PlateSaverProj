import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class MultiProgressImgComponent extends StatelessWidget {
  final double size;
  final double totalTime;
  final double curTime;

  const MultiProgressImgComponent({
    Key? key,
    required this.size,
    required this.totalTime,
    required this.curTime,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return CircleAvatar(
      radius: size,
      backgroundColor: Colors.blue,
    );
  }
}
