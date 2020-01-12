def function(n, k, m, a)
	point = a.inject(&:+)
	goal = n * m
	need = goal - point
	return -1 if need > k

	(need <= 0) ? 0 : need
end

n, k, m = gets.chomp.split(' ').map(&:to_i)
a = gets.chomp.split(' ').map(&:to_i)
puts function(n, k, m, a)
