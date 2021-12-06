package ua.edu.sumdu.j2se.sholokhdanil.tasks;



public class Task {

    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean tusk_active;
    private boolean repeat;



    //неактивну задачу, яка виконується у заданий час без повторення із заданою назвою
    public Task(String title, int time)
    {
        if(time < 0)
        {
            throw new IllegalArgumentException("time < 0");
        }
        this.title = title;
        this.time = time;
        tusk_active = false;
        repeat = false;
    }

    //неактивну задачу, яка виконується у заданому проміжку часу (і початок і кінець включно) із
    //заданим інтервалом і має задану назву
    public Task(String title, int start, int end, int interval)
    {
        if(start < 0 || end <= 0 || interval < 0)
        {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        tusk_active = false;
        repeat = true;

    }

    // Методи для зчитування та встановлення назви задачі
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    //Методи для зчитування та встановлення стану задачі
    public boolean isActive()
    {
        return tusk_active;
    }

    public void setActive(boolean tusk_active)
    {
        this.tusk_active = tusk_active;
    }

    //  якщо задача повторюється метод має повертати час початку
    //повторення
    public int getTime()
    {
        if(time < 0)
        {
            throw new IllegalArgumentException("time < 0");
        }
        if (repeat)
        {
            return start;
        }

        return time;
    }

    //якщо задача повторювалась, вона має стати такою,
    //що не повторюється
    public void setTime(int time)
    {
        if(time < 0)
        {
            throw new IllegalArgumentException("time < 0");
        }
        if (repeat)
        {
            repeat = false;
        }

        this.time = time;
    }

    //якщо задача не повторюється метод має повертати час
    //виконання задачі
    public int getStartTime()
    {
        if(start < 0)
        {
            throw new IllegalArgumentException("time < 0");
        }
        if (repeat)
        {
            return start;
        }

        return time;
    }

    //якщо задача не повторюється метод має повертати час
    //виконання задачі
    public int getEndTime()
    {
        if (repeat)
        {
            return end;
        }
        return time;
    }

    //якщо задача не повторюється метод має
    //повертати 0
    public int getRepeatInterval()
    {
        if (repeat)
        {
            return interval;
        }

        return 0;
    }

    //якщо задача не
    //повторювалася метод має стати такою, що повторюється
   public void setTime(int start, int end, int interval)
    {
        if(start < 0 || end <= 0 || interval <= 0)
        {
            throw new IllegalArgumentException();
        }

        if (!repeat)
        {
            repeat = true;
        }

        this.start = start;
        this.interval = interval;
        this.end = end;
    }

    //Метод для перевірки повторюваності задач
    public boolean isRepeated()
    {
        return repeat;
    }


    public int nextTimeAfter(int current)
    {
        int startTime = getStartTime();
        int endTime = getEndTime();
        int intervalTime = getRepeatInterval();

        if (isActive())
        {
            if(!isRepeated())
            {
                if(current < startTime)
                {
                    return startTime;
                }
                else
                {
                    return -1;

                }
            }


            if (isRepeated())
            {
                if(current < startTime)
                {
                return startTime;
                }
                else if(current < endTime)
                {
                    int intervalTimes;
                    intervalTimes = (endTime - startTime) / intervalTime;

                    int nextTusk = startTime;

                    for (int i = 0; i < intervalTimes; i++) {

                        nextTusk = nextTusk + intervalTime;
                        if(nextTusk > current)
                        {
                            return nextTusk;
                        }

                    }
                }
            }

        }

        return -1;
    }
}
