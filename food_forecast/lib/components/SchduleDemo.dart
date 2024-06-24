import 'dart:ui';

import 'package:flutter/material.dart';

class SeekToView extends StatefulWidget {
  final Function() onDragStart;
  final Function() onDragEnd;
  final Function() onDragUpdate;
  final Function(double value) onChange;
  double value;

  SeekToView(
      {Key? key,
      required this.onDragStart,
      required this.onDragEnd,
      required this.onDragUpdate,
      required this.value,
      required this.onChange})
      : super(key: key);

  @override
  _VideoProgressBarState createState() {
    return _VideoProgressBarState();
  }
}

class _VideoProgressBarState extends State<SeekToView> {
  List<Offset> pathPointsCallback = [];
  List<Offset> pointerCallback = [];

  @override
  void initState() {
    super.initState();
  }

  @override
  void deactivate() {
    super.deactivate();
  }

  @override
  Widget build(BuildContext context) {
    return Listener(
      child: CustomPaint(
        painter: _ProgressBarPainter(
          value: widget.value,
          pathPointsCallback: (value) {
            pathPointsCallback = value;
          },
          pointerCallback: (value) {
            pointerCallback = value;
          },
        ),
      ),
      onPointerUp: (event) {
        // debugPrint('onPointerUp  localPosition: ${event.localPosition}');
        // debugPrint('onPointerUp: ${event.position}');
      },
      onPointerDown: (event) {
        debugPrint('onPointerDown localPosition: ${event.localPosition}');
        if (pathPointsCallback.contains(event.localPosition)) {
          debugPrint("click on curve");
        }
        if (pointerCallback.contains(event.localPosition)) {
          debugPrint("click in controller");
        }
      },
      onPointerMove: (event) {
        debugPrint('onPointerMove: ${event.original?.localPosition}');
      },
    );
  }
}

class _ProgressBarPainter extends CustomPainter {
  final ValueChanged<List<Offset>> pathPointsCallback;
  final ValueChanged<List<Offset>> pointerCallback;

  _ProgressBarPainter(
      {required this.value,
      required this.pathPointsCallback,
      required this.pointerCallback});

  double value;

  @override
  bool shouldRepaint(CustomPainter painter) {
    return true;
  }

  @override
  void paint(Canvas canvas, Size size) {
    const width = 20.0;

    canvas.translate(size.width / 2, size.height / 2);

    Paint paint = Paint();
    paint.style = PaintingStyle.stroke;
    paint.color = Colors.black12;
    paint.strokeWidth = width;
    paint.style = PaintingStyle.stroke;

    Path path = Path()
      ..addOval(Rect.fromCircle(
        center: const Offset(0, 0),
        radius: size.width / 2 - width / 2,
      ));
    canvas.drawPath(path, paint);

    paint.style = PaintingStyle.fill;
    paint.color = Colors.blue;
    Path pathPointer = Path()
      ..addOval(Rect.fromCircle(
          center: Offset(0, -size.width / 2 + width / 2), radius: width / 2));
    canvas.drawPath(pathPointer, paint);

    var pointInBezierLine = <Offset>[];
    for (var metric in path.computeMetrics()) {
      for (int i = 0; i < metric.length; i++) {
        var tangent = metric.getTangentForOffset(i.toDouble());
        if (tangent?.position != null) {
          pointInBezierLine.add(tangent!.position);
        }
      }
    }
    // Return
    pathPointsCallback(pointInBezierLine);

    var pointerList = <Offset>[];
    for (var metric in pathPointer.computeMetrics()) {
      for (int i = 0; i < metric.length; i++) {
        var tangent = metric.getTangentForOffset(i.toDouble());
        if (tangent?.position != null) {
          pointerList.add(tangent!.position);
          debugPrint("tangent ${tangent!.position}");
        }
      }
    }
    // Return
    pointerCallback(pointerList);
  }
}
