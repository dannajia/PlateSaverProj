class BaseListEntity<T> {
  int code;
  String msg;
  List<T?> rows;
  int total;

  BaseListEntity(
      {required this.code,
      required this.msg,
      required this.rows,
      required this.total});

  factory BaseListEntity.fromJson(json) {
    return BaseListEntity(
      code: json['code'],
      msg: json['msg'],
      rows: json['rows'],
      total: json['total'],
    );
  }
}
