Tic Tac Toe – Git Lehrprojekt (Java / Maven)

Dieses Repository enthält ein Tic-Tac-Toe-Spiel in Java, das im Rahmen eines Git-Lehrgangs entwickelt wird.
Das Projekt dient dazu, Git-Grundlagen praktisch zu erlernen – darunter Commits, Branches, Merges, Konflikte und das Arbeiten mit GitHub.

Ziel des Projekts

Git kennenlernen und sicher anwenden

Versionskontrolle in der Softwareentwicklung verstehen

Branching-Strategien praktisch üben

Eine kleine Java-Anwendung planen, entwickeln und erweitern

Maven zum Builden und Strukturieren eines Projekts verwenden

Projektbeschreibung

Das Java-Tic-Tac-Toe umfasst:

Ein 3×3-Brett

Zwei Spieler (X und O)

Gewinnlogik (horizontal, vertikal, diagonal)

Erkennung eines Unentschiedens

Konsolenbasierte Benutzereingabe

Klar strukturierter Java-Code im Maven-Projektformat

Technologien

Java (Version 8 oder höher)

Maven als Build-Werkzeug

Standard-Java-Bibliotheken (keine zusätzlichen Dependencies erforderlich)

Projekt ausführen

Repository klonen:

git clone <repository-url>


Build ausführen:

mvn clean package


Spiel starten:

java -jar target/tictactoe.jar


(Falls der JAR-Name anders lautet, bitte anpassen.)

📚 Git-Lerninhalte im Projekt

Dieses Projekt eignet sich perfekt für Git-Einsteiger.
Folgende Themen werden geübt:

Git installieren & erstes Repository erstellen

Dateien versionieren und Änderungen nachverfolgen

Sinnvolle .gitignore-Regeln anwenden

Branches erstellen, wechseln und zusammenführen

Merge-Konflikte verstehen und lösen

Tags für Versionen setzen

Arbeiten mit GitHub (Push, Pull Requests, Issues)

Gute Commit-Nachrichten schreiben

Projektstruktur (Maven)
tictactoe/
├─ src/
│  ├─ main/
│  │  └─ java/
│  │     └─ <dein-package>/
│  │         └─ ...
│  └─ test/
│     └─ java/
├─ pom.xml
└─ README.md

Mitwirken

Da das Projekt als Trainingsumgebung dient, sind Erweiterungen ausdrücklich erwünscht:

Neue Features (z. B. KI-Gegner, GUI, Spielstatistik)

Verbesserungen im Code

Erweiterte Tests

Dokumentationsupdates

Pull Requests sind willkommen!
