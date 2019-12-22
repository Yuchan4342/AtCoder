def minimum_hug_to_palindrome(string)
	array = string.split('')
	n = array.length
	minimum_hug = 0
	(0...(n / 2)).each_with_index do |i|
		if array[i] != array[n - i - 1]
			minimum_hug += 1
		end
	end
	minimum_hug
end

line = gets.chomp
puts minimum_hug_to_palindrome(line)
