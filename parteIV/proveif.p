var a, b : integer;
begin
a := 10;
b:=20;
if(a=10 and true=true and (true or false) and not(true and false) and false) then
	print (true)
else
	print (false);
if(b=a and b >= a) then
	print (true)
else
	print (false);
if(true) then
	print (-42++84);
if(false) then
	print (-10000)
end
