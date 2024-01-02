#include <bits/stdc++.h>

using namespace std;

int visited[8]; // nodes = 7
vector<vector<int>> v1(8); // nodes = 7

bool dfs(int root, int parent) {
    visited[root] = 1;

    for (auto adjacent_node : v1[root]) {
        if (visited[adjacent_node] == 0) {
            if (dfs(adjacent_node, root)) {
                return true;
            }
        } 
		else if (adjacent_node != parent) {
            return true;
        }
    }

    return false;
}

int main() {
    int nodes = 7;

    for (int i = 0; i < nodes; i++) {
        int node_number;
        cin >> node_number;

        int adjacency_nodes;
        cin >> adjacency_nodes;

        while (adjacency_nodes--) {
            int adjacency_node_number;
            cin >> adjacency_node_number;
            v1[node_number].push_back(adjacency_node_number);
        }
    }

    int root = 1;
    int parent = -1;

    if (dfs(root, parent)) {
        cout << "Cycle Found!" << endl;
    } else {
        cout << "No Cycle Found!" << endl;
    }

    return 0;
}
