
#include <bits/stdc++.h>

using namespace std;

int main() {
	

	int nodes;
	cin >> nodes;

	vector< vector<int> > v1(nodes+1);

	for(int i = 0; i < nodes; i++) {
		int node_number;
		cin >> node_number;

		int adjacency_nodes;
		cin >> adjacency_nodes;

		while (adjacency_nodes--)
		{
			int adjacency_node_number;
			cin >> adjacency_node_number;
			v1[node_number].push_back(adjacency_node_number);
		}
	}

	queue<int> q;

	int visited[nodes + 1];
	memset(visited ,0, sizeof(visited));
	int parent[nodes + 1]; 
	parent[1] = -1;

	visited[1] = 1;

	q.push(1);

	int flag = 0;

	while (!q.empty())
	{
		int temp = q.front();
		q.pop();

		for (auto adjacent_node : v1[temp]) {

			if (visited[adjacent_node] == 0) {
				visited[adjacent_node] = 1;
				parent[adjacent_node] = temp;
				q.push(adjacent_node);
			}

			else if (visited[adjacent_node] == 1 && parent[temp] != adjacent_node) {
				cout << "Cycle Found!" << endl;
				exit(0);
			}
		}
	}
	
	cout << "No Cycle Found!" << endl;

	return 0;
}



