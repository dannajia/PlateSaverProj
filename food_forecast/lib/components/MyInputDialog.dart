import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class MyInputDialog extends StatelessWidget {
  final ValueChanged<String> submitCallback;
  final String cancelText;
  final String submitText;
  final String title;
  final VoidCallback? cancelCallback;
  final TextInputType? keyboardType;

  const MyInputDialog(
      {Key? key,
      required this.submitCallback,
      this.cancelCallback,
      this.keyboardType = TextInputType.text,
      this.title = "Reminder",
      this.cancelText = "Cancel",
      this.submitText = "Submit"})
      : super(key: key);

  @override
  Widget build(BuildContext context) {

    TextEditingController controller = TextEditingController();

    return SizedBox.expand(
      child: Material(
        color: Colors.black12,
        child: Center(
          child: Container(
            margin: EdgeInsets.only(bottom: 200.w),
            width: 580.w,
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(30.w),
              color: Colors.white,
            ),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                SizedBox(
                  height: 36.w,
                ),
                Stack(
                  alignment: Alignment.center,
                  children: [
                    Container(
                      width: 80.w,
                      height: 14.w,
                      margin: EdgeInsets.only(top: 24.w),
                      decoration: BoxDecoration(
                        borderRadius: BorderRadius.circular(6.w),
                        color: const Color(0x4DFFA53D),
                      ),
                    ),
                    Text(
                      title,
                      style: TextStyle(fontSize: 32.w, color: Colors.black87),
                    ),
                  ],
                ),
                SizedBox(
                  height: 24.w,
                ),
                Container(
                  margin: EdgeInsets.symmetric(horizontal: 48.w),
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(12.w),
                    color: const Color(0xFFEFF1F8),
                  ),
                  child: Row(
                    mainAxisSize: MainAxisSize.max,
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      SizedBox(
                        width: 24.w,
                      ),
                      Expanded(
                        flex: 1,
                        child: TextField(
                          controller: controller,
                          keyboardType: keyboardType,
                          decoration:
                              const InputDecoration(border: InputBorder.none),
                          maxLines: 1,
                          style:
                              TextStyle(fontSize: 30.w, color: Colors.black87),
                        ),
                      ),
                      IconButton(
                        onPressed: () {
                          controller.text = '';
                        },
                        icon: Icon(
                          Icons.remove_circle_outlined,
                          size: 36.w,
                          color: Colors.black38,
                        ),
                      ),
                    ],
                  ),
                ),
                SizedBox(
                  height: 35.w,
                ),
                Divider(
                  height: 1.w,
                  color: const Color(0x20000000),
                ),
                Container(
                  height: 94.w,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.only(
                      bottomLeft: Radius.circular(30.w),
                      bottomRight: Radius.circular(30.w),
                    ),
                  ),
                  child: Row(
                    children: [
                      Expanded(
                        flex: 1,
                        child: GestureDetector(
                          behavior: HitTestBehavior.opaque,
                          onTap: () {
                            if (cancelCallback != null) {
                              cancelCallback!();
                            } else {
                              Navigator.pop(context);
                            }
                          },
                          child: Container(
                            decoration: BoxDecoration(
                              color: Colors.white,
                              borderRadius: BorderRadius.only(
                                bottomLeft: Radius.circular(30.w),
                              ),
                            ),
                            child: Center(
                              child: Text(
                                cancelText,
                                style: TextStyle(
                                    fontSize: 32.w, color: Colors.black38),
                              ),
                            ),
                          ),
                        ),
                      ),
                      Container(
                        width: 1.w,
                        color: const Color(0x20000000),
                      ),
                      Expanded(
                        flex: 1,
                        child: GestureDetector(
                          behavior: HitTestBehavior.opaque,
                          onTap: () {
                            if(controller.text == ""){
                              return;
                            }
                            submitCallback(controller.text);
                          },
                          child: Container(
                            decoration: BoxDecoration(
                              color: Colors.white,
                              borderRadius: BorderRadius.only(
                                bottomRight: Radius.circular(30.w),
                              ),
                            ),
                            child: Center(
                              child: Text(
                                submitText,
                                style: TextStyle(
                                    fontSize: 32.w,
                                    color: const Color(0xFFFFA53D)),
                              ),
                            ),
                          ),
                        ),
                      ),
                    ],
                  ),
                )
              ],
            ),
          ),
        ),
      ),
    );
  }
}
