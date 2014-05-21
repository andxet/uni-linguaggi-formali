var a, b, c : integer;
var x, y, z : boolean;
begin
	a := 5;
	b := -5;
	c := +10;
	x := true;
	y := false;
	z := not true;
	
	a := a+b;
	a := b+a;
	
	a := a*b;
	a := b*a;
	
	a := a/b;
	a := b/a;
	
	x := x and y;
	
	x := x or y;
	
	x := not x;
	
	while a <> 0 do begin
		if a < b then begin
			a := b 
		end;
		x := x and not y
	end;
	
	while y do begin
		if x then begin
			a := b 
		end;
		x := x and not y
	end;
	
	z := true
end