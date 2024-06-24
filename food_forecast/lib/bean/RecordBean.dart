class RecordBean {
  double? vegetables;
  double? fruits;
  double? proteins;
  double? grains;
  double? entrees;
  double? milk;
  int? launchPeriod;

  RecordBean(
      {this.vegetables,
        this.fruits,
        this.proteins,
        this.grains,
        this.entrees,
        this.launchPeriod,
        this.milk});

  RecordBean.fromJson(Map<String, dynamic> json) {
    vegetables = json['vegetables'];
    fruits = json['fruits'];
    proteins = json['proteins'];
    grains = json['grains'];
    entrees = json['entrees'];
    milk = json['milk'];
    launchPeriod = json['launchPeriod'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['vegetables'] = this.vegetables;
    data['fruits'] = this.fruits;
    data['proteins'] = this.proteins;
    data['grains'] = this.grains;
    data['entrees'] = this.entrees;
    data['milk'] = this.milk;
    data['launchPeriod'] = this.launchPeriod;
    return data;
  }
}
