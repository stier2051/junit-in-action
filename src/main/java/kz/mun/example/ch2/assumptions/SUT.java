package kz.mun.example.ch2.assumptions;

public class SUT {
    private Job currentJob;

    public void run(Job currentJob) {
        this.currentJob = currentJob;
    }

    public boolean hasJobToRun() {
        return currentJob != null;
    }
}
