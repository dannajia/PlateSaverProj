import 'package:flutter/cupertino.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:get/get.dart';
import '../../components/RoundContainer.dart';
import '../../constants/CustomTitles.dart';
import '../PdfView.dart';
import 'logic.dart';

class RegisterPage extends StatefulWidget {
  const RegisterPage({super.key});

  @override
  _RegisterPageState createState() => _RegisterPageState();
}

class _RegisterPageState extends State<RegisterPage> {
  final logic = Get.put(RegisterLogic());

  final List<String> _schoolNames = <String>[
    'Annandale HS',
    'Centreville HS',
    'Chantilly HS',
    'Edison HS',
    'Fairfax HS',
    'Falls Church HS',
    'Herndon HS',
    'Justice HS',
    'Langley HS',
    'Lewis HS',
    'Madison HS',
    'Marshall HS',
    'McLean HS',
    'Mountain View HS',
    'Mount Vernon HS',
    'Oakton HS',
    'South County HS',
    'South Lakes HS',
    'Thomas Jefferson HS',
    'Westfield HS',
    'West Potomac HS',
    'West Springfield HS',
    'Woodson HS',
    'Carson MS',
    'Cooper MS',
    'Franklin MS',
    'Frost MS',
    'Glasgow MS',
    'Herndon MS',
    'Holmes MS',
    'Hughes MS',
    'Irving MS',
    'Katherine Johnson MS',
    'Key MS',
    'Kilmer MS',
    'Liberty MS',
    'Longfellow MS',
    'Luther Jackson MS',
    'Poe MS',
    'Rocky Run MS',
    'Sandburg MS',
    'South County MS',
    'Stone MS',
    'Thoreau MS',
    'Twain MS',
    'Whitman MS',
  ];

  double _kItemExtent = 32.0;

