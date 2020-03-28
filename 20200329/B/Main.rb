def function(x)
	num_500 = (x / 500)
	num_5 = x % 500 / 5
	num_500 * 1000 + num_5 * 5
end

x = gets.chomp.to_i
puts function(x)
