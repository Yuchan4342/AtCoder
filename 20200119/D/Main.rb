def c(n, i, j)
	k = 1
	digits = 1
	count = 0
	while true
		k = 10 ** (digits - 1) * i
		while k / (10 ** (digits - 1)) == i and k <= n
			count += 1 if k % 10 == j
			k += 1
		end
		break if k > n

		digits += 1
	end
	count
end

def handstand(n)
	array = Array.new(9) {Array.new(9, -1)}
	count = 0
	(1..9).each do |i|
		(1..9).each do |j|
			if array[i - 1][j - 1] == -1
				array[i - 1][j - 1] = c(n, i, j)
			end
			if array[j - 1][i - 1] == -1
				array[j - 1][i - 1] = c(n, j, i)
			end
			count += array[i - 1][j - 1] * array[j - 1][i - 1]
		end
	end
	count
end

n = gets.chomp.to_i
puts handstand(n)
