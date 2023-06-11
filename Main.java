import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Main {
    static double totalPrice = 0.0;
    public static JPanel selectedDishesPanel;
    static JLabel  SubTotal;
    public static JPanel allDishesPanel;
    static public ArrayList<Foodx> foodList = new ArrayList<>();
    static public ArrayList<Foodx> Food_SE = new ArrayList<>();
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("SOF");
        ImageIcon logo = new ImageIcon("D:\\kaka\\project\\src\\10.png");
        frame.setIconImage(logo.getImage());
        frame.getContentPane().setBackground(new Color(0x252836)); // Set the background color of the content pane
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        ImageIcon home = new ImageIcon("C:\\Users\\97059\\Desktop\\images png\\logo.png");

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(8, 1)); // Set GridLayout with 8 rows and 1 column
        panel1.setBackground(new Color(0x1f1d2b)); // Set a background color for panel1
        panel1.setPreferredSize(new Dimension(100, 720));

        String[] iconFiles = {
                "D:\\kaka\\project\\src\\1.png",
                "D:\\kaka\\project\\src\\2.png",
                "D:\\kaka\\project\\src\\3.png",
                "D:\\kaka\\project\\src\\4.png",
                "D:\\kaka\\project\\src\\5.png",
                "D:\\kaka\\project\\src\\6.png",
                "D:\\kaka\\project\\src\\7.png" ,
                "D:\\kaka\\project\\src\\8.png"
        };

        // Create and add the home logo label
        JLabel labelHome = new JLabel(home);
        panel1.add(labelHome);
        panel1.setLayout(new FlowLayout());
        for (String iconFile : iconFiles) {
            ImageIcon icon = new ImageIcon(iconFile);
            JButton button = new JButton(icon);

            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusPainted(false);//hide burder

            // Add the button to panel1
            panel1.add(button);
        }
//panel1   الي ع الشمال
//panel2   الي ع اليمين
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0x252836)); // Set a background color for panel2
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(300, 700));

        frame.add(panel1, BorderLayout.WEST); // Add panel1 to the west of the frame
        frame.add(panel2, BorderLayout.EAST); // Add panel2 to the east of the frame

        JLabel ordLab = new JLabel("Order# 34562");
        ordLab.setForeground(Color.white);
        ordLab.setFont(new Font("Arial", Font.PLAIN, 20));
        ordLab.setBounds(10, 20, 160, 40);

        JButton b1 = new JButton("Dine In");
        JButton b2 = new JButton("To Go");
        JButton b3 = new JButton("Delivery");
        b1.setFocusPainted(false);//hide burder
        b2.setFocusPainted(false);//hide burder
        b3.setFocusPainted(false);//hide burder

        JLabel butlabel = new JLabel();
        butlabel.setLayout(new GridLayout(1, 3));
        b1.setBackground(new Color(0x1f1d2b));
        b2.setBackground(new Color(0x1f1d2b));
        b3.setBackground(new Color(0x1f1d2b));
        b1.setForeground(new Color(0xEA7C69));
        b2.setForeground(new Color(0xEA7C69));
        b3.setForeground(new Color(0xEA7C69));


        FlowLayout flowLayout1 = new FlowLayout(FlowLayout.CENTER, 6, 0); // Use FlowLayout with a horizontal gap of 3 pixels
        butlabel.setLayout(flowLayout1);

        butlabel.add(b1);
        butlabel.add(b2);
        butlabel.add(b3);
        butlabel.setBounds(10, 70, 250, 450);
        butlabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel item = new JLabel("   Item                         Price");

        item.setBounds(10, -100, 250, 450);
        item.setFont(new Font("Arial", Font.PLAIN, 14));
        FlowLayout flowLayout2 = new FlowLayout(FlowLayout.LEFT);

        item.setLayout(null);
        item.setForeground(Color.white);
        item.setBackground(new Color(0xEA7C69));

/////////////////////////////////////////////---===========================

        JPanel Total = new JPanel();
        JButton paypal = new JButton("Continue To Payment");//paypal Button
        paypal.setFocusPainted(false);//hide burder
        paypal.setFocusPainted(false);//hide burder
        paypal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PaymentView paymentView = new PaymentView();
                paymentView.setVisible(true);

            }
        });

        JLabel  Disacount =  new JLabel("Disacoun                                         0.0$");
        SubTotal =  new JLabel("SubTotal                                          "+totalPrice + "$");
        SubTotal.setForeground(Color.white);
        Disacount.setForeground(Color.white);
        Disacount.setFont(new Font("Arial", Font.BOLD, 14));
        SubTotal.setFont(new Font("Arial", Font.BOLD, 14));

        Total.setBackground(new Color(0x1F1D2B));
        paypal.setBackground(new Color(0xEA7C69));
        paypal.setForeground(Color.white);
        paypal.setFont(new Font("Arial", Font.BOLD, 16));
        Total.setLayout(new GridLayout(4,1,0,0));
        paypal.setPreferredSize(new Dimension(280, 40));

        Total.setPreferredSize(new Dimension(300, 120));

        Total.add(Disacount);
        Total.add(SubTotal);
        Total.add(paypal);

