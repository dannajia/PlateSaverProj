import 'package:flutter/material.dart';

class BackGroundPage extends StatelessWidget {

  final Widget child;

  const BackGroundPage({Key? key, required this.child}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      width: double.infinity,
      height: double.infinity,
      decoration: const BoxDecoration(
        gradient: LinearGradient(
          colors: [Color(0xffFAE6CD), Color(0xffFAE6CD), Color(0xffF2F3F6)],
          begin: Alignment.topCenter,
          end: Alignment.bottomCenter,
          stops: [0, 0.1, 1],
        ),
      ),
      child: child,
    );
  }
}