  int _selectedSchool = 8;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      resizeToAvoidBottomInset: true,
      backgroundColor: Theme.of(context).backgroundColor,
      body: SizedBox.expand(
        child: SingleChildScrollView(
          child: Stack(
            children: [
              Column(
                mainAxisSize: MainAxisSize.max,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  SizedBox(
                    height: 120.w,
                  ),
                  Container(
                    padding: EdgeInsets.only(left: 60.w),
                    alignment: Alignment.topLeft,
                    child: Text(
                      CustomTitles.registerPage,
                      style: TextStyle(
                          fontSize: 52.w,
                          color: Colors.black,
                          fontWeight: FontWeight.w700),
                    ),
                  ),
                  SizedBox(
                    height: 60.w,
                  ),
                  Form(
                    child: Column(
                      children: [
                        RoundContainer(
                          padding: EdgeInsets.symmetric(
                              horizontal: 46.w, vertical: 10.w),
                          margin: EdgeInsets.symmetric(
                              horizontal: 32.w, vertical: 10.w),
                          borderRadius: 12.w,
                          backgroundColor: const Color(0xffF7F7F7),
                          child: TextFormField(
                            onChanged: (value) {
                              logic.registerBean.firstName = value;
                            },
                            textInputAction: TextInputAction.next,
                            keyboardType: TextInputType.name,
                            decoration: const InputDecoration(
                                hintText: "First Name",
                                border: InputBorder.none),
                          ),
                        ),
                        RoundContainer(
                          padding: EdgeInsets.symmetric(
                              horizontal: 46.w, vertical: 10.w),
                          margin: EdgeInsets.symmetric(
                              horizontal: 32.w, vertical: 10.w),
                          borderRadius: 12.w,
                          backgroundColor: const Color(0xffF7F7F7),
                          child: TextFormField(
                            keyboardType: TextInputType.name,
                            onChanged: (value) {
                              logic.registerBean.lastName = value;
                            },
                            textInputAction: TextInputAction.next,
                            decoration: const InputDecoration(
                                hintText: "Last Name",
                                border: InputBorder.none),
                          ),
                        ),
                        RoundContainer(
                          padding: EdgeInsets.symmetric(
                              horizontal: 46.w, vertical: 10.w),
                          margin: EdgeInsets.symmetric(
                              horizontal: 32.w, vertical: 10.w),
                          borderRadius: 12.w,
                          backgroundColor: const Color(0xffF7F7F7),
                          child: TextFormField(
                            keyboardType: TextInputType.phone,
                            onChanged: (value) {
                              logic.registerBean.phone = value;
                            },
                            textInputAction: TextInputAction.next,
                            decoration: const InputDecoration(
                                hintText: "Phone", border: InputBorder.none),
                          ),
                        ),
                        RoundContainer(
                          padding: EdgeInsets.symmetric(
                              horizontal: 46.w, vertical: 10.w),
                          margin: EdgeInsets.symmetric(
                              horizontal: 32.w, vertical: 10.w),
                          borderRadius: 12.w,
                          backgroundColor: const Color(0xffF7F7F7),
                          child: Stack(
                            alignment: Alignment.centerRight,
                            children: [
                              const Positioned(
                                right: 0.0,
                                child: Icon(Icons.arrow_drop_down_outlined),
                              ),
                              TextFormField(
                                readOnly: true,
                                onTap: () {
                                  selectSchool();
                                },
                                controller: TextEditingController(
                                    text: logic.registerBean.userSchool),
                                decoration: const InputDecoration(
                                    hintText: "School",
                                    border: InputBorder.none),
                              ),
                            ],
                          ),
                        ),
                        RoundContainer(
                          padding: EdgeInsets.symmetric(
                              horizontal: 46.w, vertical: 10.w),
                          margin: EdgeInsets.symmetric(
                              horizontal: 32.w, vertical: 10.w),
                          borderRadius: 12.w,
                          backgroundColor: const Color(0xffF7F7F7),
                          child: TextFormField(
                            keyboardType: TextInputType.name,
                            onChanged: (value) {
                              logic.registerBean.username = value;
                            },
                            textInputAction: TextInputAction.next,
                            decoration: const InputDecoration(
                                hintText: "User Name",
                                border: InputBorder.none),
                          ),
                        ),
                        RoundContainer(
                          padding: EdgeInsets.symmetric(
                              horizontal: 46.w, vertical: 10.w),
                          margin: EdgeInsets.symmetric(
                              horizontal: 32.w, vertical: 10.w),
                          borderRadius: 12.w,
                          backgroundColor: const Color(0xffF7F7F7),
                          child: TextFormField(
                            obscureText: true,
                            keyboardType: TextInputType.visiblePassword,
                            onChanged: (value) {
                              logic.registerBean.password = value;
                            },
                            textInputAction: TextInputAction.next,
                            decoration: const InputDecoration(
                                hintText: "Password", border: InputBorder.none),
                          ),
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
                                      logic.acceptProtocol.value =
                                          value ?? false;
                                    },
                                  )),
                              Container(
                                child: RichText(
                                  softWrap: false,
                                  text: TextSpan(
                                      text: "Read and agree",
                                      style: const TextStyle(
                                          color: Colors.black87),
                                      children: [
                                        TextSpan(
                                            text: "《User protocol》\n",
                                            style: TextStyle(
                                              color: Theme.of(context)
                                                  .primaryColor,
                                            ),
                                            recognizer: TapGestureRecognizer()
                                              ..onTap = () {
                                                Navigator.push(
                                                    context,
                                                    MaterialPageRoute(
                                                      builder: (context) =>
                                                          const PdfViewPage(
                                                        fileName:
                                                            "TERMS_OF_USE",
                                                        pageTitle:
                                                            "TERMS OF USE",
                                                      ),
                                                    ));
                                              }),
                                        TextSpan(
                                            text: "《Privacy agreement》",
                                            style: TextStyle(
                                              color: Theme.of(context)
                                                  .primaryColor,
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
                                                            "PRIVACY NOTICE",
                                                      ),
                                                    ));
                                              }),
                                      ]),
                                ),
                              ),
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
                                fixedSize: Size(620.w, 100.w)),
                            onPressed: logic.loading.value
                                ? null
                                : () {
                                    // check if accept the agreement
                                    if (!logic.acceptProtocol.value) {
                                      Fluttertoast.showToast(
                                          msg:
                                              "please read and accept protocols");
                                      return;
                                    }
                                    // validation of registration info
                                    if (logic.registerBean.firstName == null ||
                                        logic.registerBean.firstName!.isEmpty) {
                                      Fluttertoast.showToast(
                                          msg: "please complete First Name");
                                      return;
                                    } else if (logic.registerBean.lastName ==
                                            null ||
                                        logic.registerBean.lastName!.isEmpty) {
                                      Fluttertoast.showToast(
                                          msg: "please complete Last Name");
                                      return;
                                    } /**else if (logic.registerBean.phone ==
                                            null ||
                                        logic.registerBean.phone!.isEmpty) {
                                      Fluttertoast.showToast(
                                          msg: "please complete phone");
                                      return;
                                    }**/ else if (logic.registerBean.userSchool ==
                                            null ||
                                        logic
                                            .registerBean.userSchool!.isEmpty) {
                                      // Fluttertoast.showToast(
                                      //     msg: "please complete School");
                                      // return;
                                      logic.registerBean.userSchool =
                                          "Langley HS";
                                    } else if (logic.registerBean.username ==
                                            null ||
                                        logic.registerBean.username!.isEmpty) {
                                      Fluttertoast.showToast(
                                          msg: "please complete User Name");
                                      return;
                                    } else if (logic.registerBean.password ==
                                            null ||
                                        logic.registerBean.password!.isEmpty) {
                                      Fluttertoast.showToast(
                                          msg: "please complete Password");
                                      return;
                                    }
                                    logic.register();
                                  },
                            child: logic.loading.value
                                ? const CircularProgressIndicator(
                                    color: Colors.white,
                                  )
                                : const Text(
                                    "Register",
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
                                    Navigator.pop(context);
                                  },
                            child: Text(
                              "Login",
                              style: TextStyle(
                                  color: Theme.of(context).primaryColor),
                            ),
                          ),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }

