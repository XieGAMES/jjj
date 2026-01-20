# Desktop Application Setup

## Overview
This project includes a native desktop application built with JavaFX that connects to the backend API.

## Project Structure
- `zd.zmk.desktop`: Main package for desktop application
  - `DesktopApplication.java`: Main entry point for the desktop app
  - `controller/`: FXML controllers
    - `MainController.java`: Controller for the main window
  - `model/`: Model classes for UI binding
    - `VendingMachineModel.java`: UI-friendly model for vending machines
  - `view/`: FXML view files (resources/fxml/)
  - `util/`: Utility classes
    - `ApiClient.java`: HTTP client for connecting to backend API

## Dependencies
The desktop application uses:
- JavaFX 20 for the UI
- Jackson for JSON processing
- Standard Java HTTP client for API communication

## Running the Application
1. Make sure the backend server is running on `http://localhost:8080`
2. Compile the project with Java 17+
3. Run the `zd.zmk.desktop.DesktopApplication` class

## Features
- View all vending machines from the backend
- Refresh data from the API
- Display vending machine information in a table

## Future Enhancements
- Add, edit, and delete vending machines
- View detailed information for each machine
- Add product and sales management
- Implement search and filtering capabilities