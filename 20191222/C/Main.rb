def greatest_common_divisor(a, b)
	r = a % b
	while(!r.zero?)
	    a = b
	    b = r
	    r = a % b
  	end
  	b
end

def least_common_multiple(a, b)
	gcd = greatest_common_divisor(a, b)
	a * b / gcd
end

line = gets.chomp
a, b = line.split(' ').map(&:to_i)
puts least_common_multiple(a, b)
