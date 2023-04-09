import 'package:flutter/material.dart';

class CompteDto {
  int? id;

  double solde;

  String nom;

  String cne;

  String email;

  String adresse;

  String metier;

  CompteDto(
      {this.id,
      required this.adresse,
      required this.nom,
      required this.cne,
      required this.metier,
      required this.email,
      required this.solde});

  factory CompteDto.fromJson(Map<String, dynamic> json) {
    return CompteDto(adresse: json['adresse'],nom: json['nom'],cne: json['cne'],
        metier:json['metier'], email:json['email'],solde: json['solde']);
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'cne': cne,
      'nom': nom,
      'adresse': adresse,
      'email': email,
      'metier': metier,
      'solde': solde
    };
  }
}
