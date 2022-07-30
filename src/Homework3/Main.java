package Homework3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void createFile(String fileName, StringBuilder logger, boolean dir)
    {
        File file = new File(fileName);
        if (dir)
        {
            if (file.mkdir())
            {
                logger.append("Создана папка " + fileName + "\n");
            }
            else
            {
                logger.append("Папка " + fileName + " уже существует\n");
            }
        }
        else {
            try {
                file.createNewFile();
                logger.append("Файл " + fileName + " успешно создан\n");
            } catch (IOException e)
            {
                logger.append("Ошибка при создании файла " + fileName + "\n");
            }
        }
    }




    public static void main(String[] args) {

        StringBuilder logger = new StringBuilder();

        String path = "D:\\Games";
        String[] directory = {"src", "res", "savegames", "temp"};
        for (String folderName : directory) {
            createFile(path + "\\" + folderName, logger, true);
        }
        createFile(path + "\\src\\main", logger, true);
        createFile(path + "\\src\\test", logger, true);

        String[] directory2 = {"drawables", "vectors", "icons"};
        for (String folderName : directory2){
            createFile(path + "\\" + folderName,logger,true);
        }

        createFile(path + "\\src\\main\\Main.java",logger,false);
        createFile(path + "\\src\\main\\Utils.java",logger,false);
        createFile(path + "\\temp\\temp.txt",logger,false);
        try {
            FileWriter writer = new FileWriter(path + "\\temp\\temp.txt");
            writer.write(logger.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path2 = "D:\\Games\\savegames\\save";
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(path2 + "s.zip"));
            GameProgress[] arrayGameProgress = new GameProgress[3];
            arrayGameProgress[0] = new GameProgress(100,15,70,35);
            arrayGameProgress[1] = new GameProgress(99,16,56,34);
            arrayGameProgress[2] = new GameProgress(98, 17, 99, 3);
            int saveIndex = 1;

            for (GameProgress g : arrayGameProgress) {

                FileOutputStream fileOutputStream = new FileOutputStream(path2 + saveIndex++);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(g);
                objectOutputStream.close();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.delete(Paths.get("D:\\Games\\savegames\\save1"));
            Files.delete(Paths.get("D:\\Games\\savegames\\save2"));
            Files.delete(Paths.get("D:\\Games\\savegames\\save3"));
        } catch (Exception e){
            System.out.println("Файл не удален");
        }



    }
}
