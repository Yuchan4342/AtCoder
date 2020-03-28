def min(x, y)
	x < y ? x : y
end

def shortest_distance(i, j, n, x, y)
	if i <= x && y <= j
		(x - i) + (j - y) + 1
	elsif i <= x && j < y
		dist = min(y - j + 1, j - x)
		(x - i) + dist
	elsif x < i && y <= j
		dist = min(i - x + 1, y - i)
		(j - y) + dist
	elsif x < i && j < y
		min(j - i, i - x + y - j + 1)
	end
end

def function(n, x, y)
	counts = Array.new(n, 0)
	(1...n).each do |i|
		((i + 1)..n).each do |j|
			distance = shortest_distance(i, j, n, x, y)
			counts[distance] += 1
		end
	end
	(1...n).each do |k|
		puts counts[k]
	end
end

n, x, y = gets.chomp.split.map(&:to_i)
function(n, x, y)
