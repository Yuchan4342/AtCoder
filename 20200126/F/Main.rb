def function(n, d, a, x, h)
end

n, d, a = gets.chomp.split.map(&:to_i)
x = []
h = []
(0...n).each do |i|
	x_i, h_i = gets.chomp.split.map(&:to_i)
	x.push(x_i)
	h.push(h_i)
end
puts function(n, d, a, x, h)
