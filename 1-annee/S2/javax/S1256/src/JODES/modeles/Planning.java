package JODES.modeles;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import JODES.JO2024;

public class Planning {

    protected int numSemaine;
    protected List<List<Session>> sessions = new ArrayList<List<Session>>();
    protected ArrayList<LocalDate> days = new ArrayList<>();
    protected int year;
    protected int month;
    protected int day;

    // ----------- Constructors -----------

    public Planning(LocalDate date) {
        this.numSemaine = getNumSemaineFromDate(date);
        this.year = date.getYear();
        this.month = date.getMonthValue();
        this.day = date.getDayOfMonth();
        initializeDaysOfWeek();
    }

    // ----------- Getters & setters -----------
    
    
    public int getNumSemaineFromDate(LocalDate d) {
        // from StackOverflow
        return d.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
    }

    public int getNumSemaine() {
        return numSemaine;
    }

    public List<List<Session>> getSessions() {
        return sessions;
    }

    public ArrayList<LocalDate> getDays() {
        return days;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    // ----------- Methods -----------

    public void getSessionsFromDataBase(int numSemaine) {
        for (Entite e : JO2024.sesEntites)
        {
            if (DataParser.isSession(e))
            {
                Session s = (Session) e;
                int numSemaineSession = getNumSemaineFromDate(s.getDate());
                if (numSemaineSession == this.numSemaine)
                {
                    this.sessions.get(0).add(s);
                }
            }
        }
    }

    public void initializeDaysOfWeek() {
        WeekFields week = WeekFields.of(Locale.FRANCE);
        for (int i=0; i<7; i++)
        {
            LocalDate date = LocalDate.of(year, month, day)
            .with(week.weekOfYear(), numSemaine)
            .with(week.dayOfWeek(), i);
            this.days.add(date);
        }
    }

}
