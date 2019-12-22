# def function(n)
# 	if n < 2
# 		1
# 	else
# 		n * function(n - 2)
# 	end
# end

def number_of_zero_for_f(n)
	# n が奇数なら必ず 0.
	return 0 if n.odd?

	number_of_five = 0
	# n が偶数の場合, 2, 4, ..., n の中の約数5の個数を数える.
	number_to_divide = 5
	while (number_to_divide * 2 <= n)
		number_of_five += n / 2 / number_to_divide
		number_to_divide *= 5
	end
	number_of_five
end

n = gets.chomp.to_i
puts number_of_zero_for_f(n)
