package org.example.graph;

import java.util.*;

public class BFS
{
    public static<T> Optional<Node<T>> search(T value, Node<T> start)
    {
        System.out.println("##########################");
        System.out.println("\t\tBFS");
        System.out.println("##########################");

        Queue<NodePath<T>> queue = new ArrayDeque<>();

        NodePath<T> currentValue;
        Node<T> currentNode;
        Set<Node<T>> closed = new HashSet<>();

        queue.add(new NodePath<T>(start, new ArrayDeque<>()));

        //1 - Verificar si puede continuar
        while(!queue.isEmpty())
        {
            currentValue = queue.remove();
            currentNode = currentValue.getNode();
            System.out.println("Visitando el nodo " + currentNode.toString());
            printPath(currentValue.getPath(), currentNode.getValue());

            //2 - Verificar si se encuentra en la meta
            if(currentNode.getValue().equals(value))
            {
                System.out.println("##########################");
                System.out.println("Camino a la meta:");
                printPath(currentValue.getPath(), value);
                return Optional.of(currentNode);
            }
            else
            {
                //3 - Agregar al espacio explorado
                closed.add(currentNode);
                //4 - Nodos sucesores
                for (var item: currentNode.getNeighbors())
                {
                    var traveledNodes = currentValue.getPath();
                    traveledNodes.add(currentNode);
                    queue.add(new NodePath<T>(item, traveledNodes));
                }
                queue.removeIf(x -> closed.contains(x.getNode()));
            }
        }
        System.out.println("##########################");
        System.out.println("No se ha encontrado la meta");
        return Optional.empty();
    }

    private static<T> void printPath(Queue<Node<T>> nodes, T goal)
    {
        for (var item: nodes)
        {
            System.out.print(item.toString() + " -> ");
        }

        System.out.println(goal.toString());
    }
}