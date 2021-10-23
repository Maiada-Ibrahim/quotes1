quotes Application
<--API--> Used json parser (Gson library) to parse the json file to a class of type quote and Buffered reader built-in class to read the file from the local machine .

Overview
My application will read data from API and respond with a random quote and display it to the user, if offline it will read from A local JSON file and display a random quote from it .

Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites
Operating system: Mac OS, Windows, Linux
Git Follow the instruction in the links below to install git in your machine
Windows
Mac OS
Linux
Codeing Editor
Installation
open your terminal
Clone the repo git clone git@github.com:Maiada-Ibrahim/quotes1.git
Usage
To use the Application using the IDE Simply run the program and the output will be displayed.
Architecture
This application was build with Core Java and it includes:

Class App to handle Connecting to an API and reading data methods.
Class ApiQuote to hole the data responded from Api class .
Class Quote to hold the data read locally .