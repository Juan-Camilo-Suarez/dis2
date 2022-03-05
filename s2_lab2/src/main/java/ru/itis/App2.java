package ru.itis;

import ru.itis.Models.Certificant;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class App2 {
    public static void main(String[] args) throws IOException {

        String path = "/home/camilo/IdeaProjects/dis2/s2_lab2/src/main/java/ru/itis";
        generatekey("rootCA", path);
        generatecertroot(new Certificant("RU", "Tatarstan", "Kazan", "Itis", "itis", "itis", "juancamilos@gmail.com", "rootCA", "rootCA"), path);
        generatekey("suarez", path);
        generateceruser(new Certificant("RU", "Tatarstan", "Kazan", "Itis", "itis", "Camilo", "juancamilosuarez3@gmail.com", "suarezCA", "suarez"), path);
    }

    public static void generateceruser(Certificant cr, String path) throws IOException {
        String command = "openssl req -new -utf8 -key " + cr.getRootkey() + ".key" + " -out " + cr.getCertificateName() + ".csr" +
                " -subj " + "/C=" + cr.getCountryCode() + "/ST=" + cr.getState() + "/L=" + cr.getCity() + "/O=" + cr.getOrganization() +
                "/OU=" + cr.getOrganizationUnit() + "/CN=" + cr.getEmailAddress();
        List<String> commands = Arrays.asList(command.split(" "));
        System.out.println(command);
        ProcessBuilder pb = new ProcessBuilder(commands).directory(new File(path));
        pb.redirectErrorStream(true);
        Process process = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("tasklist:" + line);
        }

    }

    public static void generatecertroot(Certificant cr, String path) throws IOException {
        String command = "openssl req -x509 -utf8 -new -key " + cr.getRootkey() + ".key" + " -days 10000 -out " + cr.getCertificateName() + ".crt" + " -subj " +
                "/C=" + cr.getCountryCode() + "/ST=" + cr.getState() + "/L=" + cr.getCity() + "/O=" + cr.getOrganization() + "/OU=" + cr.getOrganizationUnit() + "/CN=" + cr.getEmailAddress();
        List<String> commands = Arrays.asList(command.split(" "));
        System.out.println(command);
        ProcessBuilder pb = new ProcessBuilder(commands).directory(new File(path));
        pb.redirectErrorStream(true);
        Process process = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("tasklist:" + line);
        }


    }

    public static void generatekey(String rootkey, String path) throws IOException {
        String command = "openssl genrsa -out " + rootkey + ".key 2048";
        List<String> commands = Arrays.asList(command.split(" "));
        ProcessBuilder pb = new ProcessBuilder(queuecommands(command)).directory(new File(path));
        pb.redirectErrorStream(true);
        Process process = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("tasklist:" + line);
        }
    }

    public static String[] queuecommands(String texto) {
        return texto.split(" ");
    }

}
