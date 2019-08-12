# PiGarage
A Garage Door Opener For The Rasberry Pi
<br/><br/>
What you will need?<br/>
Raspberry Pi (wifi module recommend)<br/>
Raspbian (Desktop or Lite) https://www.raspberrypi.org/downloads/raspbian/<br/>
5V Relay interface board<br/>
Android Device<br/>
JDK

<br/>
<img src="https://github.com/MitchellKopczyk/PiGarage/blob/master/img/PiGarageClient.png" height="300" width="275">
<br/>


<br/>
Wiring 3 Easy Steps:
<br/><br/>
Power
<img src="https://github.com/MitchellKopczyk/PiGarage/blob/master/img/Power.jpg" height="200" width="300">
<br/><br/>
GPIO
<img src="https://github.com/MitchellKopczyk/PiGarage/blob/master/img/GPIO.jpg" height="200" width="300">
<br/><br/>
Garage Switch
<img src="https://github.com/MitchellKopczyk/PiGarage/blob/master/img/GarageSwitch.jpg" height="200" width="300">
<br/><br/><br/>
Installing Server:<br/><br/>
Copy the PiGarageServer directory anywhere on your Pi and from that directory run the command sudo bash install.sh<br/>
<img src="https://github.com/MitchellKopczyk/PiGarage/blob/master/img/install.png">
<br/>
Configuration :<br/><br/>
Once the install completes there are three configuation files in the PiGarage directory they are named pins, port, and keys.<br/>
pins: sets the GPIO pins you wish to use to output to the relay switch (each line represent a pin, only 4 pins/doors are allowed at this time)<br/>
port: set the port on which the server will run on<br/>
keys: stores keys used to authenticate and specify the users that wishes to open doors <br/><br/>
Run Server:<br/><br/>
Run the server using the command sudo bash run.sh
<img src="https://github.com/MitchellKopczyk/PiGarage/blob/master/img/run.png">
<br/>
The server should be good to go. Run the run.sh as daemon for background use if you would like.<br/>
Please read over scripts before executing them.<br/><br/>
Pinout For Pi B+ (note when addressing GPIO pins in pins config file they go by their GPIO# not the physical pinout# on the board.<br/>
<img src="https://github.com/MitchellKopczyk/PiGarage/blob/master/img/pinout.png" height "500" width="200">
