package mate.academy;

import mate.academy.dao.LiteraryDaoImpl;
import mate.academy.dao.LiteraryFormatDao;
import mate.academy.literaryformate.LiteraryFormat;
import java.util.List;


public class  Main {
    public static void main(String[] args) {
        LiteraryFormat format = new LiteraryFormat();
        format.setTitle("proza");
        LiteraryFormatDao literaryFormatDao = new LiteraryDaoImpl();
        /*LiteraryFormat savedFormate = literaryFormatDao.create(format);*/
        /*System.out.println(savedFormate);*/

    /*    System.out.println(literaryFormatDao.deleted(savedFormate.getId()));*/

        literaryFormatDao.getAll().forEach(System.out::println);
    }
}

