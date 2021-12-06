package ua.edu.sumdu.j2se.sholokhdanil.tasks;

public class LinkedTaskList extends AbstractTaskList {

    private Node head;
    private int size_int;

    private static class Node{
        public Task data;
        public Node next;

        public Node(Task data)
        {
            this.data = data;
            next = null;
        }

    }

    //метод, що додає до списку вказану задачу
    @Override
    public void add(Task data)
    {

        if(data == null)
        {
            throw new NullPointerException("Добавление элемента null в список");
        }

        Node newNode = new Node(data);
        Node currentNode = head;

        if(head == null)
        {
            head = newNode;


        }else{
            while(currentNode.next != null)
            {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }
        size_int++;

    }


    //метод, що видаляє задачу зі списку і повертає істину, якщо
    //така задача була у списку. Якщо у списку було декілька таких задач, необхідно видалити одну
    //будь-яку
    public boolean remove(Task data)
    {
        int counteDelete = 0;
        Node  currentNode = head;
        Node previousNode = null;


        while(currentNode != null)
        {
            if(currentNode.data.equals(data))
            {
                counteDelete++;
                if(currentNode == head)
                {
                    head = currentNode.next;
                }else {
                    previousNode.next = currentNode.next;
                }
            }


            previousNode = currentNode;
            currentNode = currentNode.next;

        }

        if (counteDelete>0)
        {
            size_int--;
            return true;
        }else {
            return false;
        }

    }

    //метод, що повертає кількість задач у списку.
    public int size()
    {
        return size_int;
    }

    //– метод, що повертає задачу, яка знаходиться на вказаному місці у
    //списку, перша задача має індекс 0.
    public Task getTask(int index)
    {
        Node currentNode = head;

        if(index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < index; i++)
        {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }


    public LinkedTaskList incoming(int from, int to)
    {
        LinkedTaskList newsTaskList = new LinkedTaskList();
        Node currentNode = head;


        for(int i = 0; i < newsTaskList.size(); i++)
        {
            Task task = currentNode.data;
            int time = 0;

            if(task.isActive())
            {
                time = task.getStartTime();
            }

            if(time > from && time < to)
            {
                newsTaskList.add(task);
            }
        }

        return newsTaskList;



        /*

        for(int i = 0; i < newsTaskList.size(); i++)
        {
            Task task = tasksList[i];
            int time = 0;

            if(task.isActive())
            {
                time = task.getStartTime();
            }

            if(time > from && time < to)
            {
                newsTaskList.add(task);
            }

        }*/

    }


}
