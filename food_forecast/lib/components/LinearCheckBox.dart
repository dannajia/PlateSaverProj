import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class LinearCheckBox extends StatefulWidget {
  final String labelText;
  final bool checkState;
  final ValueChanged<bool> valueChanged;

  const LinearCheckBox({
    Key? key,
    required this.labelText,
    this.checkState = false,
    required this.valueChanged,
  }) : super(key: key);

  @override
  State<LinearCheckBox> createState() => _LinearCheckBoxState();
}

class _LinearCheckBoxState extends State<LinearCheckBox> {
  Color themeColor = const Color(0xffFFA53D);

  late bool checkState;
  TextStyle normalStyle = TextStyle(fontSize: 30.w, color: Colors.black87);
  TextStyle selectStyle =
      TextStyle(fontSize: 30.w, color: const Color(0xffFFA53D));

  @override
  void initState() {
    super.initState();
    checkState = widget.checkState;
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.symmetric(
        vertical: 4.w,
      ),
      child: Row(
        mainAxisSize: MainAxisSize.max,
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Text(
            widget.labelText,
            style: checkState ? selectStyle : normalStyle,
          ),
          Checkbox(
            activeColor: themeColor,
            value: checkState,
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(8.w),
              side: const BorderSide(
                color: Colors.black12
              )
            ),
            onChanged: (value) {
              setState(() {
                checkState = value ?? false;
              });
              widget.valueChanged(checkState);
            },
          ),
        ],
      ),
    );
  }
}
