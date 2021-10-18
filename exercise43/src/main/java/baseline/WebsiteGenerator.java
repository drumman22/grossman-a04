/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class WebsiteGenerator {
    private String siteName;
    private String author;
    private boolean JSFolder;
    private boolean CSSFolder;

    public void createDirectory(File path) {
        createFolder(path);
        if (JSFolder)
            createFolder(new File(path + "/js"));
        if (CSSFolder)
            createFolder(new File (path + "/css"));
    }

    public void createFolder(File path) {
        // attempt to create new directory
        if (!path.mkdir()) {
            System.out.println("An error has occurred.");
            System.exit(1);
        }
    }

    public void formatHtmlTemplate(File dir, File template) throws IOException {
        File newDir = new File(dir + "/" + template.getName());
        copyFile(template, newDir);

        String line = "";
        String oldtext = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(newDir))) {
            while ((line = reader.readLine()) != null) {
                oldtext += line + "\r\n";
            }
        }

        String replacedtext  = oldtext.replaceAll("\\$title", this.siteName);
        replacedtext = replacedtext.replaceAll("\\$author", this.author);

        try (FileWriter writer = new FileWriter(newDir)) {
            writer.write(replacedtext);
        }
    }

    public void copyFile(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isJSFolder() {
        return JSFolder;
    }

    public void setJSFolder(boolean JSFolder) {
        this.JSFolder = JSFolder;
    }

    public boolean isCSSFolder() {
        return CSSFolder;
    }

    public void setCSSFolder(boolean CSSFolder) {
        this.CSSFolder = CSSFolder;
    }
}
