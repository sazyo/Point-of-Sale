import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class PaymentView extends JFrame {
    private JRadioButton creditCardOption;
    private JRadioButton cashOption;
    private JTextField cardholderNameField;
    private JTextField cardNumberField;
    private JTextField expirationDateField;
    private JTextField cvvNumberField;
    private JPanel felads ;//الحقول الفارغه
    private JPanel felads1 ;
    private JPanel felads2 ;
    private JComboBox<String> paymentOptionsCombo;


    private JPanel listx ;//قائمة الاكل

    public PaymentView() {
        setTitle("Payment View");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setLayout(new GridLayout(0,2));
        setResizable(false);
        listx=new JPanel(new FlowLayout(FlowLayout.LEFT));


        for (Foodx F :Main.Food_SE)
        {listx.add(createFoodPanel(F));
            System.out.println(F); }

        felads = new JPanel(new GridLayout(1, 2));
        felads1 = new JPanel(new GridLayout(8, 0));
        felads2 = new JPanel(new GridLayout(8, 0));

        JLabel paymentOptionsLabel = new JLabel("Payment Options:");
        felads1.add(paymentOptionsLabel);
        paymentOptionsLabel.setForeground(Color.white);

        JLabel cardholderNameLabel = new JLabel("Cardholder Name:");
        felads1.add(cardholderNameLabel);
        cardholderNameLabel.setForeground(Color.white);

        JLabel cardNumberLabel = new JLabel("Card Number:");
        felads1.add(cardNumberLabel);
        cardNumberLabel.setForeground(Color.white);

        JLabel expirationDateLabel = new JLabel("Expiration Date:");
        felads1.add(expirationDateLabel);
        expirationDateLabel.setForeground(Color.white);


        JLabel cvvNumberLabel = new JLabel("CVV Number:");
        felads1.add(cvvNumberLabel);
        cvvNumberLabel.setForeground(Color.white);

        String[] paymentOptions = {"Credit Card", "Cash"};

        // Create a combo box and set the payment options as its items
        paymentOptionsCombo = new JComboBox<>(paymentOptions);
        felads2.add(paymentOptionsCombo);



        cardholderNameField = new JTextField();
        felads2.add(cardholderNameField);



        cardNumberField = new JTextField();
        felads2.add(cardNumberField);



        expirationDateField = new JTextField();
        felads2.add(expirationDateField);


        cvvNumberField = new JTextField();
        felads2.add(cvvNumberField);

        JLabel total = new JLabel();
        total.setText("Total Price is : "+Main.totalPrice+"$");
        total.setFont(new Font("Arial", Font.BOLD, 14));

        felads1.add(total);
        total.setForeground(new Color(0xEA7C69));


        JButton cancelButton = new JButton("Cancel");
        cancelButton.setForeground(Color.white);
        cancelButton.setBackground(new Color(0xEA7C69));
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        JButton confirmButton = new JButton("Confirm Payment");
        confirmButton.setForeground(Color.white);
        confirmButton.setBackground(new Color(0xEA7C69));
        confirmButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String selectedOption = (String) paymentOptionsCombo.getSelectedItem();

                if (selectedOption.equals("Credit Card")) {

                    if (!cardholderNameField.getText().isEmpty() && !cardNumberField.getText().isEmpty() && !expirationDateField.getText().isEmpty() && !cvvNumberField.getText().isEmpty()) {

                        Main.totalPrice = 0;
                        JOptionPane.showMessageDialog(null, "Credit Card payment successful!", "Payment Confirmation", JOptionPane.INFORMATION_MESSAGE);

                        Main.selectedDishesPanel.removeAll();
                        Main.selectedDishesPanel.revalidate();
                        Main.selectedDishesPanel.repaint();
                        dispose();
                        Main.Food_SE.clear();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Please enter the above data", "Payment Confirmation", JOptionPane.WARNING_MESSAGE);

                } else if (selectedOption.equals("Cash")) {
                    // Perform cash payment processing
                    JOptionPane.showMessageDialog(null, " Cash payment successful!", "Payment Confirmation", JOptionPane.INFORMATION_MESSAGE);

                    Main.totalPrice=0;
                    Main.selectedDishesPanel.removeAll();
                    Main.selectedDishesPanel.revalidate();
                    Main.selectedDishesPanel.repaint();
                    dispose();
                    Main.Food_SE.clear();

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
