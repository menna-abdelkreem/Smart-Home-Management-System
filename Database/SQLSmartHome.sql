CREATE DATABASE SmartHome;
GO

USE SmartHome;
GO


CREATE TABLE Device (
    id INT PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    location NVARCHAR(100),
    powerUsage FLOAT,
    type NVARCHAR(20) NOT NULL,   
    isOn BIT DEFAULT 0
);

CREATE TABLE LightAttributes (
    id INT PRIMARY KEY,
    brightness INT,
    color NVARCHAR(50),
    FOREIGN KEY (id) REFERENCES Device(id) ON DELETE CASCADE
);
CREATE TABLE ACAttributes (
    id INT PRIMARY KEY,
    temperature FLOAT,
    mode NVARCHAR(50),
    FOREIGN KEY (id) REFERENCES Device(id) ON DELETE CASCADE
);
CREATE TABLE RefrigeratorAttributes (
    id INT PRIMARY KEY,
    temperature FLOAT,
    doorOpen BIT,
    FOREIGN KEY (id) REFERENCES Device(id) ON DELETE CASCADE
);
CREATE TABLE DoorAttributes (
    id INT PRIMARY KEY,
    isLocked BIT,
    FOREIGN KEY (id) REFERENCES Device(id) ON DELETE CASCADE
);
CREATE TABLE Room (
    name NVARCHAR(100) PRIMARY KEY
);
CREATE TABLE RoomDevices (
    roomName NVARCHAR(100),
    deviceId INT,
    FOREIGN KEY (roomName) REFERENCES Room(name),
    FOREIGN KEY (deviceId) REFERENCES Device(id),
    PRIMARY KEY (roomName, deviceId)
);
CREATE TABLE Users (
    id INT PRIMARY KEY,
    username NVARCHAR(50),
    password NVARCHAR(100),
    email NVARCHAR(100),
    phone NVARCHAR(20),
    role NVARCHAR(20),

    preferredMode NVARCHAR(20),
    language NVARCHAR(10),
    notificationsEnabled BIT,
    theme NVARCHAR(20),
    twoFactorEnabled BIT,

    lastLogin DATETIME,
    totalUsageHours FLOAT,
    lastUsedDevice NVARCHAR(100),
    energySavingMode BIT
);
CREATE TABLE UserAllowedRooms (
    userId INT,
    roomName NVARCHAR(100),
    FOREIGN KEY (userId) REFERENCES Users(id),
    FOREIGN KEY (roomName) REFERENCES Room(name)
);
CREATE TABLE UserAllowedDevices (
    userId INT,
    deviceName NVARCHAR(100),
    FOREIGN KEY (userId) REFERENCES Users(id)
);

