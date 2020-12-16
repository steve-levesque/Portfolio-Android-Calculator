# Portfolio-Android-Calculator

Started from a preset "Master/Detail Flow" example from Android Studio.

Calculator app for Android phones, tablets or others that support API 19 (4.4 KitKat version) or higher to support the built-in PDF generating.

## Features
### Save PDF
Saves the list of operations as a PDF file at /storage/emulated/0/Documents.
### Clear List
Deletes all enteries in the list.
### Grid Button
Opens the calculator interface.
### Operation Item Click
Shows information about the operation (total and equation).

Item list of saved operations |  Calculator          | Details about an operation
:-------------------------:|:-------------------------:|:----------------------------:
<img src="https://github.com/steve-levesque/Portfolio-Android-Calculator/blob/master/Screenshots/ItemList.jpg" alt="List of items within the app." width="200"/>  |  <img src="https://github.com/steve-levesque/Portfolio-Android-Calculator/blob/master/Screenshots/Calculator.jpg" alt="Calculator interface." width="200"/> | <img src="https://github.com/steve-levesque/Portfolio-Android-Calculator/blob/master/Screenshots/SaveItem.jpg" alt="Saved item from the list." width="200"/>

## Additional information
### API Version
Targeted for API 30 (R), but supports minimum version API 16 (4.1 Jelly Bean version). Reminder that API 19 (4.4 KitKat version) is needed for the PDF built-in class.

### Permissions
The application required read/write permission on your device. This is needed for the PDF Utility to work and create the pdf file on the directory. Depending of the API, you will need to enable it yourself. It may be done by default on older API versions.

### Code and IDE
- Java is used as the coding language.
- Android studio 4.0.1

### Unit Tests
- Current coverage: 6%.
<img src="https://github.com/steve-levesque/Portfolio-Android-Calculator/blob/master/Screenshots/Coverage_UnitTest.png" alt="Coverage list."/>

## How to run app, code or tests
### All cases
- Download the roject and run on Android Studio.
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
