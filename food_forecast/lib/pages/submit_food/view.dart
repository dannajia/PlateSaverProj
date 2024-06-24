import 'package:decimal/decimal.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:food_forecast/constants/Routers.dart';
import 'package:get/get.dart';
import 'package:get/get.dart';

import '../../constants/CustomTitles.dart';
import '../../utils/storage.dart';
import '../login/view.dart';
import 'logic.dart';

class SubmitFoodPage extends StatefulWidget {
  const SubmitFoodPage({super.key});

  @override
  _SubmitFoodPageState createState() => _SubmitFoodPageState();
}

class _SubmitFoodPageState extends State<SubmitFoodPage> {
  final logic = Get.put(SubmitFoodLogic());

  double _kItemExtent = 32.0;

  int _selectedPeriod = 0;

  final List<String> _periodList = <String>[
    'A Lunch',
    'B Lunch',
    'C Lunch',
    'D Lunch',
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      resizeToAvoidBottomInset: true,
      backgroundColor: Theme.of(context).backgroundColor,
      body: SizedBox.expand(
        child: SingleChildScrollView(
          child: Column(
            children: [
              SafeArea(
                top: true,
                bottom: false,
                child: Stack(
                  children: [
                    Container(
                      padding: EdgeInsets.only(left: 60.w, top: 60.w),
                      alignment: Alignment.topLeft,
                      child: Text(
                        CustomTitles.homePage,
                        style: TextStyle(
                            fontSize: 52.w,
                            color: Colors.black,
                            fontWeight: FontWeight.w700),
                      ),
                    ),
                    Positioned(
                      right: 40.w,
                      top: 40.w,
                      child: IconButton(
                        onPressed: () {
                          /*Storage().setToken("");
                          Get.offAll(const LoginPage());*/
                          Get.toNamed(Routers.setting);
                        },
                        icon: const Icon(Icons.settings),
                      ),
                    )
                  ],
                ),
              ),
              SizedBox(
                height: 60.w,
              ),
              Padding(
                padding: EdgeInsets.symmetric(horizontal: 32.w),
                child: Form(
                  child: Column(
                    children: [
                      CategoryItem(
                        category: "Vegetables",
                        onchange: (value) {
                          logic.recordBean.vegetables = value;
                        },
                      ),
                      CategoryItem(
                        category: "Fruits",
                        onchange: (value) {
                          logic.recordBean.fruits = value;
                        },
                      ),
                      CategoryItem(
                        category: "Proteins",
                        onchange: (value) {
                          logic.recordBean.proteins = value;
                        },
                      ),
                      CategoryItem(
                        category: "Grains",
                        onchange: (value) {
                          logic.recordBean.grains = value;
                        },
                      ),
                      CategoryItem(
                        category: "Entrees",
                        onchange: (value) {
                          logic.recordBean.entrees = value;
                        },
                      ),
                      CategoryItem(
                        category: "Milk",
                        onchange: (value) {
                          logic.recordBean.milk = value;
                        },
                      ),
                      Row(
                        children: [
                          Text(
                            "Tomorrow's Lunch Period",
                            style: TextStyle(fontSize: 32.w),
                          )
                        ],
                      ),
                      Container(
                        margin: EdgeInsets.only(left: 42.w),
                        decoration: const BoxDecoration(
                          border: Border(
                            bottom:
                                BorderSide(color: Color(0xff86A596), width: 1),
                          ),
                        ),
                        child: Stack(
                          alignment: Alignment.centerRight,
                          children: [
                            const Positioned(
                              child: Icon(Icons.arrow_drop_down_outlined),
                            ),
                            TextFormField(
                              readOnly: true,
                              controller: TextEditingController(
                                  text: _periodList[_selectedPeriod]),
                              onTap: () {
                                selectPeriod();
                              },
                              textAlign: TextAlign.left,
                              decoration: const InputDecoration(
                                  border: InputBorder.none,
                                  hintText: "select..."),
                            ),
                          ],
                        ),
                      ),
                      SizedBox(
                        height: 32.w,
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
                              fixedSize: Size(680.w, 100.w)),
                          onPressed: logic.loading.value
                              ? null
                              : () {
                                  logic.recordBean.launchPeriod ??= 0;
                                  logic.saveRecord();
                                },
                          child: logic.loading.value
                              ? const CircularProgressIndicator(
                                  color: Colors.white,
                                )
                              : const Text(
                                  "Submit",
                                  style: TextStyle(color: Colors.white),
                                ),
                        ),
                      ),
                      SizedBox(
                        height: 50.w,
                      ),
                    ],
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  void selectPeriod() {
    showCupertinoModalPopup<void>(
      context: context,
      builder: (BuildContext context) => Container(
        height: MediaQuery.of(context).size.height * 0.35,
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
                    "Select Lunch Period",
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
                    initialItem: _selectedPeriod,
                  ),
                  onSelectedItemChanged: (int selectedItem) {
                    _selectedPeriod = selectedItem;
                    logic.recordBean.launchPeriod = selectedItem;
                    setState(() {});
                  },
                  children: List<Widget>.generate(
                    _periodList.length,
                    (int index) {
                      return Center(child: Text(_periodList[index]));
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
    Get.delete<SubmitFoodLogic>();
    super.dispose();
  }
}

class CategoryItem extends StatefulWidget {
  final String category;
  final ValueChanged<double?> onchange;

  CategoryItem({
    Key? key,
    required this.category,
    required this.onchange,
  }) : super(key: key);

  @override
  State<CategoryItem> createState() => _CategoryItemState();
}

class _CategoryItemState extends State<CategoryItem> {
  late TextEditingController buyController;
  late TextEditingController leftController;

  @override
  void initState() {
    super.initState();
    buyController = TextEditingController();
    leftController = TextEditingController();
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisSize: MainAxisSize.min,
      children: [
        Row(
          children: [
            _getIcon(widget.category),
            Text(
              " ${widget.category}",
              style: TextStyle(fontSize: 32.w),
            )
          ],
        ),
        Container(
          margin: EdgeInsets.only(left: 42.w),
          decoration: const BoxDecoration(
            border: Border(
              bottom: BorderSide(color: Color(0xff86A596), width: 1),
            ),
          ),
          child: Row(
            children: [
              const Text("Buy"),
              Expanded(
                child: TextFormField(
                  keyboardType: TextInputType.numberWithOptions(decimal: true),
                  textInputAction: TextInputAction.next,
                  inputFormatters: [
                    FilteringTextInputFormatter.allow(
                        RegExp(r'([0-9]\d*\.?\d*)|(0\.\d*[0-9])'))
                  ],
                  onChanged: (value) {
                    if (leftController.text.isNotEmpty && value.isNotEmpty) {
                      Decimal buy = Decimal.parse(value);
                      Decimal left = Decimal.parse(leftController.text);
                      if (left > buy) {
                        Fluttertoast.showToast(msg: "error data!");
                        return;
                      }
                      final res = buy - left;
                      widget.onchange(res.toDouble());
                    } else {
                      widget.onchange(null);
                    }
                  },
                  controller: buyController,
                  textAlign: TextAlign.right,
                  decoration: const InputDecoration(
                      border: InputBorder.none, hintText: "input..."),
                ),
              ),
            ],
          ),
        ),
        Container(
          margin: EdgeInsets.only(left: 42.w),
          decoration: const BoxDecoration(
            border: Border(
              bottom: BorderSide(color: Color(0xff86A596), width: 1),
            ),
          ),
          child: Row(
            children: [
              const Text("left-over"),
              Expanded(
                child: TextFormField(
                  controller: leftController,
                  textAlign: TextAlign.right,
                  keyboardType: TextInputType.numberWithOptions(decimal: true),
                  textInputAction: TextInputAction.next,
                  inputFormatters: [
                    FilteringTextInputFormatter.allow(
                        RegExp(r'([0-9]\d*\.?\d*)|(0\.\d*[0-9]'
                        r')'))
                  ],
                  onChanged: (value) {
                    if (buyController.text.isNotEmpty && value.isNotEmpty) {
                      Decimal buy = Decimal.parse(buyController.text);
                      Decimal left = Decimal.parse(value);

                      if (left > buy) {
                        Fluttertoast.showToast(msg: "error data!");
                        return;
                      }

                      final res = buy - left;
                      widget.onchange(res.toDouble());
                    } else {
                      widget.onchange(null);
                    }
                  },
                  decoration: const InputDecoration(
                      border: InputBorder.none, hintText: "input..."),
                ),
              ),
            ],
          ),
        ),
        SizedBox(
          height: 32.w,
        ),
      ],
    );
  }

  Widget _getIcon(category) {
    String img = "ve";
    if (category == "Fruits") {
      img = "fr";
    } else if (category == "Proteins") {
      img = "pr";
    } else if (category == "Grains") {
      img = "gr";
    } else if (category == "Entrees") {
      img = "en";
    } else if (category == "Milk") {
      img = "mil";
    }
    return Image.asset(
      "assets/foods/$img.png",
      width: 30.w,
      height: 30.w,
    );
  }
}
