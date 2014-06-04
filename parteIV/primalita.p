var n , i , r : integer;
var primo : boolean;
begin
	n := 1237;
	i := 2;
	primo := true;
	while i < n / 2 and primo do begin
		r := n - ( n / i ) * i ;
		print( r );
		primo := r <> 0;
		i := i + 1
	end;
	print( primo )
end
