---
layout: page
title: "R Workthrough"
author: "Avinash Iyer"
permalink: /NSP_R_Workthrough
output: 
  html_document:
    keep_md: true
---
## Why?
I need to #learntocode and I figure that with a statistics class coming up and econometrics classes in my future, I will need a high powered stats language for my needs, and R fits the bill. I'm using No Starch Press's guides "The Art of R Programming" and "The Book of R" to work my way through.

## Getting Started

To store a vector to a variable, we do the following:


```r
x <- c(1,2,4)
```

We can also store this variable into a new variable:


```r
q <- c(x,x,8)
```

Then, we print `q`:


```r
q
```

```
## [1] 1 2 4 1 2 4 8
```

To pull out the individual element, we do the following:


```r
x[3]
```

```
## [1] 4
```

Elements of vectors in R are indexed at 1, **not** 0. For example, we would get an error if we tried to find `x[0]`. Importantly, we can also do subsets (or slicing, if we're talking about Python syntax).


```r
x[2:3]
```

```
## [1] 2 4
```

The syntax `x[2:3]` means we start at index 2 (or the 2nd element) and go until (and including) index 3 (or the 3rd element). For example, with our vector `q`:


```r
q[2:4]
```

```
## [1] 2 4 1
```

We can also find some values:


```r
mean(x)
```

```
## [1] 2.333333
```

```r
sd(x)
```

```
## [1] 1.527525
```

R also has a bunch of internal data sets that we can use for our own edification by typing in the following:


```r
data()
```

For example, we can use the dataset `Nile` for some fun:


```r
mean(Nile)
```

```
## [1] 919.35
```

```r
sd(Nile)
```

```
## [1] 169.2275
```

```r
hist(Nile)
```

![](NSP_R_Workthrough_files/figure-html/unnamed-chunk-9-1.png)<!-- -->

To make a function, we can define as follows:


```r
oddcount <- function(x){
  k<- 0 # assign 0 to k
  for (n in x){
    if(n%% 2 == 1) k<-k+1 # %% is modulus
  }
  return(k)
}
```

We can test our `oddcount` function on various vectors:


```r
oddcount(c(1,3,5))
```

```
## [1] 3
```

```r
oddcount(c(1,3,7,9,2,4))
```

```
## [1] 4
```

In function `oddcount`, the values of `k` and `n` are local variables, and so don't really exist until the function is called. This is different from Python. Additionally, functions are passed by value rather than by reference. Let's create a function called `addone`, and see what happens to our vectors.


```r
addone <- function(x){
  for(i in 1:length(x)){
    x[i] <- x[i]+1
  }
  return(x)
}
z <- c(1,3,5)
addone(z)
```

```
## [1] 2 4 6
```

```r
z
```

```
## [1] 1 3 5
```

## Vectors
In R, there is no separate thing as a "scalar," since scalars are considered to be 1-dimensional vectors. We define vectors as follows:

```r
x <- c(1,3,4)
x
```

```
## [1] 1 3 4
```

```r
length(x)
```

```
## [1] 3
```
R automatically recycles (or basically copypastes) the shorter vector in addition until it reaches the length of the longer vector, as follows:

```r
y<- c(1,3,4,5,6)
y
```

```
## [1] 1 3 4 5 6
```

```r
z <- x+y
```

```
## Warning in x + y: longer object length is not a multiple of shorter object
## length
```

```r
z
```

```
## [1] 2 6 8 6 9
```
This is equivalent to adding `c(1,3,4,1,3)` to `c(1,3,4,5,6)`.

Multiplication is performed elementwise:

```r
w <- c(1,3,4) * c(6,7,8)
w
```

```
## [1]  6 21 32
```
This is true of other numeric operators:

```r
k <- w %% c(3,4,2)
k
```

```
## [1] 0 1 0
```

Alternatively, we can do the following:

```r
w %% 2
```

```
## [1] 0 1 0
```

We can also generate vectors with slicing operations:

```r
z <- 5:8
z
```

```
## [1] 5 6 7 8
```

If we wanted to extract all but the last element, we can do either of the following:

```r
z[1:(length(z)-1)]
```

```
## [1] 5 6 7
```

```r
z[-length(z)]
```

```
## [1] 5 6 7
```

Slicing is precedent over plus/minus, so be wary (which is why we put the `length(z)-1` in parentheses up there).

We can also make vectors from sequences as follows:

```r
seq(from=1.1,to=2,length=10)
```

```
##  [1] 1.1 1.2 1.3 1.4 1.5 1.6 1.7 1.8 1.9 2.0
```
Sequences help deal with the null vector problem:

```r
x <- c(5,12,13)
seq(x)
```

```
## [1] 1 2 3
```

```r
x <- NULL
seq(x)
```

```
## integer(0)
```

We can also use the `rep(x,times)` function to repeat vectors a number of times.

```r
x <- rep(8,4)
x
```

```
## [1] 8 8 8 8
```

We can also use the argument `each` within the `rep` function to change how numbers are repeated.

```r
rep(c(5,12,13),3)
```

```
## [1]  5 12 13  5 12 13  5 12 13
```

```r
rep(c(5,12,13),each=3)
```

```
## [1]  5  5  5 12 12 12 13 13 13
```

We can also use the functions `any` and `all` as "or" or "and" for vector elements:

```r
x <- 1:10
any(x>8)
```

```
## [1] TRUE
```

```r
all(x>3)
```

```
## [1] FALSE
```

```r
any(x>88)
```

```
## [1] FALSE
```

We can use the `any` and `all` functions to find the number of runs of 1s in a vector of 0s and 1s, as follows:

```r
findruns <- function(x,k){
  n <- length(x)
  runs <- NULL
  for(i in 1:(n-k+1)){
    if(all(x[i:(i+k-1)] == 1)){
      runs <- c(runs,i)
    }
  }
  return(runs)
}
findruns(c(1,1,0,0,1,1,1,0,1,1,1),2) # this function should return (1,5,6,9,10)
```

```
## [1]  1  5  6  9 10
```

Considering that this function creates a new vector every time it finds a run, this is very memory inefficient. We can solve this by initializing a new vector in `runs` and then cutting it towards the end.

```r
findruns1 <- function(x,k){
  n <- length(x)
  runs <- vector(length=n) # create a vector of length n at the beginning
  count <- 0
  for(i in 1:(n-k+1)){
    if(all(x[i:(i+k-1)] == 1)){
      count <- count + 1 # remember that indexing in R starts at 1
      runs[count] <- i
    }
  }
  # this loop will change the vector elements in runs to the point where the runs start
  if(count > 0){ # if statement is to make sure we cut off our runs value
    runs <- runs[1:count]
  } else{
    runs <- NULL
  }
  return(runs)
}
findruns1(c(1,1,0,0,1,1,1,0,1,1,1),2)
```

```
## [1]  1  5  6  9 10
```

Most operations can be vectorized, as in the following:

```r
u <- c(5,2,8)
v <- c(1,3,9)
u > v
```

```
## [1]  TRUE FALSE FALSE
```
Here, the function checks each element of the vectors `u` and `v`. Additionally, we could do the following:

```r
w <- function(x) return(x+1)
w(u)
```

```
## [1] 6 3 9
```
Other standard functions are also vectorized:

```r
sqrt(u)
```

```
## [1] 2.236068 1.414214 2.828427
```

```r
u+1
```

```
## [1] 6 3 9
```
Additionally, they can be nested:

```r
sqrt(w(u))
```

```
## [1] 2.449490 1.732051 3.000000
```

```r
round(sqrt(1:9))
```

```
## [1] 1 1 2 2 2 2 3 3 3
```

Some functions end up working via vectorization even if they look like they have scalars. For example, the following function:

```r
add_square_vector <- function(x,c){
  return((x+c)^2)
}
```
We can do with a scalar element:

```r
add_square_vector(1:3,2)
```

```
## [1]  9 16 25
```
Or even with a vector element:

```r
add_square_vector(1:3,1:3)
```

```
## [1]  4 16 36
```



Imagine we have a vectorized function that yields a vector. For example:

```r
z12 <- function(z) return(c(z,z^2))
```
Then, we have the following:

```r
z12(3)
```

```
## [1] 3 9
```
and

```r
z12(1:8)
```

```
##  [1]  1  2  3  4  5  6  7  8  1  4  9 16 25 36 49 64
```

In order to resolve this, we could use the `matrix` function:

```r
matrix(z12(1:8),ncol=2)
```

```
##      [,1] [,2]
## [1,]    1    1
## [2,]    2    4
## [3,]    3    9
## [4,]    4   16
## [5,]    5   25
## [6,]    6   36
## [7,]    7   49
## [8,]    8   64
```
We can also use the `sapply(x,f)` (or *simplify apply*) to apply `f` to every element of `x` and convert to a matrix:

```r
sapply(1:8,z12)
```

```
##      [,1] [,2] [,3] [,4] [,5] [,6] [,7] [,8]
## [1,]    1    2    3    4    5    6    7    8
## [2,]    1    4    9   16   25   36   49   64
```

To deal with `NA` values, we can illustrate using the following:

```r
x <- c(8,NA,12,168,13)
x
```

```
## [1]   8  NA  12 168  13
```

```r
mean(x)
```

```
## [1] NA
```

```r
mean(x,na.rm=TRUE)
```

```
## [1] 50.25
```
We use `na.rm` to remove `NA` values. Whereas `NA` does affect the `mean` and other mathematical functions, `NULL` does not:

```r
y <- c(8,NULL,12,168,13)
mean(y)
```

```
## [1] 50.25
```

## Matrices, In Detail
### Defining and Subsetting
A matrix is simply a bunch of rows and columns. We can create a matrix as follows:

```r
A <- matrix(data=c(-3,2,893,0.17),nrow=2,ncol=2)
A
```

```
##      [,1]   [,2]
## [1,]   -3 893.00
## [2,]    2   0.17
```
We need to make sure that the length of the data vector is eqactly equal to `nrow*ncol`. By default, the `matrix` function fills in data by row, but we can also make it fill in the data by column:

```r
A <- matrix(data=c(1,2,3,4,5,6),nrow=2,ncol=3,byrow=TRUE)
A
```

```
##      [,1] [,2] [,3]
## [1,]    1    2    3
## [2,]    4    5    6
```

```r
B <- matrix(data=c(1,2,3,4,5,6),nrow=2,ncol=3,byrow = FALSE)
B
```

```
##      [,1] [,2] [,3]
## [1,]    1    3    5
## [2,]    2    4    6
```
We can also use bindings as follows:

```r
R <- rbind(1:3,4:6)
R
```

```
##      [,1] [,2] [,3]
## [1,]    1    2    3
## [2,]    4    5    6
```

```r
C <- cbind(1:3,4:6)
C
```

```
##      [,1] [,2]
## [1,]    1    4
## [2,]    2    5
## [3,]    3    6
```
We can then extract dimension as follows:

```r
dim(R)
```

```
## [1] 2 3
```

```r
dim(C)
```

```
## [1] 3 2
```
Where the first number is the rows and the second number is the columns. We can find the rows and columns as follows:

```r
R[1,]
```

```
## [1] 1 2 3
```

```r
R[,2]
```

```
## [1] 2 5
```
We can also use negative indices to delete.

```r
R[,-2]
```

```
##      [,1] [,2]
## [1,]    1    3
## [2,]    4    6
```
### Exercise 3.1
Part A:

```r
mtx <- matrix(data=c(4.3,3.1,8.2,8.2,3.2,0.9,1.6,6.5),nrow=4,ncol=2,byrow=TRUE)
mtx
```

```
##      [,1] [,2]
## [1,]  4.3  3.1
## [2,]  8.2  8.2
## [3,]  3.2  0.9
## [4,]  1.6  6.5
```
Part B:

```r
dim(mtx[-1,])
```

```
## [1] 3 2
```

```r
dim(mtx[-2,])
```

```
## [1] 3 2
```

```r
dim(mtx[-3,])
```

```
## [1] 3 2
```

```r
dim(mtx[-4,])
```

```
## [1] 3 2
```
Part C:

```r
mtx[,2] <- sort(mtx[,2])
mtx
```

```
##      [,1] [,2]
## [1,]  4.3  0.9
## [2,]  8.2  3.1
## [3,]  3.2  6.5
## [4,]  1.6  8.2
```
Part D:

```r
R <- mtx[-4,-2]
matrix(R)
```

```
##      [,1]
## [1,]  4.3
## [2,]  8.2
## [3,]  3.2
```
Part E:

```r
R <- mtx[3:4,]
R
```

```
##      [,1] [,2]
## [1,]  3.2  6.5
## [2,]  1.6  8.2
```
Part F:

```r
mtx[c(4,1),2] <- diag(x=R) * (-1/2)
mtx[c(4,1),1] <- diag(x=R) * (-1/2)
mtx
```

```
##      [,1] [,2]
## [1,] -4.1 -4.1
## [2,]  8.2  3.1
## [3,]  3.2  6.5
## [4,] -1.6 -1.6
```
### Operations
We can take the transpose of a matrix as follows:

```r
A <- rbind(c(2,5,2),c(6,1,4))
A
```

```
##      [,1] [,2] [,3]
## [1,]    2    5    2
## [2,]    6    1    4
```

```r
t(A)
```

```
##      [,1] [,2]
## [1,]    2    6
## [2,]    5    1
## [3,]    2    4
```
From Linear Algebra, we know that `t(t(A)) = A`

```r
t(t(A))
```

```
##      [,1] [,2] [,3]
## [1,]    2    5    2
## [2,]    6    1    4
```
We can find the inverse of a (square) matrix with the `solve` function:

```r
A <- rbind(c(1,0,3),c(5,3,4),c(3,3,7))
solve(A)
```

```
##            [,1]        [,2]       [,3]
## [1,]  0.3333333  0.33333333 -0.3333333
## [2,] -0.8518519 -0.07407407  0.4074074
## [3,]  0.2222222 -0.11111111  0.1111111
```
We can do matrix multiplication by using `%*%`, as follows:

```r
B <- rbind(c(0,1,3),c(1,1,3),c(3,5,7))
A%*%B # A is the matrix used in the previous code chunk
```

```
##      [,1] [,2] [,3]
## [1,]    9   16   24
## [2,]   15   28   52
## [3,]   24   41   67
```
### Exercise 3.2
Part A:

```r
A <- cbind(c(1,2,7),c(2,4,6))
B <- cbind(c(10,30,50),c(20,40,60))
(2/7)*(A-B)
```

```
##            [,1]       [,2]
## [1,]  -2.571429  -5.142857
## [2,]  -8.000000 -10.285714
## [3,] -12.285714 -15.428571
```
Part B:

```r
A<- cbind(c(1,2,7))
B<- cbind(c(3,4,8))
t(A) %*% B
```

```
##      [,1]
## [1,]   67
```

```r
mtx <- (B%*%t(B))+(A%*%t(A)) - cbind(c(100,0,0),c(0,100,0),c(0,0,100))
solve(mtx) 
```

```
##              [,1]         [,2]        [,3]
## [1,] -0.007923676  0.003123274 0.007843334
## [2,]  0.003123274 -0.005350239 0.011483806
## [3,]  0.007843334  0.011483806 0.017584735
```
Part C:

```r
A <- cbind(c(2,0,0,0),c(0,3,0,0),c(0,0,5,0),c(0,0,0,-1))
solve(A)%*%A - cbind(c(1,0,0,0),c(0,1,0,0),c(0,0,1,0),c(0,0,0,1))
```

```
##      [,1] [,2] [,3] [,4]
## [1,]    0    0    0    0
## [2,]    0    0    0    0
## [3,]    0    0    0    0
## [4,]    0    0    0    0
```
### Multidimensional Arrays
To create an array with certain dimension, we include a dataset and use the `array` function as follows:

```r
AR <- array(data=1:24,dim=c(3,4,2))
AR
```

```
## , , 1
## 
##      [,1] [,2] [,3] [,4]
## [1,]    1    4    7   10
## [2,]    2    5    8   11
## [3,]    3    6    9   12
## 
## , , 2
## 
##      [,1] [,2] [,3] [,4]
## [1,]   13   16   19   22
## [2,]   14   17   20   23
## [3,]   15   18   21   24
```
We can see that the element is expressed as `(a,b,c)` where `(a,b)` is in the 2D array, while `c` is the last element that shows which 2D array we are dealing with. We can also use four dimensions, as follows:

```r
arr <- array(data=rep(1:24,times=3),dim=c(3,4,2,3))
arr
```

```
## , , 1, 1
## 
##      [,1] [,2] [,3] [,4]
## [1,]    1    4    7   10
## [2,]    2    5    8   11
## [3,]    3    6    9   12
## 
## , , 2, 1
## 
##      [,1] [,2] [,3] [,4]
## [1,]   13   16   19   22
## [2,]   14   17   20   23
## [3,]   15   18   21   24
## 
## , , 1, 2
## 
##      [,1] [,2] [,3] [,4]
## [1,]    1    4    7   10
## [2,]    2    5    8   11
## [3,]    3    6    9   12
## 
## , , 2, 2
## 
##      [,1] [,2] [,3] [,4]
## [1,]   13   16   19   22
## [2,]   14   17   20   23
## [3,]   15   18   21   24
## 
## , , 1, 3
## 
##      [,1] [,2] [,3] [,4]
## [1,]    1    4    7   10
## [2,]    2    5    8   11
## [3,]    3    6    9   12
## 
## , , 2, 3
## 
##      [,1] [,2] [,3] [,4]
## [1,]   13   16   19   22
## [2,]   14   17   20   23
## [3,]   15   18   21   24
```
We can extract subsets as follows:

```r
AR[2,,2]
```

```
## [1] 14 17 20 23
```

```r
AR[2,c(3,1),2]
```

```
## [1] 20 14
```

```r
arr[1,,,1]
```

```
##      [,1] [,2]
## [1,]    1   13
## [2,]    4   16
## [3,]    7   19
## [4,]   10   22
```

```r
arr[,,2,]
```

```
## , , 1
## 
##      [,1] [,2] [,3] [,4]
## [1,]   13   16   19   22
## [2,]   14   17   20   23
## [3,]   15   18   21   24
## 
## , , 2
## 
##      [,1] [,2] [,3] [,4]
## [1,]   13   16   19   22
## [2,]   14   17   20   23
## [3,]   15   18   21   24
## 
## , , 3
## 
##      [,1] [,2] [,3] [,4]
## [1,]   13   16   19   22
## [2,]   14   17   20   23
## [3,]   15   18   21   24
```

```r
arr[1:3,4,,]
```

```
## , , 1
## 
##      [,1] [,2]
## [1,]   10   22
## [2,]   11   23
## [3,]   12   24
## 
## , , 2
## 
##      [,1] [,2]
## [1,]   10   22
## [2,]   11   23
## [3,]   12   24
## 
## , , 3
## 
##      [,1] [,2]
## [1,]   10   22
## [2,]   11   23
## [3,]   12   24
```
### Exercise 3.3
Part A:

```r
arr <- array(data=seq(from=4.8,to=0.1,by=-0.1),dim=c(4,2,6))
arr
```

```
## , , 1
## 
##      [,1] [,2]
## [1,]  4.8  4.4
## [2,]  4.7  4.3
## [3,]  4.6  4.2
## [4,]  4.5  4.1
## 
## , , 2
## 
##      [,1] [,2]
## [1,]  4.0  3.6
## [2,]  3.9  3.5
## [3,]  3.8  3.4
## [4,]  3.7  3.3
## 
## , , 3
## 
##      [,1] [,2]
## [1,]  3.2  2.8
## [2,]  3.1  2.7
## [3,]  3.0  2.6
## [4,]  2.9  2.5
## 
## , , 4
## 
##      [,1] [,2]
## [1,]  2.4  2.0
## [2,]  2.3  1.9
## [3,]  2.2  1.8
## [4,]  2.1  1.7
## 
## , , 5
## 
##      [,1] [,2]
## [1,]  1.6  1.2
## [2,]  1.5  1.1
## [3,]  1.4  1.0
## [4,]  1.3  0.9
## 
## , , 6
## 
##      [,1] [,2]
## [1,]  0.8  0.4
## [2,]  0.7  0.3
## [3,]  0.6  0.2
## [4,]  0.5  0.1
```
Part B:

```r
arr2 <- arr[c(4,1),2,]
arr2
```

```
##      [,1] [,2] [,3] [,4] [,5] [,6]
## [1,]  4.1  3.3  2.5  1.7  0.9  0.1
## [2,]  4.4  3.6  2.8  2.0  1.2  0.4
```
Part C:

```r
arr3 <- array(data=(rep(arr2[2,], times=4)),dim=c(2,2,2,3))
arr3
```

```
## , , 1, 1
## 
##      [,1] [,2]
## [1,]  4.4  2.8
## [2,]  3.6  2.0
## 
## , , 2, 1
## 
##      [,1] [,2]
## [1,]  1.2  4.4
## [2,]  0.4  3.6
## 
## , , 1, 2
## 
##      [,1] [,2]
## [1,]  2.8  1.2
## [2,]  2.0  0.4
## 
## , , 2, 2
## 
##      [,1] [,2]
## [1,]  4.4  2.8
## [2,]  3.6  2.0
## 
## , , 1, 3
## 
##      [,1] [,2]
## [1,]  1.2  4.4
## [2,]  0.4  3.6
## 
## , , 2, 3
## 
##      [,1] [,2]
## [1,]  2.8  1.2
## [2,]  2.0  0.4
```
Part D:

```r
arr4 <- arr[,,-6]
arr4
```

```
## , , 1
## 
##      [,1] [,2]
## [1,]  4.8  4.4
## [2,]  4.7  4.3
## [3,]  4.6  4.2
## [4,]  4.5  4.1
## 
## , , 2
## 
##      [,1] [,2]
## [1,]  4.0  3.6
## [2,]  3.9  3.5
## [3,]  3.8  3.4
## [4,]  3.7  3.3
## 
## , , 3
## 
##      [,1] [,2]
## [1,]  3.2  2.8
## [2,]  3.1  2.7
## [3,]  3.0  2.6
## [4,]  2.9  2.5
## 
## , , 4
## 
##      [,1] [,2]
## [1,]  2.4  2.0
## [2,]  2.3  1.9
## [3,]  2.2  1.8
## [4,]  2.1  1.7
## 
## , , 5
## 
##      [,1] [,2]
## [1,]  1.6  1.2
## [2,]  1.5  1.1
## [3,]  1.4  1.0
## [4,]  1.3  0.9
```
Part E:

```r
arr4[c(2,4),2,c(1,3,5)] <- -99
arr4
```

```
## , , 1
## 
##      [,1]  [,2]
## [1,]  4.8   4.4
## [2,]  4.7 -99.0
## [3,]  4.6   4.2
## [4,]  4.5 -99.0
## 
## , , 2
## 
##      [,1] [,2]
## [1,]  4.0  3.6
## [2,]  3.9  3.5
## [3,]  3.8  3.4
## [4,]  3.7  3.3
## 
## , , 3
## 
##      [,1]  [,2]
## [1,]  3.2   2.8
## [2,]  3.1 -99.0
## [3,]  3.0   2.6
## [4,]  2.9 -99.0
## 
## , , 4
## 
##      [,1] [,2]
## [1,]  2.4  2.0
## [2,]  2.3  1.9
## [3,]  2.2  1.8
## [4,]  2.1  1.7
## 
## , , 5
## 
##      [,1]  [,2]
## [1,]  1.6   1.2
## [2,]  1.5 -99.0
## [3,]  1.4   1.0
## [4,]  1.3 -99.0
```
## Non-Numerical Values
### Booleans
We can write booleans as follows:

```r
foo <- TRUE
foo
```

```
## [1] TRUE
```

```r
bar <- FALSE
bar
```

```
## [1] FALSE
```
We can also make a vector of booleans:

```r
baz <- c(T,T,T,F,T,F,F,F)
baz
```

```
## [1]  TRUE  TRUE  TRUE FALSE  TRUE FALSE FALSE FALSE
```
And we can make a matrix from this vector:

```r
qux <- matrix(data=baz,nrow=2,ncol=4,byrow=foo)
qux
```

```
##      [,1]  [,2]  [,3]  [,4]
## [1,] TRUE  TRUE  TRUE FALSE
## [2,] TRUE FALSE FALSE FALSE
```
And there are relational operators:

```r
1 == 2
```

```
## [1] FALSE
```

```r
1 > 2
```

```
## [1] FALSE
```

```r
1 < 2
```

```
## [1] TRUE
```

```r
1 >= 2
```

```
## [1] FALSE
```

```r
1 <= 2
```

```
## [1] TRUE
```

```r
1 != 2
```

```
## [1] TRUE
```
These relational operators are also elementwise on a vector:

```r
foo <- c(3,2,1,4,1,2,1,-1,0,3)
bar <- c(4,1,2,1,1,0,0,3,0,4)
foo >= bar
```

```
##  [1] FALSE  TRUE FALSE  TRUE  TRUE  TRUE  TRUE FALSE  TRUE FALSE
```
We can assign this vector of elementwise operations to a new vector:

```r
quux <- (foo == bar)
quux
```

```
##  [1] FALSE FALSE FALSE FALSE  TRUE FALSE FALSE FALSE  TRUE FALSE
```
There are logical operators too:

```r
T & F
```

```
## [1] FALSE
```

```r
T | F
```

```
## [1] TRUE
```

```r
T && F
```

```
## [1] FALSE
```

```r
T || F
```

```
## [1] TRUE
```
Pipes are `OR`, ampersands are `AND`. These operators are different when operating on vectors:

```r
foo <- c(T,F,F,F,T,F,T,T,T,F,T,F)
bar <- c(F,T,F,T,F,F,F,F,T,T,T,T)
foo&bar # elementwise
```

```
##  [1] FALSE FALSE FALSE FALSE FALSE FALSE FALSE FALSE  TRUE FALSE  TRUE FALSE
```

```r
foo|bar # elementwise
```

```
##  [1]  TRUE  TRUE FALSE  TRUE  TRUE FALSE  TRUE  TRUE  TRUE  TRUE  TRUE  TRUE
```

```r
foo&&bar # first element
```

```
## Warning in foo && bar: 'length(x) = 12 > 1' in coercion to 'logical(1)'

## Warning in foo && bar: 'length(x) = 12 > 1' in coercion to 'logical(1)'
```

```
## [1] FALSE
```

```r
foo||bar # first element
```

```
## Warning in foo || bar: 'length(x) = 12 > 1' in coercion to 'logical(1)'
```

```
## [1] TRUE
```
