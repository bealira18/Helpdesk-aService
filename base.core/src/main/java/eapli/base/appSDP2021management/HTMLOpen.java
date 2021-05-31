package eapli.base.appSDP2021management;

import java.io.*;

public class HTMLOpen {

    public void abrirHTML() {

        try {
            File help = new File("www/index.html");

            if (!help.canRead())
                throw new FileNotFoundException("Help não encontrado!");

            String caminhoAExecutar = help.getAbsolutePath();

            Runtime run = Runtime.getRuntime();

            String[] cmd = new String[3];
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
            cmd[2] = caminhoAExecutar;

            try {
                run.exec(cmd);
            } catch (IOException notWinXpOr2000) {
                cmd[0] = "command.exe";
                try {
                    run.exec(cmd);
                } catch (IOException notWinAtAll) {
                    run.exec(cmd[2]);
                    System.out.println("Trying Linux... Did it work? Hope so...");
                }
            }
        } catch (IOException ioe) {
            System.err.println("Esquece, nao rolou!");

        }
    }
}
