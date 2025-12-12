# 🥐 Croissonne
> **A Strategic Tile-Placement Board Game (Java)**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Course](https://img.shields.io/badge/Course-Programming_Methodology-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Complete-success?style=for-the-badge)

## 📖 About The Project

**Croissonne** is a turn-based strategy board game inspired by the classic *Carcassonne*. Developed as a final project for a **Programming Methodology** course, this application reimagines the original mechanics with perilous terrain types and custom scoring logic.

The goal of this project was to demonstrate strong **Object-Oriented Programming (OOP)** principles, separating complex game logic from the graphical user interface.

---

## 🎮 Game Mechanics

Unlike the peaceful countryside of the original, **Croissonne** introduces high-stakes terrain. Players take turns drawing tiles to build a shared map.

| Feature | Description |
| :--- | :--- |
| **Terrain Types** | Rivers, Mountains, and the dangerous **Abyss**. |
| **The Twist** | Navigate path logic while surviving "Death" tiles like the `CURVE_OF_DEATH` or `CASTLE_ON_ABYSS`. |
| **Scoring** | Recursive pathfinding algorithms calculate points for completed rivers and controlled territories. |

---

## 🛠️ Technical Architecture

This project is built using a strict **MVC-inspired architecture** to ensure modularity and clean code.

### 1. Object-Oriented Design
* **Inheritance:** The game utilizes a robust tile hierarchy. The base `Tile` class extends into `RegularTile` and `ScoreableTile` to differentiate behavior.
* **Interfaces:** Implements `Rotatable` and `Scoreable` interfaces to decouple game mechanics from specific object types.

### 2. Algorithmic Highlights
* **Recursive Pathfinding:** The `RiverScoreCollector` class uses recursion to traverse connected tiles and calculate scores based on path completion.
* **Area Control:** The `TileAreaDeterminer` dynamically assesses board state to determine valid placement zones.

### 3. Resource Management
* **Asset Loading:** Dedicated `AudioLoader` and `ImageLoader` classes handle standard I/O operations efficiently, managing resources for 9 player colors and over 15 unique tile types[cite: 1, 3].

---

## 📂 Project Structure

```text
src/
├── application/    # Main entry point (Main.java) 
├── component/      # Models: Board, Player, and Tile hierarchy 
├── gui/            # View: Game Panes (BoardPane, InGamePane) 
├── logic/          # Controller: GameLogic, Scoring, Storage 
├── data/           # Resources: ImageLoader, AudioLoader 
└── utils/          # Utilities: Enums (PlayerColor, TileType) 
````

-----

## 🚀 How to Run

### Prerequisites

  * **Java JDK 8** or higher.
  * (Optional) An IDE like IntelliJ IDEA or Eclipse for editing.

### Running the JAR

You can run the pre-compiled game directly:

```bash
java -jar croissonne.jar
```


### Running from Source

1.  Clone the repo.
2.  Open the folder in your IDE.
3.  Run `src/application/Main.java`.

-----

## 📸 Gallery

  * **Dynamic Menus:** Main Menu, Player Selection (up to 9 colors), and Tutorial screens[cite: 1, 3].
  * **Visual Feedback:** Custom graphics for distinct tiles like `WATERFALL_TO_ABYSS` and `TJUNCTION_RIVER`.

*(Note: Add screenshots of your gameplay here to make the repo pop\!)*

-----

## 👨‍💻 Contributors

* **HGKXZ** - Worachart Poungtabtim
* **Rirhcceez** - Patcharapon Srisuwan
* **wirepecion** - Siravut Chunu

*Created for Programming Methodology Class*

<!-- end list -->
