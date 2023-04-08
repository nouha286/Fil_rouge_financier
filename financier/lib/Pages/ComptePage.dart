import 'dart:ffi';

import 'package:flutter/material.dart';

class ComptePage extends StatefulWidget {
  const ComptePage({super.key});

  @override
  State<ComptePage> createState() => _ComptePageState();
}

class _ComptePageState extends State<ComptePage> {
  final _formKey = GlobalKey<FormState>();
  String _nom = "";
  String _prenom = "";
  String _email = "";
  String _telephone = "";
  double solde = 0.0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Ajouter un Compte'),
      ),
      body: SingleChildScrollView(
        child: Column(
          children: [
            Padding(
              padding: EdgeInsets.all(16.0),
              child: Container(
                padding: EdgeInsets.all(16.0),
                decoration: BoxDecoration(
                  color: Colors.white,
                  boxShadow: [
                    BoxShadow(
                      color:
                          Colors.grey.withOpacity(0.2), // Couleur de BoxShadow
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
                child: Form(
                  key: _formKey,
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: <Widget>[
                      TextFormField(
                        decoration: InputDecoration(
                          labelText: 'Nom ',
                        ),
                        validator: (value) {
                          if (value!.isEmpty) {
                            return 'Le nom est obligatoire.';
                          }
                          return null;
                        },
                        onSaved: (value) {
                          _nom = value!;
                        },
                      ),
                      TextFormField(
                        decoration: InputDecoration(
                          labelText: 'Prénom',
                        ),
                        validator: (value) {
                          if (value!.isEmpty) {
                            return 'Le prénom est obligatoire.';
                          }
                          return null;
                        },
                        onSaved: (value) {
                          _prenom = value!;
                        },
                      ),
                      TextFormField(
                        decoration: InputDecoration(
                          labelText: 'E-mail',
                        ),
                        validator: (value) {
                          if (value!.isEmpty) {
                            return 'L\'e-mail est obligatoire.';
                          }
                          if (!value.contains('@')) {
                            return 'L\'e-mail n\'est pas valide.';
                          }
                          return null;
                        },
                        onSaved: (value) {
                          _email = value!;
                        },
                      ),
                      TextFormField(
                        decoration: InputDecoration(
                          labelText: 'Téléphone',
                        ),
                        validator: (value) {
                          if (value!.isEmpty) {
                            return 'Le téléphone est obligatoire.';
                          }
                          return null;
                        },
                        onSaved: (value) {
                          _telephone = value!;
                        },
                      ),
                      Padding(
                        padding: EdgeInsets.symmetric(vertical: 16.0),
                        child: ElevatedButton(
                          onPressed: () {
                            if (_formKey.currentState!.validate()) {
                              _formKey.currentState!.save();
                              // Enregistrer le Compte dans la base de données
                              Navigator.pop(context);
                            }
                          },
                          child: Row(
                            mainAxisAlignment: MainAxisAlignment.center,
                            children: [
                              Text('Enregistrer'),
                            ],
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ),
            Container(
              child: Text('hi'),
            )
          ],
        ),
      ),
    );
  }
}
