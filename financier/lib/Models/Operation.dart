class Operation {
  int id;
  String dateOperation;

  double montant;

  String type;

  Operation(
      {required this.id,
      required this.dateOperation,
      required this.montant,
      required this.type});

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'dateOperation': dateOperation,
      'montant': montant,
      'type': type
    };
  }

  factory Operation.fromJson(Map<String, dynamic> json) {
    return Operation(
        id: json['id'],
        type: json['type'],
        montant: json['montant'],
        dateOperation: json['dateOperation']);
  }
}
