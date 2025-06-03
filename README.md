# Monopoly Game 🎲

This project is a simple implementation of the classic Monopoly board game in Java. It allows users to play a game of Monopoly with two players, buy properties, build houses and hotels, pay rent, and draw luck cards. The game can be saved and loaded at any time.

## 📜 Repository Structure

- `monopoly/src/`: Contains the Java source code for the game.
  - `Main.java`: The main class to run the game.
  - `Tabuleiro.java`: Represents the game board and manages the game logic.
  - `Jogador.java`: Represents a player in the game.
  - `Propriedade.java`: Represents a property on the board (e.g., land, station, utility).
  - `CartaSorte.java`: Represents a luck card.
- `monopoly/bin/`: Contains the compiled Java bytecode files.
- `logTabuleiro.bytej`: The file used to save and load the game state.
- `README.md`: This file, providing information about the project.

## 🚀 How to Run

1.  **Compile the code:**
    Navigate to the `monopoly/src/` directory and compile the Java files. You can use a Java compiler (javac).
    ```bash
    cd monopoly/src
    javac *.java -d ../bin
    ```
2.  **Run the game:**
    Navigate to the `monopoly/bin/` directory (or stay in `monopoly/src` and adjust the classpath) and run the `Main` class.
    ```bash
    cd ../bin 
    java Main
    ```
    Alternatively, from the `monopoly/src` directory:
    ```bash
    java -cp ../bin Main
    ```
    The game will start in the console, and you can interact with it by following the on-screen prompts.

## 💾 Saving and Loading

-   **Saving:** During your turn, when prompted to roll the dice or save, type `salvar` to save the current game state. The game will be saved to the `logTabuleiro.bytej` file in the root directory.
-   **Loading:** When you start the game, it will ask if you want to load a saved game. Choose the option to load, and it will resume from the state saved in `logTabuleiro.bytej`.

## 🤝 Contributing

Contributions are welcome! If you have ideas for improvements or find any bugs, feel free to:

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix.
3.  Make your changes.
4.  Submit a pull request with a clear description of your changes.
