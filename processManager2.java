import java.io.*;

public class processManager2 {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String command = "cmd /c date";
        Process p = null;

        try {
            p = r.exec(command);

            // Writing - sending input to date
            OutputStream os = p.getOutputStream();
            os.write("10-10-13".getBytes());
            os.flush();

            // Reading - getting output date
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader((is)));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        }  catch (IOException e) {
            e.printStackTrace();
        }

        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println(exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
