#Introduction

This program was made for simulating the durability of a pencil with Java. The package consists of three classes: WriteDurability.java, Pencil.java and Paper.java. It requires the Java SDK and/or Eclipse IDE. Once installed, you can compile the package from the command line and run the WriteDurability.java program to begin the test.

#Compilation

To compile the programs correctly in CMD, all you need to do is have all files in the pencil_durability folder and place it on the desktop.

>> cd C:\Users\...\Desktop\

>> javac pencil_durability/*.java

>> java pencil_durability/WriteDurability.java

##Overview

Upon running the program, you will be prompted to enter three properties for your pencil: Length, Durability, and Eraser Durability all as integer values. This will determine how your pencil operates throughout the test. Once the pencil is made, a 'paper' is automatically created without the need for input, and you will be prompted to enter one of five functions: 'write', 'erase', 'edit', 'sharpen', or 'exit'.


##Write 

If the 'write' function is entered, the next prompt will ask for the text you wish to enter with the 'pencil' onto the 'paper'. The paper does not have a text limit, so you can write as much as your pencil will allow.

##Erase

If the 'erase' function is entered, the next prompt will ask for the text you wish to erase. The text you enter will be erased in REVERSE order, so if I wrote "My name is Sedrick. Sedrick is my name.", and erased 'name', then the last occurance of 'name' would be removed first:

"My name is Sedrick. Sedrick is my     "


##Edit

If the 'edit' function is entered, it will only work if something has been erased at least once. The last position of the erased value is where the edit begins in the text. If the edited text collides with characters on the paper, your text will be replaced with '@'. Editing does NOT increase the text length on the paper. Only the 'write' function will do that. A message will appear indicating this when you try to edit larger than your written text on paper.

##Sharpen

Sharpening the pencil increases the durability back to max. You can sharpen your pencil as many times as the length value will allow. So if a pencil is of length 4, it can only be sharpened 4 times.

#Exit

The exit function was a way for me to quit the program. Use it only if you want to end the test.
