# Android Quiz App

A simple yet effective Android quiz application that tests users' knowledge of Android development concepts using Fragments.

## Features

- Welcome screen with start button
- Multiple-choice questions
- Real-time score tracking
- Result screen with final score
- Option to retry the quiz
- Smooth fragment transitions
- Modern Material Design UI

## Technical Details

### Built With
- Java
- Android SDK
- AndroidX libraries
- Fragment API

### Minimum Requirements
- Android SDK 26 (Android 8.0) or higher
- AndroidX compatibility

## Project Structure

```
QuizApp/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/quizapp/
│   │   │   ├── MainActivity.java
│   │   │   ├── Question.java
│   │   │   ├── QuestionFragment.java
│   │   │   ├── StartFragment.java
│   │   │   └── ResultFragment.java
│   │   └── res/
│   │       ├── layout/
│   │       │   ├── activity_main.xml
│   │       │   ├── fragment_question.xml
│   │       │   ├── fragment_start.xml
│   │       │   └── fragment_result.xml
│   └── build.gradle
└── build.gradle
```

## Setup Instructions

1. Clone the repository:
```bash
git clone https://github.com/yourusername/QuizApp.git
```

2. Open the project in Android Studio

3. Build the project:
   - Click "Build" > "Make Project"
   - Or use the keyboard shortcut Ctrl+F9 (Windows/Linux) or Cmd+F9 (macOS)

4. Run the app:
   - Select your target device
   - Click "Run" > "Run 'app'"
   - Or use the keyboard shortcut Shift+F10 (Windows/Linux) or Control+R (macOS)

## Usage

1. Launch the app
2. Press "Start Quiz" on the welcome screen
3. Answer each question by selecting one of four options
4. View your final score on the result screen
5. Choose to try again if desired

## Architecture

- **MainActivity**: Controls the quiz flow and manages fragments
- **Fragments**: Handle UI components and user interactions
- **Question Model**: Data structure for quiz questions
- **Fragment Navigation**: Manages transitions between screens

## Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details

## Acknowledgments

- Android Developer Documentation
- Material Design Guidelines
- AndroidX Fragment Library
