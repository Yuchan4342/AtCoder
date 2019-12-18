def is_palindrome(string)
	array = string.split('')
	n = array.length
	(0...(n / 2)).each_with_index do |i|
		if array[i] != array[n - i - 1]
			return false
		end
	end
	return true
end

line = gets.chomp
puts is_palindrome(line)
