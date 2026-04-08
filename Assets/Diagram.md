classDiagram
direction BT
class Calculations {
  ~ Calculations() 
  - handleCalc(String) void
  + main(String[]) void
  + computing(double, double, String) double
}
class Display {
  ~ Display() 
  - styleButton(JButton, String) void
  + main(String[]) void
}
class Inputs {
  ~ Inputs() 
  + getCurrent() String
  + setCurrent(String) void
  - handleInput(String) void
  + main(String[]) void
}

Calculations  -->  Inputs 
Inputs  -->  Display 
