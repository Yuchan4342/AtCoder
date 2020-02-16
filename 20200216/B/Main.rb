def function(n, a)
	a.each do |c|
		if (c % 2).zero? && !(c % 3).zero? && !(c % 5).zero?
			return 'DENIED'
		end
	end
	'APPROVED'
end

n = gets.chomp.to_i
a = gets.chomp.split.map(&:to_i)
puts function(n, a)
