# Senior-Project
## Goals
* To create a playable side scrolling video game

## Plot
* The player must go a few levels spread throughout the world, collecting a story item in each one
* The player may complete the levels in any order, except the last one
* The player may move freely from one level to the others
* The levels will consist of a series of rooms, in which the player must figure out how to open the doors to get to the next room. The plot item that the player is after will be in a deep room in the dungeon.
* The player will be able to open doors by using a key, or by other means, such as flipping a switch, or defeating all of the enemies in the room
* In the areas that are not levels, there should be a village in which the player can talk to the villagers for hints/clues.
* The player should be able to save their progress. I was thinking there could be a set of flags for each level that keep track of the player's progress, and then maybe set of global flags that can be accessed from any level. For something like a key that should only be able to be picked up once, it should set one of these bits when it is picked up. If the level is loaded again, when it is time to create the key, its flag will be checked to see if it has already been picked up. I might be able to use these flags for actor communication as well. So, for the switch opening a door, the switch and the door would be assigned the same flag. The door could check the flag every frame, waiting for it to change. When the switch is hit, all it will do is toggle the flag, so that it doesn't have to know that it is opening a door. The door will observe tha changed flag, and open or close itself. It might be better to set up some kind of observer system for this, so that instead of the door checking the flag every frame, it can be notified automatically when the change happens, via a callback method of some sort.
* There should be a couple of short, scripted cinematic events(cutscenes), which are done on the fly(not stored in a movie file), which would involve showing the player character walking, without input from the keyboard, and maybe displaying some text. I am thinking maybe one at the beginning of the game, one at the end, and maybe one in between.

## Other Goals
### Transitions
#### Transitions Between Rooms in the Same Level
* For rooms in which the door is on the left or right egde of the room, the camera should slide horizontally into the next room. After the transition takes place, the actors from the previous room should be discarded, but not the door, because the player should be able to use the door to go back to the previous room.
* For rooms in which the door is the kind that you push up on the controller(the door is on the wall, behind the player), the screen should fade to black, and then fade into the new room.
* I have not decided how I will handle vertical transitions, or if I will implement them at all. If I do, I will probably go for something similar to the horizontal panning to the next room, but vertical.
#### Transitions Between Levels
* Transitions between levels should look similar to transitions between rooms in which the door is on the wall behind the player. The sreen should fade to black, and then fade into the requested room of the next level.
* The way I am thinking about it right now, all of the reading from the disk for the level should happen durng this transition, as the screen will be black. This would avoid any potential stuttering or freezing up during room transitions, especially the horizontal sliding ones, in which the screen is not faded to black.
### Map Editor
* Instead of entering map data by hand in a text file, I should make a gui so that I could use the mouse to make maps. Also, using an SQLite data base to hold everything would be easier to maintain than trying to stitch together a bunch of folders, zip files, text files, xml files, and other things.
* I was thinking of using either Java Swing or JavaFX for the gui.
### Animations
