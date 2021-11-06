package org.isen.conceptObject.misc;

public class Constant {

    private Constant(){}

    public static int MAP_SIZE_X = 12;
    public static int MAP_SIZE_Y = 12;

    public static int SAFE_ZONE_SIZE = 3;

    public static int MAP_SIZE_CELL = 50;

    public static int MASTER_GOBLINS_POS_X = 0;
    public static int MASTER_GOBLINS_POS_Y = Constant.MAP_SIZE_Y - 1;
    public static int[] SAFE_ZONE_GOBLINS = new int[]{0,  2, Constant.MAP_SIZE_Y - 3,  Constant.MAP_SIZE_Y - 1};

    public static int MASTER_ELVE_POS_X = Constant.MAP_SIZE_X - 1;
    public static int MASTER_ELVE_POS_Y = Constant.MAP_SIZE_Y - 1;
    public static int[] SAFE_ZONE_ELVE = new int[]{Constant.MAP_SIZE_X- 3,  Constant.MAP_SIZE_X- 1, Constant.MAP_SIZE_Y - 3,  Constant.MAP_SIZE_Y - 1};


    public static int MASTER_HUMAN_POS_X = 0;
    public static int MASTER_HUMAN_POS_Y = 0;
    public static int[] SAFE_ZONE_HUMAN = new int[]{0,  2, 0,  2};


    public static int MASTER_ORC_POS_X = Constant.MAP_SIZE_X - 1;
    public static int MASTER_ORC_POS_Y = 0;
    public static int[] SAFE_ZONE_ORC= new int[]{ Constant.MAP_SIZE_X - 3,  Constant.MAP_SIZE_X - 1, 0,  2};

    public static int NUMBER_PAWN_PER_TEAM = 7;

    public static int NUMBER_TURN = 40;
}
