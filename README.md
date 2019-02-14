# Notes-Hub (name to be changed)

Notes-Hub or Notes in a Graph is supposed to be an application
showcasing common cloud infrastructure and techniques
such as discovery, gateway,
containerization, orchestration, centralized configuration and
hashing of secrets to build a modular project (maven multi module)
which can transition into a microservice project in the future quite easily, one
to build on the fundamentels of the project maintainer and two (once it's done) help
others transition more easily into building large scale projects.

Notes-Hub or Notes in a Graph will
initially be a web application only.
It'll allow the user to create:
  - Hub (A collection of Notes by Users that subscribe to the Hub)
  - Notes (public notes and private notes, associated with one or more hubs)
  - Tags (colored descriptive tags putting them on Hubs and notes)
  - Categories to collect tags and associate a hub
  with the category instead of spamming the taglist.

The end product regarding categories is still a topic to think about.

## The current state of the project: Building Infrastructure
- Creating bash and docker files for Spring Boot applications and others.
- Writing tests to see that containers are working properly

Develop Status [![Build Status](https://travis-ci.org/lotusmeanseight/NotesHub.svg?branch=develop)](https://travis-ci.org/lotusmeanseight/NotesHub)
