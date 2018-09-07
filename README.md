# Space Challenge: Mission to Mars!

This is an implementation of Udacity's Space Challenge problem; the final project in their free course *Object Oriented Programming in Java*.
The purpose of this project is mastery of fundamental object-oriented concepts like:
- Use of classes to define and compartmentalize the behavior of similar *objects*.
- Multiple inheritance through the use of *interfaces*.
- Importing and using frameworks to extend the functionality of Java without "reinventing the wheel".
- Efficiently repeating code through the use of *for* and *while* loops, as well as ArrayLists.
- Use of *constructors* to build new objects on-the-fly.
- *Public* versus *private* variables, and the use of *getter* and *setter* functions to manipulate private variables otherwise outside of the scope and class of the code.

But what does it do? This program simulates a mission to colonize Mars. Two types of rockets are loaded, launched, and landed to the Red Planet. These rockets, the *U1* and *U2*, have different characteristics such as weight, cost, and carrying capacity. Which can complete the mission most cost-effectively, and/or with the fewest accidents? Let's find out!

## How to Use
  1. Copy or clone this GitHub project to your own hard drive.
  2. Open your favorite terminal program (ie: *Windows Command Line*, *Git Bash*).
  3. Navigate to the */src* directory within the project (wherever it was saved when copied/cloned.
  4. Type "java -version" to check if Java is installed. If not, you can download it for free from http://www.oracle.com/technetwork/java/javase/downloads/index.html.
  5. Type "javac SpaceChallenge.java" to compile the program.
  6. Type "java SpaceChallenge" to run the program.
  7. Run the program as many times as you'd like. Is one rocket always more economical than the other? Is one rocket more prone to violently explode?
  
## Suggested Uses
This program is provided free for use by the public. Feel free to muck about with the code with your favorite Java editor. Some things to try:
- Change the variables in the U1 and U2 rockets. If the U1 rocket could carry twice as much cargo, would it be twice as economical? Or would it just explode twice as often when landing?
- Change the cargo, listed in *phase1.txt* and *phase2.txt*.
- Currently, if any single item is too large to be carried by any rocket, the simulation will fudge the numbers and carry it anyway. This is a function, and not a bug. But can you figure out why this is and how to prevent it?
- Currently the cost of the cargo is not considered in the budget. That's not very realistic! Can you add a "cost" field to *phase1.txt* and *phase2.txt* items? And modify the code to consider the costs of replacing a crashed rocket *and* its cargo?
 
## Credits
- The "Space Challenge" problem was created by Udacity.
- This solution was coded by Kevin Lanzing.
- Java was created by James Gosling for Sun Microsystems, and since acquired by Oracle Corporation.
- GitHub is owned by Microsoft.


