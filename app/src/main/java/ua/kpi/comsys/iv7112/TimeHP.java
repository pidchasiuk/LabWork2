package ua.kpi.comsys.iv7112;

import java.sql.Time;

public class TimeHP {
    private int hours, minutes, seconds;

    public TimeHP(){
        hours = minutes = seconds = 0;
    }

    public TimeHP(int hours, int minutes, int seconds) throws Exception {
        if(hours < 0 || hours > 23) throw new Exception("Incorrect hours");
        if(minutes < 0 || minutes > 59) throw new Exception("Incorrect minutes");
        if(seconds < 0 || seconds > 59) throw new Exception("Incorrect seconds");

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public TimeHP(Time time){
        this.hours = time.getHours();
        this.minutes = time.getMinutes();
        this.seconds = time.getSeconds();
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        return (((hours > 12 ) ? hours - 12 : hours) + ":" + minutes + ":" + seconds + " " + ((hours > 12 ) ? "PM" : "AM"));
    }

    public TimeHP sum (TimeHP timeHP) throws Exception {
        Time date1 = new Time(this.hours, this.minutes, this.seconds);
        Time date2 = new Time(timeHP.getHours(), timeHP.getMinutes(), timeHP.getSeconds());

        long sum = (date1.getTime() + date2.getTime() + 10800000);
        Time sumDate = new Time(sum);

        return new TimeHP(sumDate.getHours(),
                sumDate.getMinutes(),
                sumDate.getSeconds());
    }

    public TimeHP diff (TimeHP timeHP) throws Exception {
        Time date1 = new Time(this.hours, this.minutes, this.seconds);
        Time date2 = new Time(timeHP.getHours(), timeHP.getMinutes(), timeHP.getSeconds());

        long sum = (date1.getTime() - date2.getTime() - 10800000);
        Time sumDate = new Time(sum);

        return new TimeHP(sumDate.getHours(),
                sumDate.getMinutes(),
                sumDate.getSeconds());
    }

    public static TimeHP sum (TimeHP time1, TimeHP time2) throws Exception {
        Time date1 = new Time(time1.hours, time1.minutes, time1.seconds);
        Time date2 = new Time(time2.hours, time2.minutes, time2.seconds);

        long sum = (date1.getTime() + date2.getTime() + 10800000);
        Time sumDate = new Time(sum);

        return new TimeHP(sumDate.getHours(),
                sumDate.getMinutes(),
                sumDate.getSeconds());
    }

    public static TimeHP diff (TimeHP time1, TimeHP time2) throws Exception {
        Time date1 = new Time(time1.hours, time1.minutes, time1.seconds);
        Time date2 = new Time(time2.hours, time2.minutes, time2.seconds);

        long sum = (date1.getTime() - date2.getTime() - 10800000);
        Time sumDate = new Time(sum);

        return new TimeHP(sumDate.getHours(),
                sumDate.getMinutes(),
                sumDate.getSeconds());
    }
}

