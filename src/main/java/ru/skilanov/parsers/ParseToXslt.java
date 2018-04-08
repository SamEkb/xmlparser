package ru.skilanov.parsers;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Класс реализация интерфейса XsltParser, служит для изменения одного xml документа в другой при помощи xslt.
 */
public class ParseToXslt implements XsltParser {

    private static final String TRANSFORMER = "channel.xsl";
    private static final String INPUT_FILE = "1.xml";
    private static final String OUTPUT_FILE = "2.xml";

    /**
     *
     */
    @Override
    public void transformXml() {
        try {
            StreamSource transformerFile = new StreamSource(new File(TRANSFORMER));
            StreamSource inputFile = new StreamSource(new File(INPUT_FILE));
            StreamResult outputFile = new StreamResult(new File(OUTPUT_FILE));

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(transformerFile);

            transformer.transform(inputFile, outputFile);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
