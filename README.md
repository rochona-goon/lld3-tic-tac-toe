# lld3-tic-tac-toe

Tic-Tac-Toe LLD Implementation

A robust, object-oriented implementation of the classic Tic-Tac-Toe game, 
designed with scalability and clean code principles (LLD) in mind. 
This project demonstrates various design patterns to handle multiple players, 
bot players with different difficulty levels, and extensible winning strategies.


**🚀 Features**

* Support for N-sized boards: Play on $3 \times 3$ or scale up to $N \times N$.
* Multiplayer & Bot Support: Mix human players with automated bots.
* Difficulty Levels: Bots utilize different move strategies (Easy, Medium, Hard(in progress)).
* Extensible Winning Rules: Easily add new winning conditions (Row, Column, Diagonal).
* Input Validation: Robust checking for move validity and game state.

**🏗️ Project Structure**

The project is organized into distinct layers to ensure separation of concerns:

* **Controller:** Entry point for the UI/Client to interact with the game logic.
* **Models:**  Core entities like Board, Player, Bot, Move, and Cell.
* **Strategies:**  Implementation of Bot Playing Strategies and Winning Strategies.
* **Validators:**  Logic to verify game initialization rules and move legality.
* **Exceptions:**  Custom exceptions for handling invalid game states.

**🛠️ Design Patterns Used**

* Strategy Pattern: Used for BotPlayingStrategy and WinningStrategy to allow runtime switching of logic.
* Builder Pattern: Employed in the Game model to handle complex object creation with validation.
* Factory Pattern: Used to instantiate players or bots based on type.