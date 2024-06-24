import 'package:flutter/material.dart';
import 'package:syncfusion_flutter_pdfviewer/pdfviewer.dart';

class PdfViewPage extends StatelessWidget {
  final String fileName;
  final String pageTitle;

  const PdfViewPage({Key? key, required this.fileName, required this.pageTitle}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(pageTitle),
      ),
      body: Container(
        child: SfPdfViewer.asset("assets/pdfs/${fileName}.pdf"),
      ),
    );
  }
}
