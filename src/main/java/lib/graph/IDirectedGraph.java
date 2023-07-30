package lib.graph;

public interface IDirectedGraph<V, E> {
    // vertices are named from 0..n-1
    int getVertexCount();
    int getEdgeCount();
    V getVertexData(int u);
    E getEdgeData(int u, int v);
}
