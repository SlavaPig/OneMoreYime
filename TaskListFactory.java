package ua.edu.sumdu.j2se.sholokhdanil.tasks;

public class TaskListFactory {

    public AbstractTaskList createTaskList(ListTypes.types type)
    {

        ArrayTaskList arrayTaskList = new ArrayTaskList();
        LinkedTaskList linkedTaskList = new LinkedTaskList();


        if(type == null)
        {
            throw new NullPointerException("type == null");
        }

        if (type.equals(ListTypes.types.ARRAY))
        {
            return arrayTaskList;
        }else {
            return linkedTaskList;
        }
    }


}
