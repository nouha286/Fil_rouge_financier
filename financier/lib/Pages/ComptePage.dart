import 'dart:ffi';

import 'package:financier/Pages/OperationPage.dart';
import 'package:flutter/material.dart';

import '../Dto/CompteDto.dart';
import '../Models/Compte.dart';
import '../Service/CompteService.dart';
import '../Widgets/CarteCompte.dart';

class ComptePage extends StatefulWidget {
  const ComptePage({super.key});

  @override
  State<ComptePage> createState() => _ComptePageState();
}

class _ComptePageState extends State<ComptePage> {
  final _formKey = GlobalKey<FormState>();
  String _nom = "";
  String _metier = "";
  String _email = "";
  String _cne = "";
  String _adresse = "";
  double _solde = 0;

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
                          labelText: 'Adresse',
                        ),
                        validator: (value) {
                          if (value!.isEmpty) {
                            return 'L adresse est obligatoire.';
                          }
                          return null;
                        },
                        onSaved: (value) {
                          _adresse = value!;
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
                          labelText: 'CNE',
                        ),
                        validator: (value) {
                          if (value!.isEmpty) {
                            return 'Le numéro du carte national d identité est obligatoire.';
                          }
                          return null;
                        },
                        onSaved: (value) {
                          _cne = value!;
                        },
                      ),
                      TextFormField(
                        decoration: InputDecoration(
                          labelText: 'Solde du compte',
                        ),
                        validator: (value) {
                          if (value!.isEmpty) {
                            return 'Le solde est obligatoire.';
                          }
                          if (double.tryParse(value) == null) {
                            return 'Le solde doit être un nombre.';
                          }
                          return null;
                        },
                        onSaved: (value) {
                          _solde = double.parse(value!);
                        },
                      ),
                      TextFormField(
                        decoration: InputDecoration(
                          labelText: 'métier du titulaire',
                        ),
                        validator: (value) {
                          if (value!.isEmpty) {
                            return 'La métier est obligatoire.';
                          }
                          return null;
                        },
                        onSaved: (value) {
                          _metier = value!;
                        },
                      ),
                      Padding(
                        padding: EdgeInsets.symmetric(vertical: 16.0),
                        child: ElevatedButton(
                          onPressed: () async {
                            if (_formKey.currentState!.validate()) {
                              _formKey.currentState!.save();
                              CompteDto nouveauCompte = CompteDto(
                                  adresse: _adresse,
                                  nom: _nom,
                                  cne: _cne,
                                  metier: _metier,
                                  email: _email,
                                  solde: _solde);
                              await CompteService.ajouterCompte(nouveauCompte);
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
              child: FutureBuilder<List<Compte>>(
                future: CompteService.getComptes(),
                builder:
                    (BuildContext ctx, AsyncSnapshot<List<Compte>> snapshot) {
                  return snapshot.hasData
                      ? Container(
  width: MediaQuery.of(context).size.width,
  child: ListView.builder(
    shrinkWrap: true,
    physics: ClampingScrollPhysics(),
    scrollDirection: Axis.vertical,
    itemCount: snapshot.data!.length,
    itemBuilder: (BuildContext context, index) {
      final compteList = snapshot.data![index];
      return MaterialButton(
          onPressed: () {
                                    Navigator.push(
                                      context,
                                      MaterialPageRoute(
                                          builder: (context) => OperationPage(compteId: compteList.id)),
                                    );
                                  },
        child: CarteCompte(
          solde: compteList.solde,
          dateCreation: compteList.dateCreation,
          referenceCompte: compteList.referenceCompte,
          etat: compteList.etat,
           id: compteList.id,
        ),
      );
    },
  ),
)
                      : Center(
                          child: CircularProgressIndicator(),
                        );
                },
              ),
            )
          ],
        ),
      ),
    );
  }
}
