package com.example.IdleGame;

class Job {
    private long baseGold;
    private long level = 0;
    private long costOfNextLevel;
    private double multiplier = 1;
    private long gps;
    private Boolean active = false;

    long baseGoldAmounts[] = {1, 10, 100, 1000, 10000};
    long startingCostOfNextLevel[] = {100, 1000, 10000, 100000, 1000000};
    //double levelGrowthRate[] = {1.1, 1.2, 1.3, 1.4, 1.5};
    double growthRate = 1.15;


    public Job(int tier) {
        baseGold = baseGoldAmounts[tier];
        costOfNextLevel = startingCostOfNextLevel[tier];

    }

    public void loadData(int[] savedData){

    }

    public int[] saveData(){
        int[] saveData = {1};

        return saveData;
    }

    public long getGps(){
        update();

        return gps;
    }


    public void setMult(int mod){


    }
    public void incMult(int mod){}

    public void buyLevel(int quantity){

        level += quantity;
        costOfNextLevel = (long)(costOfNextLevel *(Math.pow( growthRate, quantity)));


        update();
    }

    public long getCostOfLevels(int quantity){
        long totalCost = costOfNextLevel;
        //formula for summing them

        return totalCost;
    }

    //public long getMaxLevelsCanBuy(long balance){}

    public boolean isActive(){
        return active;
    }


    public void setActive(){
        active = true;
    }

    public void update(){
        gps = baseGold * level;
    }

}

