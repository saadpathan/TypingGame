# TypingGame

Welcome to the Typing Game GitHub repository! This project is a fun and interactive typing game designed to help users improve their typing speed and accuracy. The game challenges users to type a given sentence as quickly and accurately as possible, and then provides feedback on their performance.

## Features

### User Interface
- **Prompt and Target Text**:
  - The game starts by displaying a prompt label that instructs users to type the provided sentence.
  - The target sentence is: "The quick brown fox jumps over the lazy dog."

- **Text Area**:
  - A large, editable text area is provided for users to type the target sentence.

- **Start/Submit Button**:
  - A button to start the game. Once the game is started, the button text changes to "Submit."
  - Clicking "Submit" ends the game and checks the typed text against the target text.

- **Timer**:
  - A timer displays the elapsed time in the format "Timer: mm:ss:SSS".
  - The timer starts when the user begins typing and stops when the user clicks "Submit."

- **Result Label**:
  - Displays the result of the game, indicating whether the typed text is correct or incorrect, and shows the time taken if correct.

### Functionality
- **Start Game**:
  - Clicking the "Start" button clears the text area, makes it editable, and starts the timer.
  
- **End Game**:
  - Clicking the "Submit" button stops the timer, makes the text area non-editable, and checks the typed text.
  - If the typed text matches the target text, the result label displays a success message along with the time taken.
  - If the typed text does not match the target text, the result label prompts the user to try again.

- **Timer Update**:
  - The timer updates every 10 milliseconds to provide an accurate measure of typing speed.

### Design
- **Java Swing**:
  - Utilizes Java Swing for the graphical user interface, ensuring cross-platform compatibility and a responsive design.
  
- **Fonts and Colors**:
  - Custom fonts and colors are used to enhance the visual appeal of the game, making it engaging and user-friendly.

## How to Run
1. Ensure you have Java installed on your system.
2. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/typing-game.git
   ```
3. Navigate to the project directory and compile the code:
   ```bash
   javac -d bin -sourcepath src src/typinggame/TypingGame.java
   ```
4. Run the application:
   ```bash
   java -cp bin typinggame.TypingGame
   ```

## Contributing
We welcome contributions from the community. If you have any suggestions, bug reports, or feature requests, please open an issue or submit a pull request. Make sure to follow our contributing guidelines.

