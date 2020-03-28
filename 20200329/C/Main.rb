def function(k, n, array)
	# 隣接する家の間の最大の距離.
	max_distance = array.first + k - array.last
	(0...(n - 1)).each do |index|
		distance = array[index + 1] - array[index]
		max_distance = (distance > max_distance) ? distance : max_distance
	end
	k - max_distance
end

k, n = gets.chomp.split.map(&:to_i)
a = gets.chomp.split.map(&:to_i)
puts function(k, n, a)
