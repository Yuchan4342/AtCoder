def result(a, b, x)
	min = 0
	max = 1_000_000_000
	digit = max.to_s.length
	half = (max - min) / 2
	price = a * max + b * digit
	return max if price < x
	min
	while max - min > 1
		digit = half.to_s.length
		price = a * half + b * digit
		if price > x
			max = half
			half = (max - min) / 2 + min
		elsif price < x
			min = half
			half = (max - min) / 2 + min
		else
			return half
		end
	end
	min
end

a, b, x = gets.chomp.split().map(&:to_i)
puts result(a, b, x)
