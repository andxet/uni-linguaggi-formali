var a, b, c : integer;
var x, y, z : boolean;
begin
a:=20;
b:=5;
c:=3;
x:= true;
y:= false;
z:= x or y;
print(z);
print(x and y or true and not false);
print((a+a*c-b)/5-b*c++a+-b);
print(10>0 and false);
print(10<=0 or not false);
print(10<=0 or true);
print(10>=10);
print(10<=10);
print(10<>0);
print(10=10);


end