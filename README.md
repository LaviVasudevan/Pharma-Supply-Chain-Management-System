# Pharmacy Supply Chain Management System

## Description

The Pharmacy Supply Chain Management System is designed to streamline interactions between manufacturers, wholesalers, pharmacies, and waste management agencies. It optimizes medicine production, distribution, and waste collection, ensuring efficient supply chain management from production to end-user delivery.

STAKEHOLDERS
- Manufacturers: Produce medicines in batches, which are then sold to wholesalers.
- Wholesalers: Maintain inventory and set prices per package, distributing medicines to pharmacies based on orders.
- Pharmacies: Place orders to restock shelves and meet customer demand.
- Waste Management Agencies: Receive waste collection requests and dispose of wastes responsibly and in compliance with regulations.

## Prerequisites

Ensure the following are installed:

- **JDK 8 or higher**
- **Oracle Database**
- **Eclipse/Netbeans**
- **VS Code**

## Features

### Pharmacy Interface
- **Pharmacy Home:** Displays a list of pharmacy orders, including dates, wholesalers, and supply status.
- **View Orders:** Shows detailed information about orders made to wholesalers.
- **Dispose Medicines:** Enables pharmacies to select medicines for disposal and choose a service provider.
- **Order New Medicines:** Allows pharmacies to order medicines and choose a wholesaler.

### Wholesaler Interface
- **Wholesaler Home:** Displays inventory with filters for expired and low stock, updates medicine prices, and clears expired stock.
- **Medicine Info:** Provides detailed information about medicines.
- **Transaction History:** Shows details of waste collection requests and orders placed with manufacturers.
- **Pharmacy Orders:** Displays details of orders from pharmacies and allows updating of order status.
- **Dispose Medicines:** Enables wholesalers to select medicines for disposal and choose a service provider.
- **Order New Medicines:** Allows wholesalers to order medicines and choose a manufacturer.

### Provider Interface
- **Provider Home:** Allows providers to update supply status, schedule pickup dates, and view requests sorted by completion status.
  
![ss2](https://github.com/user-attachments/assets/557234bf-e5c0-4b19-a715-6a2b9c690520)
![ss3](https://github.com/user-attachments/assets/3e6d0dcc-d8e4-49f5-9031-341f17022efe)

## Usage

### Database Setup
1. **Run SQL Script:** Use the provided SQL script to set up your database.

### Java Project Setup
1. **Update Database Configuration:**
   In `DatabaseHandler.java`, update the `url`, `username`, and `password` fields:
   ```java
   private static final String url = "jdbc:your_database_url";
   private static final String username = "your_database_username";
   private static final String password = "your_database_password";
   ```
2. **Compile and Run:**
   Navigate to the project root and compile:
   ```bash
   mvn clean install
   ```
   - Run `Login.java` from your IDE or command line.

## Contributors

- Lavanya Vasudevan ( LaviVasudevan )
- Krithika C
