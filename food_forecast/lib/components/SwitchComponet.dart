import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class SwitchComponent extends StatefulWidget {
  final String leftText;
  final String rightText;
  final ValueChanged<int> onChanged;

  const SwitchComponent(
      {Key? key,
      required this.leftText,
      required this.rightText,
      required this.onChanged})
      : super(key: key);

  @override
  State<SwitchComponent> createState() => _SwitchComponentState();
}

class _SwitchComponentState extends State<SwitchComponent> {
  TextStyle normalStyle = TextStyle(fontSize: 28.w, color: Colors.black54);
  TextStyle activeStyle = TextStyle(fontSize: 32.w, color: Colors.black87);

  late int activeIndex;

  @override
  void initState() {
    super.initState();
    activeIndex = 0;
  }

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisSize: MainAxisSize.min,
      children: [
        GestureDetector(
          behavior: HitTestBehavior.opaque,
          onTap: () {
            setState(() {
              activeIndex = 0;
            });
            widget.onChanged(activeIndex);
          },
          child: Column(
            mainAxisSize: MainAxisSize.min,
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Text(
                widget.leftText,
                style: activeIndex == 0 ? activeStyle : normalStyle,
              ),
              SizedBox(
                height: 4.w,
              ),
              Container(
                width: 54.w,
                height: 4.w,
                color: activeIndex == 0
                    ? const Color(0xffFFA53D)
                    : Colors.transparent,
              ),
            ],
          ),
        ),
        SizedBox(
          width: 40.w,
        ),
        GestureDetector(
          onTap: () {
            setState(() {
              activeIndex = 1;
            });
            widget.onChanged(activeIndex);
          },
          behavior: HitTestBehavior.opaque,
          child: Column(
            mainAxisSize: MainAxisSize.min,
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Text(
                widget.rightText,
                style: activeIndex == 1 ? activeStyle : normalStyle,
              ),
              SizedBox(
                height: 4.w,
              ),
              Container(
                width: 54.w,
                height: 4.w,
                color: activeIndex == 1
                    ? const Color(0xffFFA53D)
                    : Colors.transparent,
              ),
            ],
          ),
        )
      ],
    );
  }
}
