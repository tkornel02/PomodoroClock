package timer;

public class Time {
    private int sec;

    public Time(int h, int m, int s)  {
        if (h > 23) h = 23;
        if (m > 59) m = 59;
        if (s > 59) s = 59;
        sec = 3600*h + 60*m + s;
    }

    public void addSec(int secCount){
        sec+=secCount;
    }
    public void subSec(int secCount){
        if (sec-secCount < 0) sec = 0;
        else sec-=secCount;

    }
    public int getSec() {
        return sec-getHour()*3600-getMin()*60;
    }
    public int getAllSec(){
        return sec;
    }
    public int getHour() {
        return sec/3600;
    }
    public int getMin(){
        return (sec%3600)/60;
    }

    public void setTime(Time t){
        sec = t.sec;
    }

    @Override
    public String toString() {
        return String.format("%2s:%2s:%2s", getHour(),getMin(),getSec()).replace(' ','0');
    }
}
