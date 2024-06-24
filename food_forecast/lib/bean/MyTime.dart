class MyTime {
  late int hour;
  late int minute;

  MyTime({required this.hour, required this.minute});

  MyTime.fromJson(Map<String, dynamic> json) {
    hour = json['hour'] ?? 0;
    minute = json['minute'] ?? 0;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['hour'] = this.hour;
    data['minute'] = this.minute;
    return data;
  }

  @override
  String toString() {
    return "$hour:$minute";
  }
}
