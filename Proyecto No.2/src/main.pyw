import networkx as nx
import matplotlib.pyplot as plt
import matplotlib.animation as animation
import sys
import random
import time

G = nx.Graph()
# G.add_node(1) # Agrega un nodo
# G.add_edge(1,2) # Agrega una arista, de 1 a 2(comienzo a fin)
# G.number_of_edges() # Cantidad de aristas
# G.number_of_nodes() # Cantidad de nodos
# nx.degree(G) # Devuelve el grado de cada nodo

# otro grafica
# H = nx.complete_graph(10)
# nx.draw(H, with_labels=True)
G.add_nodes_from(range(1, 11))
G.add_edges_from([(1, 2), (1, 3), (1, 6), (1, 7), (1, 8), (1, 9), (1, 10), (2, 3), (2, 4), (2, 5), (2, 6), (2, 7), (2, 8), (2, 9), (2, 10), (3, 4), (3, 5), (3, 6), (3, 7), (3, 8), (3, 9), (3, 10), (4, 5), (4, 6), (4, 7), (4, 8), (4, 9), (4, 10), (5, 6), (5, 7), (5, 8), (5, 9), (5, 10), (6, 7), (6, 8), (6, 9), (6, 10), (7, 8), (7, 9), (7, 10), (8, 9), (8, 10), (9, 10)])
# nx.draw(G, with_labels=True) #Para colocar el nombre de los nodos
pos = nx.spring_layout(G)

fig = plt.figure()
ax = fig.add_subplot(111)

nx.draw_networkx_nodes(G, pos, ax=ax, node_color='blue', node_size=100)
nx.draw_networkx_edges(G, pos, ax=ax, edge_color='black', width=1)
nx.draw_networkx_labels(G, pos, ax=ax, font_size=12, font_family='sans-serif')
plt.show()