import 'package:flutter/material.dart';

import 'package:flutter/material.dart';
import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  List<Map<String, dynamic>> _options = [
    {
      'title': 'Agence',
      'route': '/agence',
    },
    {
      'title': 'Agent',
      'route': '/agent',
    },
    {
      'title': 'Responsable',
      'route': '/responsable',
    },
    {
      'title': 'Crédit',
      'route': '/credit',
    },
    {
      'title': 'Compte',
      'route': '/compte',
    },
    {
      'title': 'Opération',
      'route': '/operation',
    }
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Tableau de bord'),
      ),
      body: GridView.count(
        crossAxisCount: 2,
        padding: EdgeInsets.all(16.0),
        children: _options
            .map((option) => GestureDetector(
                  onTap: () {
                    Navigator.pushNamed(context, option['route']);
                  },
                  child: Card(
                    child: Center(
                      child: Text(
                        option['title'],
                        style: TextStyle(fontSize: 20.0),
                      ),
                    ),
                  ),
                ))
            .toList(),
      ),
    );
  }
}
