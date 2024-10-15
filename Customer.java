class Customer {
    private String customerID;
    private String address;
    private String phoneNumber;

    public Customer(String customerID, String address, String phoneNumber) {
        this.customerID = customerID;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void viewDetails() {
        System.out.println("Customer ID: " + customerID);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
    }

    public void updateProfile(String newAddress, String newPhoneNumber) {
        this.address = newAddress;
        this.phoneNumber = newPhoneNumber;
        System.out.println("Profile updated for customer ID: " + customerID);
    }
}
