#!/bin/bash

#remove old version of PiGrageServer
sudo rm -rf ./out/com/
sudo rm -rf ./out/*.class

#Uncomment to install jdk8
#sudo apt-get install openjdk-8-jdk -y

#compile PiGarageServer
javac -d out -cp ./src  ./src/*.java