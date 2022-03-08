# bet_service (in progress)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Features](#features)
* [To-do](#to-do)
* [Setup](#setup)

## General info
It is best to learn programming through practice. My motivation to build this application is the desire to consolidate technology and acquire new skills. Basicly this 
is REST API for now. Later on I'll build frontend using React. Is powered by external API. The application allows you to register, log in, check the results of matches in a given season for available leagues. You can also add bets to the cart and settle the winnings(not real). Secured by Spring Security. Authorization using JWT.
	
## Technologies
Project is created with:
* Java JDK 13
* Spring Boot 2.6.2
* MySQL
* H2 Database
* Hibernate
* React(future frontend) >> little teaser << dockerized login/registration home page for app: https://hub.docker.com/repository/docker/piotrka94/betservice-front-login

## Features
* only admin can fetch new leagues to application 
* only admin is allowed to get fixtures for league for a given season of a given year
* if you are not app user you can only view available leagues and football matches for actual season
* registration with email confirmation to enable user
* create/edit you profile >> personal details
* for matches in next 7 days(sometimes less, depends on API info) you can fetch real odds value
* you can add those odds to your cart and process it

## To-do
* finish results checking feature
* add pay-in option - for a now you'll get 100$ for a start :)
* testing in progress
* frontend React
* DEPLOY!!

## Setup
NOT READY TO USE
