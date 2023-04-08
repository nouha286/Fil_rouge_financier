import 'package:financier/Pages/AgentPage.dart';
import 'package:financier/Pages/ComptePage.dart';
import 'package:financier/Pages/CreditPage.dart';
import 'package:financier/Pages/HomePage.dart';
import 'package:financier/Pages/OperationPage.dart';
import 'package:financier/Pages/ResponsablePage.dart';
import 'package:flutter/material.dart';
void main() {
  
  runApp(
    MyApp(),
  );
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  void initState() {
    super.initState();
    init();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'MenYOU',
      initialRoute: '/',
      theme: ThemeData(),
      routes: {
        '/': (context) => HomePage(),
        '/Home': (context) => HomePage(),
        '/operation':(context) => OperationPage(),
        '/compte':(context) => ComptePage(),
        '/responsable':(context) => ResponsablePage(),
        '/agent':(context) => AgentPage(),
        '/agence':(context) => AgentPage(),
        '/credit':(context) => CreditPage()

        //'/FoodDetailsPage': (context) => PlatDetailsPage(),
      },
    );
  }

 

 

 

  void init() async {
    // await sqlDb.delete();
    // await sqlDb.addData();
    // dynamic t = await getPlat();
    // print('hi$t');
  }
}
