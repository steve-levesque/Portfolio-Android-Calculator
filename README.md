<!-- Repo's Banner -->
![Portfolio-Android-Calculator](https://user-images.githubusercontent.com/42849270/124153726-bbf55600-da62-11eb-907d-3e8d2124df2b.png)



<!-- Shield Badges -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]


<!-- Description of the Project -->
## About

Calculator app for Android phones, tablets or others that support API 19 (4.4 KitKat version) or higher to support the built-in PDF generating.

### Features
#### Save PDF
Saves the list of operations as a PDF file at /storage/emulated/0/Documents.
#### Clear List
Deletes all enteries in the list.
#### Grid Button
Opens the calculator interface.
#### Operation Item Click
Shows information about the operation (total and equation).

Item list of saved operations |  Calculator          | Details about an operation
:-------------------------:|:-------------------------:|:----------------------------:
<img src="https://github.com/steve-levesque/Portfolio-Android-Calculator/blob/main/Screenshots/ItemList.jpg" alt="List of items within the app." width="200"/>  |  <img src="https://github.com/steve-levesque/Portfolio-Android-Calculator/blob/main/Screenshots/Calculator.jpg" alt="Calculator interface." width="200"/> | <img src="https://github.com/steve-levesque/Portfolio-Android-Calculator/blob/main/Screenshots/SaveItem.jpg" alt="Saved item from the list." width="200"/>

### Unit Tests
- Current coverage: 6%.
- JUnit tests
- 2 types: material and code oriented.
<img src="https://github.com/steve-levesque/Portfolio-Android-Calculator/blob/main/Screenshots/Coverage_UnitTest.png" alt="Coverage list."/>


<!-- Repo's Content Tree -->
## Directories and Files
<details open>
  <summary><b>Project's Tree</b></summary>
    
  ``` bash
    |- Calculator           # Contains the Android Studio project.
    |   |- ...              # App content.
    |   |- .gitignore       # Excludes IDE specific, compiled and not needed files.   
    |- Files
    |   |- Save_Sample.pdf  # Sample of a saved pdf with an entry from the calculator.  
    |- Screenshots          # Contains the screenshots of the repo.
    |   |- ...
    |- LICENSE              # Details about the license.
    |- README.md            # This file.
  ```
</details>


<!-- Getting Started -->
## Installation
Download Android Studio and follow the steps until completed. Below are informations about other components you need to have/install in order for the application to work.

### API Version
Targeted for API 30 (R), but supports minimum version API 16 (4.1 Jelly Bean version). Reminder that API 19 (4.4 KitKat version) is needed for the PDF built-in class.

### Permissions
The application required read/write permission on your device. This is needed for the PDF Utility to work and create the pdf file on the directory. Depending of the API, you will need to enable it yourself. It may be done by default on older API versions.

### APK on Device
You may plug your phone or device to your computer in order to install the application. Elsewhere, you can use the emulator or compile the project into an apk.



## How to Execute
### All cases
- Download the project and run it on Android Studio with the start (play) button. The emulator should pop-up with your application.
### Exterior device
- Plug in device and allow device debugging. (Supposing that dev mode is enabled already on it)
- Select your device and run code.
- After the app is installed, allow permissions if necessary.
### Emulator
- Download and install on Android Studio an adequate API with a phone design of choice. (in general prompts of the IDE are intuitive)
- Select your emulator and run code.
### Tests
- InstrumentedTest: Choose physical device and Ctrl+Shift+F10 or right click -> Run "Instrumented_testname".
- UnitTest: Ctrl+Shift+F10 or right click -> Run "Unit_testname" with Coverage. 



<!-- Contribution -->
## Contribution

Contributions are always welcome, thank you for you time. Here are the steps to do so.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/MyContribution`)
3. Commit your Changes (`git commit -m 'Add MyContribution'`)
4. Push to the Branch (`git push origin feature/MyContribution`)
5. Open a Pull Request



<!-- License -->
## License

See the `LICENSE` file at the root of the project directory for more information.



<!-- Acknowlegements and Sources -->
## Acknowlegements and Sources
- Started with a preset "Master/Detail Flow" example from Android Studio.



<!-- md links & imgs -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/steve-levesque/Portfolio-Android-Calculator.svg?style=for-the-badge
[contributors-url]: https://github.com/steve-levesque/Portfolio-Android-Calculator/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/steve-levesque/Portfolio-Android-Calculator.svg?style=for-the-badge
[forks-url]: https://github.com/steve-levesque/Portfolio-Android-Calculator/network/members
[stars-shield]: https://img.shields.io/github/stars/steve-levesque/Portfolio-Android-Calculator.svg?style=for-the-badge
[stars-url]: https://github.com/steve-levesque/Portfolio-Android-Calculator/stargazers
[issues-shield]: https://img.shields.io/github/issues/steve-levesque/Portfolio-Android-Calculator.svg?style=for-the-badge
[issues-url]: https://github.com/steve-levesque/Portfolio-Android-Calculator/issues
[license-shield]: https://img.shields.io/github/license/steve-levesque/Portfolio-Android-Calculator.svg?style=for-the-badge
[license-url]: https://github.com/steve-levesque/Portfolio-Android-Calculator/blob/main/LICENSE