///////////////////////////////////////////////////////////////////////////
        JPanel main1 = new JPanel();
        JPanel taitel = new JPanel();
        JPanel food = new JPanel();
        taitel.setBackground(new Color(0x252836));
        food.setBackground(new Color(0x252836));
        main1.setBackground(new Color(0x252836));


        JLabel name = new JLabel("   An-Najah Restaurant");
        name.setFont(new Font("Arial", Font.PLAIN, 30));
        name.setForeground(new Color(255, 255, 255));
        taitel.setLayout(null);
        name.setBounds(0, 10, 400, 50);
        taitel.add(name);

        JLabel dateLabel = new JLabel(getFormattedDate());
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        dateLabel.setForeground(Color.white);
        dateLabel.setBounds(0, 50, 400, 25);
        taitel.add(dateLabel);
        taitel.setBackground(new Color(0x252836));


        JPanel search = new JPanel();
        search.setPreferredSize(new Dimension(250, 25));
        search.setBackground(new Color(0x252836));
        search.setBounds(650, 40, 200, 90);
        //search.setOpaque(false);
        taitel.add(search);

        JTextField search_bar = new JTextField();
        search_bar.setText(" \uD83D\uDD0D  Search forh, coffe, etc...");
        search_bar.setPreferredSize(new Dimension(200, 25));
        search_bar.setOpaque(false);
        search.add(search_bar);
        search_bar.setForeground(Color.white);
        taitel.setBounds(0, 0, 870, 90);
        food.setBounds(0, 90, 636, 40);

        String[] buttonNames = {"Hot Dishes", "Cold Dishes", "Soup", "Grill", "Appetizer", "Dessert","Edit"};
        Font buttonFont = new Font("Arial", Font.PLAIN, 12);

        food.setLayout(new GridLayout(1, buttonNames.length)); // Set the layout of the food panel to a 1xN grid

        for (String bname : buttonNames) {
            JButton button = new JButton(bname);
            button.setFocusPainted(false);
            button.setBorder(null);
            button.setBackground(null);
            button.setForeground(Color.WHITE);
            button.setFont(buttonFont);

            if (bname.equals("Edit")) {
                ImageIcon editIcon = new ImageIcon("D:\\kaka\\project\\src\\edit.png"); // Replace "edit_icon.png" with your icon file path
                button.setIcon(editIcon);

                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ManagementView managementView = new ManagementView();
                        managementView.setVisible(true);
                        System.out.println("Edit button clicked!");
                    }
                });
            }

            food.add(button);
        }
        JPanel choose = new JPanel();
        choose.setBounds(0, 140, 870, 61);
        choose.setBackground(new Color(0x252836));
        JLabel chooseL = new JLabel("Choose Dishes");
        choose.setLayout(null);
        Border border = BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(0x252836));
        choose.setBorder(border);
        chooseL.setBounds(20, 10, 200, 30);
        chooseL.setForeground(Color.white);
        chooseL.setFont(new Font("Arial", Font.BOLD, 25));
        choose.add(chooseL);
        String choo[] = {"\u21E9 Dine In", "To Go", "Delivery"};
        JComboBox dine = new JComboBox<>(choo);
        dine.setBounds(750, 10, 100, 30);
        dine.setForeground(Color.WHITE);
        dine.setBackground(null);
        choose.add(dine);
        main1.add(choose);
        allDishesPanel = new JPanel(new GridLayout(2, 3,25,25));
        allDishesPanel.setBackground(new Color(0x1f1d2b)); // allDishesPanel  بانل الاطباق الرئيسة
        allDishesPanel.setBounds(30, 200, 810, 480);
        main1.add(allDishesPanel);
//////////////////

////////////////////
       // selectedDishesPanel = new JPanel(new GridLayout(0, 1));
        //JScrollPane scrollPane = new JScrollPane(selectedDishesPanel); // Create a scroll pane and pass the panel as its view
       // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Set vertical scrollbar always visible
        //frame.getContentPane().add(scrollPane);

        JPanel text =new JPanel(new GridLayout(3,1,0,25));


        text.setBackground(new Color(0x1F1D2B));
        text.add(ordLab);//نص
        text.add(butlabel);//نوع الطلب
        text.add(item); //نص

        panel2.add(text,BorderLayout.NORTH);//بانل تحتوي على النصوص و نوع الطلب


        main1.setLayout(null);
        main1.add(taitel);
        main1.add(food);
        frame.add(main1, BorderLayout.CENTER);

        foodList.add(new Foodx("Pizza", "Delicious Italian dish", "D:\\kaka\\project\\src\\image1.png", 10.00,1));
        foodList.add(new Foodx("Burger", "Classic fast food", "D:\\kaka\\project\\src\\image2.png", 8.00,1));
        foodList.add(new Foodx("Sushi", "Japanese delicacy", "D:\\kaka\\project\\src\\image3.png", 12.00,1));
        foodList.add(new Foodx("Pasta", "Italian pasta dish", "D:\\kaka\\project\\src\\image4.png", 9.00,1));
        foodList.add(new Foodx("Salad", "Healthy mix of greens", "D:\\kaka\\project\\src\\image5.png", 7.00,1));
        foodList.add(new Foodx("Ice Cream", "Refreshing frozen treat", "D:\\kaka\\project\\src\\image6.png", 5.00,1));
