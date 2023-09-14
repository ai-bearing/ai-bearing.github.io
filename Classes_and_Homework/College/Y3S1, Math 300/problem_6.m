% Problem 6
syms t
f = diff(sin(t));
x=0:pi/100:2*pi;
y1=sin(x);
y2=vpa(subs(f,t,2))*(x-2) + sin(2);
plot(x,y1,x,y2);
ylim([-2 2]);
legend('sin(x)','tangent line at x=2')
title('Graph 2')
xlabel('x')
ylabel('y')
