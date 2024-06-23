# MediStock

**MediStock** is an educational Android application for inventory management, developed as a learning project. The application consists of two separate apps: a **User app** and an **Admin app**, with backend APIs built using Flask and hosted on PythonAnywhere.

## Disclaimer

This project is developed solely for learning purposes. It is not secure and should not be used in production environments.

## Features

### User App

- **User Registration & Login**: Simple account creation and authentication.
- **Admin Approval**: Admin approval required for new accounts. Users can register, but an admin must approve their accounts before they can access the application.
- **Order Management**: Users can create orders for products listed by the admin. Orders are categorized into pending, approved, and disapproved tabs based on admin actions.
- **Sales Management**: Users can sell products and maintain a comprehensive sales history.
- **Profile Management**: Users can update their account details such as name, email, and phone number, etc.

### Admin App

- **User Management**: Admins can add new users, view all approved users, manage pending user requests, and disapprove users.
- **Product Management**: Admins can add, view, and manage products available for orders.
- **Order Approval**: Admins can approve or disapprove orders placed by users.

[![MediStock App Video](https://img.youtube.com/vi/VIDEO_ID_HERE/0.jpg)](https://github.com/Muhammad-Noman59/MediStock/raw/master/MediStock%20App%20Video.mp4)
![logo](https://github.com/Muhammad-Noman59/MediStock/raw/master/MediStock%20App%20Video.mp4)

## Technology Stack

### User and Admin Apps

- **Kotlin**: The modern programming language for Android development.
- **Jetpack Compose**: Android’s modern toolkit for building native UI.
- **Retrofit**: A type-safe HTTP client for Android and Java.
- **Navigation Component**: Handle all app navigation.
- **Preference Data Store**: Store key-value pairs in a more efficient way.

### APIs

- **Flask**: A lightweight WSGI web application framework in Python.

### Architecture

- **MVVM (Model-View-ViewModel)**: Ensuring a clear separation of concerns and a clean architecture.

## Learning Experience

Developing MediStock has been an amazing learning experience. Here are some of the key things I learned:

- **API Development with Flask (Python)**: I learned how to create and manage APIs, allowing the app to communicate with the server effectively.
- **API Integration with Retrofit**: I figured out how to connect the app to APIs, making network requests and handling responses smoothly.
- **MVVM Architecture**: I understood how to structure the app using the Model-View-ViewModel architecture, making the code cleaner and easier to manage.
- **Jetpack Compose**: I explored building user interfaces with Jetpack Compose, creating responsive and dynamic UI elements.
- **Logic Building**: I improved my problem-solving skills by designing and implementing complex features like user registration, admin approval, order management, and sales tracking.

This project has been full of learning opportunities and has helped me grow as a developer.

## Download APKs

You can download the APKs for the User and Admin apps from the links below:

- [Download User App APK](https://github.com/Muhammad-Noman59/MediStock/releases/download/1.1/MediStock.apk)
- [Download Admin App APK](https://github.com/Muhammad-Noman59/MediStock/releases/download/1.1/AdminOfMediStock.apk)


## Getting Started

### API Hosting

The backend APIs for MediStock are hosted on PythonAnywhere. Ensure to update your base URL in the Retrofit configuration to point to the hosted API.


### Prerequisites

- **Android Studio**: The official IDE for Android development.
- **Python 3.x**: Required for running the Flask API.

### Installation

#### User and Admin Apps

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/Muhammad-Noman59/MediStock.git
    ```

2. **Open in Android Studio**:
    - Open the `UserApp` or `AdminApp` folder in Android Studio.

3. **Build and Run**:
    - Build the project and run it on an emulator or a physical device.

#### APIs

1. **Navigate to the API Directory**:
    ```bash
    cd MediStock/APIs
    ```

2. **Set Up a Virtual Environment**:
    ```bash
    python3 -m venv venv
    source venv/bin/activate
    ```

3. **Install Flask**:
    ```bash
    pip install flask
    ```

4. **Run the Flask App**:
    ```bash
    flask run
    ```

## Supporting
- **Financial Support**
<p align="left">  <a href="https://coindrop.to/muhammad-noman59" target="blank"><img align="center" src="https://github.com/Muhammad-Noman59/Tip-And-Bill-Calculator/assets/164490322/ee086675-e265-4457-a07e-9d2d7ad9e671" height="100" width="250" /></a></p>


## Contact Me

<p align="left">  <a href="https://wa.me/923104881573" target="blank"><img align="center" src="https://seeklogo.com/images/W/whatsapp-icon-logo-BDC0A8063B-seeklogo.com.png" height="35" width="35" /></a> <a href="https://www.facebook.com/profile.php?id=100092720556743&mibextid=ZbWKwL" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/facebook.svg" alt="https://www.facebook.com/profile.php?id=100092720556743" height="35" width="35" /></a> <a href="https://linkedin.com/in/muhammad-noman59" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="muhammad-noman59" height="35" width="35" /></a>

---

 <img alt="gfi" src="https://github.com/Muhammad-Noman59/Muhammad-Noman59/blob/main/Thnks%20For%20Watching.gif">

