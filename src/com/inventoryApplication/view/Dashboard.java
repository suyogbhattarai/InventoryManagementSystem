package com.inventoryApplication.view;

import com.inventoryApplication.controller.algorithms.BinarySearch;
import com.inventoryApplication.controller.algorithms.InsertionSort;
import com.inventoryApplication.controller.algorithms.MergeSort;
import com.inventoryApplication.controller.algorithms.SelectionSort;
import com.inventoryApplication.model.ContractModel;
import com.inventoryApplication.model.HardwareModel;
import com.inventoryApplication.util.ValidationUtil;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Suyog Bhattarai Lmuid:23048633
 *
 *
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    CardLayout cardLayout;
    private List<ContractModel> ContractList;
    private List<HardwareModel> HardwareList;

    public Dashboard() {
        initComponents();
        initializeLayout();
        setDefaultActiveButton();
        initializeData();
        initializeTableListener();

    }

    private void setDefaultActiveButton() {
        activeButton = DashBoardButton;  // Make DashboardButton active by default
        setBtnColor(DashBoardButton);   // Apply active button color
        activeButton.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, new Color(237, 240, 242)));
        loadScreen("DashBoardScreen");  // Load default screen
    }

    private void initializeLayout() {
        cardLayout = new java.awt.CardLayout();

        pnlCards.setLayout(cardLayout);
        getContentPane().setLayout(cardLayout);

        pnlCards.add(DashBoardPanel, "DashBoardScreen");
        pnlCards.add(InstockPanel, "InStockScreen");
        pnlCards.add(ProductPanel, "ProductScreen");
        pnlCards.add(ContractPanel, "ContractScreen");
        pnlCards.add(OrdersPanel, "OrdersScreen");
        pnlCards.add(SuppliersPanel, "SuppliersScreen");
        getContentPane().add(pnlMain, "MainScreen");
        getContentPane().add(loginPage, "LoginScreen");

        cardLayout.show(getContentPane(), "DashboardScreen");

    }

    private void addContract(ContractModel contract) {
        ContractList.add(contract);
        DefaultTableModel model = (DefaultTableModel) tableContractDashboard.getModel();
        DefaultTableModel model2 = (DefaultTableModel) tableContractDashboard1.getModel();
        model2.addRow(new Object[]{contract.getContractId(), contract.getContractTitle(), contract.getContractLocation(), contract.getContractStartDate(), contract.getContractExpectedEndDate(), contract.getContractStatus(), contract.getContractValue(), contract.getClientName(), contract.getScopeOfWork()});

        model.addRow(new Object[]{contract.getContractId(), contract.getContractTitle(), contract.getContractLocation(), contract.getContractStartDate(), contract.getContractExpectedEndDate(), contract.getContractStatus(), contract.getContractValue(), contract.getClientName(), contract.getScopeOfWork()
        });
    }

    private void addStock(HardwareModel stock) {
        HardwareList.add(stock);
        DefaultTableModel model = (DefaultTableModel) tableStockList.getModel();
        DefaultTableModel model2 = (DefaultTableModel) tableLatestStockDashboard.getModel();
        model2.addRow(new Object[]{stock.getProductId(), stock.getProductName(), stock.getSupplierName(), stock.getDateOfEntry(), stock.getPrice(), stock.getQuantity(), stock.getUnit(), stock.getMeasurementDescription()});

        model.addRow(new Object[]{stock.getProductId(), stock.getProductName(), stock.getSupplierName(), stock.getDateOfEntry(), stock.getPrice(), stock.getQuantity(), stock.getUnit(), stock.getMeasurementDescription()});

    }

    private void initializeData() {
        ContractList = new ArrayList();

        addContract(new ContractModel(1, "Construction of gate", "Baluwatar", LocalDate.parse("2024-12-09"), LocalDate.parse("2024-12-14"), "Pending", 22000, "Suya Pratap Singh", "Make a good looking gate for the newly built house"));
        addContract(new ContractModel(2, "Renovation of roof", "Jhamsikhel", LocalDate.parse("2024-12-10"), LocalDate.parse("2024-12-20"), "In Progress", 50000, "Hari Kumar", "Replace old tiles with waterproof roofing materials"));
        addContract(new ContractModel(3, "Painting the house", "Bhaisepati", LocalDate.parse("2024-12-11"), LocalDate.parse("2024-12-18"), "Completed", 30000, "Ram Shrestha", "Apply weather-resistant paint to the exterior walls"));
        addContract(new ContractModel(4, "Building compound wall", "Kalimati", LocalDate.parse("2024-12-12"), LocalDate.parse("2024-12-22"), "Pending", 70000, "Raju Maharjan", "Construct a 6-foot-high compound wall around the property"));
        addContract(new ContractModel(5, "Installation of plumbing", "Baneshwor", LocalDate.parse("2024-12-13"), LocalDate.parse("2024-12-17"), "In Progress", 45000, "Sita Rai", "Install modern plumbing systems for the newly built house"));
        addContract(new ContractModel(6, "Wooden flooring setup", "Kumaripati", LocalDate.parse("2024-12-14"), LocalDate.parse("2024-12-25"), "Pending", 35000, "Ramesh Adhikari", "Set up high-quality wooden flooring in the living room"));
        addContract(new ContractModel(7, "Electric wiring", "Maharajgunj", LocalDate.parse("2024-12-15"), LocalDate.parse("2024-12-23"), "Pending", 40000, "Manoj Karki", "Install electric wiring and safety measures for the entire house"));
        addContract(new ContractModel(8, "Garden landscaping", "Tinkune", LocalDate.parse("2024-12-16"), LocalDate.parse("2024-12-30"), "In Progress", 60000, "Anita Singh", "Design and landscape a garden in the backyard"));
        addContract(new ContractModel(9, "Bathroom tiling", "Satdobato", LocalDate.parse("2024-12-17"), LocalDate.parse("2024-12-20"), "Completed", 20000, "Kiran Lama", "Install anti-slip tiles in all the bathrooms"));
        addContract(new ContractModel(10, "Window glass fitting", "Patan", LocalDate.parse("2024-12-18"), LocalDate.parse("2024-12-24"), "Pending", 18000, "Shyam Thapa", "Install heat-resistant glass for all the windows"));
        addContract(new ContractModel(11, "Roof waterproofing", "Kathmandu", LocalDate.parse("2024-12-20"), LocalDate.parse("2024-12-28"), "In Progress", 25000, "Ram Bahadur", "Apply waterproof coating to the entire roof area"));
        addContract(new ContractModel(12, "Electric wiring installation", "Bhaktapur", LocalDate.parse("2024-12-15"), LocalDate.parse("2024-12-22"), "Completed", 32000, "Sita Rai", "Install new electrical wiring throughout the building"));
        addContract(new ContractModel(13, "Interior painting", "Lalitpur", LocalDate.parse("2024-12-10"), LocalDate.parse("2024-12-18"), "Pending", 15000, "Gopal Shrestha", "Paint all interior walls with a weather-resistant paint"));
        addContract(new ContractModel(14, "Plumbing system upgrade", "Pokhara", LocalDate.parse("2024-12-14"), LocalDate.parse("2024-12-21"), "In Progress", 40000, "Krishna Maharjan", "Upgrade the plumbing system to ensure better water flow"));
        addContract(new ContractModel(15, "Floor tiling", "Chitwan", LocalDate.parse("2024-12-17"), LocalDate.parse("2024-12-24"), "Pending", 22000, "Ramesh Magar", "Install ceramic tiles on all floors"));

        HardwareList = new ArrayList();
        addStock(new HardwareModel(1, "Jagadamba steels", "Khanikhola enterprise", LocalDate.parse("2024-12-03"), 200000, 50, "meter", "Thickness:20 mm length :2 mter per pice"));
        addStock(new HardwareModel(2, "Shree Cement", "Bhairahawa Distributors", LocalDate.parse("2024-11-25"), 150000, 100, "bag", "Grade: OPC 43, Weight: 50 kg per bag"));
        addStock(new HardwareModel(3, "Nepal Paints", "Colors Nepal Pvt. Ltd.", LocalDate.parse("2024-10-15"), 75000, 30, "liter", "Finish: Matte, Color: White"));
        addStock(new HardwareModel(4, "Jagadamba Rods", "Biratnagar Steel Suppliers", LocalDate.parse("2024-09-30"), 300000, 20, "ton", "Diameter: 12 mm, Length: 12 meters per rod"));
        addStock(new HardwareModel(5, "Himalayan Bricks", "Kathmandu Bricks Traders", LocalDate.parse("2024-12-01"), 120000, 5000, "piece", "Size: Standard, Quality: Grade A"));
        addStock(new HardwareModel(6, "Pashupati Pipes", "Chitwan Pipe Industries", LocalDate.parse("2024-11-10"), 180000, 200, "meter", "Diameter: 4 inches, Material: PVC"));
        addStock(new HardwareModel(7, "Asian Tiles", "Lalitpur Tiles Mart", LocalDate.parse("2024-10-05"), 95000, 300, "square meter", "Type: Ceramic, Finish: Glossy"));
        addStock(new HardwareModel(8, "Everest Roofing Sheets", "Pokhara Metal Works", LocalDate.parse("2024-12-07"), 220000, 100, "sheet", "Length: 10 feet, Thickness: 0.5 mm"));
        addStock(new HardwareModel(9, "Panchakanya Pipes", "Hetauda Suppliers", LocalDate.parse("2024-11-15"), 175000, 150, "meter", "Diameter: 2 inches, Material: HDPE"));
        addStock(new HardwareModel(10, "Trishakti Cement", "Butwal Cement Distributors", LocalDate.parse("2024-11-20"), 130000, 120, "bag", "Grade: PPC, Weight: 50 kg per bag"));
        addStock(new HardwareModel(11, "Supreme TMT Steel Bars", "Steel Suppliers Pvt. Ltd.", LocalDate.parse("2024-11-22"), 800000, 50, "bundle", "Grade: Fe 500, Length: 12 meters per bar"));
        addStock(new HardwareModel(12, "Asian Paints", "Color World Distributors", LocalDate.parse("2024-11-25"), 250000, 200, "litre", "Type: Emulsion, Color: White"));
        addStock(new HardwareModel(13, "PVC Pipes", "Nepal Plastic Suppliers", LocalDate.parse("2024-11-18"), 90000, 300, "piece", "Diameter: 1 inch, Length: 6 meters per pipe"));
        addStock(new HardwareModel(14, "Ceramic Floor Tiles", "Tile World", LocalDate.parse("2024-11-15"), 120000, 80, "box", "Size: 600x600 mm, Finish: Glossy"));
        addStock(new HardwareModel(15, "Electrical Wire Coils", "Power Line Distributors", LocalDate.parse("2024-11-28"), 60000, 150, "coil", "Gauge: 2.5 mm, Length: 90 meters per coil"));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPage = new javax.swing.JPanel();
        bannerImg = new javax.swing.JLabel();
        loginCard = new RoundedPanel(50,Color.WHITE);
        loginTitleTxt = new javax.swing.JLabel();
        txtFieldUsername = new javax.swing.JTextField();
        txtFieldPassword = new javax.swing.JPasswordField();
        pnlLoginBtn = new RoundedPanel(50,new Color(56,183,53));
        loginTxt = new javax.swing.JLabel();
        MainLogo1 = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pnlMain = new javax.swing.JPanel();
        NavBar = new javax.swing.JPanel();
        MainLogo = new javax.swing.JLabel();
        lblSearchBtn = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        addProductBtn = new RoundedPanel(50,new Color(194,72,34));
        addProductText = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addContractBtn = new RoundedPanel(50,new Color(44,44,44));
        addProductText1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addStockBtn = new RoundedPanel(50,new Color(56,183,53));
        addProductText2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addStockBtn1 = new RoundedPanel(50,new Color(180,20,9));
        addProductText8 = new javax.swing.JLabel();
        dropDownSearch = new javax.swing.JComboBox<>();
        jSplitPane1 = new javax.swing.JSplitPane();
        SideMenu = new javax.swing.JPanel();
        DashBoardButton = new javax.swing.JPanel();
        MenuIcon = new javax.swing.JLabel();
        DashboardText = new javax.swing.JLabel();
        InStockButton = new javax.swing.JPanel();
        MenuIcon2 = new javax.swing.JLabel();
        InStockText = new javax.swing.JLabel();
        ContractButton = new javax.swing.JPanel();
        MenuIcon4 = new javax.swing.JLabel();
        ContractText = new javax.swing.JLabel();
        OrderButton = new javax.swing.JPanel();
        MenuIcon5 = new javax.swing.JLabel();
        OrderText = new javax.swing.JLabel();
        SupplierButton = new javax.swing.JPanel();
        MenuIcon6 = new javax.swing.JLabel();
        SupplierText = new javax.swing.JLabel();
        ProductButton = new javax.swing.JPanel();
        MenuIcon3 = new javax.swing.JLabel();
        ProductText = new javax.swing.JLabel();
        pnlCards = new javax.swing.JPanel();
        InstockPanel = new javax.swing.JScrollPane();
        pnlInStockMain = new javax.swing.JPanel();
        addStockPanel = new RoundedPanel(40,Color.white);
        addContractText4 = new javax.swing.JLabel();
        txtContractTitle4 = new javax.swing.JTextField();
        txtContractId4 = new javax.swing.JTextField();
        txtContractLocation4 = new javax.swing.JTextField();
        txtContractExpectedEndDate4 = new javax.swing.JTextField();
        txtContractStatus4 = new javax.swing.JTextField();
        txtContractValue4 = new javax.swing.JTextField();
        txtClientName4 = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtScopeOfWork4 = new javax.swing.JTextArea();
        addContractBtn5 = new RoundedPanel(50,new Color(44,44,44));
        addProductText7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        InstockListDisplay = new RoundedPanel(40,Color.WHITE);
        StockListText = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableStockList = new javax.swing.JTable();
        ProductPanel = new javax.swing.JScrollPane();
        pnlProductMain = new javax.swing.JPanel();
        pnlDataDisplayParent4 = new javax.swing.JPanel();
        addProductPanel = new RoundedPanel(40,Color.white);
        addProducttext = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        txtContractTitle3 = new javax.swing.JTextField();
        txtContractId3 = new javax.swing.JTextField();
        txtContractLocation3 = new javax.swing.JTextField();
        txtContractExpectedEndDate3 = new javax.swing.JTextField();
        txtContractStatus3 = new javax.swing.JTextField();
        txtContractValue3 = new javax.swing.JTextField();
        txtClientName3 = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtScopeOfWork3 = new javax.swing.JTextArea();
        addContractBtn4 = new RoundedPanel(50,new Color(44,44,44));
        addProductText6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ProductListDisplay = new RoundedPanel(40,Color.WHITE);
        productlistText = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableProductList = new javax.swing.JTable();
        OrdersPanel = new javax.swing.JScrollPane();
        pnlOrdersMain = new javax.swing.JPanel();
        pnlDataDisplayParent3 = new javax.swing.JPanel();
        addOrdersPanel = new RoundedPanel(40,Color.white);
        addOrdersText = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        txtContractTitle2 = new javax.swing.JTextField();
        txtContractId2 = new javax.swing.JTextField();
        txtContractLocation2 = new javax.swing.JTextField();
        txtContractExpectedEndDate2 = new javax.swing.JTextField();
        txtContractStatus2 = new javax.swing.JTextField();
        txtContractValue2 = new javax.swing.JTextField();
        txtClientName2 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtScopeOfWork2 = new javax.swing.JTextArea();
        addContractBtn3 = new RoundedPanel(50,new Color(44,44,44));
        addProductText5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ordersListDisplay = new RoundedPanel(40,Color.WHITE);
        OrdersList = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableOrdersList = new javax.swing.JTable();
        SuppliersPanel = new javax.swing.JScrollPane();
        pnlSupplierMain = new javax.swing.JPanel();
        pnlDataDisplayParent2 = new javax.swing.JPanel();
        addSupplierPanel = new RoundedPanel(40,Color.white);
        addContractText1 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtContractTitle1 = new javax.swing.JTextField();
        txtContractId1 = new javax.swing.JTextField();
        txtContractLocation1 = new javax.swing.JTextField();
        txtContractExpectedEndDate1 = new javax.swing.JTextField();
        txtContractStatus1 = new javax.swing.JTextField();
        txtContractValue1 = new javax.swing.JTextField();
        txtClientName1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtScopeOfWork1 = new javax.swing.JTextArea();
        addContractBtn2 = new RoundedPanel(50,new Color(44,44,44));
        addProductText4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SupplierListDisplay = new RoundedPanel(40,Color.WHITE);
        SupplierListText = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableSupplierList = new javax.swing.JTable();
        ContractPanel = new javax.swing.JScrollPane();
        pnlContractMain = new javax.swing.JPanel();
        pnlDataDisplayParent1 = new javax.swing.JPanel();
        addContractsPanel = new RoundedPanel(40,Color.white);
        addContractText = new javax.swing.JLabel();
        txtContractTitle = new javax.swing.JTextField();
        txtContractId = new javax.swing.JTextField();
        txtContractLocation = new javax.swing.JTextField();
        txtContractExpectedEndDate = new javax.swing.JTextField();
        txtContractStatus = new javax.swing.JTextField();
        txtContractValue = new javax.swing.JTextField();
        txtClientName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtScopeOfWork = new javax.swing.JTextArea();
        addContractBtnContractPanel = new RoundedPanel(50,new Color(194,72,34));
        addContractTextPanel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtContractStartDate = new javax.swing.JTextField();
        updateContractBtnContractPanel = new RoundedPanel(50,new Color(44,44,44));
        updateContractText = new javax.swing.JLabel();
        deleteContractBtnContractPanel = new RoundedPanel(50,new Color(180,20,9));
        deleteContractText = new javax.swing.JLabel();
        ClearDataBtn = new RoundedPanel(50,new Color(0,0,0
        ));
        clearDataTxt = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        PendingContractsDisplay2 = new RoundedPanel(40,Color.WHITE);
        totalPurchaseText6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableContractDashboard1 = new javax.swing.JTable();
        sortDropDown1 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        DashBoardPanel = new javax.swing.JScrollPane();
        DashBoardScreen = new javax.swing.JPanel();
        pnlDisplayParent = new javax.swing.JPanel();
        displayPanel3 = new RoundedPanel(40,Color.WHITE);
        revenueText6 = new javax.swing.JLabel();
        totalPurchaseText2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        displayPanel1 = new RoundedPanel(40,Color.WHITE);
        revenueText3 = new javax.swing.JLabel();
        totalPurchaseText = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        displayPanel2 = new RoundedPanel(40,Color.WHITE);
        revenueText5 = new javax.swing.JLabel();
        totalPurchaseText3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pnlDataDisplayParent = new javax.swing.JPanel();
        PendingContractsDisplay1 = new RoundedPanel(40,Color.WHITE);
        totalPurchaseText4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableContractDashboard = new javax.swing.JTable();
        sortDropDown = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        NewOrdersDisplayPanel = new RoundedPanel(40,Color.WHITE);
        totalPurchaseText1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane12 = new javax.swing.JScrollPane();
        tableNewOrdersDashboard = new javax.swing.JTable();
        LatestStockDisplayPanel1 = new RoundedPanel(40,Color.WHITE);
        totalPurchaseText5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane13 = new javax.swing.JScrollPane();
        tableLatestStockDashboard = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(44, 44, 44));
        setMinimumSize(new java.awt.Dimension(1440, 1024));
        setName("Dashboard"); // NOI18N

        loginPage.setBackground(new java.awt.Color(239, 239, 239));

        bannerImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bannerImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventoryApplication/resources/website logo (2) 1.png"))); // NOI18N

        loginCard.setBackground(null
        );

        loginTitleTxt.setBackground(new java.awt.Color(194, 72, 34));
        loginTitleTxt.setFont(new java.awt.Font("Poppins Medium", 1, 48)); // NOI18N
        loginTitleTxt.setForeground(new java.awt.Color(194, 72, 34));
        loginTitleTxt.setText("Login To Your Account");

        txtFieldUsername.setBackground(new java.awt.Color(239, 239, 239));
        txtFieldUsername.setBorder(null);
        txtFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldUsernameActionPerformed(evt);
            }
        });

        txtFieldPassword.setBackground(new java.awt.Color(239, 239, 239));
        txtFieldPassword.setBorder(null);

        pnlLoginBtn.setBackground(null);
        pnlLoginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlLoginBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlLoginBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlLoginBtnMouseExited(evt);
            }
        });

        loginTxt.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        loginTxt.setForeground(new java.awt.Color(255, 255, 255));
        loginTxt.setText("Sign In");

        javax.swing.GroupLayout pnlLoginBtnLayout = new javax.swing.GroupLayout(pnlLoginBtn);
        pnlLoginBtn.setLayout(pnlLoginBtnLayout);
        pnlLoginBtnLayout.setHorizontalGroup(
            pnlLoginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginBtnLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(loginTxt)
                .addGap(24, 24, 24))
        );
        pnlLoginBtnLayout.setVerticalGroup(
            pnlLoginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        MainLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventoryApplication/resources/MainLogo.png"))); // NOI18N
        MainLogo1.setText("jLabel1");

        lblMessage.setFont(new java.awt.Font("Poppins Light", 1, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(204, 0, 51));

        jLabel16.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        jLabel16.setText("Password:");

        jLabel17.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        jLabel17.setText("Username:");

        javax.swing.GroupLayout loginCardLayout = new javax.swing.GroupLayout(loginCard);
        loginCard.setLayout(loginCardLayout);
        loginCardLayout.setHorizontalGroup(
            loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginCardLayout.createSequentialGroup()
                .addGroup(loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginCardLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginTitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(loginCardLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(MainLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        loginCardLayout.setVerticalGroup(
            loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginCardLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(MainLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginTitleTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel17)
                .addGap(4, 4, 4)
                .addComponent(txtFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(pnlLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout loginPageLayout = new javax.swing.GroupLayout(loginPage);
        loginPage.setLayout(loginPageLayout);
        loginPageLayout.setHorizontalGroup(
            loginPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPageLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(loginCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bannerImg)
                .addContainerGap(524, Short.MAX_VALUE))
        );
        loginPageLayout.setVerticalGroup(
            loginPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPageLayout.createSequentialGroup()
                .addComponent(bannerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1145, Short.MAX_VALUE))
            .addGroup(loginPageLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(loginCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NavBar.setBackground(new java.awt.Color(255, 255, 255));

        MainLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventoryApplication/resources/MainLogo.png"))); // NOI18N
        MainLogo.setText("jLabel1");

        lblSearchBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventoryApplication/resources/searchIcon.png"))); // NOI18N
        lblSearchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchBtnMouseClicked(evt);
            }
        });

        searchBar.setEditable(true);
        searchBar.setBackground(new java.awt.Color(252, 252, 252));
        searchBar.setColumns(10);
        searchBar.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        searchBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));
        searchBar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchBarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchBarFocusLost(evt);
            }
        });
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });

        addProductBtn.setBackground(null);
        addProductBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addProductBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addProductBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addProductBtnMouseExited(evt);
            }
        });

        addProductText.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        addProductText.setForeground(new java.awt.Color(255, 255, 255));
        addProductText.setText("   Add Product");

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("+");

        javax.swing.GroupLayout addProductBtnLayout = new javax.swing.GroupLayout(addProductBtn);
        addProductBtn.setLayout(addProductBtnLayout);
        addProductBtnLayout.setHorizontalGroup(
            addProductBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addProductBtnLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addProductText, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        addProductBtnLayout.setVerticalGroup(
            addProductBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(addProductText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        addContractBtn.setBackground(null);
        addContractBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addContractBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addContractBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addContractBtnMouseExited(evt);
            }
        });

        addProductText1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        addProductText1.setForeground(new java.awt.Color(255, 255, 255));
        addProductText1.setText("   Add Contract");

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("+");

        javax.swing.GroupLayout addContractBtnLayout = new javax.swing.GroupLayout(addContractBtn);
        addContractBtn.setLayout(addContractBtnLayout);
        addContractBtnLayout.setHorizontalGroup(
            addContractBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addContractBtnLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addProductText1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        addContractBtnLayout.setVerticalGroup(
            addContractBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(addProductText1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        addStockBtn.setBackground(null);
        addStockBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addStockBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addStockBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addStockBtnMouseExited(evt);
            }
        });

        addProductText2.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        addProductText2.setForeground(new java.awt.Color(255, 255, 255));
        addProductText2.setText("   Add Stock");

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("+");

        javax.swing.GroupLayout addStockBtnLayout = new javax.swing.GroupLayout(addStockBtn);
        addStockBtn.setLayout(addStockBtnLayout);
        addStockBtnLayout.setHorizontalGroup(
            addStockBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addStockBtnLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addProductText2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        addStockBtnLayout.setVerticalGroup(
            addStockBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(addProductText2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        addStockBtn1.setBackground(null);
        addStockBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addStockBtn1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addStockBtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addStockBtn1MouseExited(evt);
            }
        });

        addProductText8.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        addProductText8.setForeground(new java.awt.Color(255, 255, 255));
        addProductText8.setText("Log Out");

        javax.swing.GroupLayout addStockBtn1Layout = new javax.swing.GroupLayout(addStockBtn1);
        addStockBtn1.setLayout(addStockBtn1Layout);
        addStockBtn1Layout.setHorizontalGroup(
            addStockBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addStockBtn1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(addProductText8)
                .addGap(24, 24, 24))
        );
        addStockBtn1Layout.setVerticalGroup(
            addStockBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addProductText8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        dropDownSearch.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        dropDownSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Models", "Contract", "Stock", "Order", "Product","supplier" }));
        dropDownSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));
        dropDownSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dropDownSearchMouseClicked(evt);
            }
        });
        dropDownSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropDownSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NavBarLayout = new javax.swing.GroupLayout(NavBar);
        NavBar.setLayout(NavBarLayout);
        NavBarLayout.setHorizontalGroup(
            NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dropDownSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(addProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(addContractBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(addStockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(addStockBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(620, Short.MAX_VALUE))
        );
        NavBarLayout.setVerticalGroup(
            NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NavBarLayout.createSequentialGroup()
                        .addGroup(NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addStockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addContractBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addStockBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblSearchBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dropDownSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NavBarLayout.createSequentialGroup()
                        .addGroup(NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NavBarLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(MainLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))))
        );

        pnlMain.add(NavBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 110));

        jSplitPane1.setDividerSize(0);

        SideMenu.setBackground(new java.awt.Color(37, 38, 58));
        SideMenu.setMaximumSize(new java.awt.Dimension(113, 934));
        SideMenu.setMinimumSize(new java.awt.Dimension(113, 934));
        SideMenu.setName("DashBoardIcon"); // NOI18N
        SideMenu.setPreferredSize(new java.awt.Dimension(113, 934));

        DashBoardButton.setBackground(new java.awt.Color(37, 38, 58));
        DashBoardButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashBoardButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashBoardButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashBoardButtonMouseExited(evt);
            }
        });

        MenuIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventoryApplication/resources/InStockIcon.png"))); // NOI18N
        MenuIcon.setText("jLabel1");

        DashboardText.setBackground(new java.awt.Color(255, 255, 255));
        DashboardText.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        DashboardText.setForeground(new java.awt.Color(255, 255, 255));
        DashboardText.setText("Dashboard");

        javax.swing.GroupLayout DashBoardButtonLayout = new javax.swing.GroupLayout(DashBoardButton);
        DashBoardButton.setLayout(DashBoardButtonLayout);
        DashBoardButtonLayout.setHorizontalGroup(
            DashBoardButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardButtonLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(MenuIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DashboardText, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        DashBoardButtonLayout.setVerticalGroup(
            DashBoardButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardButtonLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(MenuIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DashboardText)
                .addGap(6, 6, 6))
        );

        InStockButton.setBackground(new java.awt.Color(37, 38, 58));
        InStockButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InStockButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InStockButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InStockButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                InStockButtonMousePressed(evt);
            }
        });

        MenuIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventoryApplication/resources/InStockIcon.png"))); // NOI18N
        MenuIcon2.setText("jLabel1");

        InStockText.setBackground(new java.awt.Color(255, 255, 255));
        InStockText.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        InStockText.setForeground(new java.awt.Color(255, 255, 255));
        InStockText.setText("In-Stock");

        javax.swing.GroupLayout InStockButtonLayout = new javax.swing.GroupLayout(InStockButton);
        InStockButton.setLayout(InStockButtonLayout);
        InStockButtonLayout.setHorizontalGroup(
            InStockButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InStockButtonLayout.createSequentialGroup()
                .addGroup(InStockButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InStockButtonLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(InStockText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InStockButtonLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(MenuIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        InStockButtonLayout.setVerticalGroup(
            InStockButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InStockButtonLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(MenuIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InStockText)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        ContractButton.setBackground(new java.awt.Color(37, 38, 58));
        ContractButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ContractButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ContractButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ContractButtonMouseExited(evt);
            }
        });

        MenuIcon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventoryApplication/resources/InStockIcon.png"))); // NOI18N
        MenuIcon4.setText("jLabel1");

        ContractText.setBackground(new java.awt.Color(255, 255, 255));
        ContractText.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        ContractText.setForeground(new java.awt.Color(255, 255, 255));
        ContractText.setText("Contracts");

        javax.swing.GroupLayout ContractButtonLayout = new javax.swing.GroupLayout(ContractButton);
        ContractButton.setLayout(ContractButtonLayout);
        ContractButtonLayout.setHorizontalGroup(
            ContractButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContractButtonLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(ContractButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContractText)
                    .addGroup(ContractButtonLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(MenuIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        ContractButtonLayout.setVerticalGroup(
            ContractButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContractButtonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(MenuIcon4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContractText)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        OrderButton.setBackground(new java.awt.Color(37, 38, 58));
        OrderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OrderButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OrderButtonMouseExited(evt);
            }
        });

        MenuIcon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventoryApplication/resources/InStockIcon.png"))); // NOI18N
        MenuIcon5.setText("jLabel1");

        OrderText.setBackground(new java.awt.Color(255, 255, 255));
        OrderText.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        OrderText.setForeground(new java.awt.Color(255, 255, 255));
        OrderText.setText("Orders");

        javax.swing.GroupLayout OrderButtonLayout = new javax.swing.GroupLayout(OrderButton);
        OrderButton.setLayout(OrderButtonLayout);
        OrderButtonLayout.setHorizontalGroup(
            OrderButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderButtonLayout.createSequentialGroup()
                .addGroup(OrderButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OrderButtonLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(MenuIcon5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(OrderButtonLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(OrderText)))
                .addGap(0, 37, Short.MAX_VALUE))
        );
        OrderButtonLayout.setVerticalGroup(
            OrderButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderButtonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(MenuIcon5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrderText)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        SupplierButton.setBackground(new java.awt.Color(37, 38, 58));
        SupplierButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupplierButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SupplierButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SupplierButtonMouseExited(evt);
            }
        });

        MenuIcon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventoryApplication/resources/InStockIcon.png"))); // NOI18N
        MenuIcon6.setText("jLabel1");

        SupplierText.setBackground(new java.awt.Color(255, 255, 255));
        SupplierText.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        SupplierText.setForeground(new java.awt.Color(255, 255, 255));
        SupplierText.setText("Suppliers");

        javax.swing.GroupLayout SupplierButtonLayout = new javax.swing.GroupLayout(SupplierButton);
        SupplierButton.setLayout(SupplierButtonLayout);
        SupplierButtonLayout.setHorizontalGroup(
            SupplierButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SupplierButtonLayout.createSequentialGroup()
                .addGroup(SupplierButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SupplierButtonLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(MenuIcon6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SupplierButtonLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(SupplierText)))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        SupplierButtonLayout.setVerticalGroup(
            SupplierButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SupplierButtonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(MenuIcon6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SupplierText)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        ProductButton.setBackground(new java.awt.Color(37, 38, 58));
        ProductButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProductButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProductButtonMouseExited(evt);
            }
        });

        MenuIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventoryApplication/resources/InStockIcon.png"))); // NOI18N
        MenuIcon3.setText("jLabel1");

        ProductText.setBackground(new java.awt.Color(255, 255, 255));
        ProductText.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        ProductText.setForeground(new java.awt.Color(255, 255, 255));
        ProductText.setText("Products");

        javax.swing.GroupLayout ProductButtonLayout = new javax.swing.GroupLayout(ProductButton);
        ProductButton.setLayout(ProductButtonLayout);
        ProductButtonLayout.setHorizontalGroup(
            ProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductButtonLayout.createSequentialGroup()
                .addGroup(ProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductButtonLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(MenuIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProductButtonLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(ProductText)))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        ProductButtonLayout.setVerticalGroup(
            ProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductButtonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(MenuIcon3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductText)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SideMenuLayout = new javax.swing.GroupLayout(SideMenu);
        SideMenu.setLayout(SideMenuLayout);
        SideMenuLayout.setHorizontalGroup(
            SideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashBoardButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(InStockButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ContractButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(OrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SupplierButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ProductButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SideMenuLayout.setVerticalGroup(
            SideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SideMenuLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(DashBoardButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(InStockButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(ContractButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(ProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(OrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(SupplierButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1296, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(SideMenu);

        pnlCards.setLayout(new java.awt.CardLayout());

        InstockPanel.setBorder(null);

        pnlInStockMain.setBackground(new java.awt.Color(237, 240, 242));

        addStockPanel.setBackground(null);

        addContractText4.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        addContractText4.setForeground(new java.awt.Color(194, 72, 34));
        addContractText4.setText("Add Stock:");

        txtContractTitle4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Title:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractTitle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractTitle4ActionPerformed(evt);
            }
        });

        txtContractId4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Id:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractId4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractId4ActionPerformed(evt);
            }
        });

        txtContractLocation4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Location:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractLocation4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractLocation4ActionPerformed(evt);
            }
        });

        txtContractExpectedEndDate4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Expected End Date:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractExpectedEndDate4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractExpectedEndDate4ActionPerformed(evt);
            }
        });

        txtContractStatus4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Status:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractStatus4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractStatus4ActionPerformed(evt);
            }
        });

        txtContractValue4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Value:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractValue4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractValue4ActionPerformed(evt);
            }
        });

        txtClientName4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Client Name:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtClientName4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClientName4ActionPerformed(evt);
            }
        });

        txtScopeOfWork4.setColumns(20);
        txtScopeOfWork4.setRows(5);
        txtScopeOfWork4.setBorder(null);
        jScrollPane10.setViewportView(txtScopeOfWork4);

        addContractBtn5.setBackground(null);
        addContractBtn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addContractBtn5MouseClicked(evt);
            }
        });

        addProductText7.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        addProductText7.setForeground(new java.awt.Color(255, 255, 255));
        addProductText7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addProductText7.setText("   Add Stock");

        javax.swing.GroupLayout addContractBtn5Layout = new javax.swing.GroupLayout(addContractBtn5);
        addContractBtn5.setLayout(addContractBtn5Layout);
        addContractBtn5Layout.setHorizontalGroup(
            addContractBtn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addContractBtn5Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(addProductText7, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        addContractBtn5Layout.setVerticalGroup(
            addContractBtn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addProductText7, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel11.setText("Scope Of Work:");

        jSeparator14.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator14.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout addStockPanelLayout = new javax.swing.GroupLayout(addStockPanel);
        addStockPanel.setLayout(addStockPanelLayout);
        addStockPanelLayout.setHorizontalGroup(
            addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStockPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addStockPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(addStockPanelLayout.createSequentialGroup()
                        .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(addStockPanelLayout.createSequentialGroup()
                                .addComponent(txtContractExpectedEndDate4, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtContractValue4, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addStockPanelLayout.createSequentialGroup()
                                .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtContractId4, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                    .addComponent(txtContractLocation4)
                                    .addComponent(addContractText4, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addStockPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtContractStatus4, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(addStockPanelLayout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(txtContractTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                        .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClientName4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addContractBtn5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36))))
        );
        addStockPanelLayout.setVerticalGroup(
            addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addStockPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(addContractText4)
                .addGap(18, 18, 18)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addStockPanelLayout.createSequentialGroup()
                        .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContractId4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContractTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClientName4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContractLocation4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContractStatus4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addStockPanelLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addStockPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContractExpectedEndDate4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContractValue4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addStockPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addContractBtn5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        InstockListDisplay.setBackground(null);
        InstockListDisplay.setBorder(null);
        InstockListDisplay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StockListText.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        StockListText.setForeground(new java.awt.Color(194, 72, 34));
        StockListText.setText("Stock List:");
        InstockListDisplay.add(StockListText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 271, -1));

        jSeparator13.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator13.setForeground(new java.awt.Color(51, 51, 51));
        InstockListDisplay.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1190, 10));

        jScrollPane11.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jScrollPane11.setViewportBorder(null);

        tableStockList.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        tableStockList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Id", "Product Name", "Supplier Name", "Date of Entry ", "Price", "Quantity", "Unit", "Measurement Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableStockList.setGridColor(new java.awt.Color(215, 215, 215));
        tableStockList.setRowHeight(25);
        tableStockList.setRowMargin(5);
        tableStockList.setSelectionBackground(new java.awt.Color(194, 72, 34));
        tableStockList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableStockList.setShowGrid(false);
        tableStockList.setShowHorizontalLines(true);
        jScrollPane11.setViewportView(tableStockList);
        if (tableStockList.getColumnModel().getColumnCount() > 0) {
            tableStockList.getColumnModel().getColumn(0).setResizable(false);
            tableStockList.getColumnModel().getColumn(1).setResizable(false);
            tableStockList.getColumnModel().getColumn(1).setPreferredWidth(250);
            tableStockList.getColumnModel().getColumn(2).setResizable(false);
            tableStockList.getColumnModel().getColumn(2).setPreferredWidth(250);
            tableStockList.getColumnModel().getColumn(3).setResizable(false);
            tableStockList.getColumnModel().getColumn(4).setResizable(false);
            tableStockList.getColumnModel().getColumn(5).setResizable(false);
            tableStockList.getColumnModel().getColumn(6).setResizable(false);
            tableStockList.getColumnModel().getColumn(7).setResizable(false);
            tableStockList.getColumnModel().getColumn(7).setPreferredWidth(250);
        }

        InstockListDisplay.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1200, 180));

        javax.swing.GroupLayout pnlInStockMainLayout = new javax.swing.GroupLayout(pnlInStockMain);
        pnlInStockMain.setLayout(pnlInStockMainLayout);
        pnlInStockMainLayout.setHorizontalGroup(
            pnlInStockMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInStockMainLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlInStockMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(InstockListDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 1239, Short.MAX_VALUE)
                    .addComponent(addStockPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlInStockMainLayout.setVerticalGroup(
            pnlInStockMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInStockMainLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(InstockListDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(addStockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1749, Short.MAX_VALUE))
        );

        InstockPanel.setViewportView(pnlInStockMain);

        pnlCards.add(InstockPanel, "card3");

        ProductPanel.setBorder(null);

        pnlProductMain.setBackground(new java.awt.Color(237, 240, 242));

        pnlDataDisplayParent4.setBackground(new java.awt.Color(237, 240, 242));

        javax.swing.GroupLayout pnlDataDisplayParent4Layout = new javax.swing.GroupLayout(pnlDataDisplayParent4);
        pnlDataDisplayParent4.setLayout(pnlDataDisplayParent4Layout);
        pnlDataDisplayParent4Layout.setHorizontalGroup(
            pnlDataDisplayParent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1250, Short.MAX_VALUE)
        );
        pnlDataDisplayParent4Layout.setVerticalGroup(
            pnlDataDisplayParent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        addProductPanel.setBackground(null);

        addProducttext.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        addProducttext.setForeground(new java.awt.Color(194, 72, 34));
        addProducttext.setText("Add Product:");

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));

        txtContractTitle3.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtContractTitle3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Title:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractTitle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractTitle3ActionPerformed(evt);
            }
        });

        txtContractId3.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtContractId3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Id:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractId3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractId3ActionPerformed(evt);
            }
        });

        txtContractLocation3.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtContractLocation3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Location:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractLocation3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractLocation3ActionPerformed(evt);
            }
        });

        txtContractExpectedEndDate3.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtContractExpectedEndDate3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Expected End Date:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractExpectedEndDate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractExpectedEndDate3ActionPerformed(evt);
            }
        });

        txtContractStatus3.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtContractStatus3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Status:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractStatus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractStatus3ActionPerformed(evt);
            }
        });

        txtContractValue3.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtContractValue3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Value:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractValue3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractValue3ActionPerformed(evt);
            }
        });

        txtClientName3.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtClientName3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Client Name:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtClientName3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClientName3ActionPerformed(evt);
            }
        });

        txtScopeOfWork3.setColumns(20);
        txtScopeOfWork3.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtScopeOfWork3.setRows(5);
        txtScopeOfWork3.setBorder(null);
        jScrollPane8.setViewportView(txtScopeOfWork3);

        addContractBtn4.setBackground(null);
        addContractBtn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addContractBtn4MouseClicked(evt);
            }
        });

        addProductText6.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        addProductText6.setForeground(new java.awt.Color(255, 255, 255));
        addProductText6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addProductText6.setText("   Add Contract");

        javax.swing.GroupLayout addContractBtn4Layout = new javax.swing.GroupLayout(addContractBtn4);
        addContractBtn4.setLayout(addContractBtn4Layout);
        addContractBtn4Layout.setHorizontalGroup(
            addContractBtn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addContractBtn4Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(addProductText6, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        addContractBtn4Layout.setVerticalGroup(
            addContractBtn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addProductText6, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel10.setText("Scope Of Work:");

        javax.swing.GroupLayout addProductPanelLayout = new javax.swing.GroupLayout(addProductPanel);
        addProductPanel.setLayout(addProductPanelLayout);
        addProductPanelLayout.setHorizontalGroup(
            addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addProductPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator10)
                    .addGroup(addProductPanelLayout.createSequentialGroup()
                        .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(addProductPanelLayout.createSequentialGroup()
                                .addComponent(txtContractExpectedEndDate3, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtContractValue3, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addProductPanelLayout.createSequentialGroup()
                                .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtContractId3, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                    .addComponent(txtContractLocation3)
                                    .addComponent(addProducttext, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addProductPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtContractStatus3, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(addProductPanelLayout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(txtContractTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClientName3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addContractBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(36, 36, 36))
        );
        addProductPanelLayout.setVerticalGroup(
            addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addProductPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(addProducttext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addProductPanelLayout.createSequentialGroup()
                        .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContractId3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContractTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClientName3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContractLocation3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContractStatus3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addProductPanelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addProductPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContractExpectedEndDate3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContractValue3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addProductPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addContractBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        ProductListDisplay.setBackground(null);
        ProductListDisplay.setBorder(null);
        ProductListDisplay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productlistText.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        productlistText.setForeground(new java.awt.Color(194, 72, 34));
        productlistText.setText("Product List:");
        ProductListDisplay.add(productlistText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 271, -1));

        jSeparator11.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator11.setForeground(new java.awt.Color(51, 51, 51));
        ProductListDisplay.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1200, 10));

        jScrollPane9.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jScrollPane9.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N

        tableProductList.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        tableProductList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Contract Id", "Contract Title", "Contract Location", "Contract Start Date", "Contract End Date", "Contract Status", "Contract value ", "Client Name", "Scope Of Work"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableProductList.setGridColor(new java.awt.Color(215, 215, 215));
        tableProductList.setRowHeight(25);
        tableProductList.setRowMargin(5);
        tableProductList.setSelectionBackground(new java.awt.Color(194, 72, 34));
        tableProductList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableProductList.setShowHorizontalLines(true);
        jScrollPane9.setViewportView(tableProductList);

        ProductListDisplay.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1200, 180));

        javax.swing.GroupLayout pnlProductMainLayout = new javax.swing.GroupLayout(pnlProductMain);
        pnlProductMain.setLayout(pnlProductMainLayout);
        pnlProductMainLayout.setHorizontalGroup(
            pnlProductMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductMainLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlProductMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProductListDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)
                    .addComponent(addProductPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(pnlProductMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlProductMainLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDataDisplayParent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlProductMainLayout.setVerticalGroup(
            pnlProductMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductMainLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(ProductListDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(addProductPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1749, Short.MAX_VALUE))
            .addGroup(pnlProductMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlProductMainLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDataDisplayParent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        ProductPanel.setViewportView(pnlProductMain);

        pnlCards.add(ProductPanel, "card4");

        OrdersPanel.setBorder(null);

        pnlOrdersMain.setBackground(new java.awt.Color(237, 240, 242));

        pnlDataDisplayParent3.setBackground(new java.awt.Color(237, 240, 242));

        javax.swing.GroupLayout pnlDataDisplayParent3Layout = new javax.swing.GroupLayout(pnlDataDisplayParent3);
        pnlDataDisplayParent3.setLayout(pnlDataDisplayParent3Layout);
        pnlDataDisplayParent3Layout.setHorizontalGroup(
            pnlDataDisplayParent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1250, Short.MAX_VALUE)
        );
        pnlDataDisplayParent3Layout.setVerticalGroup(
            pnlDataDisplayParent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        addOrdersPanel.setBackground(null);

        addOrdersText.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        addOrdersText.setForeground(new java.awt.Color(194, 72, 34));
        addOrdersText.setText("Add Orders:");

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));

        txtContractTitle2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Title:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractTitle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractTitle2ActionPerformed(evt);
            }
        });

        txtContractId2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Id:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractId2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractId2ActionPerformed(evt);
            }
        });

        txtContractLocation2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Location:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractLocation2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractLocation2ActionPerformed(evt);
            }
        });

        txtContractExpectedEndDate2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Expected End Date:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractExpectedEndDate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractExpectedEndDate2ActionPerformed(evt);
            }
        });

        txtContractStatus2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Status:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractStatus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractStatus2ActionPerformed(evt);
            }
        });

        txtContractValue2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Value:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractValue2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractValue2ActionPerformed(evt);
            }
        });

        txtClientName2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Client Name:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtClientName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClientName2ActionPerformed(evt);
            }
        });

        txtScopeOfWork2.setColumns(20);
        txtScopeOfWork2.setRows(5);
        txtScopeOfWork2.setBorder(null);
        jScrollPane6.setViewportView(txtScopeOfWork2);

        addContractBtn3.setBackground(null);
        addContractBtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addContractBtn3MouseClicked(evt);
            }
        });

        addProductText5.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        addProductText5.setForeground(new java.awt.Color(255, 255, 255));
        addProductText5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addProductText5.setText("   Add Contract");

        javax.swing.GroupLayout addContractBtn3Layout = new javax.swing.GroupLayout(addContractBtn3);
        addContractBtn3.setLayout(addContractBtn3Layout);
        addContractBtn3Layout.setHorizontalGroup(
            addContractBtn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addContractBtn3Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(addProductText5, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        addContractBtn3Layout.setVerticalGroup(
            addContractBtn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addProductText5, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel9.setText("Scope Of Work:");

        javax.swing.GroupLayout addOrdersPanelLayout = new javax.swing.GroupLayout(addOrdersPanel);
        addOrdersPanel.setLayout(addOrdersPanelLayout);
        addOrdersPanelLayout.setHorizontalGroup(
            addOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addOrdersPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(addOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator8)
                    .addGroup(addOrdersPanelLayout.createSequentialGroup()
                        .addGroup(addOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(addOrdersPanelLayout.createSequentialGroup()
                                .addComponent(txtContractExpectedEndDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtContractValue2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addOrdersPanelLayout.createSequentialGroup()
                                .addGroup(addOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtContractId2, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                    .addComponent(txtContractLocation2)
                                    .addComponent(addOrdersText, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(addOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addOrdersPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtContractStatus2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(addOrdersPanelLayout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(txtContractTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(addOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClientName2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addContractBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(36, 36, 36))
        );
        addOrdersPanelLayout.setVerticalGroup(
            addOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addOrdersPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(addOrdersText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(addOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addOrdersPanelLayout.createSequentialGroup()
                        .addGroup(addOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContractId2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContractTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClientName2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(addOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContractLocation2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContractStatus2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addOrdersPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(addOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addOrdersPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(addOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContractExpectedEndDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContractValue2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addOrdersPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addContractBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        ordersListDisplay.setBackground(null);
        ordersListDisplay.setBorder(null);
        ordersListDisplay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OrdersList.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        OrdersList.setForeground(new java.awt.Color(194, 72, 34));
        OrdersList.setText("Orders List:");
        ordersListDisplay.add(OrdersList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 271, -1));

        jSeparator9.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator9.setForeground(new java.awt.Color(51, 51, 51));
        ordersListDisplay.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1180, 10));

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        tableOrdersList.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        tableOrdersList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Contract Id", "Contract Title", "Contract Location", "Contract Start Date", "Contract End Date", "Contract Status", "Contract value ", "Client Name", "Scope Of Work"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableOrdersList.setGridColor(new java.awt.Color(215, 215, 215));
        tableOrdersList.setSelectionBackground(new java.awt.Color(194, 72, 34));
        tableOrdersList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableOrdersList.setShowHorizontalLines(true);
        jScrollPane7.setViewportView(tableOrdersList);

        ordersListDisplay.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1210, 180));

        javax.swing.GroupLayout pnlOrdersMainLayout = new javax.swing.GroupLayout(pnlOrdersMain);
        pnlOrdersMain.setLayout(pnlOrdersMainLayout);
        pnlOrdersMainLayout.setHorizontalGroup(
            pnlOrdersMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrdersMainLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlOrdersMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ordersListDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 1249, Short.MAX_VALUE)
                    .addComponent(addOrdersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(592, Short.MAX_VALUE))
            .addGroup(pnlOrdersMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlOrdersMainLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDataDisplayParent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlOrdersMainLayout.setVerticalGroup(
            pnlOrdersMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrdersMainLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(ordersListDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(addOrdersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1749, Short.MAX_VALUE))
            .addGroup(pnlOrdersMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlOrdersMainLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDataDisplayParent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        OrdersPanel.setViewportView(pnlOrdersMain);

        pnlCards.add(OrdersPanel, "card5");

        SuppliersPanel.setBorder(null);

        pnlSupplierMain.setBackground(new java.awt.Color(237, 240, 242));

        pnlDataDisplayParent2.setBackground(new java.awt.Color(237, 240, 242));

        javax.swing.GroupLayout pnlDataDisplayParent2Layout = new javax.swing.GroupLayout(pnlDataDisplayParent2);
        pnlDataDisplayParent2.setLayout(pnlDataDisplayParent2Layout);
        pnlDataDisplayParent2Layout.setHorizontalGroup(
            pnlDataDisplayParent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1250, Short.MAX_VALUE)
        );
        pnlDataDisplayParent2Layout.setVerticalGroup(
            pnlDataDisplayParent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        addSupplierPanel.setBackground(null);

        addContractText1.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        addContractText1.setForeground(new java.awt.Color(194, 72, 34));
        addContractText1.setText("Add Supplier:");

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));

        txtContractTitle1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Title:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractTitle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractTitle1ActionPerformed(evt);
            }
        });

        txtContractId1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Id:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractId1ActionPerformed(evt);
            }
        });

        txtContractLocation1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Location:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractLocation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractLocation1ActionPerformed(evt);
            }
        });

        txtContractExpectedEndDate1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Expected End Date:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractExpectedEndDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractExpectedEndDate1ActionPerformed(evt);
            }
        });

        txtContractStatus1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Status:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractStatus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractStatus1ActionPerformed(evt);
            }
        });

        txtContractValue1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Value:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractValue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractValue1ActionPerformed(evt);
            }
        });

        txtClientName1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Client Name:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtClientName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClientName1ActionPerformed(evt);
            }
        });

        txtScopeOfWork1.setColumns(20);
        txtScopeOfWork1.setRows(5);
        txtScopeOfWork1.setBorder(null);
        jScrollPane2.setViewportView(txtScopeOfWork1);

        addContractBtn2.setBackground(null);
        addContractBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addContractBtn2MouseClicked(evt);
            }
        });

        addProductText4.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        addProductText4.setForeground(new java.awt.Color(255, 255, 255));
        addProductText4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addProductText4.setText("   Add Contract");

        javax.swing.GroupLayout addContractBtn2Layout = new javax.swing.GroupLayout(addContractBtn2);
        addContractBtn2.setLayout(addContractBtn2Layout);
        addContractBtn2Layout.setHorizontalGroup(
            addContractBtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addContractBtn2Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(addProductText4, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        addContractBtn2Layout.setVerticalGroup(
            addContractBtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addProductText4, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel8.setText("Scope Of Work:");

        javax.swing.GroupLayout addSupplierPanelLayout = new javax.swing.GroupLayout(addSupplierPanel);
        addSupplierPanel.setLayout(addSupplierPanelLayout);
        addSupplierPanelLayout.setHorizontalGroup(
            addSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addSupplierPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(addSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator6)
                    .addGroup(addSupplierPanelLayout.createSequentialGroup()
                        .addGroup(addSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(addSupplierPanelLayout.createSequentialGroup()
                                .addComponent(txtContractExpectedEndDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtContractValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addSupplierPanelLayout.createSequentialGroup()
                                .addGroup(addSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtContractId1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                    .addComponent(txtContractLocation1)
                                    .addComponent(addContractText1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(addSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addSupplierPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtContractStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(addSupplierPanelLayout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(txtContractTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(addSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClientName1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addContractBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(36, 36, 36))
        );
        addSupplierPanelLayout.setVerticalGroup(
            addSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addSupplierPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(addContractText1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(addSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addSupplierPanelLayout.createSequentialGroup()
                        .addGroup(addSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContractId1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContractTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClientName1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(addSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContractLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContractStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addSupplierPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(addSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addSupplierPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(addSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContractExpectedEndDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContractValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addSupplierPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addContractBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        SupplierListDisplay.setBackground(null);
        SupplierListDisplay.setBorder(null);
        SupplierListDisplay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SupplierListText.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        SupplierListText.setForeground(new java.awt.Color(194, 72, 34));
        SupplierListText.setText("Supplier List:");
        SupplierListDisplay.add(SupplierListText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 271, -1));

        jSeparator7.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator7.setForeground(new java.awt.Color(51, 51, 51));
        SupplierListDisplay.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1200, 10));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        tableSupplierList.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        tableSupplierList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Contract Id", "Contract Title", "Contract Location", "Contract Start Date", "Contract End Date", "Contract Status", "Contract value ", "Client Name", "Scope Of Work"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableSupplierList.setGridColor(new java.awt.Color(215, 215, 215));
        tableSupplierList.setSelectionBackground(new java.awt.Color(194, 72, 34));
        tableSupplierList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableSupplierList.setShowHorizontalLines(true);
        jScrollPane5.setViewportView(tableSupplierList);

        SupplierListDisplay.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1200, 180));

        javax.swing.GroupLayout pnlSupplierMainLayout = new javax.swing.GroupLayout(pnlSupplierMain);
        pnlSupplierMain.setLayout(pnlSupplierMainLayout);
        pnlSupplierMainLayout.setHorizontalGroup(
            pnlSupplierMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierMainLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlSupplierMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SupplierListDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)
                    .addComponent(addSupplierPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(597, Short.MAX_VALUE))
            .addGroup(pnlSupplierMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlSupplierMainLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDataDisplayParent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlSupplierMainLayout.setVerticalGroup(
            pnlSupplierMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierMainLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(SupplierListDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(addSupplierPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1749, Short.MAX_VALUE))
            .addGroup(pnlSupplierMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlSupplierMainLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDataDisplayParent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        SuppliersPanel.setViewportView(pnlSupplierMain);

        pnlCards.add(SuppliersPanel, "card6");

        ContractPanel.setBorder(null);

        pnlContractMain.setBackground(new java.awt.Color(237, 240, 242));

        pnlDataDisplayParent1.setBackground(new java.awt.Color(237, 240, 242));

        javax.swing.GroupLayout pnlDataDisplayParent1Layout = new javax.swing.GroupLayout(pnlDataDisplayParent1);
        pnlDataDisplayParent1.setLayout(pnlDataDisplayParent1Layout);
        pnlDataDisplayParent1Layout.setHorizontalGroup(
            pnlDataDisplayParent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1250, Short.MAX_VALUE)
        );
        pnlDataDisplayParent1Layout.setVerticalGroup(
            pnlDataDisplayParent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        addContractsPanel.setBackground(null);

        addContractText.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        addContractText.setForeground(new java.awt.Color(194, 72, 34));
        addContractText.setText("Manage Contracts:");

        txtContractTitle.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtContractTitle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Title:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractTitleActionPerformed(evt);
            }
        });

        txtContractId.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtContractId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Id:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractIdActionPerformed(evt);
            }
        });

        txtContractLocation.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtContractLocation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Location:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractLocationActionPerformed(evt);
            }
        });

        txtContractExpectedEndDate.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtContractExpectedEndDate.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Expected End Date:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractExpectedEndDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractExpectedEndDateActionPerformed(evt);
            }
        });

        txtContractStatus.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtContractStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Status:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractStatusActionPerformed(evt);
            }
        });

        txtContractValue.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtContractValue.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Value:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractValueActionPerformed(evt);
            }
        });

        txtClientName.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtClientName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Client Name:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtClientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClientNameActionPerformed(evt);
            }
        });

        txtScopeOfWork.setColumns(20);
        txtScopeOfWork.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtScopeOfWork.setRows(5);
        txtScopeOfWork.setBorder(null);
        jScrollPane1.setViewportView(txtScopeOfWork);

        addContractBtnContractPanel.setBackground(null);
        addContractBtnContractPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addContractBtnContractPanelMouseClicked(evt);
            }
        });

        addContractTextPanel.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        addContractTextPanel.setForeground(new java.awt.Color(255, 255, 255));
        addContractTextPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addContractTextPanel.setText("   Add Contract");

        javax.swing.GroupLayout addContractBtnContractPanelLayout = new javax.swing.GroupLayout(addContractBtnContractPanel);
        addContractBtnContractPanel.setLayout(addContractBtnContractPanelLayout);
        addContractBtnContractPanelLayout.setHorizontalGroup(
            addContractBtnContractPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addContractTextPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );
        addContractBtnContractPanelLayout.setVerticalGroup(
            addContractBtnContractPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addContractBtnContractPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addContractTextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel7.setText("Scope Of Work:");

        txtContractStartDate.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        txtContractStartDate.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contract Start Date:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        txtContractStartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractStartDateActionPerformed(evt);
            }
        });

        updateContractBtnContractPanel.setBackground(null);
        updateContractBtnContractPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateContractBtnContractPanelMouseClicked(evt);
            }
        });

        updateContractText.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        updateContractText.setForeground(new java.awt.Color(255, 255, 255));
        updateContractText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateContractText.setText("   Update Contract");
        updateContractText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateContractTextMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout updateContractBtnContractPanelLayout = new javax.swing.GroupLayout(updateContractBtnContractPanel);
        updateContractBtnContractPanel.setLayout(updateContractBtnContractPanelLayout);
        updateContractBtnContractPanelLayout.setHorizontalGroup(
            updateContractBtnContractPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(updateContractText, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        updateContractBtnContractPanelLayout.setVerticalGroup(
            updateContractBtnContractPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(updateContractText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        deleteContractBtnContractPanel.setBackground(null);
        deleteContractBtnContractPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteContractBtnContractPanelMouseClicked(evt);
            }
        });

        deleteContractText.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        deleteContractText.setForeground(new java.awt.Color(255, 255, 255));
        deleteContractText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteContractText.setText("   Delete Contract");
        deleteContractText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteContractTextMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout deleteContractBtnContractPanelLayout = new javax.swing.GroupLayout(deleteContractBtnContractPanel);
        deleteContractBtnContractPanel.setLayout(deleteContractBtnContractPanelLayout);
        deleteContractBtnContractPanelLayout.setHorizontalGroup(
            deleteContractBtnContractPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteContractText, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
        );
        deleteContractBtnContractPanelLayout.setVerticalGroup(
            deleteContractBtnContractPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteContractText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ClearDataBtn.setBackground(null);
        ClearDataBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearDataBtnMouseClicked(evt);
            }
        });

        clearDataTxt.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        clearDataTxt.setForeground(new java.awt.Color(255, 255, 255));
        clearDataTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clearDataTxt.setText("Clear Data");
        clearDataTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearDataTxtMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ClearDataBtnLayout = new javax.swing.GroupLayout(ClearDataBtn);
        ClearDataBtn.setLayout(ClearDataBtnLayout);
        ClearDataBtnLayout.setHorizontalGroup(
            ClearDataBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clearDataTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        ClearDataBtnLayout.setVerticalGroup(
            ClearDataBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clearDataTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jSeparator16.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator16.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout addContractsPanelLayout = new javax.swing.GroupLayout(addContractsPanel);
        addContractsPanel.setLayout(addContractsPanelLayout);
        addContractsPanelLayout.setHorizontalGroup(
            addContractsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addContractsPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(addContractsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addContractsPanelLayout.createSequentialGroup()
                        .addComponent(addContractBtnContractPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(updateContractBtnContractPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(deleteContractBtnContractPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(ClearDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(addContractsPanelLayout.createSequentialGroup()
                        .addGroup(addContractsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 1168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addContractsPanelLayout.createSequentialGroup()
                                .addGroup(addContractsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(addContractsPanelLayout.createSequentialGroup()
                                        .addComponent(txtContractStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtContractExpectedEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(addContractsPanelLayout.createSequentialGroup()
                                        .addGroup(addContractsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(addContractText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtContractId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(116, 116, 116)
                                        .addComponent(txtContractTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(addContractsPanelLayout.createSequentialGroup()
                                        .addComponent(txtContractStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtContractLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(addContractsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContractValue, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        addContractsPanelLayout.setVerticalGroup(
            addContractsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addContractsPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(addContractText)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(addContractsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addContractsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtContractTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                        .addComponent(txtContractId, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGroup(addContractsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(addContractsPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(addContractsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtContractLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addComponent(txtContractStartDate)))
                    .addGroup(addContractsPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(41, 41, 41)
                .addGroup(addContractsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContractStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContractExpectedEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContractValue, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(addContractsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addContractsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(updateContractBtnContractPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteContractBtnContractPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addContractBtnContractPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ClearDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(144, 144, 144))
        );

        PendingContractsDisplay2.setBackground(null);
        PendingContractsDisplay2.setBorder(null);
        PendingContractsDisplay2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalPurchaseText6.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        totalPurchaseText6.setForeground(new java.awt.Color(194, 72, 34));
        totalPurchaseText6.setText("Contract List:");
        PendingContractsDisplay2.add(totalPurchaseText6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 271, -1));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jScrollPane4.setViewportBorder(null);
        jScrollPane4.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        jScrollPane4.setViewport(null);

        tableContractDashboard1.setBorder(null);
        tableContractDashboard1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        tableContractDashboard1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Contract Id", "Contract Title", "Contract Location", "Contract Start Date", "Contract End Date", "Contract Status", "Contract value ", "Client Name", "Scope Of Work"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableContractDashboard1.setAlignmentY(2.0F);
        tableContractDashboard1.setFocusCycleRoot(true);
        tableContractDashboard1.setGridColor(new java.awt.Color(214, 214, 214));
        tableContractDashboard1.setRowHeight(25);
        tableContractDashboard1.setRowMargin(5);
        tableContractDashboard1.setSelectionBackground(new java.awt.Color(194, 72, 34));
        tableContractDashboard1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableContractDashboard1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableContractDashboard1.setShowGrid(false);
        tableContractDashboard1.setShowHorizontalLines(true);
        jScrollPane4.setViewportView(tableContractDashboard1);
        if (tableContractDashboard1.getColumnModel().getColumnCount() > 0) {
            tableContractDashboard1.getColumnModel().getColumn(0).setResizable(false);
            tableContractDashboard1.getColumnModel().getColumn(0).setPreferredWidth(70);
            tableContractDashboard1.getColumnModel().getColumn(1).setResizable(false);
            tableContractDashboard1.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableContractDashboard1.getColumnModel().getColumn(2).setResizable(false);
            tableContractDashboard1.getColumnModel().getColumn(2).setPreferredWidth(90);
            tableContractDashboard1.getColumnModel().getColumn(3).setResizable(false);
            tableContractDashboard1.getColumnModel().getColumn(4).setResizable(false);
            tableContractDashboard1.getColumnModel().getColumn(5).setResizable(false);
            tableContractDashboard1.getColumnModel().getColumn(6).setResizable(false);
            tableContractDashboard1.getColumnModel().getColumn(7).setResizable(false);
            tableContractDashboard1.getColumnModel().getColumn(7).setPreferredWidth(100);
            tableContractDashboard1.getColumnModel().getColumn(8).setResizable(false);
            tableContractDashboard1.getColumnModel().getColumn(8).setPreferredWidth(270);
        }

        PendingContractsDisplay2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1190, 180));

        sortDropDown1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item", "Latest Data", "Price:High To Low", "Price:Low To High", "Client Name","Pending","On Hold","Completed" }));
        sortDropDown1.setBorder(null);
        sortDropDown1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sortDropDown1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sortDropDown1MouseClicked(evt);
            }
        });
        sortDropDown1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortDropDown1ActionPerformed(evt);
            }
        });
        PendingContractsDisplay2.add(sortDropDown1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 150, 30));

        jLabel18.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel18.setText("Sort By:");
        PendingContractsDisplay2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, -1, 50));

        jSeparator17.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator17.setForeground(new java.awt.Color(51, 51, 51));
        PendingContractsDisplay2.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1190, 10));

        javax.swing.GroupLayout pnlContractMainLayout = new javax.swing.GroupLayout(pnlContractMain);
        pnlContractMain.setLayout(pnlContractMainLayout);
        pnlContractMainLayout.setHorizontalGroup(
            pnlContractMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContractMainLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlContractMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PendingContractsDisplay2, javax.swing.GroupLayout.DEFAULT_SIZE, 1236, Short.MAX_VALUE)
                    .addComponent(addContractsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(605, Short.MAX_VALUE))
            .addGroup(pnlContractMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlContractMainLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDataDisplayParent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlContractMainLayout.setVerticalGroup(
            pnlContractMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContractMainLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(PendingContractsDisplay2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(addContractsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1647, Short.MAX_VALUE))
            .addGroup(pnlContractMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlContractMainLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDataDisplayParent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        ContractPanel.setViewportView(pnlContractMain);

        pnlCards.add(ContractPanel, "card7");

        DashBoardPanel.setBorder(null);

        DashBoardScreen.setBackground(new java.awt.Color(237, 240, 242));

        pnlDisplayParent.setBackground(new java.awt.Color(237, 240, 242));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 40, 5);
        flowLayout1.setAlignOnBaseline(true);
        pnlDisplayParent.setLayout(flowLayout1);

        displayPanel3.setBackground(null);
        displayPanel3.setBorder(null);

        revenueText6.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        revenueText6.setForeground(new java.awt.Color(194, 72, 34));
        revenueText6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventoryApplication/resources/cardLogo.png"))); // NOI18N

        totalPurchaseText2.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        totalPurchaseText2.setForeground(new java.awt.Color(194, 72, 34));
        totalPurchaseText2.setText("Income");

        jLabel2.setFont(new java.awt.Font("Poppins Light", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("20,000");

        jLabel6.setFont(new java.awt.Font("Poppins Light", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 209, 0));
        jLabel6.setText("+");

        javax.swing.GroupLayout displayPanel3Layout = new javax.swing.GroupLayout(displayPanel3);
        displayPanel3.setLayout(displayPanel3Layout);
        displayPanel3Layout.setHorizontalGroup(
            displayPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(displayPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(displayPanel3Layout.createSequentialGroup()
                        .addComponent(revenueText6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2))
                    .addComponent(totalPurchaseText2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        displayPanel3Layout.setVerticalGroup(
            displayPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(totalPurchaseText2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(displayPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(revenueText6)
                    .addGroup(displayPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        pnlDisplayParent.add(displayPanel3);

        displayPanel1.setBackground(null);
        displayPanel1.setBorder(null);

        revenueText3.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        revenueText3.setForeground(new java.awt.Color(194, 72, 34));
        revenueText3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventoryApplication/resources/cardLogo.png"))); // NOI18N

        totalPurchaseText.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        totalPurchaseText.setForeground(new java.awt.Color(194, 72, 34));
        totalPurchaseText.setText("Revenue");

        jLabel14.setFont(new java.awt.Font("Poppins Light", 0, 48)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 209, 0));
        jLabel14.setText("+");

        jLabel15.setFont(new java.awt.Font("Poppins Light", 0, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("100,000");

        javax.swing.GroupLayout displayPanel1Layout = new javax.swing.GroupLayout(displayPanel1);
        displayPanel1.setLayout(displayPanel1Layout);
        displayPanel1Layout.setHorizontalGroup(
            displayPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(displayPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(displayPanel1Layout.createSequentialGroup()
                        .addComponent(revenueText3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel15))
                    .addComponent(totalPurchaseText, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        displayPanel1Layout.setVerticalGroup(
            displayPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(totalPurchaseText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(displayPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(revenueText3)
                    .addGroup(displayPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        pnlDisplayParent.add(displayPanel1);

        displayPanel2.setBackground(null);
        displayPanel2.setBorder(null);

        revenueText5.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        revenueText5.setForeground(new java.awt.Color(194, 72, 34));
        revenueText5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventoryApplication/resources/cardLogo.png"))); // NOI18N

        totalPurchaseText3.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        totalPurchaseText3.setForeground(new java.awt.Color(194, 72, 34));
        totalPurchaseText3.setText("Total Purchase");

        jLabel12.setFont(new java.awt.Font("Poppins Light", 0, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 209, 0));
        jLabel12.setText("+");

        jLabel13.setFont(new java.awt.Font("Poppins Light", 0, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("80,000");

        javax.swing.GroupLayout displayPanel2Layout = new javax.swing.GroupLayout(displayPanel2);
        displayPanel2.setLayout(displayPanel2Layout);
        displayPanel2Layout.setHorizontalGroup(
            displayPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(displayPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalPurchaseText3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(displayPanel2Layout.createSequentialGroup()
                        .addComponent(revenueText5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        displayPanel2Layout.setVerticalGroup(
            displayPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(totalPurchaseText3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(displayPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(revenueText5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(displayPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        pnlDisplayParent.add(displayPanel2);

        pnlDataDisplayParent.setBackground(new java.awt.Color(237, 240, 242));
        pnlDataDisplayParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PendingContractsDisplay1.setBackground(null);
        PendingContractsDisplay1.setBorder(null);
        PendingContractsDisplay1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalPurchaseText4.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        totalPurchaseText4.setForeground(new java.awt.Color(194, 72, 34));
        totalPurchaseText4.setText("Pending Contracts");
        PendingContractsDisplay1.add(totalPurchaseText4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 271, -1));

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        PendingContractsDisplay1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 67, 1160, -1));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        tableContractDashboard.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        tableContractDashboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Contract Title", "Contract Location", "Contract Start Date", "Contract End Date", "Contract Status", "Contract value ", "Client Name", "Scope Of Work"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableContractDashboard.setGridColor(new java.awt.Color(214, 214, 214));
        tableContractDashboard.setRowHeight(25);
        tableContractDashboard.setRowMargin(5);
        tableContractDashboard.setSelectionBackground(new java.awt.Color(194, 72, 34));
        tableContractDashboard.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableContractDashboard.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableContractDashboard.setShowGrid(false);
        tableContractDashboard.setShowHorizontalLines(true);
        jScrollPane3.setViewportView(tableContractDashboard);
        if (tableContractDashboard.getColumnModel().getColumnCount() > 0) {
            tableContractDashboard.getColumnModel().getColumn(0).setResizable(false);
            tableContractDashboard.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableContractDashboard.getColumnModel().getColumn(1).setResizable(false);
            tableContractDashboard.getColumnModel().getColumn(1).setPreferredWidth(180);
            tableContractDashboard.getColumnModel().getColumn(2).setResizable(false);
            tableContractDashboard.getColumnModel().getColumn(2).setPreferredWidth(120);
            tableContractDashboard.getColumnModel().getColumn(3).setResizable(false);
            tableContractDashboard.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableContractDashboard.getColumnModel().getColumn(4).setResizable(false);
            tableContractDashboard.getColumnModel().getColumn(4).setPreferredWidth(100);
            tableContractDashboard.getColumnModel().getColumn(5).setResizable(false);
            tableContractDashboard.getColumnModel().getColumn(6).setResizable(false);
            tableContractDashboard.getColumnModel().getColumn(7).setResizable(false);
            tableContractDashboard.getColumnModel().getColumn(7).setPreferredWidth(170);
            tableContractDashboard.getColumnModel().getColumn(8).setResizable(false);
            tableContractDashboard.getColumnModel().getColumn(8).setPreferredWidth(250);
        }

        PendingContractsDisplay1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1160, 200));

        sortDropDown.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        sortDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item", "Latest Data", "Price:High To Low", "Price:Low To High", "Client Name","Completed","On Hold","Pending" }));
        sortDropDown.setBorder(null);
        sortDropDown.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sortDropDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sortDropDownMouseClicked(evt);
            }
        });
        sortDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortDropDownActionPerformed(evt);
            }
        });
        PendingContractsDisplay1.add(sortDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 150, 30));

        jLabel1.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel1.setText("Sort By:");
        PendingContractsDisplay1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, -1, -1));

        pnlDataDisplayParent.add(PendingContractsDisplay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 1200, 290));

        NewOrdersDisplayPanel.setBackground(null);
        NewOrdersDisplayPanel.setBorder(null);
        NewOrdersDisplayPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalPurchaseText1.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        totalPurchaseText1.setForeground(new java.awt.Color(194, 72, 34));
        totalPurchaseText1.setText("New Orders");
        NewOrdersDisplayPanel.add(totalPurchaseText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 271, -1));

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        NewOrdersDisplayPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1150, 10));

        jScrollPane12.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        tableNewOrdersDashboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Customer Name", "Order Date", "Customer Contact", "Products Ordered", "Total Amount", "Order Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableNewOrdersDashboard.setGridColor(new java.awt.Color(214, 214, 214));
        tableNewOrdersDashboard.setRowHeight(25);
        tableNewOrdersDashboard.setRowMargin(5);
        tableNewOrdersDashboard.setSelectionBackground(new java.awt.Color(194, 72, 34));
        tableNewOrdersDashboard.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableNewOrdersDashboard.setShowGrid(false);
        tableNewOrdersDashboard.setShowHorizontalLines(true);
        jScrollPane12.setViewportView(tableNewOrdersDashboard);
        if (tableNewOrdersDashboard.getColumnModel().getColumnCount() > 0) {
            tableNewOrdersDashboard.getColumnModel().getColumn(0).setResizable(false);
            tableNewOrdersDashboard.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableNewOrdersDashboard.getColumnModel().getColumn(1).setResizable(false);
            tableNewOrdersDashboard.getColumnModel().getColumn(1).setPreferredWidth(250);
            tableNewOrdersDashboard.getColumnModel().getColumn(2).setResizable(false);
            tableNewOrdersDashboard.getColumnModel().getColumn(2).setPreferredWidth(250);
            tableNewOrdersDashboard.getColumnModel().getColumn(3).setResizable(false);
            tableNewOrdersDashboard.getColumnModel().getColumn(4).setResizable(false);
            tableNewOrdersDashboard.getColumnModel().getColumn(5).setResizable(false);
            tableNewOrdersDashboard.getColumnModel().getColumn(6).setResizable(false);
        }

        NewOrdersDisplayPanel.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1160, 190));

        LatestStockDisplayPanel1.setBackground(null);
        LatestStockDisplayPanel1.setBorder(null);
        LatestStockDisplayPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalPurchaseText5.setFont(new java.awt.Font("Poppins Light", 1, 24)); // NOI18N
        totalPurchaseText5.setForeground(new java.awt.Color(194, 72, 34));
        totalPurchaseText5.setText("Latest Stock");
        LatestStockDisplayPanel1.add(totalPurchaseText5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 271, -1));

        jSeparator4.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        LatestStockDisplayPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1160, 10));

        jScrollPane13.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        tableLatestStockDashboard.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        tableLatestStockDashboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Product Name", "Supplier Name", "Date Of Entry", "Price", "Quantity", "Unit", "Measurement Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableLatestStockDashboard.setGridColor(new java.awt.Color(214, 214, 214));
        tableLatestStockDashboard.setRowHeight(25);
        tableLatestStockDashboard.setRowMargin(5);
        tableLatestStockDashboard.setSelectionBackground(new java.awt.Color(194, 72, 34));
        tableLatestStockDashboard.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableLatestStockDashboard.setShowGrid(false);
        tableLatestStockDashboard.setShowHorizontalLines(true);
        jScrollPane13.setViewportView(tableLatestStockDashboard);
        if (tableLatestStockDashboard.getColumnModel().getColumnCount() > 0) {
            tableLatestStockDashboard.getColumnModel().getColumn(0).setResizable(false);
            tableLatestStockDashboard.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableLatestStockDashboard.getColumnModel().getColumn(1).setResizable(false);
            tableLatestStockDashboard.getColumnModel().getColumn(1).setPreferredWidth(250);
            tableLatestStockDashboard.getColumnModel().getColumn(2).setResizable(false);
            tableLatestStockDashboard.getColumnModel().getColumn(2).setPreferredWidth(250);
            tableLatestStockDashboard.getColumnModel().getColumn(3).setResizable(false);
            tableLatestStockDashboard.getColumnModel().getColumn(4).setResizable(false);
            tableLatestStockDashboard.getColumnModel().getColumn(5).setResizable(false);
            tableLatestStockDashboard.getColumnModel().getColumn(6).setResizable(false);
            tableLatestStockDashboard.getColumnModel().getColumn(7).setResizable(false);
            tableLatestStockDashboard.getColumnModel().getColumn(7).setPreferredWidth(250);
        }

        LatestStockDisplayPanel1.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1160, 200));

        javax.swing.GroupLayout DashBoardScreenLayout = new javax.swing.GroupLayout(DashBoardScreen);
        DashBoardScreen.setLayout(DashBoardScreenLayout);
        DashBoardScreenLayout.setHorizontalGroup(
            DashBoardScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardScreenLayout.createSequentialGroup()
                .addGroup(DashBoardScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDataDisplayParent, javax.swing.GroupLayout.PREFERRED_SIZE, 1332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDisplayParent, javax.swing.GroupLayout.PREFERRED_SIZE, 1313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DashBoardScreenLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(DashBoardScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LatestStockDisplayPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NewOrdersDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(549, Short.MAX_VALUE))
        );
        DashBoardScreenLayout.setVerticalGroup(
            DashBoardScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardScreenLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pnlDisplayParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(pnlDataDisplayParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(LatestStockDisplayPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(NewOrdersDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1240, 1240, 1240))
        );

        DashBoardPanel.setViewportView(DashBoardScreen);

        pnlCards.add(DashBoardPanel, "card10");

        jSplitPane1.setRightComponent(pnlCards);

        pnlMain.add(jSplitPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 108, 1958, 1960));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1987, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(loginPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2068, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(loginPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  private void loadScreen(String screenName) {
        cardLayout.show(pnlCards, screenName);
    }

    private void loadScreenPage(String screenName) {
        cardLayout.show(getContentPane(), screenName);
    }

    private void setBtnColor(JPanel btn) {
        btn.setBackground(new Color(194, 72, 34));
    }

    private void setInitialBtnColor(JPanel btn) {
        btn.setBackground(new Color(37, 38, 58));
    }

    private JPanel activeButton = null;

    private void setActiveButton(JPanel btn) {

        if (activeButton != null && activeButton != btn) {
            setInitialBtnColor(activeButton);
            activeButton.setBorder(BorderFactory.createEmptyBorder());
        }
        activeButton = btn;
        setBtnColor(activeButton);
        activeButton.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, new Color(237, 240, 242)));
    }

    private void SupplierButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierButtonMouseClicked
        loadScreen("SuppliersScreen");
        setActiveButton(SupplierButton);

    }//GEN-LAST:event_SupplierButtonMouseClicked

    private void OrderButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderButtonMouseClicked
        loadScreen("OrdersScreen");
        setActiveButton(OrderButton);

    }//GEN-LAST:event_OrderButtonMouseClicked

    private void ContractButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContractButtonMouseClicked
        loadScreen("ContractScreen");
        setActiveButton(ContractButton);

    }//GEN-LAST:event_ContractButtonMouseClicked

    private void ProductButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseClicked
        loadScreen("ProductScreen");
        setActiveButton(ProductButton);

    }//GEN-LAST:event_ProductButtonMouseClicked

    private void InStockButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InStockButtonMousePressed

    }//GEN-LAST:event_InStockButtonMousePressed

    private void InStockButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InStockButtonMouseClicked
        loadScreen("InStockScreen");
        setActiveButton(InStockButton);

    }//GEN-LAST:event_InStockButtonMouseClicked

    private void DashBoardButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashBoardButtonMouseClicked
        loadScreen("DashBoardScreen");
        setActiveButton(DashBoardButton);

    }//GEN-LAST:event_DashBoardButtonMouseClicked

    private void DashBoardButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashBoardButtonMouseEntered
        // TODO add your handling code here:
        if (activeButton != DashBoardButton) {
            setBtnColor(DashBoardButton);
        }

    }//GEN-LAST:event_DashBoardButtonMouseEntered

    private void InStockButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InStockButtonMouseEntered
        if (activeButton != InStockButton) {
            setBtnColor(InStockButton);
        }
    }//GEN-LAST:event_InStockButtonMouseEntered

    private void ProductButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseEntered
        if (activeButton != ProductButton) {
            setBtnColor(ProductButton);
        }
    }//GEN-LAST:event_ProductButtonMouseEntered

    private void ContractButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContractButtonMouseEntered
        if (activeButton != ContractButton) {
            setBtnColor(ContractButton);
        }
    }//GEN-LAST:event_ContractButtonMouseEntered

    private void OrderButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderButtonMouseEntered
        if (activeButton != OrderButton) {
            setBtnColor(OrderButton);
        }
    }//GEN-LAST:event_OrderButtonMouseEntered

    private void SupplierButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierButtonMouseEntered
        if (activeButton != SupplierButton) {
            setBtnColor(SupplierButton);
        }
    }//GEN-LAST:event_SupplierButtonMouseEntered

    private void DashBoardButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashBoardButtonMouseExited
        if (activeButton != DashBoardButton) {
            setInitialBtnColor(DashBoardButton);
        }
    }//GEN-LAST:event_DashBoardButtonMouseExited

    private void InStockButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InStockButtonMouseExited
        if (activeButton != InStockButton) {
            setInitialBtnColor(InStockButton);
        }
    }//GEN-LAST:event_InStockButtonMouseExited

    private void ProductButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseExited
        if (activeButton != ProductButton) {
            setInitialBtnColor(ProductButton);
        }
    }//GEN-LAST:event_ProductButtonMouseExited

    private void ContractButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContractButtonMouseExited
        if (activeButton != ContractButton) {
            setInitialBtnColor(ContractButton);
        }
    }//GEN-LAST:event_ContractButtonMouseExited

    private void OrderButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderButtonMouseExited
        if (activeButton != OrderButton) {
            setInitialBtnColor(OrderButton);
        }
    }//GEN-LAST:event_OrderButtonMouseExited

    private void SupplierButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierButtonMouseExited
        if (activeButton != SupplierButton) {
            setInitialBtnColor(SupplierButton);
        }


    }//GEN-LAST:event_SupplierButtonMouseExited

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void txtContractTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractTitleActionPerformed

    private void txtContractIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractIdActionPerformed

    private void txtContractLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractLocationActionPerformed

    private void txtContractExpectedEndDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractExpectedEndDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractExpectedEndDateActionPerformed

    private void txtContractStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractStatusActionPerformed

    private void txtContractValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractValueActionPerformed

    private void txtClientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClientNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClientNameActionPerformed

    private void addContractBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addContractBtnMouseClicked
        loadScreen("ContractScreen");
        setActiveButton(ContractButton);
    }//GEN-LAST:event_addContractBtnMouseClicked

    private void addContractBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addContractBtnMouseEntered
        // TODO add your handling code here:

        addContractBtn.setBackground(new Color(44, 44, 44));
    }//GEN-LAST:event_addContractBtnMouseEntered

    private void addContractBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addContractBtnMouseExited
        // TODO add your handling code here:
        addContractBtn.setBackground(Color.WHITE);
    }//GEN-LAST:event_addContractBtnMouseExited

    private void addProductBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductBtnMouseEntered
        // TODO add your handling code here:
        addProductBtn.setBackground(new Color(194, 72, 34));
    }//GEN-LAST:event_addProductBtnMouseEntered

    private void addProductBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductBtnMouseClicked
        // TODO add your handling code here:
        loadScreen("ProductScreen");
        setActiveButton(ProductButton);
    }//GEN-LAST:event_addProductBtnMouseClicked

    private void addProductBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductBtnMouseExited
        // TODO add your handling code here:
        addProductBtn.setBackground(Color.WHITE);
    }//GEN-LAST:event_addProductBtnMouseExited

    private void addStockBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStockBtnMouseClicked
        // TODO add your handling code here:
        loadScreen("InStockScreen");
        setActiveButton(InStockButton);
    }//GEN-LAST:event_addStockBtnMouseClicked

    private void addStockBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStockBtnMouseEntered
        // TODO add your handling code here:
        addStockBtn.setBackground(new Color(56, 183, 53));
    }//GEN-LAST:event_addStockBtnMouseEntered

    private void addStockBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStockBtnMouseExited
        addStockBtn.setBackground(Color.WHITE);
    }//GEN-LAST:event_addStockBtnMouseExited
    private boolean isContractIdDuplicate(int contractId) {
        // Assuming `contractList` is a List<ContractModel> storing all contracts
        for (ContractModel contract : ContractList) {
            if (contract.getContractId() == contractId) {
                return true; // Duplicate ID found
            }
        }
        return false; // ID is unique
    }

    private void initializeTableListener() {
        tableContractDashboard1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) { // Ensure the event is finalized
                int selectedRow = tableContractDashboard1.getSelectedRow(); // Get the selected row index
                if (selectedRow != -1) { // Ensure a row is selected
                    // Retrieve values from the selected row
                    String contractIdStr = tableContractDashboard1.getValueAt(selectedRow, 0).toString(); // Column 0
                    String contractTitle = tableContractDashboard1.getValueAt(selectedRow, 1).toString(); // Column 1
                    String contractLocation = tableContractDashboard1.getValueAt(selectedRow, 2).toString(); // Column 2
                    String startDateString = tableContractDashboard1.getValueAt(selectedRow, 3).toString(); // Column 3
                    String endDateString = tableContractDashboard1.getValueAt(selectedRow, 4).toString(); // Column 4
                    String contractStatus = tableContractDashboard1.getValueAt(selectedRow, 5).toString(); // Column 5
                    String contractValueStr = tableContractDashboard1.getValueAt(selectedRow, 6).toString().trim(); // Column 6
                    String clientName = tableContractDashboard1.getValueAt(selectedRow, 7).toString(); // Column 7
                    String scopeOfWork = tableContractDashboard1.getValueAt(selectedRow, 8).toString(); // Column 8

                    // Populate the text fields with the retrieved data
                    txtContractId.setText(contractIdStr);
                    txtContractTitle.setText(contractTitle);
                    txtContractLocation.setText(contractLocation);
                    txtContractStartDate.setText(startDateString);
                    txtContractExpectedEndDate.setText(endDateString);
                    txtContractStatus.setText(contractStatus);
                    txtContractValue.setText(contractValueStr);
                    txtClientName.setText(clientName);
                    txtScopeOfWork.setText(scopeOfWork);
                }
            }
        });
    }

    private void refreshTable() {
        DefaultTableModel tableModel = (DefaultTableModel) tableContractDashboard1.getModel();
        tableModel.setRowCount(0);  // Clear the current rows

        // Populate the table with updated data
        for (ContractModel contract : ContractList) {
            tableModel.addRow(new Object[]{
                contract.getContractId(),
                contract.getContractTitle(),
                contract.getContractLocation(),
                contract.getContractStartDate(),
                contract.getContractExpectedEndDate(),
                contract.getContractStatus(),
                contract.getContractValue(),
                contract.getClientName(),
                contract.getScopeOfWork()
            });
        }
    }


    private void addContractBtnContractPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addContractBtnContractPanelMouseClicked
        try {
            // Retrieve and trim input values
            String contractIdStr = txtContractId.getText().trim();
            String contractTitle = txtContractTitle.getText().trim();
            String contractLocation = txtContractLocation.getText().trim();
            String startDateString = txtContractStartDate.getText().trim();
            String endDateString = txtContractExpectedEndDate.getText().trim();
            String contractStatus = txtContractStatus.getText().trim();
            String contractValueStr = txtContractValue.getText().trim();
            String clientName = txtClientName.getText().trim();
            String scopeOfWork = txtScopeOfWork.getText().trim();

            // Check if any field is empty
            if (ValidationUtil.isNullOrEmpty(contractIdStr)
                    || ValidationUtil.isNullOrEmpty(contractTitle)
                    || ValidationUtil.isNullOrEmpty(contractLocation)
                    || ValidationUtil.isNullOrEmpty(startDateString)
                    || ValidationUtil.isNullOrEmpty(endDateString)
                    || ValidationUtil.isNullOrEmpty(contractStatus)
                    || ValidationUtil.isNullOrEmpty(contractValueStr)
                    || ValidationUtil.isNullOrEmpty(clientName)
                    || ValidationUtil.isNullOrEmpty(scopeOfWork)) {

                JOptionPane.showMessageDialog(null, "All fields must be filled.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int contractId = Integer.parseInt(contractIdStr);
            if (!ValidationUtil.isValidId(contractId)) {
                JOptionPane.showMessageDialog(null, "Contract ID must be a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (isContractIdDuplicate(contractId)) {
                JOptionPane.showMessageDialog(null, "Contract ID must be unique. The given ID already exists.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!ValidationUtil.isValidName(clientName)) {
                JOptionPane.showMessageDialog(null, "Client Name should only contain alphabetic characters.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!ValidationUtil.isValidStatus(contractStatus)) {
                JOptionPane.showMessageDialog(null, "Contract Status must be one of: Pending, Completed, or On Hold.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!ValidationUtil.isValidValue(Double.parseDouble(contractValueStr))) {
                JOptionPane.showMessageDialog(null, "Contract Value must be a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate contractStartDate;
            LocalDate contractExpectedEndDate;

            try {
                contractStartDate = LocalDate.parse(startDateString, formatter);
                contractExpectedEndDate = LocalDate.parse(endDateString, formatter);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Dates must be in the format yyyy-MM-dd.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (contractStartDate.isAfter(contractExpectedEndDate)) {
                JOptionPane.showMessageDialog(null, "Start date cannot be after the expected end date.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // All validations passed, proceed with adding the contract
            ContractModel model = new ContractModel(
                    Integer.parseInt(contractIdStr),
                    contractTitle,
                    contractLocation,
                    contractStartDate,
                    contractExpectedEndDate,
                    contractStatus,
                    Double.parseDouble(contractValueStr),
                    clientName,
                    scopeOfWork
            );

            addContract(model);
            refreshTable();
            JOptionPane.showMessageDialog(null, "Contract successfully added!", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Numeric fields must contain valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_addContractBtnContractPanelMouseClicked

    private void txtContractTitle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractTitle1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractTitle1ActionPerformed

    private void txtContractId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractId1ActionPerformed

    private void txtContractLocation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractLocation1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractLocation1ActionPerformed

    private void txtContractExpectedEndDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractExpectedEndDate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractExpectedEndDate1ActionPerformed

    private void txtContractStatus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractStatus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractStatus1ActionPerformed

    private void txtContractValue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractValue1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractValue1ActionPerformed

    private void txtClientName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClientName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClientName1ActionPerformed

    private void addContractBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addContractBtn2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addContractBtn2MouseClicked

    private void txtContractTitle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractTitle2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractTitle2ActionPerformed

    private void txtContractId2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractId2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractId2ActionPerformed

    private void txtContractLocation2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractLocation2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractLocation2ActionPerformed

    private void txtContractExpectedEndDate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractExpectedEndDate2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractExpectedEndDate2ActionPerformed

    private void txtContractStatus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractStatus2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractStatus2ActionPerformed

    private void txtContractValue2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractValue2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractValue2ActionPerformed

    private void txtClientName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClientName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClientName2ActionPerformed

    private void addContractBtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addContractBtn3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addContractBtn3MouseClicked

    private void txtContractTitle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractTitle3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractTitle3ActionPerformed

    private void txtContractId3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractId3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractId3ActionPerformed

    private void txtContractLocation3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractLocation3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractLocation3ActionPerformed

    private void txtContractExpectedEndDate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractExpectedEndDate3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractExpectedEndDate3ActionPerformed

    private void txtContractStatus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractStatus3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractStatus3ActionPerformed

    private void txtContractValue3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractValue3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractValue3ActionPerformed

    private void txtClientName3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClientName3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClientName3ActionPerformed

    private void addContractBtn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addContractBtn4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addContractBtn4MouseClicked

    private void txtContractTitle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractTitle4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractTitle4ActionPerformed

    private void txtContractId4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractId4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractId4ActionPerformed

    private void txtContractLocation4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractLocation4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractLocation4ActionPerformed

    private void txtContractExpectedEndDate4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractExpectedEndDate4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractExpectedEndDate4ActionPerformed

    private void txtContractStatus4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractStatus4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractStatus4ActionPerformed

    private void txtContractValue4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractValue4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractValue4ActionPerformed

    private void txtClientName4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClientName4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClientName4ActionPerformed

    private void addContractBtn5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addContractBtn5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addContractBtn5MouseClicked

    private void addStockBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStockBtn1MouseClicked
        txtFieldUsername.setText("");
        txtFieldPassword.setText("");
        loadScreenPage("LoginScreen"); // Load the main screen
    }//GEN-LAST:event_addStockBtn1MouseClicked

    private void addStockBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStockBtn1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_addStockBtn1MouseEntered

    private void addStockBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStockBtn1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_addStockBtn1MouseExited

    private void pnlLoginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLoginBtnMouseClicked
        String username = txtFieldUsername.getText().trim();
        String password = new String(txtFieldPassword.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            lblMessage.setText("! Please enter your username and password.");
        } // Check if username and password are incorrect
        else if (!username.equals("admin") || !password.equals("admin")) {
            lblMessage.setText("! Username and password mismatch.");
        } // If credentials are correct, proceed to load the main screen
        else {
            lblMessage.setText(""); // Clear any previous error messages
            loadScreenPage("MainScreen"); // Load the main screen
        }
    }//GEN-LAST:event_pnlLoginBtnMouseClicked

    private void pnlLoginBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLoginBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlLoginBtnMouseEntered

    private void pnlLoginBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLoginBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlLoginBtnMouseExited

    private void txtFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldUsernameActionPerformed

    private void txtContractStartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractStartDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContractStartDateActionPerformed

    private void updateContractBtnContractPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateContractBtnContractPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_updateContractBtnContractPanelMouseClicked

    private void deleteContractBtnContractPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteContractBtnContractPanelMouseClicked

    }//GEN-LAST:event_deleteContractBtnContractPanelMouseClicked

    private void deleteContractTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteContractTextMouseClicked
        int selectedRowIndex = tableContractDashboard1.getSelectedRow();
        System.out.println("Delete button clicked");
        // Check if a row is selected
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please select a row to delete.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int confirmation = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to delete the selected contract?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (confirmation == JOptionPane.YES_OPTION) {

            int modelRowIndex = tableContractDashboard1.convertRowIndexToModel(selectedRowIndex);
            ContractModel contractToDelete = ContractList.get(modelRowIndex);
            ContractList.remove(contractToDelete);

            ((DefaultTableModel) tableContractDashboard1.getModel()).removeRow(selectedRowIndex);
            ((DefaultTableModel) tableContractDashboard.getModel()).removeRow(selectedRowIndex);
            JOptionPane.showMessageDialog(
                    null,
                    "The contract has been successfully deleted.",  
                    "Deletion Successful", 
                    JOptionPane.INFORMATION_MESSAGE   
            );
        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Deletion cancelled.",
                    "Cancelled",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }//GEN-LAST:event_deleteContractTextMouseClicked

    private void clearDataTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearDataTxtMouseClicked
        txtContractId.setText("");
        txtContractTitle.setText("");
        txtContractLocation.setText("");
        txtContractStartDate.setText("");
        txtContractExpectedEndDate.setText("");
        txtContractStatus.setText("");
        txtContractValue.setText("");
        txtClientName.setText("");
        txtScopeOfWork.setText("");
    }//GEN-LAST:event_clearDataTxtMouseClicked

    private void ClearDataBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearDataBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearDataBtnMouseClicked

    private void updateContractTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateContractTextMouseClicked
        int selectedRowIndex = tableContractDashboard1.getSelectedRow();

        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please select a row to update.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this contract?", "Update Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {

                String contractIdStr = txtContractId.getText().trim();
                String contractTitle = txtContractTitle.getText().trim();
                String contractLocation = txtContractLocation.getText().trim();
                String startDateString = txtContractStartDate.getText().trim();
                String endDateString = txtContractExpectedEndDate.getText().trim();
                String contractStatus = txtContractStatus.getText().trim();
                String contractValueStr = txtContractValue.getText().trim();

                String clientName = txtClientName.getText();
                String scopeOfWork = txtScopeOfWork.getText().trim();

                // Check if any field is empty
                if (ValidationUtil.isNullOrEmpty(contractIdStr)
                        || ValidationUtil.isNullOrEmpty(contractTitle)
                        || ValidationUtil.isNullOrEmpty(contractLocation)
                        || ValidationUtil.isNullOrEmpty(startDateString)
                        || ValidationUtil.isNullOrEmpty(endDateString)
                        || ValidationUtil.isNullOrEmpty(contractStatus)
                        || ValidationUtil.isNullOrEmpty(contractValueStr)
                        || ValidationUtil.isNullOrEmpty(clientName)
                        || ValidationUtil.isNullOrEmpty(scopeOfWork)) {

                    JOptionPane.showMessageDialog(null, "All fields must be filled.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int contractId = Integer.parseInt(contractIdStr);
                if (!ValidationUtil.isValidId(contractId)) {
                    JOptionPane.showMessageDialog(null, "Contract ID must be a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!ValidationUtil.isValidName(clientName)) {
                    JOptionPane.showMessageDialog(null, "Client Name should only contain alphabetic characters.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!ValidationUtil.isValidStatus(contractStatus)) {
                    JOptionPane.showMessageDialog(null, "Contract Status must be one of: Pending, Completed, or On Hold.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!ValidationUtil.isValidValue(Double.parseDouble(contractValueStr))) {
                    JOptionPane.showMessageDialog(null, "Contract Value must be a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate contractStartDate;
                LocalDate contractExpectedEndDate;

                try {
                    contractStartDate = LocalDate.parse(startDateString, formatter);
                    contractExpectedEndDate = LocalDate.parse(endDateString, formatter);
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(null, "Dates must be in the format yyyy-MM-dd.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ContractModel contractToUpdate = null;
                for (ContractModel contract : ContractList) {
                    if (contract.getContractId() == contractId) {
                        contractToUpdate = contract;
                        break;
                    }
                }

                if (contractToUpdate != null) {
                    System.out.println(contractToUpdate);
                    contractToUpdate.setContractTitle(contractTitle);
                    contractToUpdate.setContractLocation(contractLocation);
                    contractToUpdate.setContractStartDate(contractStartDate);
                    contractToUpdate.setContractExpectedEndDate(contractExpectedEndDate);
                    contractToUpdate.setContractStatus(contractStatus);
                    contractToUpdate.setContractValue(Double.parseDouble(contractValueStr));
                    contractToUpdate.setClientName(clientName);
                    contractToUpdate.setScopeOfWork(scopeOfWork);
                    System.out.println(contractToUpdate);
                    System.out.println(ContractList);
                    refreshTable();
                    JOptionPane.showMessageDialog(null, "Contract successfully updated!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Contract with the given ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Numeric fields must contain valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Update cancelled.",
                    "Cancelled",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }


    }//GEN-LAST:event_updateContractTextMouseClicked

    private void lblSearchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchBtnMouseClicked


MergeSort mergeSortAlgorithm = new MergeSort();
mergeSortAlgorithm.performMergeSort (ContractList) ;  

  BinarySearch binarySearch = new BinarySearch();
ContractModel searchedContractModel = binarySearch.searchByClient(searchBar.getText(),ContractList,0,ContractList.size() - 1);
      if (searchedContractModel != null) {
        JOptionPane.showMessageDialog(
            null, 
            "Contract Name:  "+ searchedContractModel.getContractTitle() +"\n"+
            "Location of the Contract: " + searchedContractModel.getContractLocation() +"\n"+
            "Contract Start Date: " + searchedContractModel.getContractStartDate()+"\n"+
            "Contract Expected End Date: " + searchedContractModel.getContractExpectedEndDate()+"\n" + 
            " Contract Value: " + searchedContractModel.getContractValue()+"\n" 
            ,"Success", 
            JOptionPane.INFORMATION_MESSAGE
        );
       

} else {
       JOptionPane.showMessageDialog(null, "Contract with the given client name was not found!", "Error", JOptionPane.ERROR_MESSAGE);

      }
    }//GEN-LAST:event_lblSearchBtnMouseClicked

    private void sortDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortDropDownActionPerformed
        String selectedOption = (String) sortDropDown.getSelectedItem();

        SelectionSort selectionSort = new SelectionSort();
        MergeSort mergeSort = new MergeSort();
        InsertionSort insertionSort=new InsertionSort();

        switch (selectedOption) {

            case "Price:Low To High":

                selectionSort.performLowToHighSelectionSort(ContractList);
                break;

            case "Price:High To Low":
                System.out.println("chiryoooo");
                selectionSort.performHighToLowSelectionSort(ContractList);
                break;

            case "Latest Data":
                // Implement sorting for the latest contracts if required
                selectionSort.performLatestDataSelectionSort(ContractList);
                break;

            case "Client Name":
                mergeSort.performMergeSort(ContractList);
                break;
                
            case "Completed":
                insertionSort.sortByCompleted(ContractList);
                break;
                
            case "On Hold":
                insertionSort.sortByOnHold(ContractList);
                break;
                
            case "Pending":
                insertionSort.sortByPending(ContractList);
                break;

            case "Select Item":
                // No action needed for default selection
                System.out.println("Please select a valid option.");
                break;

            default:
                System.out.println("Invalid selection: " + selectedOption);
                break;
        }

        // Update the table model after sorting
        DefaultTableModel contractTableModel = (DefaultTableModel) tableContractDashboard.getModel();
        contractTableModel.setRowCount(0);
        System.out.print(ContractList);

        ContractList.forEach(element -> {
            Object[] contractData = {
                element.getContractId(),
                element.getContractTitle(),
                element.getContractLocation(),
                element.getContractStartDate(),
                element.getContractExpectedEndDate(),
                element.getContractStatus(),
                element.getContractValue(),
                element.getClientName(),
                element.getScopeOfWork()
            };

            // Debugging output to check Contract Value
            System.out.println("Contract Value: " + element.getContractValue());

            // Add data to the table model
            contractTableModel.addRow(contractData);
        });
    }//GEN-LAST:event_sortDropDownActionPerformed

    private void sortDropDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sortDropDownMouseClicked
 
    }//GEN-LAST:event_sortDropDownMouseClicked

    private void sortDropDown1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sortDropDown1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sortDropDown1MouseClicked

    private void sortDropDown1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortDropDown1ActionPerformed
       String selectedOption = (String) sortDropDown1.getSelectedItem();

    

        SelectionSort selectionSort = new SelectionSort();
        MergeSort mergeSort = new MergeSort();
        InsertionSort insertionSort=new InsertionSort();
        
        switch (selectedOption) {

            case "Price:Low To High":

                selectionSort.performLowToHighSelectionSort(ContractList);
                break;

            case "Price:High To Low":
                System.out.println("chiryoooo");
                selectionSort.performHighToLowSelectionSort(ContractList);
                break;

            case "Latest Data":
                // Implement sorting for the latest contracts if required
                selectionSort.performLatestDataSelectionSort(ContractList);
                break;

            case "Client Name":
                mergeSort.performMergeSort(ContractList);
                break;

            case "Select Item":
                // No action needed for default selection
                System.out.println("Please select a valid option.");
                break;
                
            case "Completed":
                insertionSort.sortByCompleted(ContractList);
                break;
                
            case "On Hold":
                insertionSort.sortByOnHold(ContractList);
                break;
                
            case "Pending":
                insertionSort.sortByPending(ContractList);
                break;
            

            default:
                System.out.println("Invalid selection: " + selectedOption);
                break;
        }

        // Update the table model after sorting
        DefaultTableModel contractTableModel = (DefaultTableModel) tableContractDashboard1.getModel();
        contractTableModel.setRowCount(0);
        System.out.print(ContractList);

        ContractList.forEach(element -> {
            Object[] contractData = {
                element.getContractId(),
                element.getContractTitle(),
                element.getContractLocation(),
                element.getContractStartDate(),
                element.getContractExpectedEndDate(),
                element.getContractStatus(),
                element.getContractValue(),
                element.getClientName(),
                element.getScopeOfWork()
            };

            // Debugging output to check Contract Value
            System.out.println("Contract Value: " + element.getContractValue());

            // Add data to the table model
            contractTableModel.addRow(contractData);
        });
    }//GEN-LAST:event_sortDropDown1ActionPerformed

    private void dropDownSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropDownSearchActionPerformed
 String selectedOption = (String) dropDownSearch.getSelectedItem();

  
    System.out.println("Selected Option: " + selectedOption);


    if (selectedOption == null || selectedOption.trim().isEmpty()) {
        searchBar.setText("Select a model to search");
        System.out.println("No option selected");
    } else if (selectedOption.equals("Contract")) {
        searchBar.setText("Enter Client Name");
    } else if (selectedOption.equals("Stock")) {
        searchBar.setText("Enter Hardware Name");
        System.out.println("Stock selected");
    } else if (selectedOption.equals("Order")) {
        searchBar.setText("Enter Order Name");
        System.out.println("Order selected");
    } else if (selectedOption.equals("Product")) {
        searchBar.setText("Enter Product Name");
    } else if (selectedOption.equalsIgnoreCase("supplier")) { // Case-insensitive match
        searchBar.setText("Enter Supplier Name");
    } else {
        searchBar.setText("Select a model to search");
        System.out.println("Default case triggered");
    }         
    
    }//GEN-LAST:event_dropDownSearchActionPerformed

    private void searchBarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchBarFocusGained
        searchBar.setText("");

    }//GEN-LAST:event_searchBarFocusGained

    private void searchBarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchBarFocusLost
  
 searchBar.setText ( "Select a model to search ") ;


    }//GEN-LAST:event_searchBarFocusLost

    private void dropDownSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dropDownSearchMouseClicked

    }//GEN-LAST:event_dropDownSearchMouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ClearDataBtn;
    private javax.swing.JPanel ContractButton;
    private javax.swing.JScrollPane ContractPanel;
    private javax.swing.JLabel ContractText;
    private javax.swing.JPanel DashBoardButton;
    private javax.swing.JScrollPane DashBoardPanel;
    private javax.swing.JPanel DashBoardScreen;
    private javax.swing.JLabel DashboardText;
    private javax.swing.JPanel InStockButton;
    private javax.swing.JLabel InStockText;
    private javax.swing.JPanel InstockListDisplay;
    private javax.swing.JScrollPane InstockPanel;
    private javax.swing.JPanel LatestStockDisplayPanel1;
    private javax.swing.JLabel MainLogo;
    private javax.swing.JLabel MainLogo1;
    private javax.swing.JLabel MenuIcon;
    private javax.swing.JLabel MenuIcon2;
    private javax.swing.JLabel MenuIcon3;
    private javax.swing.JLabel MenuIcon4;
    private javax.swing.JLabel MenuIcon5;
    private javax.swing.JLabel MenuIcon6;
    private javax.swing.JPanel NavBar;
    private javax.swing.JPanel NewOrdersDisplayPanel;
    private javax.swing.JPanel OrderButton;
    private javax.swing.JLabel OrderText;
    private javax.swing.JLabel OrdersList;
    private javax.swing.JScrollPane OrdersPanel;
    private javax.swing.JPanel PendingContractsDisplay1;
    private javax.swing.JPanel PendingContractsDisplay2;
    private javax.swing.JPanel ProductButton;
    private javax.swing.JPanel ProductListDisplay;
    private javax.swing.JScrollPane ProductPanel;
    private javax.swing.JLabel ProductText;
    private javax.swing.JPanel SideMenu;
    private javax.swing.JLabel StockListText;
    private javax.swing.JPanel SupplierButton;
    private javax.swing.JPanel SupplierListDisplay;
    private javax.swing.JLabel SupplierListText;
    private javax.swing.JLabel SupplierText;
    private javax.swing.JScrollPane SuppliersPanel;
    private javax.swing.JPanel addContractBtn;
    private javax.swing.JPanel addContractBtn2;
    private javax.swing.JPanel addContractBtn3;
    private javax.swing.JPanel addContractBtn4;
    private javax.swing.JPanel addContractBtn5;
    private javax.swing.JPanel addContractBtnContractPanel;
    private javax.swing.JLabel addContractText;
    private javax.swing.JLabel addContractText1;
    private javax.swing.JLabel addContractText4;
    private javax.swing.JLabel addContractTextPanel;
    private javax.swing.JPanel addContractsPanel;
    private javax.swing.JPanel addOrdersPanel;
    private javax.swing.JLabel addOrdersText;
    private javax.swing.JPanel addProductBtn;
    private javax.swing.JPanel addProductPanel;
    private javax.swing.JLabel addProductText;
    private javax.swing.JLabel addProductText1;
    private javax.swing.JLabel addProductText2;
    private javax.swing.JLabel addProductText4;
    private javax.swing.JLabel addProductText5;
    private javax.swing.JLabel addProductText6;
    private javax.swing.JLabel addProductText7;
    private javax.swing.JLabel addProductText8;
    private javax.swing.JLabel addProducttext;
    private javax.swing.JPanel addStockBtn;
    private javax.swing.JPanel addStockBtn1;
    private javax.swing.JPanel addStockPanel;
    private javax.swing.JPanel addSupplierPanel;
    private javax.swing.JLabel bannerImg;
    private javax.swing.JLabel clearDataTxt;
    private javax.swing.JPanel deleteContractBtnContractPanel;
    private javax.swing.JLabel deleteContractText;
    private javax.swing.JPanel displayPanel1;
    private javax.swing.JPanel displayPanel2;
    private javax.swing.JPanel displayPanel3;
    private javax.swing.JComboBox<String> dropDownSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblSearchBtn;
    private javax.swing.JPanel loginCard;
    private javax.swing.JPanel loginPage;
    private javax.swing.JLabel loginTitleTxt;
    private javax.swing.JLabel loginTxt;
    private javax.swing.JPanel ordersListDisplay;
    private javax.swing.JPanel pnlCards;
    private javax.swing.JPanel pnlContractMain;
    private javax.swing.JPanel pnlDataDisplayParent;
    private javax.swing.JPanel pnlDataDisplayParent1;
    private javax.swing.JPanel pnlDataDisplayParent2;
    private javax.swing.JPanel pnlDataDisplayParent3;
    private javax.swing.JPanel pnlDataDisplayParent4;
    private javax.swing.JPanel pnlDisplayParent;
    private javax.swing.JPanel pnlInStockMain;
    private javax.swing.JPanel pnlLoginBtn;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlOrdersMain;
    private javax.swing.JPanel pnlProductMain;
    private javax.swing.JPanel pnlSupplierMain;
    private javax.swing.JLabel productlistText;
    private javax.swing.JLabel revenueText3;
    private javax.swing.JLabel revenueText5;
    private javax.swing.JLabel revenueText6;
    private javax.swing.JTextField searchBar;
    private javax.swing.JComboBox<String> sortDropDown;
    private javax.swing.JComboBox<String> sortDropDown1;
    private javax.swing.JTable tableContractDashboard;
    private javax.swing.JTable tableContractDashboard1;
    private javax.swing.JTable tableLatestStockDashboard;
    private javax.swing.JTable tableNewOrdersDashboard;
    private javax.swing.JTable tableOrdersList;
    private javax.swing.JTable tableProductList;
    private javax.swing.JTable tableStockList;
    private javax.swing.JTable tableSupplierList;
    private javax.swing.JLabel totalPurchaseText;
    private javax.swing.JLabel totalPurchaseText1;
    private javax.swing.JLabel totalPurchaseText2;
    private javax.swing.JLabel totalPurchaseText3;
    private javax.swing.JLabel totalPurchaseText4;
    private javax.swing.JLabel totalPurchaseText5;
    private javax.swing.JLabel totalPurchaseText6;
    private javax.swing.JTextField txtClientName;
    private javax.swing.JTextField txtClientName1;
    private javax.swing.JTextField txtClientName2;
    private javax.swing.JTextField txtClientName3;
    private javax.swing.JTextField txtClientName4;
    private javax.swing.JTextField txtContractExpectedEndDate;
    private javax.swing.JTextField txtContractExpectedEndDate1;
    private javax.swing.JTextField txtContractExpectedEndDate2;
    private javax.swing.JTextField txtContractExpectedEndDate3;
    private javax.swing.JTextField txtContractExpectedEndDate4;
    private javax.swing.JTextField txtContractId;
    private javax.swing.JTextField txtContractId1;
    private javax.swing.JTextField txtContractId2;
    private javax.swing.JTextField txtContractId3;
    private javax.swing.JTextField txtContractId4;
    private javax.swing.JTextField txtContractLocation;
    private javax.swing.JTextField txtContractLocation1;
    private javax.swing.JTextField txtContractLocation2;
    private javax.swing.JTextField txtContractLocation3;
    private javax.swing.JTextField txtContractLocation4;
    private javax.swing.JTextField txtContractStartDate;
    private javax.swing.JTextField txtContractStatus;
    private javax.swing.JTextField txtContractStatus1;
    private javax.swing.JTextField txtContractStatus2;
    private javax.swing.JTextField txtContractStatus3;
    private javax.swing.JTextField txtContractStatus4;
    private javax.swing.JTextField txtContractTitle;
    private javax.swing.JTextField txtContractTitle1;
    private javax.swing.JTextField txtContractTitle2;
    private javax.swing.JTextField txtContractTitle3;
    private javax.swing.JTextField txtContractTitle4;
    private javax.swing.JTextField txtContractValue;
    private javax.swing.JTextField txtContractValue1;
    private javax.swing.JTextField txtContractValue2;
    private javax.swing.JTextField txtContractValue3;
    private javax.swing.JTextField txtContractValue4;
    private javax.swing.JPasswordField txtFieldPassword;
    private javax.swing.JTextField txtFieldUsername;
    private javax.swing.JTextArea txtScopeOfWork;
    private javax.swing.JTextArea txtScopeOfWork1;
    private javax.swing.JTextArea txtScopeOfWork2;
    private javax.swing.JTextArea txtScopeOfWork3;
    private javax.swing.JTextArea txtScopeOfWork4;
    private javax.swing.JPanel updateContractBtnContractPanel;
    private javax.swing.JLabel updateContractText;
    // End of variables declaration//GEN-END:variables
}

 class RoundedPanel extends JPanel {

        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;

        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
//            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//             
        }
    }


  

