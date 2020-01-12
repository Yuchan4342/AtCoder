def count_ac_wa(n, p, s)
	acs = []
	was = []
	(0...n).each do
		acs.push(false)
		was.push(0)
	end
	p.each_with_index do |pi, index|
		if s[index] == "AC"
			acs[pi - 1] = true
		end
		if s[index] == "WA" and !acs[pi - 1]
			was[pi - 1] += 1
		end
	end
	ac_count = acs.count(true)
	wa_count = 0
	(0...n).each do |i|
		if acs[i]
			wa_count += was[i]
		end
	end
	[ac_count, wa_count].join(' ')
end

n, m = gets.chomp.split(' ').map(&:to_i)
p = []
s = []
(0...m).each do
	pi, si = gets.chomp.split(' ')
	p.push(pi.to_i)
	s.push(si)
end
puts count_ac_wa(n, p, s)