  void selectSchool() {
    showCupertinoModalPopup<void>(
      context: context,
      builder: (BuildContext context) => Container(
        height: MediaQuery.of(context).size.height * 0.5,
        padding: const EdgeInsets.only(top: 6.0),
        // The Bottom margin is provided to align the popup above the system navigation bar.
        margin: EdgeInsets.only(
          bottom: MediaQuery.of(context).viewInsets.bottom,
        ),
        // Provide a background color for the popup.
        color: CupertinoColors.systemBackground.resolveFrom(context),
        // Use a SafeArea widget to avoid system overlaps.
        child: SafeArea(
          top: false,
          child: Column(
            children: [
              const Material(
                color: Colors.transparent,
                child: Padding(
                  padding: EdgeInsets.symmetric(vertical: 12),
                  child: Text(
                    "Select School",
                    style: TextStyle(fontSize: 24),
                  ),
                ),
              ),
              Expanded(
                flex: 1,
                child: CupertinoPicker(
                  magnification: 1.22,
                  squeeze: 1.2,
                  useMagnifier: true,
                  itemExtent: _kItemExtent,
                  // This sets the initial item.
                  scrollController: FixedExtentScrollController(
                    initialItem: _selectedSchool,
                  ),
                  // This is called when selected item is changed.
                  onSelectedItemChanged: (int selectedItem) {
                    _selectedSchool = selectedItem;
                    logic.registerBean.userSchool = _schoolNames[selectedItem];
                    setState(() {});
                  },
                  children: List<Widget>.generate(
                    _schoolNames.length,
                    (int index) {
                      return Center(child: Text(_schoolNames[index]));
                    },
                  ),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }

  @override
  void dispose() {
    Get.delete<RegisterLogic>();
    super.dispose();
  }
}
