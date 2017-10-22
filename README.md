# blobboundary

This is a solution (technically, two solutions) to the blob boundary problem.
The name, Bob Loblaw, refers to a character on the television series Arrested Development.
I spent about half a day working on this.

The problem:  

"A Blob is a shape in two-dimensional integer coordinate space where all cells have at 
least one adjoining cell to the right, left, top, or bottom that is also occupied. 
Given a 10x10 array of boolean values that represents a Blob uniformly selected at 
random from the set of all possible Blobs that could occupy that array, write a program 
that will determine the Blob boundaries. Optimize first for finding the correct result, 
second for performing a minimum number of cell Boolean value reads, and third for the 
elegance and clarity of the solution.

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


### Process
I first simply created an array of arrays to represent the grid, 
and then searched linearly, row by row. I used a 3x3 array for testing my algorithms.
This solution is demonstrated in BlobBoundaryRowByRow 
and took less than an hour.

I then read a little online to see if there was any 
information on more elegant solutions. 
I think somewhere someone wrote that either 
Depth-First or Breadth-First would be equivalent.

Next, I wondered if any helpful libraries existed. 
I didn't bother looking too long because I thought it 
would be more interesting to roll my own in this situation.

### The solution
The breadth-first algorithm is relatively simple. I didn't use any resources to complete 
 the logic, relying on my memory of breadth-first implementations.
 
I tend to avoid subclassing, preferring delegation, but extending ArrayList was a quick and 
elegant way to count the Boolean value reads. Using a single list to represent the cells, 
instead of a list of lists, was more efficient and probably more elegant.

#### Correctness
This solution has not been thoroughly tested, but I'm confident given
reasonable input that the solution is correct. I have some validation, mainly just for convenience,
i.e. to make life easier while testing.

#### Performance
I'm not sure how to go about optimizing the breadth-first search. 

The sample solution indicated better performance than I was able to 
achieve. I'm not sure 44 reads is a realistic target for a simple implementation. 
There is only one data point (fixture) to use for comparing implementations.
There is probably a way to make better guesses for finding an initial starting cell.
Generally, at least a few days would be needed to thoroughly approach optimization.

#### Elegance and Clarity
I spent probably 1/2 of my time making the solution elegant/concise and easy to read and understand.

I did not try to make Main or the RowByRow solution elegant or clear.

I am a fan of prioritizing readability, and only sacrificing for 
performance when there is a significant gain.

I appreciate short methods (almost Ruby style) because they offer the 
chance to increase semantics, and, with modern compilers, often performance is just as good.