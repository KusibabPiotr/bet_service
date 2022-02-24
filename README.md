# bet_service (in progress)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Features](#features)
* [To-do](#to-do)
* [Setup](#setup)

## General info
It is best to learn programming through practice. My motivation to build this application is the desire to consolidate technology and acquire new skills. Basicly this 
is REST API for now. Later on I'll build frontend using React. Is powered by external API. The application allows you to register, log in, check the results of matches in a given season for available leagues. You can also add bets to the card and settle the winnings(not real). Secured by Spring Security. Authorization using JWT. In progress... :(
	
## Technologies
Project is created with:
* Java JDK 13
* Spring Boot 2.6.2
* MySQL
* H2 Database
* Hibernate
* React(future frontend)

## Features
* if you are not app user you can only view available leagues and football matches for actueal season
* registration with email confirmation to enable user
* create you profile >> personal details
* for matches in next 7 days(sometimes less, depends on API info) you can fetch real odds value
* you can add bets to your cart

## To-do
* build bet cart processing
* build results checking
* testing in progress
* frontend React
* DEPLOY!!

## Setup
NOT READY TO USE
