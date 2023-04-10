import 'package:flutter/material.dart';


import '../Models/Operation.dart';
import '../Service/OperationService.dart';

class OperationPage extends StatefulWidget {
  final int compteId;

  OperationPage({required this.compteId});

  @override
  _OperationPageState createState() => _OperationPageState();
}

class _OperationPageState extends State<OperationPage> {
  late Future<List<Operation>> _operations;

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
            validator: (String value) {
              if (value.isEmpty) {
                return 'Veuillez entrer un montant';
              }
              return null;
            },
          ),
          SizedBox(height: 16.0),
          Row(
            mainAxisAlignment: MainAxisAlignment.end,
            children: [
              RaisedButton.icon(
                icon: Icon(Icons.arrow_back),
                label: Text('Retirer'),
                onPressed: () {
                  // Effectuez l'action souhaitée (retirer le montant)
                },
              ),
            ],
          ),
        ],
      ),
    ),
  ),
),

          FutureBuilder(
            future: _operations,
            builder: (BuildContext context, AsyncSnapshot<List<Operation>> snapshot) {
              if (snapshot.hasData) {
                List<Operation> operations = snapshot.data!;
                return ListView.builder(
                  itemCount: operations.length,
                  itemBuilder: (BuildContext context, int index) {
                    return ListTile(
                      leading: Text('${operations[index].montant} DH'),
                      title: Text('${operations[index].type}'),
                      subtitle: Text('${operations[index].dateOperation}'),
                      // trailing: Text('${operations[index].compte.id}'),
                    );
                  },
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
