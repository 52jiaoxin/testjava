package com.psx;

/**
 * @author psx
 * @date 2021/2/22 9:30
 */
public class CustomerList {
    private Customer[] customers;
    private int total = 0;

    public CustomerList() {
    }
    public CustomerList(int totalCustomer) {
        customers=new Customer[totalCustomer];
    }
    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }



    public boolean addCustomer(Customer customer) {
        if(total>=customers.length) {
            return false;
        }
        else{
            customers[total]=customer;
            total++;
            return true;
        }

    }

    public boolean replaceCustomer(int index, Customer cust) {
        if(index<0||index>=total)
            return false;
        else{
            customers[index]=cust;
            return true;
        }
    }

    public boolean deleteCustomer(int index) {
        if(index<0||index>=total)
            return false;
        else {
            for(int i=index;i<total-1;i++){
                customers[i]=customers[i+1];
            }
            customers[total-1]=null;
            total--;
            return  true;
        }
    }

    public Customer[] getAllCustomers() {
        Customer[] cu=new Customer[total];
        for(int i=0;i<total;i++){
            cu[i]=customers[i];
        }
        return cu;
    }

    public Customer getCustomer(int index) {
        if(index<0||index>=total)
            return null;
        return customers[index];
    }

    public int getTotal() {
        return total;
    }


}
