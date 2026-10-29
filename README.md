1. Project Description

The Video Game Database is a Java program that uses an SQLite database to store and organize information about video games. Each game has an ID, title, genre, platform, and release year.
The purpose of this program is to make it easier for users to find information about video games using a menu in the output terminal. The Java API connects to the SQLite database and allows users to retrieve information using different search options.

The API can answer questions such as:
- What video games are stored in the database?
- What game has a specific ID?
- Which games belong to a particular genre, such as RPG or Action?
- Which games are available on a specific platform, such as PC or Switch?
- Which games were released after a particular year?

The program uses three main Java classes.(Game.java) represents individual games.(GameAPI.java) handles the database connection and search operations.(Driver.java) provides the menu that allows users to interact with the program.

2. Test Run

===== Video Game Database =====
1. Display all games
2. Find game by ID
3. Search games by genre
4. Search games by platform
5. Find games released after a year
6. Exit
Enter your choice: 2

Enter game ID: 6

Game found:
ID: 6
Title: Elden Ring
Genre: RPG
Platform: PC
Release Year: 2022

===== Video Game Database =====
1. Display all games
2. Find game by ID
3. Search games by genre
4. Search games by platform
5. Find games released after a year
6. Exit
Enter your choice: 3

Enter genre: RPG

Games found:
ID: 6 | Elden Ring | RPG | PC | 2022
ID: 7 | The Witcher 3: Wild Hunt | RPG | PC | 2015

===== Video Game Database =====
1. Display all games
2. Find game by ID
3. Search games by genre
4. Search games by platform
5. Find games released after a year
6. Exit
Enter your choice: 4

Enter platform: Switch

Games found:
ID: 8 | Animal Crossing: New Horizons | Simulation | Switch | 2020
ID: 11 | Hades | Roguelike | Switch | 2020
ID: 5 | Super Mario Odyssey | Platformer | Switch | 2017
ID: 3 | The Legend of Zelda: Breath of the Wild | Adventure | Switch | 2017

===== Video Game Database =====
1. Display all games
2. Find game by ID
3. Search games by genre
4. Search games by platform
5. Find games released after a year
6. Exit
Enter your choice: 5

Enter year: 2020

Games found:
ID: 6 | Elden Ring | RPG | PC | 2022
ID: 9 | God of War Ragnarök | Action | PlayStation | 2022

===== Video Game Database =====
1. Show all games
2. Find game by ID
3. Search games by genre
4. Search games by platform
5. Find games released after a year
6. Exit
Enter your choice: 6

Goodbye!

3. AI Usage Statement

I used ChatGPT to help me understand how to set up the SQLite JDBC driver as I struggled with trying to go about that the most and trying to tie it back to the code.I used it as well for some troubleshoot errors, and organizing the project documentation.

I reviewed the instructions and code with assistance, worked through setup problems in VS Code, and learned how the Java files connect to the database throughout the process.I tested the program's operations to verify that everything works as expected multiple times over.