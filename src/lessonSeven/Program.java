package lessonSeven;

public class Program {
    public static void main(String[] args) {
        Graph graph = new Graph(13);
        graph.addEdge(0, 6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(5, 0);
        graph.addEdge(4, 6);
        graph.addEdge(4, 3);

        graph.addEdge(7, 8);

        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);
        System.out.println("Количество вершин: " + graph.vertexCount());
        System.out.println("Количество ребер: " + graph.edgeCount());

//        graph.addEdge(0, 2);
//        graph.addEdge(0, 1);
//        graph.addEdge(1, 2);
//        graph.addEdge(3, 5);
//        graph.addEdge(3, 4);
//        graph.addEdge(3, 2);
//        graph.addEdge(4, 2);
//        graph.addEdge(5, 0);

        //System.out.println(graph.adjList(5));

        /*DepthFirstPaths dfs = new DepthFirstPaths(graph, 0);
        System.out.println(dfs.hasPathTo(5));
        if (dfs.hasPathTo(5)) {
            System.out.println(dfs.pathTo(5));
        }
        System.out.println(dfs.hasPathTo(9));*/

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
        System.out.println(bfs.hasPathTo(3));
        if (bfs.hasPathTo(3)) {
            System.out.println(bfs.pathTo(3));
            System.out.println(bfs.distTo(3));
        }

        searchTest();
    }

    public static void searchTest() {
        Graph graph = new Graph(10);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 6);
        graph.addEdge(1, 7);
        graph.addEdge(2, 3);
        graph.addEdge(2, 8);
        graph.addEdge(2, 9);
        graph.addEdge(4, 5);
        graph.addEdge(4, 8);
        graph.addEdge(5, 6);
        graph.addEdge(7, 8);
        graph.addEdge(7, 9);
        System.out.println("Смежные вершины с вершиной 1: " + graph.adjList(1));
        System.out.println("Количество вершин: " + graph.vertexCount());
        System.out.println("Количество ребер: " + graph.edgeCount());

        System.out.println("-------------");


        /**
         * Поиск в ширину
         */
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 2);
        System.out.println("Имеется ли связь между 2 и 4: " + bfs.hasPathTo(4));
        if (bfs.hasPathTo(4)) {
            System.out.println("Путь поиска в ширину с вершины 2 до 4: " + bfs.pathTo(4));
            System.out.println("Расстояние кратчайшего пути: " + bfs.distTo(4));
        }

        System.out.println("---------------");

        /**
         * Поиск в глубину
         */
        DepthFirstPaths dfs = new DepthFirstPaths(graph, 0);
        System.out.println("Имеется ли связь между 0 и 9: " + dfs.hasPathTo(9));
        if (dfs.hasPathTo(5)) {
            System.out.println("Поиск в глубину: " + dfs.pathTo(9));
        }
    }
}
