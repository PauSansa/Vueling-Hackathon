# DOCUMENTATION
This code is written in order to the Vueling hackathon in colaboration with IT Academy.
Made by [Pau Sansa](https://github.com/PauSansa).

<br>

<div align="center">
  <a href="https://discordapp.com/users/1019274804362215464" alt="Send me a DM!">
    <img src="./media/discord.svg" width=25 />
  </a>
  &nbsp;&nbsp;&nbsp;
  <a href="https://www.linkedin.com/in/pausansa/">
    <img src="./media/linkedin.svg" width=25 alt="Visit my LinkedIn!"/>
  </a>
  &nbsp;&nbsp;&nbsp;
  <a href="mailto:pausansa59@gmail.com">
    <img src="./media/gmail.svg" width=25 alt="Send me an email!" />
  </a>
</div>

<br>

## CODE EXPLAINING
This code is a MVP for a new travel finder feature.
The app consists of two menus: 

 - Trip Manager
 - Trip Search Engine

 <br>

## FEATURES

1. Add a new Trip (it can be LandTrip or AirTrip)
2. Delete a trip
3. Show all Trips
4. Search Trips by Name
5. Search Trips by City

<br>

## HOW IT WORKS?
This code is written only with Java and mySQL, it consists of different classes such as Trip (from which LandTrip and AirTrip derive), TripManager (It is used to create, delete and search for trips) and dbManager (executes all actions related to the database).


 <br>
 
 ## STARTING THE APP
When the main method of the program is started, an instance of the app will be created and the init method of the instance will be run.

This init method will run the Trip Manager menu looped (in which you can change to the Search Engine).

<br>

### Trip Manager

In This Trip Manager you will be able to Add a Trip, Delete a Trip or Show All trips.

![Gif Menu Manager](./media/GifMenuManager.gif)



<br>

### Trip Search Engine

In this menu you'll be able to search trips by name or city

<br>

![Gif Search Engine](./media/GifSearchEngine.gif)

