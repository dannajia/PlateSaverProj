class RegisterBean {
  String? firstName;
  String? lastName;
  String? phone;
  String? userSchool;
  String? username;
  String? password;

  RegisterBean(
      {this.firstName,
        this.lastName,
        this.phone,
        this.userSchool,
        this.username,
        this.password});

  RegisterBean.fromJson(Map<String, dynamic> json) {
    firstName = json['firstName'];
    lastName = json['lastName'];
    phone = json['phone'];
    userSchool = json['userSchool'];
    username = json['username'];
    password = json['password'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['firstName'] = this.firstName;
    data['lastName'] = this.lastName;
    data['phone'] = this.phone;
    data['userSchool'] = this.userSchool;
    data['username'] = this.username;
    data['password'] = this.password;
    return data;
  }
}
