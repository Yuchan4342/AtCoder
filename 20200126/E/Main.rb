def function(h, n, a, b)
	used_cost = 0
	hp = h
	while (hp > 0) do
		max_cost_performance = 0
		max_i = 0
		# コスパ最大の魔法を探す
		(0...n).each do |i|
			attack = a[i] >= hp ? hp : a[i]
			cost_performance = attack.to_f / b[i].to_f
			if cost_performance > max_cost_performance or (cost_performance == max_cost_performance and b[max_i] < b[i])
				max_cost_performance = cost_performance
				max_i = i
			end
			puts [attack, cost_performance].join(',')
		end
		hp = hp - a[max_i]
		used_cost += b[max_i]
		puts [a[max_i], b[max_i], hp, used_cost].join(',')
	end
	used_cost
end

h, n = gets.chomp.split.map(&:to_i)
a = []
b = []
(0...n).each do |i|
	a_i, b_i = gets.chomp.split.map(&:to_i)
	a.push(a_i)
	b.push(b_i)
end
puts function(h, n, a, b)
