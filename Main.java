package ua.edu.sumdu.j2se.sholokhdanil.tasks;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		TaskListFactory taskListFactory = new TaskListFactory();

		taskListFactory.createTaskList(ListTypes.types.ARRAY);

		System.out.println(taskListFactory.createTaskList(ListTypes.types.ARRAY));
		System.out.println(taskListFactory.createTaskList(ListTypes.types.LINKED));

		System.out.println(taskListFactory.createTaskList(ListTypes.types.ARRAY));
		System.out.println(taskListFactory.createTaskList(ListTypes.types.LINKED));


	}



	public static void testLinked()
	{
		Task task0 = new Task("name", 1);
		Task task1 = new Task("name", 2);
		Task task2 = new Task("name", 3);
		Task task3 = new Task("name", 4);
		Task task4 = new Task("name", 5);
		Task task5 = new Task("name", 6);
		Task task6 = new Task("name", 7);
		LinkedTaskList list = new LinkedTaskList();

		System.out.println(list.size() + " --------");
		list.add(task0);
		System.out.println(list.size() + "add 0 --------");
		list.add(task1);
		System.out.println(list.size() + "add 1 --------");
		list.add(task2);
		System.out.println(list.size() + "add 2 --------");
		list.add(task3);
		System.out.println(list.size() + "add 3 --------");
		list.add(task4);
		System.out.println(list.size() + "add 4 --------");
		list.add(task5);
		System.out.println(list.size() + "add 5 --------");
		list.add(task6);
		System.out.println(list.size() + "add 6 --------");

		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.getTask(i) + " " + i);
		}

		System.out.println();
		System.out.println();



		System.out.println(list.size() + " --------");
		list.remove(task0);
		System.out.println(list.size() + "delete 0 --------");
		list.remove(task1);
		System.out.println(list.size() + "delete 1 --------");
		list.remove(task4);
		System.out.println(list.size() + "delete 4 --------");
		list.remove(task5);
		System.out.println(list.size() + "delete 5 --------");
		list.remove(task6);
		System.out.println(list.size() + "delete 6 --------");
		list.add(task2);
		System.out.println(list.size() + "add 2 --------");


		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.getTask(i) + " " + i);
		}


	}

	public static void testArray()
	{
		Task task = new Task("name", 2);
		Task task1 = new Task("name", 1);
		Task task2 = new Task("name", 3);
		Task task3 = new Task("name", 4);
		Task task4 = new Task("name", 5);
		Task task5 = new Task("name", 6);
		Task task6 = new Task("name", 7);
		ArrayTaskList list = new ArrayTaskList();


		list.add(task);
		list.add(task1);
		list.add(task2);
		list.add(task3);
		list.add(task4);
		list.add(task5);
		list.add(task6);

		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.getTask(i));
		}

		System.out.println(list.size());

		list.remove(task);

		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.getTask(i));
		}
	}

}
