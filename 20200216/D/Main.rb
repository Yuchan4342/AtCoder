def function(n, k, a)
	a = a.sort
	negative = a.select { |c| c < 0 }
	neg_n = negative.length
	zero = a.select { |c| c.zero? }
	zero_n = zero.length
	positive = a.select { |c| c.positive? }
	pos_n = positive.length
	if k <= pos_n * neg_n
		# 異符号の組み合わせ
		array = []
		negative.each do |neg|
			positive.each do |pos|
				array.push(neg * pos)
			end
		end
		array = array.sort
		array[k - 1]
	elsif k <= pos_n * neg_n + zero_n * (pos_n + neg_n) + zero_n * (zero_n - 1) / 2
		# 0が含まれる組み合わせ
		0
	else
		# 同符号の組み合わせ
		array = []
		(0...negative.length).each do |i|
			(0...i).each do |j|
				array.push(negative[negative.length - i - 1] * negative[negative.length - j - 1])
			end
		end
		(0...positive.length).each do |i|
			(0...i).each do |j|
				array.push(positive[i] * positive[j])
			end
		end
		array = array.sort
		array[k - 1 - pos_n * neg_n - zero_n * (pos_n + neg_n) - zero_n * (zero_n - 1) / 2]
	end
end

n, k = gets.chomp.split.map(&:to_i)
a = gets.chomp.split.map(&:to_i)
puts function(n, k, a)
