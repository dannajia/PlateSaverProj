import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:get/get.dart';

import '../../utils/storage.dart';
import '../PdfView.dart';
import '../login/view.dart';
import 'logic.dart';

class SettingPage extends StatefulWidget {
  const SettingPage({super.key});

  @override
  State<SettingPage> createState() => _SettingPageState();
}

class _SettingPageState extends State<SettingPage> {
  final logic = Get.put(SettingLogic());

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Setting"), backgroundColor: Theme.of(context).backgroundColor,),
      backgroundColor: Theme.of(context).backgroundColor,
      body: Padding(
        padding: EdgeInsets.symmetric(horizontal: 40.w, vertical: 24.w),
        child: Column(
          children: [
            ListTile(
              onTap: () {
                Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) =>
                      const PdfViewPage(
                        fileName: "TERMS_OF_USE",
                        pageTitle: "TERMS OF USE",
                      ),
                    ));
              },
              title: const Text("User protocol"),
              trailing: const Icon(
                Icons.chevron_right,
                color: Colors.black26,
              ),
            ),
            ListTile(
              onTap: () {
                Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) =>
                      const PdfViewPage(
                          fileName: "PRIVACY_NOTICE",
                          pageTitle: "PRIVACY NOTICE"),
                    ));
              },
              title: const Text("Privacy agreement"),
              trailing: const Icon(
                Icons.chevron_right,
                color: Colors.black26,
              ),
            ),
            ListTile(
              onTap: () {
                showDialog(
                  context: context,
                  builder: (context) =>
                      AlertDialog(
                        title: const Text("tips"),
                        content: Padding(
                          padding: EdgeInsets.all(10.w),
                          child: const Text(
                              "Your data will be deleted and cannot be recovered, are you sure to continue?"),
                        ),
                        actions: [
                          ElevatedButton(
                            onPressed: () {
                              Navigator.pop(context);
                            },
                            style: ElevatedButton.styleFrom(elevation: 0),
                            child: const Text("cancel"),
                          ),
                          ElevatedButton(
                            onPressed: () {
                              Navigator.pop(context);
                              logic.deleteUser();
                            },
                            style: ElevatedButton.styleFrom(
                                backgroundColor: Colors.red, elevation: 0),
                            child: const Text(
                              "delete",
                              style: TextStyle(color: Colors.white),
                            ),
                          ),
                        ],
                      ),
                );
              },
              title: const Text("Delete User Account"),
              trailing: const Icon(
                Icons.chevron_right,
                color: Colors.black26,
              ),
            ),
            SizedBox(
              height: 50.w,
            ),
            SizedBox(
              width: double.infinity,
              child: ElevatedButton(
                onPressed: () {
                  Storage().setToken("");
                  Get.offAll(const LoginPage());
                },
                child: const Text("Logout"),
              ),
            )
          ],
        ),
      ),
    );
  }

  @override
  void dispose() {
    Get.delete<SettingLogic>();
    super.dispose();
  }
}
