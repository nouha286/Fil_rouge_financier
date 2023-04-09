import 'package:flutter/material.dart';

class CarteCompte extends StatelessWidget {
  double solde;

  String referenceCompte;
  String dateCreation;
  String etat;

  CarteCompte({
    required this.dateCreation,
    required this.referenceCompte,
    required this.solde,
    required this.etat,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      margin: EdgeInsets.all(16.0),
      child: Container(
        decoration: BoxDecoration(
          color: Colors.white,
          boxShadow: [
            BoxShadow(
              color: Colors.redAccent.withOpacity(0.2), // Couleur de BoxShadow
              spreadRadius: 5,
              blurRadius: 7,
              offset: Offset(0, 3), // changement de position de l'ombre
            ),
          ],
          borderRadius: BorderRadius.circular(30),
          border: Border.all(
            color: Colors.white, // Couleur de bordure
          ),
        ),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            ListTile(
              title: Text(referenceCompte),
              subtitle: Text(dateCreation),
              trailing: Text('$solde DH'),
            ),
            Padding(
              padding: EdgeInsets.symmetric(horizontal: 16.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  SizedBox(height: 8.0),
                  Text('E-mail: '),
                  SizedBox(height: 8.0),
                  Text('CNE: $etat'),
                  SizedBox(height: 8.0),
                  Text('Adresse: $dateCreation'),
                  SizedBox(height: 8.0),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
