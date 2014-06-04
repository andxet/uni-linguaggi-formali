var a, b, c : integer;
begin
	a :=0;
	b:=100;
	while(a<b) do begin
		print(a+1);
		a:=a+1;
		c:=a;
		while(c>1) do
			c:=c-2;
		if(c=0)then
			print (true)
		else
			print (false)
		end
end