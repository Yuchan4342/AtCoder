def function(s)
	array = s.split('')
	(array[2] == array[3] && array[4] == array[5])
end

s = gets.chomp
puts function(s) ? 'Yes' : 'No'
