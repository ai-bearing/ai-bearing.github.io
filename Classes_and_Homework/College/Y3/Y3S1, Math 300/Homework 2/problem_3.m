% Problem 3
A = rand(4,3)
A(3:4,2:3)
A = [A(:,1) A(:,2) A(:,3) A(:,1)]
A(2:4,2:4) = eye(3)
A = [A(1,:);A(3,:)]
round(A)
A(:)'
