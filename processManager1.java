import java.io.*;

public class processManager1 {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String command = "cmd /c dir";
        Process p = null;

        try {
            p = r.exec(command);
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = br.readLine())!= null)
                System.out.println(line);

            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Error check --> 0 no error / 1 error
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Value: "+exitVal);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        try {
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader((er)));
            String liner;

            while ((liner = brer.readLine())!= null)
                System.out.println("Error --> " + liner);

            brer.close();
        }catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
