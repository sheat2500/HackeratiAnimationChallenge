# Objective

*The goal of this assignment is to demonstrate proficiency working with the 
dynamics of Android’s UI.

*Create a native Android application that displays a vertical list of items long enough 
to be scrolled. You may populate the list with whatever content you choose, but 
clicking somewhere on each item should ‘expand’ that item: animate the item’s 
height so that it grows smoothly over a few hundred milliseconds. 

*An expanded item’s UI should change from its collapsed state so that clicking somewhere on that item collapses it in the reverse way that it expands. Expanding an item should 
‘collapse’ any items that had already been expanded. 

*Your app should have an Action Bar that smoothly animates up and away when the 
list is scrolled down and animates down into view when the list is scrolled back up.
Swiping to the left or right should ‘flip’ the entire list over the vertical line defined in 
the middle of the screen. The flip appears as a 3D rotation around the line and the 
swipe gesture controls the rotation angle. The ‘back side’ of the screen should have a 
button that, when clicked, flips the screen over to display the list again. 

More Info:

1.	Your app only needs to work in portrait mode 
2.  At a minimum, your app needs to support SDK 4.1 (API 16)
3.  Use of open source 3rd party libraries is permitted
4.  Personal touches encouraged
5.  Questions are permitted

## Learned from this Challenge
The most challenging task is from the last bulletin: At first, I had two options either using 
[Card Flip](http://developer.android.com/training/animation/cardflip.html) and [ViewPager](http://developer.android.com/training/animation/screen-slide.html)

Through reading the documents and searching from internet, I found ViewPager is more extenstive and has the best performance on customized animation with touch gestures.  

## Reference
[ListViewAnimation by nhaarman](https://github.com/nhaarman/ListViewAnimations)
