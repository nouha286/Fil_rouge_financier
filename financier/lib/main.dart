import 'package:financier/Pages/HomePage.dart';
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
