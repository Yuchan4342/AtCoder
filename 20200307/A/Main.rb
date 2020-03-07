def function(s)
	array = s.split('')
	!(array[0] == array[1] && array[0] == array[2])
end

s = gets.chomp
puts function(s) ? 'Yes' : 'No'