//////////////////////////////////////////
        Foodx[] foodArray = foodList.toArray(new Foodx[foodList.size()]);
        BANEL_ALL_DISH(foodArray);


        selectedDishesPanel.setBounds(0, 150, 300, 500);
        panel2.add(selectedDishesPanel,BorderLayout.CENTER);//قائمة الاطباق المختارة
        JScrollPane scrollPane = new JScrollPane(selectedDishesPanel); //سكرووول للاطباق المختارة
        scrollPane.setPreferredSize(new Dimension(200, 200));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel2.add(scrollPane);

        panel2.add(Total,BorderLayout.SOUTH);//المجموع و زر للاكمال

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////end main
    private static String getFormattedDate() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d MMM yyyy");
        return "     " + sdf.format(now);
    }
//========================================================================================================================
    public static JPanel createFoodPanel(Foodx food) {//فنكشن الي بضيف الاطباق ع شمال

        JTextField Quantity = new JTextField();

     /*   boolean found = false;
        for (Foodx x : Food_SE) {
            if (food.getName()==x.getName()) {
                found = true;
                break;
            }
        }
        if (!found) {*/
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            // Create panel for dish details
            JPanel detailsPanel = new JPanel();
            detailsPanel.setBackground(null);

            //===================================================================================================
            ImageIcon originalIcon = new ImageIcon(food.getImagePath());
            Image originalImage = originalIcon.getImage();

            int desiredWidth = 50;
            int desiredHeight = 50;

            Image resizedImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);


            ImageIcon resizedIcon = new ImageIcon(resizedImage);

            JLabel imageLabel = new JLabel(resizedIcon);

            detailsPanel.add(imageLabel);
            //===================================================================================================
            // Create label for dish name
            JLabel nameLabel = new JLabel(" " + food.getName() + "       ");
              nameLabel.setForeground(Color.white);

            detailsPanel.add(nameLabel);
            detailsPanel.add(Quantity);

            // Create label for dish price
            JLabel priceLabel = new JLabel(String.format("$%.2f", food.getPrice()));
            priceLabel.setForeground(Color.white);
             panel.setBackground(null);

            detailsPanel.add(priceLabel);

            panel.add(detailsPanel);

            // Create delete button for the dish
            JButton deleteButton = new JButton();
            deleteButton.setFocusPainted(false);//hide burder

        ImageIcon trashIcon = new ImageIcon("D:\\kaka\\project\\src\\Trash.png");
            deleteButton.setIcon(trashIcon);
            deleteButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Remove the dish panel from the selected dishes panel
                    selectedDishesPanel.remove(panel);
                    selectedDishesPanel.revalidate();
                    selectedDishesPanel.repaint();
                    Food_SE.remove(food);

                    // Update the total price
                    totalPrice -= food.getPrice();
                    SubTotal.setText("SubTotal                                          " + totalPrice + "$");//تحديث المجموع عند الحذف
                    System.out.println(totalPrice);

                }


            });

            panel.add(deleteButton);
        return panel;

        }
     //   _________________________________________________________________________________________________________________________
        public static void BANEL_ALL_DISH(Foodx[] FL){
       for (Foodx F : FL) {
        JButton button = new JButton("<html>" + F.getName() + "<br>" + F.getDetails() + "<br>" + F.getPrice() + "$" + "<html>");//الكلام الي ع الازرار
        button.setFocusPainted(false);//hide burder

        button.setForeground(Color.white);
        button.setLayout(new BorderLayout());
        button.setBackground(null);
        ImageIcon imageIcon = new ImageIcon(F.getImagePath());
        button.setIcon(imageIcon);

        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);

        // selectedDishesPanel = new JPanel(new GridLayout(0,1,0,10));//selectedDishesPanel بانل الاطباق التي تم تحديديها
        selectedDishesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));//selectedDishesPanel بانل الاطباق التي تم تحديديها
        // selectedDishesPanel = new JPanel(new CardLayout());//selectedDishesPanel بانل الاطباق التي تم تحديديها

        selectedDishesPanel.setPreferredSize(new Dimension(250,1000));
        selectedDishesPanel.setBackground(new Color(0x1f1d2b));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add the selected food to the selected dishes panel
                Food_SE.add(F);
                selectedDishesPanel.add(createFoodPanel(F));
                selectedDishesPanel.revalidate();
                selectedDishesPanel.repaint();
                totalPrice += F.getPrice();
                SubTotal .setText("SubTotal                                          "+totalPrice + "$");////تحديث المجموع عند الاضافة
                System.out.println(totalPrice);
            }
        });
        allDishesPanel.add(button);
    }
}}

