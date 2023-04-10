class Compte {
  int id;

  double solde;

  String referenceCompte;
  String dateCreation;

  Compte(
      {required this.solde,
      required this.referenceCompte,
      required this.dateCreation,
      required this.etat,
      required this.id});
  String etat;

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'solde': solde,
      'referenceCompte': referenceCompte,
      'dateCreation': dateCreation
    };
  }

  factory Compte.fromJson(Map<String, dynamic> json) {
    return Compte(id: json['id'],
        referenceCompte: json['referenceCompte'],
        solde: json['solde'],
        dateCreation: json['dateCreation'],
        etat: json['etat']);
  }
}
