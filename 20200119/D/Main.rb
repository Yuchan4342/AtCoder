def handstand(n)
	num_digits = n.to_s.length
	count = 0
	(1..num_digits).each do |digits_a|
		(1..digits_a).each do |digits_b|
			if digits_b == 1
				if digits_a == 1
					count += n >= 9 ? 9 : n
				elsif digits_a < num_digits
					count += 9 * (10 ** (digits_a - 2)) * 2
				else
					first_digit = n.to_s.split('')[0].to_i
					count += (first_digit - 1) * (10 ** (digits_a - 2)) * 2
					array = Array.new(digits_a) { '0' }
					array[0] = first_digit.to_s
					array[array.length - 1] = first_digit.to_s
					a = array.join.to_i
					while a <= n
						array = a.to_s.split('')
						count += 2 if array.first.to_i == first_digit and array.last.to_i == first_digit
						a += 1
					end
				end
			else
				if digits_a < num_digits
					count += 9 * 9 * (10 ** (digits_a - 2)) * (10 ** (digits_b - 2))
				elsif digits_a > digits_b
					first_digit = n.to_s.split('')[0].to_i
					(1...first_digit).each do |i|
						(1..9).each do |j|
							count += (10 ** (digits_a - 2)) * (10 ** (digits_b - 2)) * 2
						end
					end
					array = Array.new(digits_a) { '0' }
					array[0] = first_digit.to_s
					array[array.length - 1] = 1.to_s
					a = array.join.to_i
					while a <= n
						array = a.to_s.split('')
						if (array.first.to_i == first_digit and array.last.to_i == j) or (array.first.to_i == j and array.last.to_i == first_digit)
							count += 2
						end
						a += 1
					end
				else
					first_digit = n.to_s.split('')[0].to_i
					(1..first_digit).each do |i|
						(1..first_digit).each do |j|
							if i < first_digit || j < first_digit
								count += (10 ** (digits_a - 2)) * (10 ** (digits_b - 2))
							elsif i == first_digit
								array = Array.new(digits_a) { '0' }
								array[0] = i.to_s
								array[array.length - 1] = j.to_s
								a = array.join.to_i
								while a <= n
									array = a.to_s.split('')
									if (array.first.to_i == i and array.last.to_i == j) or (array.first.to_i == j and array.last.to_i == i)
										count += 2
									end
									a += 1
								end
							end
						end
					end
				end
			end
		end
	end
	count
end

n = gets.chomp.to_i
puts handstand(n)
