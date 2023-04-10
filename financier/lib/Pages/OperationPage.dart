import 'package:flutter/material.dart';

import '../Models/Operation.dart';
import '../Service/OperationService.dart';

class OperationPage extends StatefulWidget {
  final int compteId;

  OperationPage({required this.compteId});

  @override
  _OperationPageState createState() => _OperationPageState(compteId: compteId);
}

class _OperationPageState extends State<OperationPage> {
  late Future<List<Operation>> _operations;
  final int compteId;

  _OperationPageState({required this.compteId});
  double _montant = 0.0;
  @override
  void initState() {
    super.initState();
    _operations = OperationService.getOperationsByCompte(widget.compteId);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Liste des opérations'),
      ),
      body: Column(
        children: [
          Container(
            padding: EdgeInsets.all(16.0),
            child: Card(
              child: Padding(
                padding: EdgeInsets.all(16.0),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    TextFormField(
                      decoration: InputDecoration(
                        labelText: 'Montant',
                      ),
                      validator: (String? value) {
                        if (value!.isEmpty) {
                          return 'Veuillez entrer un montant';
                        }
                        return null;
                      },
                      onSaved: (value) {
                        _montant = double.tryParse(value!)!;
                      },
                    ),
                    SizedBox(height: 16.0),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        ElevatedButton.icon(
                          icon: Icon(Icons.arrow_back),
                          label: Text('Retirer'),
                          onPressed: () {
                            onPressed:
                            () async {
                              await OperationService.getOperationsByCompte(
                                  compteId);
                              // Enregistrer le Compte dans la base de données
                              Navigator.pop(context);
                            };
                          },
                        ),
                        ElevatedButton.icon(
                          icon: Icon(Icons.arrow_forward),
                          label: Text('Déposer'),
                          onPressed: () {
                            // Effectuez l'action souhaitée (déposer le montant)
                          },
                          style: ElevatedButton.styleFrom(
                            primary: Colors.blue,
                            onPrimary: Colors.white,
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(8.0),
                            ),
                          ),
                        ),
                      ],
                    ),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        ElevatedButton.icon(
                          icon: Icon(Icons.mobile_screen_share_sharp),
                          label: Text('Transférer'),
                          onPressed: () {
                            // Effectuez l'action souhaitée (transférer le montant)
                          },
                          style: ElevatedButton.styleFrom(
                            primary: Colors.blue,
                            onPrimary: Colors.white,
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(8.0),
                            ),
                          ),
                        )
                      ],
                    )
                  ],
                ),
              ),
            ),
          ),
          FutureBuilder(
            future: _operations,
            builder: (BuildContext context,
                AsyncSnapshot<List<Operation>> snapshot) {
              if (snapshot.hasData) {
                List<Operation> operations = snapshot.data!;
                return Expanded(
                  child: ListView.builder(
                    itemCount: operations.length,
                    itemBuilder: (BuildContext context, int index) {
                      return ListTile(
                        leading: Text('${operations[index].montant} DH'),
                        title: Text('${operations[index].type}'),
                        subtitle: Text('${operations[index].dateOperation}'),
                        // trailing: Text('${operations[index].compte.id}'),
                      );
                    },
                  ),
                );
              } else {
                return Center(
                  child: CircularProgressIndicator(),
                );
              }
            },
          )
        ],
      ),
    );
  }
}
