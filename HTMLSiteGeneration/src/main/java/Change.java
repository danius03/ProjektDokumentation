public class Change implements Comparable<Change> {
    private int changePriority;
    private String file;

    public Change(int changePriority, String file) {
        this.changePriority = changePriority;
        this.file = file;
    }

    public int getChangePriority() {
        return changePriority;
    }

    public void setChangePriority(int changePriority) {
        this.changePriority = changePriority;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public int compareTo(Change o) {
        return o.changePriority - changePriority;
    }
}
