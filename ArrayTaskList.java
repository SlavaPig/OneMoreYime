package ua.edu.sumdu.j2se.sholokhdanil.tasks;

public class ArrayTaskList extends AbstractTaskList {

    private Task tasksList[] = new Task[10];


    //метод, що додає до списку вказану задачу
    @Override
    public void add(Task task)
    {

        Task[] newTaskList = new Task[tasksList.length + 1];

        newTaskList[0] = task;

        for (int i = 0; i < tasksList.length; i++)
        {
            newTaskList[i + 1] = tasksList[i];
        }

        tasksList = newTaskList;

    }


    //метод, що видаляє задачу зі списку і повертає істину, якщо
    //така задача була у списку. Якщо у списку було декілька таких задач, необхідно видалити одну
    //будь-яку
    @Override
    public boolean remove(Task task)
    {

        int numDelTask = -1;

        for (int i = 0; i < tasksList.length; i++)
        {
            if (tasksList[i].equals(task))
            {
                numDelTask = i;
                break;
            }
        }

        if (numDelTask != -1)
        {
            Task[] newTaskList = new Task[tasksList.length - 1];

            for (int i = 0; i < numDelTask; i++)
            {
                newTaskList[i] = tasksList[i];
            }

            for (int i = numDelTask + 1; i < tasksList.length; i++)
            {
                newTaskList[i - 1] = tasksList[i];
            }

            tasksList = newTaskList;
            return true;

        }else
            return false;

    }

    //метод, що повертає кількість задач у списку.
    public int size()
    {
        int counterTasks = 0;

        for (int i = 0; i < tasksList.length; i++)
        {
            if(tasksList[i] != null)
            {
                counterTasks++;
            }
        }

        return counterTasks;

    }

    //– метод, що повертає задачу, яка знаходиться на вказаному місці у
    //списку, перша задача має індекс 0.
    public Task getTask(int index)
    {
        if(index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        return tasksList[index];
    }


    public ArrayTaskList incoming(int from, int to)
    {
        ArrayTaskList newTaskList = new ArrayTaskList();

        for(int i = 0; i < newTaskList.size(); i++)
        {
            Task task = tasksList[i];
            int time = 0;

            if(task.isActive())
            {
                time = task.getStartTime();
            }

            if(time > from && time < to)
            {
                 newTaskList.add(task);
            }

        }

        return newTaskList;

    }


}
