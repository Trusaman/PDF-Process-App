package lunet.prod;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lunet.prod.constant.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File dir = new File(Constant.PDF_FILE_PATH);
        Arrays.stream(dir.listFiles()).filter(file -> file.getName().endsWith(".pdf")).forEach(System.out::println);



    }
    public static void main1(String[] args) throws FileNotFoundException, DocumentException, UnsupportedEncodingException {

        String employeeName = "Nguyen Van A";
        System.out.println("Xin chaào Nguyễn Văn A!");

        // create a pdf file with FileOutput

        File dir = new File(Constant.PDF_FILE_PATH);
        System.out.println("dir = " + dir.listFiles());
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith(".pdf"))
                file.delete();
        }



        String fileName = Constant.PDF_FILE_PATH + employeeName + ".pdf";
        System.out.println("fileName = " + fileName);

        // Create a new file object with the desired file name
        File file = new File(fileName);

// Create a new document object
        Document document = new Document();

// Create a new PdfWriter object to write the document to the file
        PdfWriter.getInstance(document, new FileOutputStream(file));

// Open the document
        document.open();

// Add content to the document
// Create a new table object with 2 columns
        com.itextpdf.text.pdf.PdfPTable table = new PdfPTable(2);

// Add header row to the table

        com.itextpdf.text.pdf.PdfPCell header1 = new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("NAME"));
        header1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header1);
        com.itextpdf.text.pdf.PdfPCell header2 = new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("AGE"));
        header2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header2);

// Add new row to the table with font HELVETICA using UTF-8 encoding

        table.addCell("Tran Van A");



        // format cell "24" to the right of line
        com.itextpdf.text.pdf.PdfPCell cell = new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("24"));
        cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
        table.addCell(cell);


// Add the table to the document with UTF-8 encoding


        document.add(table);



// Close the document
        document.close();

    }
}