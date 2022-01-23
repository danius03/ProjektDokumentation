import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Changelogger {

   public static void changeLog(){
      File file = new File("src/site/markdown/documentation");
      String[] directories = file.list(new FilenameFilter() {
         @Override
         public boolean accept(File current, String name) {
            return new File(current, name).isDirectory();
         }
      });

      try {
         BufferedWriter bw = new BufferedWriter(new FileWriter("src\\site\\markdown\\changelog.md"));
         bw.write("# Changelog");
         bw.newLine();
         bw.write("");
         bw.newLine();
         bw.write("---");
         bw.newLine();
         bw.write("---");
         bw.newLine();
         bw.newLine();
         bw.flush();
         List<Change> changes = new ArrayList<Change>();
         for (String directory: directories) {
               BufferedReader br = new BufferedReader(new FileReader("src\\site\\markdown\\documentation\\" + directory + "\\main\\resources\\Score.csv"));
               br.readLine();
               String line = br.readLine();
               while (line != null && line != "")
               {
                  if(Integer.parseInt(line.split(";")[2]) >= 50)
                  {
                     changes.add(new Change(Integer.parseInt(line.split(";")[2]), line.split(";")[0]));
                  }

                  line = br.readLine();
               }
         }
         Collections.sort(changes);
         for (Change c: changes) {
            bw.write("Seite: " + c.getFile() + "  => Wichtigkeit: " + c.getChangePriority());
            bw.newLine();
            bw.write("");
            bw.newLine();
            bw.flush();
         }
         bw.close();
      } catch (IOException e) {
         e.printStackTrace();
      }

   }
}
