public class Change implements Comparable<Change> {
    private int changePriority;
    private String file;
    private String codeBlock;

    public Change(int changePriority, String file, String codeBlock) {
        this.changePriority = changePriority;
        this.file = file;
        this.codeBlock = codeBlock;
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

    public String getCodeBlock() {
        return codeBlock;
    }

    public void setCodeBlock(String codeBlock) {
        this.codeBlock = codeBlock;
    }

    @Override
    public int compareTo(Change o) {
        return o.changePriority - changePriority;
    }
}
