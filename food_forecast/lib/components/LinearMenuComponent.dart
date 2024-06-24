import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

import 'RoundContainer.dart';

class LinearMenuComponent extends StatefulWidget {
  final ValueChanged<int> onChanged;

  const LinearMenuComponent({Key? key, required this.onChanged})
      : super(key: key);

  @override
  State<LinearMenuComponent> createState() => _LinearMenuComponentState();
}

class _LinearMenuComponentState extends State<LinearMenuComponent> {
  late int curIndex;

  @override
  void initState() {
    super.initState();
    curIndex = 0;
  }

  @override
  Widget build(BuildContext context) {
    return RoundContainer(
      borderRadius: 40.w,
      backgroundColor: const Color(0xffF6F6F6),
      padding: EdgeInsets.symmetric(horizontal: 12.w),
      child: Row(
        mainAxisSize: MainAxisSize.max,
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          getItem("日", 0),
          getItem("周", 1),
          getItem("月", 2),
          getItem("年", 3),
        ],
      ),
    );
  }

  TextStyle normalText = TextStyle(fontSize: 28.w, color: Colors.black87);
  TextStyle selectText = TextStyle(fontSize: 28.w, color: Colors.white);

  Color themeColor = const Color(0xffFFA53D);

  Widget getItem(title, position) {
    return Expanded(
        flex: 1,
        child: GestureDetector(
          onTap: () {
            setState(() {
              curIndex = position;
            });
            widget.onChanged(curIndex);
          },
          behavior: HitTestBehavior.opaque,
          child: RoundContainer(
            backgroundColor:
                position == curIndex ? themeColor : Colors.transparent,
            borderRadius: 36.w,
            margin: EdgeInsets.symmetric(vertical: 8.w),
            padding: EdgeInsets.symmetric(vertical: 17.w),
            child: Center(
              child: Text(
                title,
                style: position == curIndex ? selectText : normalText,
              ),
            ),
          ),
        ));
  }
}
