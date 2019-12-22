def function(n, s, t)
	s_array = s.split('')
	t_array = t.split('')
	string = ''
	0.upto(n - 1).each { |i|
		string << s_array[i] << t_array[i]
	}
	string
end

n = gets.chomp.to_i
s, t = gets.chomp.split(' ')
puts function(n, s, t)
