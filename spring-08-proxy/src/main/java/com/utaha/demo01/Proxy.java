package com.utaha.demo01;

public class Proxy implements Rent{
    private Landlord landlord;

    public Proxy() {
    }

    public Proxy(Landlord landlord) {
        this.landlord = landlord;
    }

    @Override
    public void rent() {
        seeHouse();
        landlord.rent();
        contract();
        agencyFee();
    }
    //看房
    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    //收中介费
    public void agencyFee (){
        System.out.println("中介收钱");
    }
    //签合同
    public void contract (){
        System.out.println("签合同");
    }
}
