def function(x, y, a, b, c, p_v, q_v, r)
    p_v.sort! { |x_i, y_i| y_i <=> x_i }
    q_v.sort! { |x_i, y_i| y_i <=> x_i }
    r.sort! { |x_i, y_i| y_i <=> x_i }
    p_v = p_v[0...x]
    q_v = q_v[0...y]
    p_num = x
    q_num = y
    r_index = 0
    while r_index < c do
        break if r[r_index] <= p_v[p_num - 1] && r[r_index] <= q_v[q_num - 1]
        break if r[r_index] <= p_v[p_num - 1] && q_num <= 1
        break if p_num <= 1 && r[r_index] <= q_v[q_num - 1]

        if (r[r_index] - p_v[p_num - 1]) >= (r[r_index] - q_v[q_num - 1])
            p_num -= 1
        else
            q_num -= 1
        end
        r_index += 1
    end
    result = p_num > 0 ? p_v[0...p_num].inject(&:+) : 0
    result += q_num > 0 ? q_v[0...q_num].inject(&:+) : 0
    result += r_index > 0 ? r[0...r_index].inject(&:+) : 0
    result
end

x, y, a, b, c = gets.chomp.split.map(&:to_i)
p = gets.chomp.split.map(&:to_i)
q = gets.chomp.split.map(&:to_i)
r = gets.chomp.split.map(&:to_i)
puts function(x, y, a, b, c, p, q, r)
