def function(n, k, h)
	sorted = h.sort
	return 0 if k >= n

	result = 0
	(0...(n - k)).each do |i|
		result += sorted[i]
	end
	result
end

n, k = gets.chomp.split.map(&:to_i)
h = gets.chomp.split.map(&:to_i)
puts function(n, k, h)
