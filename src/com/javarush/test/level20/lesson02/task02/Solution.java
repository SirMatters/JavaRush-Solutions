package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println("111");
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("sav", ".txt", new File("C:\\Users\\K.Perov\\Desktop\\JAVA\\"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setBirthDate(dateFormat.parse("05.05.2005"));
            user1.setCountry(User.Country.RUSSIA);
            user1.setFirstName("Suka");
            user1.setLastName("Bluat");
            user1.setMale(true);

            User user2 = new User();
            user2.setBirthDate(dateFormat.parse("06.06.2006"));
            user2.setCountry(User.Country.OTHER);
            user2.setFirstName("Baba");
            user2.setLastName(null);
            user2.setMale(false);


            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.save(outputStream);
            outputStream.flush();

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e);
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<User>();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (User user : users) {
                printWriter.println("separate");
                printWriter.println((user.isMale()) ? "male" : "female");
                printWriter.println((user.getFirstName() == null) ? "no_f_name" : user.getFirstName());
                printWriter.println((user.getLastName() == null) ? "no_l_name" : user.getLastName());
                printWriter.println(dateFormat.format(user.getBirthDate()));
                printWriter.println((user.getCountry() == null) ? "no_c" : user.getCountry().toString());
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            while (r.ready()) {
                String s = r.readLine();
                if(s.equals("separate")) {
                    User u = new User();
                    u.setMale(r.readLine().equals("male"));
                    u.setFirstName((s = r.readLine()).equals("no_f_name") ? null : s);
                    u.setLastName((s = r.readLine()).equals("no_l_name") ? null : s);
                    u.setBirthDate(dateFormat.parse(r.readLine()));
                    u.setCountry(User.Country.valueOf(r.readLine()));
                    users.add(u);
                }
            }
            r.close();
        }
    }
}
