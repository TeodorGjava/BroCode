package thinking.files;

public class SearchFiles extends Thread {
    final SynchronizedRunner runner;

    public SearchFiles(SynchronizedRunner runner) {
        this.runner = runner;
    }

    @Override
    public void run() {
        synchronized (runner) {
            runner.run();
        }
    }
}
