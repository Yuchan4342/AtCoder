def function(a, b)
	a == b ? "Yes" : "No"
end

a, b = gets.chomp.split
puts function(a, b)
