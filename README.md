# blobboundary

This is a solution to the blob boundary problem:

A Blob is a shape in two-dimensional integer coordinate space where all cells have at least one adjoining cell to the right, left, top, or bottom that is also occupied. Given a 10x10 array of boolean values that represents a Blob uniformly selected at random from the set of all possible Blobs that could occupy that array, write a program that will determine the Blob boundaries. Optimize first for finding the correct result, second for performing a minimum number of cell Boolean value reads, and third for the elegance and clarity of the solution.

Sample input:  
0000000000  
0011100000  
0011111000  
0010001000  
0011111000  
0000101000  
0000101000  
0000111000  
0000000000  
0000000000  
Sample output:  
Cell Reads: 44
Top: 1
Left: 2
Bottom: 7
Right: 6

The description refers to a character on Arrested Development, Bob Loblaw.
I spent about half a day working on this.

### Process
I first simply created an array of arrays to represent the grid, 
and then searched linearly, row by row. 
That solution is represented in BlobBoundaryRowByRow 
and took less than an hour.

I then read a little online to see if there was any 
information on more elegant solutions. 
I think somewhere someone wrote that either 
Depth-First or Breadth-First would be equivalent.

Next, I wondered if any helpful libraries existed. 
I didn't bother looking too long because I thought it 
would be more interesting to roll my own in this situation.

### The solution
The algorithm is relatively simple.  I tend to avoid subclassing,
but extending ArrayList was a quick a elegant way to count
Boolean value reads.

#### Correctness
This solution has not been thoroughly tested, but I'm confident given
reasonable input that the solution is correct. 

#### Performance
I'm not sure how to go about optimizing the breadth-first search. 

The sample solution indicated better performance than I was able to 
achieve. But there is only one data point (fixture) to compare to,
and it's possible that it's not a real value. There is probably a way 
to make better guesses for finding an initial starting cell.
Generally, a lot more time would be needed to thoroughly approach 
optimization.

#### Elegance and Clarity
I spent probably 1/2 of my time making the solution elegant/concise
and easy to read and understand.

I did not try to make Main or the RowByRow solution elegant or clear.

I am a fan of prioritizing readability, and only sacrificing for 
performance when there is a significant gain.

I appreciate short methods (almost Ruby style) because they offer the 
chance to increase semantics.