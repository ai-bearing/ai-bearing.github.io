% Problem 5
x=0:pi/100:2*pi;
y1=sin(x);
y2=cos(x);
y3=tan(x);

plot(x,y1,x,y2,x,y3)
ylim([-2 2]);
legend('sin(x)','cos(x)','tan(x)')
title('Graph 1')
xlabel('x')
ylabel('y')
