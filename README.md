# Smart-Home-Management-System
Smart Home Management System
Abstract
The Smart Home Management System is an integrated solution designed to automate, monitor, and control household deices efficiency. 
The system improves home security, energy consumption, and user comfort by providing intelligent control over lighting, temperature, doors, appliances, and renewable energy source.
It is implemented using Java(OOP principles), JavaFX for GUI, and SQL Server as the backend database.
This Project introduces a flexible user system with personalized profiles, access control levels, device management, and energy-saving insights to ensure an efficient smart home environment.
Introduction
The rapid growth of smart technologies has transformed traditional home into intelligent spaces capable of responding to user’s needs.
Smart home aim to make living more comfortable, efficient, and secure by automating daily tasks such as controlling lights, doors, refrigerators, and more.
This Project presents a complete and scalable Smart Home Management System, allowing users to monitor and control their home devices through a simple and intuitive graphical user interface (GUI).
Problem Statement
Managing a modern home with multiple device is becoming more complex.
Users often face challenges such as :
Wasting energy due to manual device control.
Lack of monitoring over device usage.
Difficulty managing access permissions for different family members.
No unified system to control lighting, temperature, appliances ,and energy units.
This project solves this issues by offering a centralized smart home platform.
A unified system is required to monitor, control, and manage hoem devices in an organized, intelligent manner.
System objectives
The system aims to:
Provide an easy-to-use interface for controlling smart home devices.
Improve home security through user management and access control.
Reduce energy consumption using energy-saving modes.
Give real-time feedback on device status.
Support multiple user roles(Admin-Parent-Kid-Guest).
Show clear analytics and usage statistics.
Offer a personalized user experience (Themes, Preferred modes, notifications.....).
Project Scope
In-Scope
Smart home device modeling(AC, Lights, Door, Refrigerator, Solar Panel, Wind Turbine)
User account system with roles and permissions.
Login system using JavaFX.
Real-time device control dashboard
SQL Server database integration.
Device usage statistics& energy tracking
MVC architecture implementation.
Out of scope
Mobile application
IoT physical device (hardware)
voice control system
System Features
User Management
Register/ Login
Two-Factor Authentication
Theme & Language setting
User profile
User roles (Admin-Parent-Kid-Guest).
Device Control
ON/OFF
Change AC temperature
Adjust light brightness
Lock/Unlock door
Refrigerator controls 
Renewable energy monitoring
Analytics & Monitoring
Total usage hours
Last used device
Energy saving mode
System activity logs
Admin panel
Manage user
Assign permissions
Add/remove rooms or devices
View system logs
System Architecture
The system uses the MVC architecture: 
Model 
contains all smart home classes
Device (Abstract)
Light
Door
Refrigerator
AC
Renewable Energy Source (Abstract)
Solar Panel
Wind Turbine
Room
User
view
JavaFX UI:
loginView
DashboardView
DeviceControlPanels
Controller
HomeController
LoginController
DeviceController
Database Layer
DBConfig
DatabaseManager
Implementation Details
Application Environment
Desktop Application
Technology: JavaFX, FXML, SQLServer
IDE: IntelliJ
Design Tool: Scene Builder
Database Tool: SQL Server Management Studio
Database Structure (SQL Server)
Tables include:
Users
Rooms
Device
DeviceStatus
EnergyUsage
Logs
The ERD describes relationships between users, room, devices, and usage logs.(Designed by Ola Ahmed)
UML Diagrams Included
Use Case Diagram
Class Diagram
Sequence Diagram
They describe the full workflow and system structure.(Designed by Menna AbdElkreem)
Project Modules 
Login Module 
Allows users to authenticate and access the system based on their roles.
Dashboard Module 
Displays device status, statics, and quick controls.
Device Management Module
Allows user to view and  and control all smart devices in each room.
User Administration Modul
Admin-only features:
Add User
Remove User
Edit permissions
Testing Plan
Unit testing for each class
GUI testing
Integration testing
Database connection testing
Scenario testing(Home, Away, Night, modes)
Expected Results
A function desktop smart home application
clean, styled, modern UI
Smooth login experience
Real-time device control
Energy Usage insights
Professional UML + ERD + documentation
Conclusion
This proposal outlines a complete Smart Home Management System with robust features, modular architecture, and good scalability.
The project demonstrates strong understanding of OOP, JavaFX, SQL Server.
