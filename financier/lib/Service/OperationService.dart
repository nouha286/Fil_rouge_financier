import 'dart:convert';

import 'package:financier/Models/Operation.dart';
import 'package:http/http.dart' as http;
class OperationService {

  static const API =
      "http://10.0.2.2:8081/operations";
  static Future<List<Operation>> getOperationsByCompte(int compteId) async {
     final response = await http.get(Uri.parse('$API/compte/$compteId'));
    if (response.statusCode == 200) {
      List<dynamic> body = json.decode(response.body);
      List<Operation> operations =
          body.map((dynamic item) => Operation.fromJson(item)).toList();
      print('hi nouhaila ${operations.length}');
      return operations;
    } else {
      throw "Erreur lors de la récupération des opérations: ${response.statusCode}";
    }
  }
  
}