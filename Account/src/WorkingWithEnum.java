public enum WorkingWithEnum {
    WON,
    LOST,
    DRAW
}

class EnumTest{
    public static void main (String[] args){
        for (WorkingWithEnum status : WorkingWithEnum.values()){
            System.out.println(status);
        }
    }
}


