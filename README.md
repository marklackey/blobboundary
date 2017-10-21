# blobboundary

This is a solution to the blob boundary problem 
the description refers to a character on Arrested Development, Bob Loblaw.
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