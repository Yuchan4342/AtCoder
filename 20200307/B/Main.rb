def function(n, a, b)
	sum = a + b
	n / sum * a + (n % sum <= a ? n % sum : a)
end

n, a, b = gets.chomp.split.map(&:to_i)
puts function(n, a, b)
