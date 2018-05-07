package ru.skilanov.parsers;

import org.xml.sax.InputSource;
import ru.skilanov.database.ItemDaoImpl;
import ru.skilanov.model.Item;
import ru.skilanov.model.ItemList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Класс парсинга xml, реализующий интерфейс XmlParser.
 */
public class ParseToXml implements XmlParser {

    private static final String INPUT_FILE = "1.xml";
    private static final String OUTPUT_FILE = "2.xml";

    /**
     * Преобразование объекта в xml.
     */
    @Override
    public void marshall() {
        ItemDaoImpl itemDaoImpl = new ItemDaoImpl();
        ItemList tests = new ItemList();

        try {
            FileOutputStream file = new FileOutputStream(INPUT_FILE);
            JAXBContext jaxbContext = JAXBContext.newInstance(ItemList.class, Item.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            List<Item> itemList = itemDaoImpl.getAll();

            for (Item item : itemList) {
                tests.add(item);
            }

            marshaller.marshal(tests, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * xml  в объект.
     */
    @Override
    public void unMarshall() {
        InputSource file = new InputSource(OUTPUT_FILE);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ItemList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
