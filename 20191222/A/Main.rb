def function(a, b, c)
	return (a + b + c >= 22)
end

line = gets.chomp
a, b, c = line.split(' ').map(&:to_i)
puts function(a, b, c) ? 'bust' : 'win'
