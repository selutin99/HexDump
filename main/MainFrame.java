import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Toolkit;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends JFrame
{

    public static void main(String[] args) throws IOException
    {
        /********************Настройка окна**********************/
        JFrame frame = new JFrame("Hex Dumper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Закрытие при нажатии на крестик
        frame.setSize(700, 600); //Установить размер
        frame.setResizable(false); //Нерасширяемое окно
        frame.setLocationRelativeTo(null); //Разместить по центру
        /*******************Конец настройка окна*****************/

        /********************Иконка приложения********************/
        //ImageIcon image = new ImageIcon(MainFrame.class.getResource("img/favicon.png"));
        //frame.setIconImage(image.getImage());
        /*****************Конец иконка приложения****************/

        /**************************Меню**************************/
        JMenuBar menuBar = new JMenuBar();
        JMenu mainFile = new JMenu("Файл");
        JMenu reference = new JMenu("Справка");
        JMenuItem exitMyApp = new JMenuItem("Выход");
        /**********Подменю для "файл"********/
        JMenuItem openMyFile = new JMenuItem("Открыть файл");
        //openMyFile.setIcon(new ImageIcon(MainFrame.class.getResource("img/openFile.png")));
        JMenu copyMyDump = new JMenu("Копировать");
        //copyMyDump.setIcon(new ImageIcon(MainFrame.class.getResource("img/copy.png")));
        JMenuItem exportDump = new JMenuItem("Экспорт дампа");
        //exportDump.setIcon(new ImageIcon(MainFrame.class.getResource("img/import.png")));

        mainFile.add(openMyFile);
        mainFile.add(copyMyDump);
        mainFile.add(exportDump);
        mainFile.add(exitMyApp);
        /******Конец подменю для "файл"******/

        /**********Подменю для "копировать"********/
        JMenuItem copyLines = new JMenuItem("Копировать нумерацию");
        JMenuItem copyDump = new JMenuItem("Копировать дамп");
        JMenuItem copyKeys = new JMenuItem("Копировать расшифрованное значение");

        copyMyDump.add(copyLines);
        copyMyDump.add(copyDump);
        copyMyDump.add(copyKeys);
        /******Конец подменю для "копировать"******/

        /**********Подменю для "справка"********/
        JMenuItem aboutProgram = new JMenuItem("О программе");
        //aboutProgram.setIcon(new ImageIcon(MainFrame.class.getResource("img/info.png")));
        JMenuItem aboutAuthor = new JMenuItem("Об авторе");

        reference.add(aboutProgram);
        reference.add(aboutAuthor);
        /******Конец подменю для "справка"******/
        menuBar.add(mainFile);
        menuBar.add(reference);
        frame.setJMenuBar(menuBar);
        /***********************Конец меню**************************/

        /*********************Главная форма**********************/
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JButton buttonOpen = new JButton();
        buttonOpen.setText("Открыть файл");
        //ImageIcon icon = new ImageIcon(MainFrame.class.getResource("img/openFile.png"));
        //buttonOpen.setIcon(icon);
        buttonOpen.setBounds(250,10,200,30);
        panel.add(buttonOpen);

        /*************Названия текстовых областей***************/
        JLabel text1 = new JLabel("Нумерация:");
        text1.setBounds(60,40,200,40);
        panel.add(text1);

        JLabel text2 = new JLabel("Шестнадцатеричный дамп:");
        text2.setBounds(270,40,200,40);
        panel.add(text2);

        JLabel text3 = new JLabel("Значение:");
        text3.setBounds(565,40,200,40);
        panel.add(text3);
        /*************Конец названия текстовых областей**********/

        /******************ТЕКСТОВЫЕ ЗОНЫ************************/
        JScrollPane scrollOfLines = new JScrollPane();
        scrollOfLines.setBounds(5, 70, 185, 350);
        panel.add(scrollOfLines);
        JTextArea textAreaOfLines = new JTextArea();
        scrollOfLines.setViewportView(textAreaOfLines);

        JScrollPane scrollOfDump = new JScrollPane();
        scrollOfDump.setBounds(195, 70, 305, 350);
        panel.add(scrollOfDump);
        JTextArea textAreaOfDump = new JTextArea();
        scrollOfDump.setViewportView(textAreaOfDump);

        JScrollPane scrollOfKeys = new JScrollPane();
        scrollOfKeys.setBounds(505, 70, 185, 350);
        panel.add(scrollOfKeys);
        JTextArea textAreaOfKeys = new JTextArea();
        scrollOfKeys.setViewportView(textAreaOfKeys);
        /***************КОНЕЦ ТЕКСТОВЫЕ ЗОНЫ********************/

        /******************Кнопки копирования*******************/
        JButton buttonCopyLines = new JButton();
        buttonCopyLines.setText("Копировать нумерацию");
        buttonCopyLines.setBounds(5,425,185,50);
        panel.add(buttonCopyLines);

        JButton buttonCopyDump = new JButton();
        buttonCopyDump.setText("Копировать дамп");
        buttonCopyDump.setBounds(255,425,190,50);
        panel.add(buttonCopyDump);

        JButton buttonCopyKeys = new JButton();
        buttonCopyKeys.setText("Копировать значения");
        buttonCopyKeys.setBounds(505,425,185,50);
        panel.add(buttonCopyKeys);

        JButton importDump = new JButton();
        importDump.setText("Экспортировать дамп");
        //ImageIcon iconForImport = new ImageIcon(MainFrame.class.getResource("img/import.png"));
        //importDump.setIcon(iconForImport);
        importDump.setBounds(250,480,200,50);
        panel.add(importDump);
        /****************Конец кнопки копирования***************/

        /******************Конец главная форма*******************/
        JFileChooser jFileChooser = new JFileChooser();
        /********************Обработчик событий********************/
        exitMyApp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                frame.setVisible(false);
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        }); //Закрытие программы
        aboutAuthor.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                JFrame authorFrame = new JFrame("Об авторе");
                authorFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //Закрытие при нажатии на крестик
                authorFrame.setSize(300, 400); //Установить размер
                authorFrame.setResizable(false); //Нерасширяемое окно
                authorFrame.setLocationRelativeTo(null); //Разместить по центру

                ImageIcon image = new ImageIcon("img/info.png");
                authorFrame.setIconImage(image.getImage());

                JLabel l1 = new JLabel();

                authorFrame.setLayout(new BorderLayout());
                authorFrame.setContentPane(new JLabel(new ImageIcon(MainFrame.class.getResource("img/photo.png"))));
                authorFrame.setLayout(new FlowLayout());
                String textOfAuthor = "<html>"
                        +"<h2 style='margin-left: 5px; margin-top: -3px; color: blue'>Шестнадцатеричный дампер.</h2>"
                        +"<p style='font-size: 15pt; margin-left: 25px; color: blue'>Автор: Александр Селютин.</p><br>"
                        +"<p style='font-size: 15pt; margin-left: 30px; margin-top: 20px; color: blue'>Мой ГитХаб:<br></p><p style='margin-left: 30px; margin-bottom: 10px;'><a href='https://github.com/selutin99'>https://github.com/selutin99</a><br></p>"
                        +"<p style='font-size: 15pt; margin-left: 30px; color: blue'>Фриланс-аккаунт:<br></p><p style='margin-left: 30px; margin-bottom: 10px'><a href='https://freelance.ru/selutin99'>https://freelance.ru/selutin99</a><br></p>"
                        +"<p style='font-size: 15pt; margin-left: 30px; color: blue'>WebMoney:<br></p><p style='margin-left: 30px; margin-bottom: 10px; color: blue'>R257423094603<br>Z420647865850<br></p>"
                        +"<p style='font-size: 15pt; margin-left: 30px; color: blue'>Мой Веб-сайт:<br></p><p style='margin-left: 30px;'><a href='http://sanya-games.890m.com/'>http://sanya-games.890m.com</a></p></html>";
                l1.setText(textOfAuthor);
                authorFrame.add(l1);

                authorFrame.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        }); //Об авторе
        aboutProgram.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                String stringInfo = "Шестнадцатеричный дампер.\nПрограмма предназначена для вывода шестнадцатеричного дампа файлов.\nКопируемые значения добавляются в буфер обмена.\n\nОтдельную благодарность хочется выразить Борису Леонидовичу Файфелю, сподвигшему меня на создание данного проекта.";
                String TITLE = "О программе";
                JOptionPane.showMessageDialog(frame, stringInfo, TITLE, JOptionPane.PLAIN_MESSAGE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        }); //О программе
        buttonOpen.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = jFileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = jFileChooser.getSelectedFile();
                    try {
                        textAreaOfLines.setText("");
                        textAreaOfDump.setText("");
                        textAreaOfKeys.setText("");

                        String s = hexDumpReturnLines(file);
                        textAreaOfLines.append(s);
                        String s1 = hexDumpReturnDump(file);
                        textAreaOfDump.append(s1);
                        String s2 = hexDumpReturnKeys(file);
                        textAreaOfKeys.append(s2);

                        textAreaOfLines.setEditable(false);
                        textAreaOfDump.setEditable(false);
                        textAreaOfKeys.setEditable(false);
                    }
                    catch(IOException e1) {
                        System.exit(0);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        }); //Открытие кнопки
        buttonCopyLines.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                String s = textAreaOfLines.getText();
                if(textAreaOfDump.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Вы скопировали пустую строку", "Предупреждение", JOptionPane.QUESTION_MESSAGE);
                }
                else {
                    setClipboard(s);
                    JOptionPane.showMessageDialog(frame, "Текст скопирован в буфер обмена", "Копирование", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });//Копирование линий в буфер обмена
        buttonCopyDump.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                String s = textAreaOfDump.getText();
                if(textAreaOfDump.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Вы скопировали пустую строку", "Предупреждение", JOptionPane.QUESTION_MESSAGE);
                }
                else {
                    setClipboard(s);
                    JOptionPane.showMessageDialog(frame, "Текст скопирован в буфер обмена", "Копирование", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });//Копирование дампа в буфер обмена
        buttonCopyKeys.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                String s = textAreaOfKeys.getText();
                if(textAreaOfKeys.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Вы скопировали пустую строку", "Предупреждение", JOptionPane.QUESTION_MESSAGE);
                }
                else {
                    setClipboard(s);
                    JOptionPane.showMessageDialog(frame, "Текст скопирован в буфер обмена", "Копирование", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });//Копирование значений в буфер обмена
        importDump.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TXT", "*.*");

                JFileChooser fc = new JFileChooser();
                fc.setDialogTitle("Экспортировать файл");
                fc.setFileFilter(filter);
                if (textAreaOfDump.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(frame,"Нечего экспортировать","Ошибка",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if ((fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)) {
                        try {
                            hexDump(fc.getSelectedFile(), jFileChooser.getSelectedFile());
                        } catch (IOException e2) {
                            System.exit(0);
                        }
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });//Импортирование файла

        openMyFile.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = jFileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = jFileChooser.getSelectedFile();
                    try {
                        textAreaOfLines.setText("");
                        textAreaOfDump.setText("");
                        textAreaOfKeys.setText("");

                        String s = hexDumpReturnLines(file);
                        textAreaOfLines.append(s);
                        String s1 = hexDumpReturnDump(file);
                        textAreaOfDump.append(s1);
                        String s2 = hexDumpReturnKeys(file);
                        textAreaOfKeys.append(s2);

                        textAreaOfLines.setEditable(false);
                        textAreaOfDump.setEditable(false);
                        textAreaOfKeys.setEditable(false);
                    }
                    catch(IOException e1) {
                        System.exit(0);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        copyLines.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                String s = textAreaOfLines.getText();
                if(textAreaOfDump.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Вы скопировали пустую строку", "Предупреждение", JOptionPane.QUESTION_MESSAGE);
                }
                else {
                    setClipboard(s);
                    JOptionPane.showMessageDialog(frame, "Текст скопирован в буфер обмена", "Копирование", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        copyDump.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                String s = textAreaOfDump.getText();
                if(textAreaOfDump.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Вы скопировали пустую строку", "Предупреждение", JOptionPane.QUESTION_MESSAGE);
                }
                else {
                    setClipboard(s);
                    JOptionPane.showMessageDialog(frame, "Текст скопирован в буфер обмена", "Копирование", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        copyKeys.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                String s = textAreaOfKeys.getText();
                if(textAreaOfKeys.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Вы скопировали пустую строку", "Предупреждение", JOptionPane.QUESTION_MESSAGE);
                }
                else {
                    setClipboard(s);
                    JOptionPane.showMessageDialog(frame, "Текст скопирован в буфер обмена", "Копирование", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        exportDump.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TXT", "*.*");

                JFileChooser fc = new JFileChooser();
                fc.setDialogTitle("Экспортировать файл");
                fc.setFileFilter(filter);
                if (textAreaOfDump.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(frame,"Нечего экспортировать","Ошибка",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if ((fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)) {
                        try {
                            hexDump(fc.getSelectedFile(), jFileChooser.getSelectedFile());
                        } catch (IOException e2) {
                            System.exit(0);
                        }
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        /*******************Конец обработчик событий**************/
        frame.setVisible(true); //Установить видимость
    }

    public static void setClipboard(String str)//Копировать в буфер обмена
    {
        StringSelection ss = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }

    public static String hexDumpReturnLines(File file) throws IOException //Отображает линии
    {
        InputStream is = new FileInputStream(file);
        int i = 0;

        StringBuilder sb0 = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("   ");

        while (is.available() > 0)
        {
            sb0.append(String.format("%04X \n", i * 16));

            for (int j = 0; j < 16; j++)
            {
                if (is.available() > 0)
                {
                    int value = (int) is.read();
                    sb1.append(String.format("%02X ", value));

                    if (!Character.isISOControl(value))
                    {
                        sb2.append((char)value);
                    }
                    else
                    {
                        sb2.append(".");
                    }
                }
                else
                {
                    for (; j<16; j++)
                    {
                        sb1.append("   ");
                    }
                }
            }
            //System.out.print(sb0);
            //System.out.print(sb1);
            //.out.println(sb2);

            i++;
        }
        String s0 = sb0.toString();
        //String s1 = sb1.toString();
        //String s2 = sb2.toString();
        is.close();
        return s0;
    }
    public static String hexDumpReturnDump(File file) throws IOException //Отображает дамп
    {
        InputStream is = new FileInputStream(file);
        int i = 0;

        StringBuilder sb0 = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("   ");

        while (is.available() > 0)
        {
            sb0.append(String.format("%04X \n", i * 16));

            for (int j = 0; j < 16; j++)
            {
                if (is.available() > 0)
                {
                    int value = (int) is.read();
                    sb1.append(String.format("%02X ", value));
                    if (!Character.isISOControl(value))
                    {
                        sb2.append((char)value);
                    }
                    else
                    {
                        sb2.append(".");
                    }
                }
                else
                {
                    for (; j<16; j++)
                    {
                        sb1.append("   ");
                    }
                }
            }
            sb1.append("\n");
            //System.out.print(sb0);
            //System.out.print(sb1);
            //.out.println(sb2);

            i++;
        }
        //String s0 = sb0.toString();
        String s1 = sb1.toString();
        //String s2 = sb2.toString();
        is.close();
        return s1;
    }
    public static String hexDumpReturnKeys(File file) throws IOException //Отображает значения
    {
        InputStream is = new FileInputStream(file);
        int i = 0;

        StringBuilder sb0 = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (is.available() > 0)
        {
            sb0.append(String.format("%04X \n", i * 16));

            for (int j = 0; j < 16; j++)
            {
                if (is.available() > 0)
                {
                    int value = (int) is.read();
                    sb1.append(String.format("%02X ", value));
                    if (!Character.isISOControl(value))
                    {
                        sb2.append((char)value);
                    }
                    else
                    {
                        sb2.append(".");
                    }
                }
                else
                {
                    for (; j<16; j++)
                    {
                        sb1.append("   ");
                    }
                }
            }
            sb2.append("\n");
            //System.out.print(sb0);
            //System.out.print(sb1);
            //.out.println(sb2);

            i++;
        }
        //String s0 = sb0.toString();
        //String s1 = sb1.toString();
        String s2 = sb2.toString();
        is.close();
        return s2;
    }
    public static void hexDump(File fileResult,File fileInn) throws IOException //Для импорта
    {
        FileWriter forResult = new FileWriter(fileResult);
        InputStream is = new FileInputStream(fileInn);
        int i = 0;

        while (is.available() > 0)
        {
            StringBuilder sb0 = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder("   ");
            sb0.append(String.format("%04X ", i * 16));

            for (int j = 0; j < 16; j++)
            {
                if (is.available() > 0)
                {
                    int value = (int) is.read();
                    sb1.append(String.format("%02X ", value));

                    if (!Character.isISOControl(value))
                    {
                        sb2.append((char)value);
                    }
                    else
                    {
                        sb2.append(".");
                    }
                }
                else
                {
                    for (; j<16; j++)
                    {
                        sb1.append("   ");
                    }
                }
            }
            String s00, s11, s22;
            s00=sb0.toString();
            forResult.write(s00);
            s11=sb1.toString();
            forResult.write(s11);
            s22=sb2.toString();
            s22+="\r\n";
            forResult.write(s22);
            i++;
        }
        is.close();
        forResult.close();
    }
}