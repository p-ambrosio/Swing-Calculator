# 🧮 Swing-Calculator
This project is of a simple calculator built using Java Swing to learn and understand the fundamentals of GUI development, using OOP practices to manage and create a clean structure. This project demonstrates basic interface design, event handling, and user interaction by implementing standard calculator operations in a colorfull, clean, functional layout.

---
## Learning Goals

This project was created to:

- Understand Java Swing components  
- Practice event-driven programming  
- Learn how to structure a small GUI application  
- Separate logic, input handling, and presentation

---
## Features
- Basic operations: addition, subtraction, multiplication, division, square-root
- Negative value handling
- Interactive GUI built with Swing
- Button-based input system
- Real-time display updates
- Simple and clean layout (Android style)
- Dark color scheme (One-dark inspired)

---
## Screenshots
![Calculator UI](Assets/Display.png)

---
## Class Diagram
```mermaid
classDiagram
direction BT

class Calculations {
  - handleCalc(String) void
  + computing(double, double, String) double
}

class Display {
  - styleButton(JButton, String) void
}

class Inputs {
  + getCurrent() String
  + setCurrent(String) void
  - handleInput(String) void
}

Calculations --> Inputs : uses
Inputs --> Display : updates
```

---
## Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Java%20Swing-GUI-blue?style=for-the-badge)

---

