import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ManagementView extends JFrame {
    private JRadioButton creditCardOption;
    private JRadioButton cashOption;
    private JTextField name;
    private JTextField details;
    private JTextField imagePath;
    private JTextField price;
    private JPanel felads ;//الحقول الفارغه
    private JPanel felads1 ;
    private JPanel felads2 ;
    private JComboBox<String> paymentOptionsCombo;


    private JPanel listx ;//قائمة الاكل

    public ManagementView() {
        setTitle("Dishes management");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setLayout(new GridLayout(0,2));
        setResizable(false);
        listx=new JPanel(new FlowLayout(FlowLayout.LEFT));


        for (Foodx F :Main.foodList)
        {
            listx.add(createFoodPanel(F));
            System.out.println(F); }

        felads = new JPanel(new GridLayout(1, 2));
        felads1 = new JPanel(new GridLayout(8, 0));
        felads2 = new JPanel(new GridLayout(8, 0));


        JLabel lablet = new JLabel(" Add New Dishes");
        felads1.add(lablet);
        lablet.setForeground(Color.white);

        JLabel lablexf = new JLabel("//");
        felads2.add(lablexf);
        lablet.setForeground(Color.white);

        JLabel Name = new JLabel(" Name:");
        felads1.add(Name);
        Name.setForeground(Color.white);

        JLabel Details = new JLabel("Details:");
        felads1.add(Details);
        Details.setForeground(Color.white);

        JLabel ImagePath = new JLabel("ImagePath:");
        felads1.add(ImagePath);
        ImagePath.setForeground(Color.white);


        JLabel Price = new JLabel("Price:");
        felads1.add(Price);
        Price.setForeground(Color.white);




        name = new JTextField();
        felads2.add(name);



        details = new JTextField();
        felads2.add(details);



        imagePath = new JTextField();
        felads2.add(imagePath);


        price = new JTextField();
        felads2.add(price);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setForeground(Color.white);
        cancelButton.setBackground(new Color(0xEA7C69));
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        JButton confirmButton = new JButton("ADD");
        confirmButton.setForeground(Color.white);
        confirmButton.setBackground(new Color(0xEA7C69));
        confirmButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                    if (!name.getText().isEmpty() && !details.getText().isEmpty() && !imagePath.getText().isEmpty() && !price.getText().isEmpty()) {
                        int pp = Integer.parseInt(price.getText());
                      // Foodx F= new Foodx(name.getText(),details.getText(),imagePath.getText(),pp,1);
                     //   Main.foodList.add(F);

                        JOptionPane.showMessageDialog(null, "Added successfully", "Added ", JOptionPane.INFORMATION_MESSAGE);

                        dispose();
                      //  Main.selectedDishesPanel.removeAll();
                     //   Main.allDishesPanel.revalidate();
                     //   Main.allDishesPanel.repaint();

                     //   Foodx[] foodArray = Main.foodList.toArray(new Foodx[Main.foodList.size()]);
                    //   Main. BANEL_ALL_DISH(foodArray);

                        System.out.println(Main.foodList.toString());

                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please enter the above data", "Added ERROR", JOptionPane.WARNING_MESSAGE);
                    }

            }
        });
        felads2.add(confirmButton);
        felads2.add(cancelButton);
        felads1.setBackground(new Color(0x252836));
        felads2.setBackground(new Color(0x252836));

        listx.setBackground(new Color(0x1f1d2b));
        felads.add(felads1);
        felads.add(felads2);

        add(felads);
        add(listx);


    }
    //==========================================================================================================================================================
    public static JPanel createFoodPanel(Foodx food) {//فنكشن الي بضيف الاطباق ع شمال

        JTextField Quantity = new JTextField();

        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        // Create panel for dish details
        JPanel detailsPanel = new JPanel();
        detailsPanel.setBackground(null);
        //===================================================================================================
        // Create label for dish image
        ImageIcon originalIcon = new ImageIcon(food.getImagePath());
        Image originalImage = originalIcon.getImage();
        // Calculate the desired width and height for the resized image
        int desiredWidth = 50;
        int desiredHeight = 50;
        // Create a scaled version of the image
        Image resizedImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);

        // Create an ImageIcon using the resized image
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Create a JLabel with the resized image
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
        return panel;

    }}
