import 'package:financier/Dto/CompteDto.dart';
import 'dart:convert';
import 'package:http/http.dart' as http;

import '../Models/Compte.dart';

class CompteService {
  static const API =
      "http://10.0.2.2:8081/comptes/"; // mettre votre endpoint API ici

  static Future<void> ajouterCompte(CompteDto compte) async {
    final response = await http.post(Uri.parse(API),
        headers: <String, String>{
          'Content-Type': 'application/json; charset=UTF-8',
        },
        body: jsonEncode(compte.toJson()));
    if (response.statusCode == 201) {
      // Compte ajouté avec succès
      print("Compte ajouté avec succès");
    } else {
      // Erreur lors de l'ajout du compte
      print("Erreur lors de l'ajout du compte: ${response.statusCode}");
    }
  }

  static Future<List<Compte>> getComptes() async {
    final response = await http.get(Uri.parse(API));
    if (response.statusCode == 200) {
      List<dynamic> body = json.decode(response.body);
      List<Compte> comptes =
          body.map((dynamic item) => Compte.fromJson(item)).toList();
      print('hi nouhaila ${comptes.length}');
      return comptes;
    } else {
      throw "Erreur lors de la récupération des comptes: ${response.statusCode}";
    }
  }
}
