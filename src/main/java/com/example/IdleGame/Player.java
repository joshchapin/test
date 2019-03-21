package com.example.IdleGame;

class Player{
    private long bankBalance = 0;
    private long totalGps = 0;
    private long baseClickPower = 1;
    private long clickPowerMultiplier = 1;

    public static final int numOfJobs = 5;
    public static final int numOfQuests = 5;


    public Job jobList[];

    private int jobData[][];
    //if unlocked, levels, (base gold?),

    public int questProgress[];
    //just have it be a number as to what point they are at.
    //so if a player hasnot completed anyquest forsomeone, they are at 0
    //if they have completed 1 quest for someone, they are at 1, etc

    public static int questRequirements[][] = {{}};

    //quest rewards in seperate class?
    /*
    quest rewards just be included into saved data (as in, if one increases
    base click power, just save the base click power and not worry about it further?
    */

    //make clicker power be 10% of GPS by default?


    public Player(){

        jobList = new Job[numOfJobs];

        for(int i = 0; i < numOfJobs; i++){
            jobList[i] = new Job(i);
        }

        questProgress = new int[numOfJobs];
        for(int i = 0; i < numOfJobs; i++){
            questProgress[i] = 0;
        }

    }

    public void loadData(){


    }

    public void saveData(){


    }

    public long getBalance(){
        return bankBalance;
    }

    public void addFunds(long money){
        bankBalance += money;
    }

    public void spendFunds(long payment){
        if(canAfford(payment)){
            bankBalance -= payment;
        }
        else{
            //error message window: "not enough gold" or whatever? should be handled before this point though
        }
    }

    public boolean canAfford(long cost){
        boolean canAfford = (cost <= bankBalance);

        return canAfford;
    }

    public long getBaseClickPower(){
        return baseClickPower;
    }

    public void addClickPower(long num){
        baseClickPower += num;
    }

    //public void setBaseClickPower

    public void calcTotalGps(){
        totalGps = 0;
        for(int i = 0; i < numOfJobs; i++){
            totalGps += jobList[i].getGps();
        }
    }

    public long getTotalGps(){
        return totalGps;
    }

    public void update(){
        calcTotalGps();


    }

}
