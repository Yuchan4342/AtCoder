# グラフ
# ref: http://unageanu.hatenablog.com/entry/20110819/1313721280
class Graph
	def initialize
		@serial = 0
		@vertices = []
	end

	def connect(from, to)
		assert_vertex_exist from
		assert_vertex_exist to
		@vertices[from].connect(to)
		@vertices[to].connect(from)
	end

	def add_vertex(data)
		id = @serial
		@serial += 1
		@vertices[id] = Vertex.new(id, data)
		return id
	end

	def inspect
		return "---\n" + vertices.collect {|v| v.inspect }.join("\n")
	end

	attr_reader :vertices

private
	def assert_vertex_exist( id )
		if ( id < 0 || id >= @vertices.length || !@vertices[id] )
			raise "vertex not exist. id=#{id}"
		end
	end
end

# 頂点
class Vertex
	def initialize( id, data )
		@id = id
		@data = data
		@edges = []
	end

	def connect(to)
		@edges.push({
		  :to=> to,
		})
	end

	def inspect
		return "#{@id}:#{@data.inspect}\n" + @edges.collect{ |e|
			"  -> #{e[:to]}"
		}.join("\n")
	end
	attr_reader :id, :data, :edges
end

def distances_from_aoki(graph, aoki_now)
	distances = graph.vertices.map { |vertice| -1 }
	distances[aoki_now] = 0
	graph.vertices[aoki_now].edges.each do |edge|
		distances[edge[:to]] = distances[aoki_now] + 1
	end
end

def game(n, u, v, graph)
	takahashi_now = u - 1
	aoki_now = v - 1
	move_time = 0
	while (true)
		graph.vertices[takahashi_now].edges.each do |edge|
			puts edge[:to]
		end
		graph.vertices[aoki_now].edges.each do |edge|
			puts edge[:to]
		end
		return move_time
	end
end

n, u, v = gets.chomp.split(' ').map(&:to_i)
graph = Graph.new
ids = []
n.times do |i|
	ids << graph.add_vertex(i)
end
(n - 1).times.map do |i|
	a, b = gets.chomp.split(' ').map(&:to_i)
	puts [ids[a - 1], ids[b - 1]].join(',')
	graph.connect(ids[a - 1], ids[b - 1])
end
puts game(n, u, v, graph)
