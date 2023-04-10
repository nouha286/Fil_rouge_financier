import 'package:financier/Service/CompteService.dart';
import 'package:flutter/material.dart';

class CarteCompte extends StatefulWidget {
  int id;
  double solde;
  String referenceCompte;
  String dateCreation;
  String etat;

  CarteCompte({
    required this.id,
    required this.dateCreation,
    required this.referenceCompte,
    required this.solde,
    required this.etat,
  });

  @override
  _CarteCompteState createState() => _CarteCompteState();
}

class _CarteCompteState extends State<CarteCompte> {
  String _buttonText = '';

  Color _color = Colors.green;

  @override
  void initState() {
    super.initState();
    _buttonText = widget.etat == 'Approuved' ? 'Désapprouver' : 'Approuver';
    if (widget.etat == 'Approuved') {
      _color = Colors.redAccent;
    } else
      _color = Colors.green;
    ;
  }

  void _onButtonPressed() {
    if (widget.etat == 'Approuved') {
      _desapprouver();
      Navigator.of(context).pushNamed('/compte');
    } else {
      _approuver();
      Navigator.of(context).pushNamed('/compte');
    }
  }

  void _approuver() {
    setState(() {
      CompteService.approveCompteById(widget.id);
      _buttonText = 'Désapprouver';
      _color = Colors.redAccent;
    });
  }

  void _desapprouver() {
    setState(() {
      CompteService.desapproveCompteById(widget.id);
      _buttonText = 'Approuver';
      _color = Colors.green;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Card(
      margin: EdgeInsets.all(16.0),
      child: Container(
        decoration: BoxDecoration(
          color: Colors.white,
          boxShadow: [
            BoxShadow(
              color: Colors.lightBlueAccent.withOpacity(0.2),
              spreadRadius: 5,
              blurRadius: 7,
              offset: Offset(0, 3),
            ),
          ],
          borderRadius: BorderRadius.circular(15),
          border: Border.all(
            color: Colors.white,
          ),
        ),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            ListTile(
              title: Text(
                'Compte N°: ${widget.referenceCompte}',
                style: TextStyle(color: Colors.green),
              ),
              subtitle: Text('Solde: ${widget.solde} DH'),
            ),
            Padding(
              padding: EdgeInsets.symmetric(horizontal: 16.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  SizedBox(height: 8.0),
                  Text('Etat du compte: '),
                  Text('${widget.etat}',
                      style: TextStyle(color: Colors.orangeAccent)),
                  SizedBox(height: 8.0),
                  Text('Date de création de compte: ${widget.dateCreation}'),
                  SizedBox(height: 8.0),
                ],
              ),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.end,
              children: [
                Padding(
                  padding: EdgeInsets.all(16.0),
                  child: ElevatedButton(
                    style: ButtonStyle(
                      backgroundColor: MaterialStateProperty.all<Color>(_color),
                    ),
                    onPressed: _onButtonPressed,
                    child: Text(_buttonText),
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
