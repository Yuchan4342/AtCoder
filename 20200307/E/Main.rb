def function(n, p, s)
  count = 0
  0.upto(n - 1) do |i|
    i.upto(n - 1) do |j|
      count += 1 if s[i..j].to_i % p == 0
    end
  end
  count
end

n, p = gets.chomp.split.map(&:to_i)
s = gets.chomp
puts function(n, p, s)
