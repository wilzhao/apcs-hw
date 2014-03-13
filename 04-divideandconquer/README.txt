Instead of looping through the sorted array/ArrayList once, we can look at the array in halves.

Say we had this array of 15 integers: 1 2 2 4 5 6 7 9 11 12 12 14 15 15 16
If we were looking for the number 5 in the array, we can start with the middle number 9 and compare 5 to 9
Since 5 is less than 9, we can focus on the left side of the array
      	   	  v   
| 1 2 2 4 5 6 7 | 9 11 12 12 14 15 15 16
(the pipe characters represent the part of the array we are focusing on and the v is the number that halves the array)
Then we take the middle of this array of 7 integers, which is 4, and when we see that 5 > 4, we can look to the right to the 4
      v     
1 2 2 4 | 5 6 7 | 9 11 12 12 14 15 15 16

Then we take the middle of these 3, which is 6, 6 > 5, so we look to the left
              v        
1 2 2 4 | 5 | 6 7 9 11 12 12 14 15 15 16

The final comparison is with 5 and 5, and since 5 equals 5, we have found what we were looking for.
          v
1 2 2 4 | 5 | 6 7 9 11 12 12 14 15 15 16

This should run more quickly than a full loop through, especially when the item we are looking for isn't in the array.
