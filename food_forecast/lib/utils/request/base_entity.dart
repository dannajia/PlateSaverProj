class BaseEntity {
  int code;
  String msg;
  dynamic data;

  BaseEntity({required this.code, required this.msg, required this.data});

  factory BaseEntity.fromJson(json) {
    return BaseEntity(
        code: json['code'],
        msg: json['msg'],
        data: json['data']);
  }
}
